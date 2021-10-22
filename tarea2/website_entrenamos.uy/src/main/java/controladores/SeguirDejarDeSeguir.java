package controladores;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.Fabrica;
import logica.IctrlUsuarios;

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
		/**
		*traigo el controlador de usuario
		*/
		Fabrica f = Fabrica.getInstance();
		IctrlUsuarios ICU = f.getIctrlUsuarios();
		
		String usuario = (String) request.getParameter("usuarioNick");
		String nickEnSesion = (String) request.getSession().getAttribute("nickname-user");
		
		//si no hay usuario en sesion
		if(nickEnSesion == null) {
			String url = "/website_entrenamos.uy/ConsultaUsuario?usuarioNick=" + usuario;
			response.sendRedirect(url);
			return;
		}
		
		boolean siguendo=false;
		Set<String> usuariosSiguiendo = ICU.usuariosSiguiendo( nickEnSesion  );
		Iterator<String> itt = usuariosSiguiendo.iterator();
		
		//compruebo si ya estoy siguendo a ese usuario 
		while( itt.hasNext() & !siguendo ) {
			
			//nick de un usuario al que ya sigo
			String auxNickname = itt.next();
			
			if ( auxNickname.equals(usuario) ) {
				siguendo=true;
			}
		}
		
		if(siguendo){
			ICU.dejarDeSeguirUsuario(nickEnSesion,usuario);
		}
		else {
			ICU.seguirUsuario(nickEnSesion,usuario);
		}
		
		String url = "/website_entrenamos.uy/ConsultaUsuario?usuarioNick=" + nickEnSesion;
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
