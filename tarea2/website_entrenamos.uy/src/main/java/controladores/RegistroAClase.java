package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.ClaseLlenaException;
import excepciones.ClaseYaCompradaException;
import logica.DtClase;
import logica.Fabrica;
import logica.IctrlClases;
import logica.IctrlUsuarios;

/**
 * Servlet implementation class RegistroAClase
 */
@WebServlet("/RegistroAClase")
public class RegistroAClase extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RegistroAClase() {
        super();
        
    }

    	
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession sesion = req.getSession();
    	Fabrica f = Fabrica.getInstance();
		IctrlUsuarios ICU = f.getIctrlUsuarios();
		IctrlClases ICL = f.getIctrlClases();
		boolean bien = false;
    	
		if ((String)sesion.getAttribute("estado-sesion") == "logged-in") {
    		try {
    			bien = ICU.esSocio((String)sesion.getAttribute("nickname-user"));
    		} catch (Exception e) {
    			
    		}
    	}
    	
    	if (bien) {
   
    		
        	String nom = req.getParameter("clase");
        	DtClase dc = ICL.darDtClase(nom);
    
        	
        	Set<String> nomCups = ICU.mostrarCuponerasDisponibles((String) sesion.getAttribute("nickname-user"), dc.getNomAct());
        	
        	;
        	
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
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession sesion = req.getSession();
    	Fabrica f = Fabrica.getInstance();
		IctrlUsuarios ICU = f.getIctrlUsuarios();
		IctrlClases ICL = f.getIctrlClases();
		boolean bien = false;
		String nick = (String)sesion.getAttribute("nickname-user");
    	
		if ((String)sesion.getAttribute("estado-sesion") == "logged-in") {
    		try {
    			bien = ICU.esSocio(nick);
    		} catch (Exception e) {
    			
    		}
    	}
    	
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
			
			boolean conCup = (req.getParameter("conCup") == "true");
			String cup = req.getParameter("cuponera");
			
			try {
				Calendar fechaActual = Calendar.getInstance();  
				Date Factual = fechaActual.getTime();
				ICL.registrarSocioAClase(nick, dc.getNomAct(), nom, conCup, cup, Factual);
				req.setAttribute("respuesta","se ha comprado la clase exitosamente");
			} catch (ClaseYaCompradaException e) {
				req.setAttribute("respuesta","Error, usted ya posee esta clase");
			} catch (ClaseLlenaException r){
				req.setAttribute("respuesta","Error, la clase está llena");
			} catch (Exception ex){
				req.setAttribute("respuesta","Error inesperado");
			}
 		
			
			RequestDispatcher dispatcher =getServletContext().getRequestDispatcher("/WEB-INF/clases/registroAClase.jsp");
			dispatcher.forward(req, resp);
			
        	
    	} else {
    		resp.setContentType("text/html");
			PrintWriter salida = resp.getWriter();
			salida.println("<html><body>");
			salida.println("error, primero debe loguearse con un socio");
			salida.println("</body></html>");
    	}
	}
	
	

}
