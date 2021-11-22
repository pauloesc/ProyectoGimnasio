package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publicadores.DtClase;
import publicadores.WebServicesADeportivas;
import publicadores.WebServicesADeportivasService;


public class ListarClases extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static WebServicesADeportivasService serviceActividades;
	private static WebServicesADeportivas portActividades;

    public ListarClases() {
    	super();
		serviceActividades = new WebServicesADeportivasService();
		portActividades = serviceActividades.getWebServicesADeportivasPort();
    }
    
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<DtClase> clases = portActividades.getTodasLasClases().getList();
		
		req.setAttribute("clases", clases);
		req.getRequestDispatcher("/WEB-INF/clases/listarClases.jsp").forward(req, resp);
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
