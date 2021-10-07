package controladores;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		Instituciones.cargarInstituciones();
		ConsultaActividad.cargarActividades();
		Login.cargarUsuarios();
		Categorias.cargarCategorias();
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
		req.setAttribute("actividad", actividad);
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
	
	public static void cargarActividades()
	{
		Fabrica.getInstance().getIctrlADeportivas().cargarDatosADeportivas();
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
