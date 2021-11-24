package controladores;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import publicadores.CuponeraNoExisteException_Exception;
import publicadores.DataCuponera;
import publicadores.WebServicesCuponeras;
import publicadores.WebServicesCuponerasService;

public class Cuponeras extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static WebServicesCuponerasService serviceCuponeras;
	private static WebServicesCuponeras portCuponeras;
	
	public Cuponeras() 
	{
		super();
		serviceCuponeras = new WebServicesCuponerasService();
		portCuponeras = serviceCuponeras.getWebServicesCuponerasPort();
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		HttpSession sesion = req.getSession();
		sesion.setAttribute("nickname-user", null);
		sesion.setAttribute("estado-sesion", "no-login");
		resp.sendRedirect("home");
	}
	
	public static Set<DataCuponera> getCuponeras() throws CuponeraNoExisteException_Exception{
		Set<DataCuponera> cuponeras = new HashSet<DataCuponera>();
		Set<String> cups = new HashSet<String>(portCuponeras.listarCuponeras().getSet());
		for (Iterator<String> iter=cups.iterator();iter.hasNext();) {
			String cup=iter.next();
			DataCuponera res = portCuponeras.mostrarCuponera(cup);
			cuponeras.add(res);
		}
		return cuponeras;
	}
	
	public static Set<String> getCuponerasAD(String act){
		
		return new HashSet<String>(portCuponeras.getCuponerasAD(act).getSet());
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
