package controladores;

import java.io.IOException;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publicadores.DataInstitucion;
import publicadores.DataActividad;
import publicadores.InstitucionDeportivaNoExisteException_Exception;
import publicadores.ActividadDeportivaNoExisteException_Exception;

import publicadores.WebServicesCuponeras;
import publicadores.WebServicesCuponerasService;
import publicadores.WebServicesIDeportivas;
import publicadores.WebServicesIDeportivasService;
import publicadores.WebServicesADeportivas;
import publicadores.WebServicesADeportivasService;

public class ConsultaInstitucion extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private static WebServicesIDeportivasService serviceInstituciones;
	private static WebServicesIDeportivas portInstituciones;
	
	private static WebServicesCuponerasService serviceCuponeras;
	private static WebServicesCuponeras portCuponeras;
	
	private static WebServicesADeportivasService serviceActividades;
	private static WebServicesADeportivas portActividades;
	
	
	public ConsultaInstitucion() 
	{
		super();
		
		serviceInstituciones = new WebServicesIDeportivasService();
		portInstituciones = serviceInstituciones
				.getWebServicesIDeportivasPort();
		
		serviceCuponeras = new WebServicesCuponerasService();
		portCuponeras = serviceCuponeras.getWebServicesCuponerasPort();
		
		serviceActividades = new WebServicesADeportivasService();
		portActividades = serviceActividades.getWebServicesADeportivasPort();
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		String inst = req.getParameter("institucion");
		DataInstitucion dataInst;
		
		try {
			dataInst = getInstitucion(inst);
		} 
		catch (Exception e) {
			dataInst = null;
		}
		
		if (dataInst == null) {
			req.getRequestDispatcher("/WEB-INF/errorpages/404.jsp")
				.include(req, resp);
		} 
		else {
			Set<String> actividades;
			try {
				actividades = getActividadesInst(inst);
			} 
			catch(Exception ex) {
				actividades = null;
	
			}
			List<String> cuponeras;
			try {
				cuponeras = getCuponerasInst(inst);
			} 
			catch(Exception ex) {
				cuponeras = null;
			}
			
			
			req.setAttribute("actividades", actividades);
			req.setAttribute("institucion", dataInst.getNombre());
			req.setAttribute("cuponeras", cuponeras);
			req.getRequestDispatcher(
					"/WEB-INF/instituciones/consultaInstitucion.jsp")
					.forward(req, resp);
		}
	}
	
	public static Set<String> getActividadesInst(String inst){
		
		List<String> nomActividades = portActividades
				.darNombresActividadesDeportivas(inst).getItem();
		
		return new HashSet<String>(nomActividades);
	}
	
	public static List<String> getCuponerasInst(String inst) {

		return portCuponeras.getCuponerasInstitucion(inst).getSet();
	}
	
	public static DataInstitucion getInstitucion(String inst) 
			throws InstitucionDeportivaNoExisteException_Exception {
		
		try {
			return portInstituciones.getInstitucion(inst);
		}
		catch (InstitucionDeportivaNoExisteException_Exception e) {
			throw e;
		}
	}
	
	public static DataActividad getDataActividad(String act) 
			throws ActividadDeportivaNoExisteException_Exception {
		
		try {
			return portActividades.getDataActividad(act);
		}
		catch (ActividadDeportivaNoExisteException_Exception e) {
			throw e;
		}
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
