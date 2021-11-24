package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publicadores.DataActividad;
import publicadores.WebServicesADeportivas;
import publicadores.WebServicesADeportivasService;


public class ListarActividades extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static WebServicesADeportivasService serviceActividades;
	private static WebServicesADeportivas portActividades;

    public ListarActividades() {
    	super();
		serviceActividades = new WebServicesADeportivasService();
		portActividades = serviceActividades.getWebServicesADeportivasPort();
    }
    
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<DataActividad> acts = portActividades.buscarActividades("").getItem();
		
		req.setAttribute("actividades", acts);
		req.getRequestDispatcher("/WEB-INF/actividades/listarActividades.jsp").forward(req, resp);
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nickEnSesion = (String) request.getSession().getAttribute("nickname-user");

		//si hay una sesion
		if( nickEnSesion != null ) {
			processRequest(request, response);
		}
		
		else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
