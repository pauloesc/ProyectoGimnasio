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
import logica.IctrlUsuarios;
import logica.InfoActividadProfe;
import logica.InfoActividadSocio;
import logica.InfoBasicaUser;
import logica.InfoBasicaSocio;
import logica.InfoBasicaProfesor;
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
		
		//nickname del socio en la url
		String user = request.getParameter("usuarioNick");
		
		//si el usuario en la url es vacio =>> redirigo a home
		if( user == null ) {
			response.sendRedirect("/website_entrenamos.uy/home");
		}
		
		/**
		*compruebo si es un socio.
		*tambien se comroueba si existe el usuario 
		*/
		boolean esSocio=true;
		try {
			esSocio = ICU.esSocio(user);
		}
		catch(UsuarioInexistenteException e) {
			/**
			compruebo si hay algun problema
			*/
			response.sendRedirect("/website_entrenamos.uy/home");
		}
		
		//informacion comun a ambos tipos de usuarios
		//declaro las variables 
		InfoBasicaUser informacionUusario = null;
		Vector<String> usuariosSeguidores = null;
		Vector<String> usuariosSiguiendo = null;
		InformacionActividad informacioActividad = null;
		//llamo a la funciones para traer la informacion
		informacionUusario = ICU.InformacionBasicaUsuario(user);
		usuariosSeguidores = ICU.UsuariosSeguidores(user);
		usuariosSiguiendo = ICU.UsuariosSiguiendo(user);
		informacioActividad = ICU.InformacionActividad(user);
		

		/**
		 * info dependiente del tipo de usuario
		 * declaro las variables 
		*/
		Vector<DataCuponera> cuponerasSocio = null;
		InfoActividadProfe actDepsIngRech = null;
		if(esSocio) {
			cuponerasSocio = ICU.Cuponeras(user);			
		}
		else {
			actDepsIngRech = ICU.InformacionActDepEstadoIngRech(user);			
		}
		
		

		request.setAttribute("esSocio", esSocio);
		request.setAttribute("infoUsuario", informacionUusario);
		request.setAttribute("infoActividad", informacioActividad);
		request.setAttribute("usersSeguidores", usuariosSeguidores);
		request.setAttribute("usersSiguiendo", usuariosSiguiendo);
		request.setAttribute("cuponeras", cuponerasSocio);
		request.setAttribute("actDepIngRech", actDepsIngRech);
		request.getRequestDispatcher("/WEB-INF/usuario/consultaUsuario.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
