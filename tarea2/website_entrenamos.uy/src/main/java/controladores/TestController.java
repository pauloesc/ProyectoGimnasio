package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.IctrlUsuarios;
import logica.Fabrica;

public class TestController extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		IctrlUsuarios ctrlUsuarios = Fabrica.getInstance().getIctrlUsuarios();
		ctrlUsuarios.cargarUsuarios();
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		dispatcher.forward(request, response);
	}
}
