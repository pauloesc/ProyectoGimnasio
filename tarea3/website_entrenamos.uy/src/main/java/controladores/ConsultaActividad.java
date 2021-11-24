package controladores;

import java.io.IOException;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import publicadores.ActividadDeportivaNoExisteException_Exception;
import publicadores.EstadoActi;
import publicadores.WebServicesADeportivas;
import publicadores.WebServicesADeportivasService;
import publicadores.WebServicesClases;
import publicadores.WebServicesClasesService;
import publicadores.WebServicesCuponeras;
import publicadores.WebServicesCuponerasService;

public class ConsultaActividad extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private static WebServicesADeportivasService serviceActividades;
	private static WebServicesADeportivas portActividades;
	
	private static WebServicesCuponerasService serviceCuponeras;
	private static WebServicesCuponeras portCuponeras;
	
	private static WebServicesClasesService serviceClases;
	private static WebServicesClases portClases;
	
	public ConsultaActividad() 
	{
		super();
		
		serviceActividades = new WebServicesADeportivasService();
		portActividades = serviceActividades.getWebServicesADeportivasPort();
		
		serviceCuponeras = new WebServicesCuponerasService();
		portCuponeras = serviceCuponeras.getWebServicesCuponerasPort();
		
		serviceClases = new WebServicesClasesService();
		portClases = serviceClases.getWebServicesClasesPort();
		
	
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		req.setCharacterEncoding("UTF-8");
		String act = req.getParameter("actividad");
		//verificar que institucion existe y sino llevar a errorPage
		publicadores.DataActividad actividad = null;
		try {
			actividad = ConsultaActividad.getDataActividad(act);
		} catch (ActividadDeportivaNoExisteException_Exception e) {
			req.getRequestDispatcher("/WEB-INF/errorpages/404.jsp").include(req, resp);
			return;
		}
				
		List<String> cup=null;
		try {
			cup = portCuponeras.getCuponerasAD(act).getSet();
		} 
		catch(Exception ex) {
			cup  = null;
		}
		
		req.setAttribute("actividad", actividad);
		req.setAttribute("cup", cup);
		
		
		Set<String> clases;
		try {
			clases = new HashSet<String>(portClases.mostrarClasesDeActividadDeportiva(act).getSet());
		} catch(Exception e) {
			clases = null;
		}
		
		req.setAttribute("clases", clases);
		req.getRequestDispatcher("/WEB-INF/actividades/consultaActividadDeportiva.jsp").forward(req, resp);
	}
	
	public static Set<String> getActividadesInst(String inst){
		List<String> actsarr = portActividades.darNombresActividadesDeportivas(inst).getItem();
		Set<String> acts = new HashSet<String>(actsarr);
		return acts;
	}
	
	public static publicadores.DataActividad getDataActividad(String act) throws ActividadDeportivaNoExisteException_Exception {
		publicadores.DataActividad acti;
		acti = portActividades.getDataActividad(act);
		if (acti != null) {
			return acti;
	 	} else
	 		throw new ActividadDeportivaNoExisteException_Exception("No existe la Actividad Deportiva.", null);
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
