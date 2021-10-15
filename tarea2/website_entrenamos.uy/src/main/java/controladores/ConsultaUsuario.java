package controladores;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excepciones.UsuarioInexistenteException;
import logica.DataCuponera;
import logica.Fabrica;
import logica.IctrlClases;
import logica.IctrlUsuarios;
import logica.InfoActividadProfe;
import logica.InfoBasicaUser;
import logica.InformacionActividad;

/**
 * Servlet implementation class ConsultaUsuario
 */
@WebServlet("/ConsultaUsuario")
public class ConsultaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Fabrica f = Fabrica.getInstance();
		IctrlUsuarios ICU = f.getIctrlUsuarios();
		
		String user = request.getParameter("usuarioNick");
		if( user == null ) {
			response.sendRedirect("/website_entrenamos.uy/home");
		}
		else {
			
			boolean esSocio = true;
			try{
				esSocio = ICU.esSocio(user);
			}
			catch(UsuarioInexistenteException e) {
			}
			
			
			Vector<DataCuponera> cuponerasSocio = null;
			InfoActividadProfe actIngRech = null;
			if(esSocio) {
				cuponerasSocio =  ICU.Cuponeras(user);
			}
			else {
				actIngRech = ICU.InformacionActDepEstadoIngRech(user);
			}
			
			InformacionActividad informacioActividad = null;
			informacioActividad = ICU.InformacionActividad(user);
			InfoBasicaUser infoUser = null;
			infoUser = ICU.InformacionBasicaUsuario(user);
			Vector<String> uSeguidores = null;
			uSeguidores = ICU.UsuariosSeguidores(user);
			Vector<String> uSiguiendo = null;
			uSiguiendo = ICU.UsuariosSiguiendo(user);
			
			
			//genero la respuesta
			request.setAttribute("esSocio", esSocio);
			request.setAttribute("cuponera", cuponerasSocio);
			request.setAttribute("actDepIngRech", actIngRech);
			request.setAttribute("informacionActividad", informacioActividad );
			request.setAttribute("infoUser", infoUser);
			request.setAttribute("seguidores", uSeguidores );
			request.setAttribute("siguiendo", uSiguiendo );
			
			request.getRequestDispatcher("/WEB-INF/usuario/consultaUsuario.jsp").forward(request, response);

		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
