package controladores;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.ActividadDeportivaRepetidaException;
import logica.Fabrica;
import logica.IctrlADeportivas;

public class AltaActividad extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private static IctrlADeportivas ctrlADeportivas = Fabrica.getInstance().getIctrlADeportivas();
	
	public AltaActividad() 
	{
		super();
		
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		String ninst = (String) req.getAttribute("institucionDeportiva");
		String nprof = "nombre prof";
		String nact = (String) req.getAttribute("nombreActividad");
		String descrip = (String) req.getAttribute("descripcionActividad");
		Float dur = (Float) req.getAttribute("duracionActividad");
		Float cost = (Float) req.getAttribute("costoActividad");
		Date date = new Date();
		Set<String> cats = null;
		try {
			ctrlADeportivas.altaActividadDeportiva(ninst, nprof, nact, descrip, dur, cost, date, cats);
		} catch (ActividadDeportivaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/WEB-INF/actividades/altaActividadDeportiva.jsp").forward(req, resp);
	}
	
	public static Set<String> getActividadesInst(String inst){
		Set<String> acts = Fabrica.getInstance().getIctrlADeportivas().darNombresActividadesDeportivas(inst);
		return acts;
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		request.getRequestDispatcher("/WEB-INF/actividades/altaActividadDeportiva.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		processRequest(request, response);
	}
}
