package controladores;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.DtClase;
import logica.Fabrica;
import logica.IctrlClases;

/**
 * Servlet implementation class ConsultaClase
 */
@WebServlet("/ConsultaClase")
public class ConsultaClase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ConsultaClase() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Fabrica f = Fabrica.getInstance();
		IctrlClases ICL = f.getIctrlClases();
		
		DtClase res = ICL.darDtClase((String)req.getParameter("clase"));
		
		req.setAttribute("nom", res.getNombre());
		req.setAttribute("nomP",res.getNomProfesor());
		req.setAttribute("act",res.getNomAct());
		req.setAttribute("url",res.getUrl());
		
		Calendar c = Calendar.getInstance();
		c.setTime(res.getFecha());
		String ini = Integer.toString(c.get(Calendar.DATE)) + "/" + Integer.toString(c.get(Calendar.MONTH)+1) + "/" + Integer.toString(c.get(Calendar.YEAR)) + "  " +Integer.toString(res.getHora()) + ":" + Integer.toString(res.getMinuto());
		req.setAttribute("fecha",ini);
		
		
		RequestDispatcher md = req.getRequestDispatcher("/WEB-INF/clases/consultaClase.jsp");
		md.forward(req, resp);
	}

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

}
