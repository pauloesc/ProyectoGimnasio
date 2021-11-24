package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publicadores.WebServicesControladorUsuarioService;

/**
 * Servlet implementation class SeguirDejarDeSeguir
 */
@WebServlet("/SeguirDejarDeSeguir")
public class SeguirDejarDeSeguir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeguirDejarDeSeguir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//---------------------------
		WebServicesControladorUsuarioService serviceCUP = new WebServicesControladorUsuarioService();
		publicadores.WebServicesControladorUsuario port = serviceCUP.getWebServicesControladorUsuarioPort();
		//---------------------------	
		
		String usuario = (String) request.getParameter("usuarioNick");
		String nickEnSesion = (String) request.getSession().getAttribute("nickname-user");
		
		//si no hay usuario en sesion
		if(nickEnSesion == null) {
			String url = "ConsultaUsuario?usuarioNick=" + usuario;
			response.sendRedirect(url);
			return;
		}
		
		boolean siguendo = false;
		siguendo = port.usuarioSigueAUsuario(nickEnSesion, usuario);
		
		if(siguendo){
			port.dejarDeSeguirUsuario(nickEnSesion,usuario);
		}
		else {
			port.seguirUsuario(nickEnSesion,usuario);
		}
		
		String url = "ConsultaUsuario?usuarioNick=" + usuario;
		response.sendRedirect(url);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
