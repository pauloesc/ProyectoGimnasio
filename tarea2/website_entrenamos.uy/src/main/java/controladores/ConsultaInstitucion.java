package controladores;

import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import excepciones.ActividadDeportivaNoExisteException;
import excepciones.InstitucionDeportivaNoExisteException;
import logica.DataActividad;
import logica.DataInstitucion;
import logica.Fabrica;
import logica.IctrlADeportivas;

public class ConsultaInstitucion extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private static IctrlADeportivas ctrlADeportivas = Fabrica.getInstance().getIctrlADeportivas();
	
	public ConsultaInstitucion() 
	{
		super();
		
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		String inst = req.getParameter("institucion");
		DataInstitucion insti = null;
		try {
			insti = ConsultaInstitucion.getInstitucion(inst);
		} catch (InstitucionDeportivaNoExisteException e) {
			insti = null;
		}
		if (insti == null) {
			req.getRequestDispatcher("/WEB-INF/errorpages/404.jsp").include(req, resp);
		} 
		else {
			Set<String> actividades;
			try {
				actividades = ConsultaInstitucion.getActividadesInst(inst);
			} 
			catch(Exception ex) {
				actividades = null;
	
			}
			Set<String> cuponeras;
			try {
				cuponeras = ConsultaInstitucion.getCuponerasInst(inst);
			} 
			catch(Exception ex) {
				cuponeras = null;
			}
			
			
			req.setAttribute("actividades", actividades);
			req.setAttribute("institucion", insti.getNombre());
			req.setAttribute("cuponeras", cuponeras);
			req.getRequestDispatcher("/WEB-INF/instituciones/consultaInstitucion.jsp").forward(req, resp);
		}
	}
	
	public static Set<String> getActividadesInst(String inst){
		Set<String> acts = Fabrica.getInstance().getIctrlADeportivas().darNombresActividadesDeportivas(inst);
		return acts;
	}	
	public static Set<String> getCuponerasInst(String inst){
		Set<String> cups = Fabrica.getInstance().getIctrlCuponeras().getCuponerasInstitucion(inst);
		return cups;
	}
	
	public static DataInstitucion getInstitucion(String inst) throws InstitucionDeportivaNoExisteException {
		return Fabrica.getInstance().getIctrlIDeportivas().getInstitucion(inst);
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
