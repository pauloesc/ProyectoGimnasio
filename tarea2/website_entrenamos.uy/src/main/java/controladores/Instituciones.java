package controladores;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.Fabrica;
import logica.IctrlIDeportivas;

public class Instituciones extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static IctrlIDeportivas ICD= Fabrica.getInstance().getIctrlIDeportivas();
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
		ICD.cargarDatosIDeportivas();
		Set<String> inst = ICD.darNombreInstituciones();
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
