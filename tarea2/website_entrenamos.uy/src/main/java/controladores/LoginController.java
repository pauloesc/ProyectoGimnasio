package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
			String recordarme = request.getParameter("recordarme");
			IctrlUsuarios ctrlUsuarios = Fabrica.getInstance().getIctrlUsuarios();
			
			// Pre-procesar user
			String email = null, nickname = null;
			if (user.contains("@"))
				email = user;
			else
				nickname = user;
			
			if (recordarme != null)
			{
				// Crear cookies para los datos de inicio de sesion
				Cookie cEmail = new Cookie("email", email);
				Cookie cNickname = new Cookie("nickname", nickname);
				Cookie cPass = new Cookie("password", pass);
				// Hacer que las cookies expiren en 10 dias
				cEmail.setMaxAge(60 * 60 * 24 * 10);
				cNickname.setMaxAge(60 * 60 * 24 * 10);
				cPass.setMaxAge(60 * 60 * 24 * 10);
				
				response.addCookie(cPass);
				response.addCookie(cNickname);
				response.addCookie(cEmail);
			}

			String auth = ctrlUsuarios.autenticarUsario(nickname, email, pass);
			
			if (auth == null)
			{
				HttpSession sesion = request.getSession();
				sesion.setAttribute("usuario", email);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
				dispatcher.forward(request, response);	
			}
			else
			{
				request.setAttribute("error", auth);
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
