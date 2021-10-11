package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.Fabrica;
import logica.IctrlADeportivas;
import logica.IctrlCategorias;
import logica.IctrlClases;
import logica.IctrlCuponeras;
import logica.IctrlIDeportivas;
import logica.IctrlUsuarios;

public class Home extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public Home()
	{
		super();
		// carga de datos hardcodeados de la logica
		Fabrica fabrica = Fabrica.getInstance();
		IctrlADeportivas ICAD = fabrica.getIctrlADeportivas();
		IctrlIDeportivas ICID = fabrica.getIctrlIDeportivas();
		IctrlCuponeras ICC = fabrica.getIctrlCuponeras();
		IctrlClases ICCL = fabrica.getIctrlClases();
		IctrlUsuarios IU = fabrica.getIctrlUsuarios();
		IctrlCategorias ICAT = fabrica.getIctrlCategorias();       
		IctrlUsuarios ICU = fabrica.getIctrlUsuarios();
		
		ICID.cargarDatosIDeportivas();
    	ICAT.cargarCategorias();
        ICAD.cargarDatosADeportivas();
        IU.cargarUsuarios();
        ICC.cargarDatosCuponeras();
        ICCL.cargarDatosClases();
        ICCL.cargarRegistroAClases();
	}
	
	public static void iniciarSesion(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		if (session.getAttribute("estado_sesion") == null) 
		{
			session.setAttribute("estado_sesion", "no_login");
		}
	}
	
	public static String getEstadoSesion(HttpServletRequest request)
	{
		return (String)request.getSession().getAttribute("estado_sesion");
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		iniciarSesion(req);
		
		req.getRequestDispatcher("/WEB-INF/home/home.jsp").forward(req, resp);
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
