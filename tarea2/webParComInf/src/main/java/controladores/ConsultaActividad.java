package controladores;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import excepciones.ActividadDeportivaNoExisteException;
import logica.DataActividad;
import logica.Fabrica;
import logica.IctrlADeportivas;

public class ConsultaActividad extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private static IctrlADeportivas ctrlADeportivas = Fabrica.getInstance().getIctrlADeportivas();
	
	public ConsultaActividad() 
	{
		super();
		
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		req.setCharacterEncoding("UTF-8");
		String act = req.getParameter("actividad");
		//verificar que institucion existe y sino llevar a errorPage
		DataActividad actividad = null;
		try {
			actividad = ConsultaActividad.getDataActividad(act);
		} catch (ActividadDeportivaNoExisteException e) {
			//resp.sendError(404); // la actividad no existe
			req.getRequestDispatcher("/WEB-INF/errorpages/404.jsp").include(req, resp);
			return;
		}
		
		Set<String> cup;
		try {
			cup = Cuponeras.getCuponerasAD(act);
		} 
		catch(Exception ex) {
			cup  = null;
		}
		
		req.setAttribute("actividad", actividad);
		req.setAttribute("cup", cup);
		
		
		Set<String> clases;
		try {
			clases = Fabrica.getInstance().getIctrlClases().mostrarClasesDeActividadDeportiva(act);
		} catch(Exception e) {
			clases = null;
		}
		
		req.setAttribute("clases", clases);
		req.getRequestDispatcher("/WEB-INF/actividades/consultaActividadDeportiva.jsp").forward(req, resp);
	}
	
	public static Set<String> getActividadesInst(String inst){
		Set<String> acts = Fabrica.getInstance().getIctrlADeportivas().darNombresActividadesDeportivas(inst);
		return acts;
	}
	
	public static DataActividad getDataActividad(String act) throws ActividadDeportivaNoExisteException {
		DataActividad acti;
		acti = ctrlADeportivas.getDataActividad(act);
		if (acti != null) {
			return acti;
	 	} else
	 		throw new ActividadDeportivaNoExisteException("No existe la Actividad Deportiva.");
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
