package controladores;

import java.util.List;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import publicadores.WebServicesIDeportivas;
import publicadores.WebServicesIDeportivasService;

public class Instituciones extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private static WebServicesIDeportivasService serviceInstituciones;
	private static WebServicesIDeportivas portInstituciones;
	
	public Instituciones() 
	{
		super();

		serviceInstituciones = new WebServicesIDeportivasService();
		portInstituciones = serviceInstituciones.getWebServicesIDeportivasPort();
		
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		HttpSession sesion = req.getSession();
		sesion.setAttribute("nickname-user", null);
		sesion.setAttribute("estado-sesion", "no-login");
		resp.sendRedirect("home");
	}

	public static Set<String> getInstituciones(){
		
		List<String> nomInstituciones = portInstituciones.darNombreInstituciones().getItem();
		
		return new HashSet<String>(nomInstituciones);
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
