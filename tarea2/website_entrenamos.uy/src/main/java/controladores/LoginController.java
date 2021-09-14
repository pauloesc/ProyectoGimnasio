package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.IctrlUsuarios;
import logica.Fabrica;

public class LoginController extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		if (request.getParameter("btn_iniciarSesion") != null)
		{
			String user = request.getParameter("input_email");
			String pass = request.getParameter("input_password");
			
			IctrlUsuarios ctrlUsuarios = Fabrica.getInstance().getIctrlUsuarios();
			
			// Pre-procesar user
			String email = null, nickname = null;
			if (user.contains("@"))
				email = user;
			else
				nickname = user;
			
			String auth = ctrlUsuarios.autenticarUsario(nickname, email, pass);
			
			if (auth == null)
			{
				HttpSession sesion = request.getSession();
				sesion.setAttribute("login", nickname);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
				dispatcher.forward(request, response);	
			}
			else
			{
				request.setAttribute("LoginError", auth);
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.include(request, response);
			}
		}
	}
}
