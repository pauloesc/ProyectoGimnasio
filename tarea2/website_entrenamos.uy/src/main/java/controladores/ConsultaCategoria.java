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

public class ConsultaCategoria extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public ConsultaCategoria() 
	{
		super();
		Instituciones.cargarInstituciones();
		Categorias.cargarCategorias();
		ConsultaActividad.cargarActividades();
		Login.cargarUsuarios();
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		req.getRequestDispatcher("/WEB-INF/categorias/consultaCategoria.jsp").forward(req, resp);
	}
	
	public static Set<String> getActividadesCat(String cat){
		//Set<String> acts = Fabrica.getInstance().getIctrlADeportivas()
		return null;
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
