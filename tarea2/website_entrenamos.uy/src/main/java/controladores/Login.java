package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.InfoBasicaUser;
import logica.IctrlUsuarios;
import logica.Fabrica;
import excepciones.UsuarioInexistenteException;

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
		
		if ( req.getParameter("btn_iniciarSesion") != null )
		{
			String user = req.getParameter("input_email");
			String pass = req.getParameter("input_password");
			IctrlUsuarios ctrlUsuarios = Fabrica.getInstance().getIctrlUsuarios();
		
			String email = null, nickname = null;
			if (user.contains("@"))
				email = user;
			else
				nickname = user;
			
			String auth = ctrlUsuarios.autenticarUsario(nickname, email, pass);
			
			if (auth == null)
			{
				if (nickname == null)
					nickname = ctrlUsuarios.getNicknameUsuario(email);
				
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
	
	public static InfoBasicaUser getUsuarioLogueado(HttpServletRequest request)
		throws UsuarioInexistenteException
	{
		String nick = (String) request.getSession().getAttribute("nickname-user");
		InfoBasicaUser usr = Fabrica.getInstance().getIctrlUsuarios().informacionBasicaUsuario(nick);
		
		if (usr == null)
			throw new UsuarioInexistenteException();
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
