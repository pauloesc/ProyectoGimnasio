package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.ActividadDeportivaNoExisteException;
import logica.DataActividad;
import logica.DtClase;
import logica.Fabrica;
import logica.IctrlADeportivas;
import logica.IctrlClases;
import logica.IctrlUsuarios;

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
		IctrlADeportivas IAD = f.getIctrlADeportivas();
		
		
		HttpSession sesion = req.getSession();
		IctrlUsuarios ICU = f.getIctrlUsuarios();
		boolean bien = false;
    	
		if ((String)sesion.getAttribute("estado-sesion") == "logged-in") {
    		try {
    			bien = ICU.esSocio((String)sesion.getAttribute("nickname-user"));
    		} catch (Exception e) {
    			
    		}
    	}
    	
		
		

		DtClase res = ICL.darDtClase((String)req.getParameter("clase"));
		
		if (res != null) {
			
			try {
				DataActividad da = IAD.getDataActividad(res.getNomAct());
				req.setAttribute("costoClase", String.valueOf(da.getCosto()));
			} catch (ActividadDeportivaNoExisteException a) {
				req.setAttribute("costoClase", "error");
			}
			
			Calendar fechaActual = Calendar.getInstance();  
			Date Factual = fechaActual.getTime();
			
			boolean vigente = !Factual.after(res.getFecha());
			
			
			if (bien && vigente) req.setAttribute("socio", "T");
			else req.setAttribute("socio", "F");
			
			req.setAttribute("nom", res.getNombre());
			req.setAttribute("nomP",res.getNomProfesor());
			req.setAttribute("act",res.getNomAct());
			req.setAttribute("url",res.getUrl());
			req.setAttribute("img",res.getImagen());
			
			//paulo
			req.setAttribute("minS",res.getMinSocios());
			req.setAttribute("actuS",res.getActualSocios());
			req.setAttribute("maxS",res.getMaxSocios());
			
			Date ee = res.getFechaReg();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			String dateString = formato.format(ee);
			req.setAttribute("fechaReg", dateString);
			//paulo
			
			Calendar c = Calendar.getInstance();
			c.setTime(res.getFecha());
			
			Integer h = res.getHora();
			Integer m = res.getMinuto();
			
			String hh = h.toString();
			String mm = m.toString();
			
			if (m < 10) {
				mm = "0" + mm;
			}
			if (h < 10) {
				hh = "0" + hh;
			}
			String ini = Integer.toString(c.get(Calendar.DATE)) + "/" + Integer.toString(c.get(Calendar.MONTH)+1) + "/" + Integer.toString(c.get(Calendar.YEAR)) + "    " +hh + ":" + mm;
			req.setAttribute("fecha",ini);
			
			
			RequestDispatcher md = req.getRequestDispatcher("/WEB-INF/clases/consultaClase.jsp");
			md.forward(req, resp);
		} else {
			resp.setContentType("text/html");
			PrintWriter salida = resp.getWriter();
			salida.println("<html><body>");
			salida.println("Ha ocurrido un error, clase no encontrada en el sistema");
			salida.println("</body></html>");
		}
	}

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

}
