package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publicadores.PremioSorteadosException_Exception;

/**
 * Servlet implementation class SortearPremios
 */
@WebServlet("/SortearPremios")
public class SortearPremios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SortearPremios() {
        super();
        // TODO Auto-generated constructor stub
   }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	publicadores.WebServicesClasesService service = 
				new publicadores.WebServicesClasesService();
		
		publicadores.WebServicesClases port = service.getWebServicesClasesPort();
		
		try {
			port.sortearPremios((String)request.getParameter("clase"));
			request.setAttribute("respuesta", "premios sorteados correctamente");
		} catch (PremioSorteadosException_Exception e) {
			request.setAttribute("respuesta", "los premios ya han sido sorteados");
		}
		
		ServletContext context = this.getServletContext(); 
		RequestDispatcher dispatcher = context.getRequestDispatcher("/ConsultaClase"); 

		dispatcher.forward(request, response); 
		
	}
    
}