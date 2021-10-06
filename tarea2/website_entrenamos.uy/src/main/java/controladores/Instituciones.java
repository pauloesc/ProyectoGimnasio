package controladores;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.Fabrica;

public class Instituciones extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public Instituciones() 
	{
		super();
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		HttpSession sesion = req.getSession();
		sesion.setAttribute("nickname-user", null);
		sesion.setAttribute("estado-sesion", "no-login");
		resp.sendRedirect("/website_entrenamos.uy/home");
	}
	
	public static Set<String> getInstituciones(){
		Set<String> inst = Fabrica.getInstance().getIctrlIDeportivas().darNombreInstituciones();
		return inst;
	}
	
	public static void cargarInstituciones()
	{
		Fabrica.getInstance().getIctrlIDeportivas().cargarDatosIDeportivas();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		processRequest(request, response);
	}
}
