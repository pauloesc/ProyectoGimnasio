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

public class FinalizarActividad extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private static WebServicesADeportivasService serviceActividades;
	private static WebServicesADeportivas portActividades;
	
	public FinalizarActividad() 
	{
		super();
		
		serviceActividades = new WebServicesADeportivasService();
		portActividades = serviceActividades.getWebServicesADeportivasPort();
		
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		req.setCharacterEncoding("UTF-8");
		String act = req.getParameter("actividad");
		publicadores.DataActividad actividad = null;
		try {
			actividad = FinalizarActividad.getDataActividad(act);
		} catch (ActividadDeportivaNoExisteException_Exception e) {
			req.getRequestDispatcher("/WEB-INF/errorpages/404.jsp").include(req, resp);
			return;
		}
		
		// verificar que no tenga clases vigentes con la funcion del controlador de actividad
				
		String botfin = req.getParameter("finact");
		if ((botfin != null) && (botfin.equals("fin"))) {
			
			List<String> clasesVigenteDeLaActividad = portActividades.mostrarClasesVigentesDeActividadDeportiva(act).getItem();
			
			if ( clasesVigenteDeLaActividad.isEmpty() ) {
			
				finalizarActividad(act);
				req.setAttribute("msjFin", "La actividad deportiva se ha finalizado.");
				req.setAttribute("estadoFinalizada", true);
				req.setAttribute("actividad", actividad);
			}
			else {
				req.setAttribute("estadoFinalizada", false);
				req.setAttribute("msjFin", "La actividad deportiva tiene clases vigentes");
			}
			
		}
		
		req.getRequestDispatcher("/consultaActividad?actividad="+act).forward(req, resp);
	}
	
	public static void finalizarActividad(String act) {
		portActividades.cambiarEstado(act, EstadoActi.FINALIZADA);
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
