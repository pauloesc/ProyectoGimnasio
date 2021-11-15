package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import publicadores.ActividadDeportivaNoExisteException_Exception;
import publicadores.ClaseLlenaException_Exception;
import publicadores.ClaseYaCompradaException_Exception;

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
    	
		boolean bien = false;
    	
		publicadores.WebServicesClasesService service = 
				new publicadores.WebServicesClasesService();
		
		publicadores.WebServicesClases port = service.getWebServicesClasesPort();
		
		publicadores.WebServicesControladorUsuarioService serviceUsr = 
				new publicadores.WebServicesControladorUsuarioService();
		
		publicadores.WebServicesControladorUsuario portUsr = serviceUsr.getWebServicesControladorUsuarioPort();
		
		publicadores.WebServicesADeportivasService serviceAD = 
				new publicadores.WebServicesADeportivasService();
		
		publicadores.WebServicesADeportivas portAD = serviceAD.getWebServicesADeportivasPort();
		
		if ((String)sesion.getAttribute("estado-sesion") == "logged-in") {
    		try {
    			bien = portUsr.esSocio((String)sesion.getAttribute("nickname-user"));
    		} catch (Exception e) {
    			
    		}
    	}
    	
    	if (bien) {
   
    		
        	String nom = req.getParameter("clase");
        	publicadores.DtClase dc = port.darDtClase(nom);
    
        	
        	try {
				publicadores.DataActividad da = portAD.getDataActividad(dc.getNomAct());
				req.setAttribute("costoClase", String.valueOf(da.getCosto()));
			} catch (ActividadDeportivaNoExisteException_Exception a) {
				req.setAttribute("costoClase", "error");
			}
        	
        	Set<String> nomCups = new HashSet<String>(portUsr.mostrarCuponerasDisponibles((String) sesion.getAttribute("nickname-user"), dc.getNomAct()).getSet());
        	
        	
        	req.setAttribute("nomC", nom);
        	req.setAttribute("nomCups", nomCups);
        	
        	Calendar c = Calendar.getInstance();
			c.setTime(dc.getFecha().toGregorianCalendar().getTime());
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
    	
		boolean bien = false;
		String nick = (String)sesion.getAttribute("nickname-user");
    	
		publicadores.WebServicesClasesService service = 
				new publicadores.WebServicesClasesService();
		
		publicadores.WebServicesClases port = service.getWebServicesClasesPort();
		
		publicadores.WebServicesControladorUsuarioService serviceUsr = 
				new publicadores.WebServicesControladorUsuarioService();
		
		publicadores.WebServicesControladorUsuario portUsr = serviceUsr.getWebServicesControladorUsuarioPort();
		
		publicadores.WebServicesADeportivasService serviceAD = 
				new publicadores.WebServicesADeportivasService();
		
		publicadores.WebServicesADeportivas portAD = serviceAD.getWebServicesADeportivasPort();
		
		if ((String)sesion.getAttribute("estado-sesion") == "logged-in") {
    		try {
    			bien = portUsr.esSocio(nick);
    		} catch (Exception e) {
    			
    		}
    	}
    	
    	if (bien) {
    		
    		
        	String nom = req.getParameter("clase");
        	publicadores.DtClase dc = port.darDtClase(nom);
        	
        	
        	try {
				publicadores.DataActividad da = portAD.getDataActividad(dc.getNomAct());
				req.setAttribute("costoClase", String.valueOf(da.getCosto()));
			} catch (ActividadDeportivaNoExisteException_Exception a) {
				req.setAttribute("costoClase", "error");
			}
        	
        	Set<String> nomCups = new HashSet<String>(portUsr.mostrarCuponerasDisponibles((String) sesion.getAttribute("nickname-user"), dc.getNomAct()).getSet());
        	
        	req.setAttribute("nomC", nom);
        	req.setAttribute("nomCups", nomCups);
        	
        	Calendar c = Calendar.getInstance();
			c.setTime(dc.getFecha().toGregorianCalendar().getTime());
			String ini = Integer.toString(c.get(Calendar.DATE)) + "/" + Integer.toString(c.get(Calendar.MONTH)+1) + "/" + Integer.toString(c.get(Calendar.YEAR)) + "  " +Integer.toString(dc.getHora()) + ":" + Integer.toString(dc.getMinuto());
			req.setAttribute("fecha",ini);
			
			boolean conCup = (req.getParameter("conCup") == "true");
			String cup = req.getParameter("cuponera");
			
			try {
				Calendar fechaActual = Calendar.getInstance();  
				Date Factual = fechaActual.getTime();
				
			
				GregorianCalendar calendar = new GregorianCalendar();
				calendar.setTime(Factual);
				XMLGregorianCalendar xmlDate = null;
				xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
				
				
				if (Factual.after(dc.getFecha().toGregorianCalendar().getTime())) {
					req.setAttribute("respuesta","Error, la clase ya expiró");
				} else {
					if (cup == null) cup = "";
					port.registrarSocioAClase(nick, dc.getNomAct(), nom, conCup, cup, xmlDate);
					req.setAttribute("respuesta","se ha comprado la clase exitosamente");
				}
	
			} catch (ClaseYaCompradaException_Exception e) {
				req.setAttribute("respuesta","Error, usted ya posee esta clase");
			} catch (ClaseLlenaException_Exception r){
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
