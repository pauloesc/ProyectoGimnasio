package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import publicadores.WebServicesControladorUsuarioService;

/**
* Servlet de Login. 
*
* @author JP
*/
public class Login extends HttpServlet {
  private static final long serialVersionUID = 1L;
	
  public Login() {
    super();
  }

  private void processRequest(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
  
  HttpSession sesion = req.getSession();
  
	//---------------------------
	WebServicesControladorUsuarioService serviceCUP = new WebServicesControladorUsuarioService();
	publicadores.WebServicesControladorUsuario port = serviceCUP.getWebServicesControladorUsuarioPort();
	//---------------------------	
		
		if ( req.getParameter("btn_iniciarSesion") != null )
		{
			String user = req.getParameter("input_email");
			String pass = req.getParameter("input_password");
		
			String email = "", nickname = "";
			if (user.contains("@"))
				email = user;
			else
				nickname = user;
			
			publicadores.WrapperStringNull auxAuth = null;
			auxAuth = port.autenticarUsario(nickname, email, pass);
			String auth = auxAuth.getInformacion();
			
			
			if (auth == null)
			{
				if (nickname == null || nickname.equals("") )
					nickname = port.getNicknameUsuario(email);
				
				sesion.setAttribute("nickname-user", nickname);
				sesion.setAttribute("estado-sesion", "logged-in");
				sesion.setAttribute("login-error", null);
				resp.sendRedirect("/website_entrenamos.uy/home");
			} else
			{
				sesion.setAttribute("login-error", auth);
				req.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(req, resp);
			}
		}
		else
		{
			sesion.setAttribute("login-error", null);
			req.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(req, resp);
		}
	}
	
	public static publicadores.InfoBasicaUser getUsuarioLogueado(HttpServletRequest request)
		throws publicadores.UsuarioDisponibilidadException_Exception
	{		
		
		//---------------------------
		WebServicesControladorUsuarioService serviceCUP = new WebServicesControladorUsuarioService();
		publicadores.WebServicesControladorUsuario port = serviceCUP.getWebServicesControladorUsuarioPort();
		//---------------------------
		
		
		publicadores.InfoBasicaUser usr = null;
		usr = port.informacionBasicaUsuario( (String) request.getSession().getAttribute("nickname-user") );
		
		if (usr == null)
			throw new publicadores.UsuarioDisponibilidadException_Exception(null, null);
		else
			return usr;
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		processRequest(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		processRequest(request, response);
	}
}
