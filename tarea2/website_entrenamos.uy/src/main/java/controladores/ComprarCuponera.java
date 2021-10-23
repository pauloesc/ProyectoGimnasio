package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.ActividadDeportivaRepetidaException;
import excepciones.ClaseLlenaException;
import excepciones.ClaseYaCompradaException;
import excepciones.CuponeraCompradaException;
import logica.DataCuponera;
import logica.DtClase;
import logica.Fabrica;
import logica.IctrlClases;
import logica.IctrlCuponeras;
import logica.IctrlUsuarios;

/**
 * Servlet implementation class RegistroAClase
 */
@WebServlet("/ComprarCuponera")
public class ComprarCuponera extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private static IctrlCuponeras ctrlCuponeras = Fabrica.getInstance().getIctrlCuponeras();
    public ComprarCuponera() {
        super();
        
    }

    	
    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		HttpSession sesion = req.getSession();
    	Fabrica f = Fabrica.getInstance();
		IctrlUsuarios ICU = f.getIctrlUsuarios();
		IctrlClases ICL = f.getIctrlClases();
		boolean bien = false;
    	
		String cup= (String)sesion.getAttribute("cuponera");
		
		if ((String)sesion.getAttribute("estado-sesion") == "logged-in") {
    		try {
    			bien = ICU.esSocio((String)sesion.getAttribute("nickname-user"));
    		} catch (Exception e) {
    			
    		}
    	}
		
		Date date = new Date();
		if (bien) {
			String nomP = (String) sesion.getAttribute("nickname-user");
		try {
			ctrlCuponeras.comprarCuponera(date, cup, nomP); 
			req.setAttribute("msjcompra", "La cuponera se ha comprado con exito.");
			req.setAttribute("compra", true);
		} catch (CuponeraCompradaException e) {
			req.setAttribute("msjcompra", e.getMessage());
			req.setAttribute("compra", false);
		}
		}
		
		req.getRequestDispatcher("/WEB-INF/cuponeras/consultaCuponera.jsp").forward(req, resp);

    	if (bien) {
    		
    		
        	String nom = req.getParameter("clase");
        	DtClase dc = ICL.darDtClase(nom);
        	
        	Set<String> nomCups = ICU.mostrarCuponerasDisponibles((String) sesion.getAttribute("nickname-user"), dc.getNomAct());
        	
        	req.setAttribute("nomC", nom);
        	req.setAttribute("nomCups", nomCups);
        	
        	Calendar c = Calendar.getInstance();
			c.setTime(dc.getFecha());
			String ini = Integer.toString(c.get(Calendar.DATE)) + "/" + Integer.toString(c.get(Calendar.MONTH)+1) + "/" + Integer.toString(c.get(Calendar.YEAR)) + "  " +Integer.toString(dc.getHora()) + ":" + Integer.toString(dc.getMinuto());
			req.setAttribute("fecha",ini);
        	
        	RequestDispatcher md = req.getRequestDispatcher("/WEB-INF/clases/registroAClase.jsp");
			md.forward(req, resp);
        	
    	} else {
    		resp.setContentType("text/html");
			PrintWriter salida = resp.getWriter();
			salida.println("<html><body>");
			salida.println("error, primero debe loguearse con un socio");
			salida.println("</body></html>");
    	}
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
