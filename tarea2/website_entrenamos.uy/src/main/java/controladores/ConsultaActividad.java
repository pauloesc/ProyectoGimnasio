package controladores;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.CuponeraNoExisteException;
import logica.DataActividad;
import logica.Fabrica;
import logica.IctrlADeportivas;
import logica.IctrlCuponeras;

public class ConsultaActividad extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private static IctrlADeportivas ctrlADeportivas = Fabrica.getInstance().getIctrlADeportivas();
	private static IctrlCuponeras ctrlCuponeras = Fabrica.getInstance().getIctrlCuponeras();
	
	public ConsultaActividad() 
	{
		super();
		
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		String act = req.getParameter("actividad");
		//verificar que institucion existe y sino llevar a errorPage
		DataActividad actividad = null;
		try {
			actividad = ConsultaActividad.getDataActividad(act);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set<String> cuponeras;
		try {
			cuponeras = ConsultaActividad.getCuponerasAD();
		} 
		catch(Exception ex) {
			cuponeras  = null;
		}
		
		req.setAttribute("actividad", actividad);
		req.setAttribute("cuponeras", cuponeras);
		req.getRequestDispatcher("/WEB-INF/actividades/consultaActividadDeportiva.jsp").forward(req, resp);
	}
	
	public static Set<String> getActividadesInst(String inst){
		Set<String> acts = Fabrica.getInstance().getIctrlADeportivas().darNombresActividadesDeportivas(inst);
		return acts;
	}
	
	public static DataActividad getDataActividad(String act){
		DataActividad acti;
		try {
			acti = ctrlADeportivas.getDataActividad(act);
		} 
		catch(Exception ex) {
			acti = null;
		}
		return acti;
	}
	
	public static Set<String> getCuponerasAD(){
		Set<String> resu = new HashSet<String>();
	
		try {
			resu=ctrlCuponeras.listarCuponeras();
		} catch (CuponeraNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resu;
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
