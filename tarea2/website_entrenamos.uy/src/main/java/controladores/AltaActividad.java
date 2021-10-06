package controladores;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.Fabrica;

public class AltaActividad extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public AltaActividad() 
	{
		super();
		Fabrica.getInstance().getIctrlIDeportivas().cargarDatosIDeportivas();
		Login.cargarUsuarios();
		Instituciones.cargarInstituciones();
		Categorias.cargarCategorias();
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		req.getRequestDispatcher("/WEB-INF/actividades/altaActividadDeportiva.jsp").forward(req, resp);
	}
	
	public static Set<String> getActividadesInst(String inst){
		Set<String> acts = Fabrica.getInstance().getIctrlADeportivas().darNombresActividadesDeportivas(inst);
		return acts;
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
