package controladores;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.io.FilenameUtils;

import publicadores.ClaseRepetidaException_Exception;


@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100)

@WebServlet("/AltaClase")
public class AltaClase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AltaClase() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession sesion = req.getSession();
		
		
		boolean ESocio = true;
		
		
		publicadores.WebServicesControladorUsuarioService service = 
				new publicadores.WebServicesControladorUsuarioService();
		
		publicadores.WebServicesControladorUsuario portUsr = service.getWebServicesControladorUsuarioPort();
		
		publicadores.WebServicesADeportivasService serviceAD = 
				new publicadores.WebServicesADeportivasService();
		
		publicadores.WebServicesADeportivas portAD = serviceAD.getWebServicesADeportivasPort();
		
    	
		if ((String)sesion.getAttribute("estado-sesion") == "logged-in") {
    		try {
    			ESocio = portUsr.esSocio((String)sesion.getAttribute("nickname-user"));
    		} catch (Exception e) {
    			
    		}
    	}
    	
    	if (!ESocio) {
        	
			
    		publicadores.InfoBasicaProfesor infP = (publicadores.InfoBasicaProfesor)portUsr.informacionBasicaUsuario((String)sesion.getAttribute("nickname-user"));
			
			
			
			
			List<String> actsarr = portAD.darNombresActividadesDeportivas(infP.getInstitucion()).getItem();
			Set<String> acts = new HashSet<String>(actsarr);
			
			req.setAttribute("institucion",infP.getInstitucion());
			req.setAttribute("actividades",acts);
			
        	RequestDispatcher md = req.getRequestDispatcher("/WEB-INF/clases/altaClase.jsp");
			md.forward(req, resp);
        	
    	} else {
    		resp.setContentType("text/html");
			PrintWriter salida = resp.getWriter();
			salida.println("<html><body>");
			salida.println("error, primero debe loguearse con un profesor");
			salida.println("</body></html>");
    	}
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession sesion = req.getSession();
    	
		
		boolean ESocio = true;
    	
		
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
    			ESocio = portUsr.esSocio((String)sesion.getAttribute("nickname-user"));
    		} catch (Exception e) {
    			
    		}
    	}
    	
    	if (!ESocio) {
    		publicadores.InfoBasicaProfesor infP = (publicadores.InfoBasicaProfesor)portUsr.informacionBasicaUsuario((String)sesion.getAttribute("nickname-user"));
    		List<String> actsarr = portAD.darNombresActividadesDeportivas(infP.getInstitucion()).getItem();
			Set<String> acts = new HashSet<String>(actsarr);
			
			req.setAttribute("institucion",infP.getInstitucion());
			req.setAttribute("actividades",acts);
			
			int Smin = Integer.parseInt(req.getParameter("sociosMinimos"));
			int Smax = Integer.parseInt(req.getParameter("sociosMaximos"));
			
			Date feI = null;
			
			try {
				
				
				String fll = req.getParameter("datepicker");
				String fn = req.getParameter("datepicker").replace("-","/");
				
				
				
				
				if (fll == fn) {
					feI = new SimpleDateFormat("MM/dd/yy").parse(fll);
				} else {
					feI = new SimpleDateFormat("yy/MM/dd").parse(fn);
				}
					
			} catch (Exception s) {
				
			}
			
			Calendar fechaActual = Calendar.getInstance();  
			Date Factual = fechaActual.getTime();
			
			if ((Smin < 0) || (Smax < 0)) {
				req.setAttribute("respuesta","Error socios minimos y socios maximos deben ser mayor a 0");
    		} else if (Smin > Smax) {
				req.setAttribute("respuesta","Error socios minimos mayor que socios maximos");
			} else if (feI.before(Factual)) {
				req.setAttribute("respuesta","Error fecha de inicio anterior a fecha actual");
			} else {
				try {
					
					String nomC = req.getParameter("nombreClase");
					String nomP = (String) sesion.getAttribute("nickname-user");
					String url = req.getParameter("urlClase");
					String act = req.getParameter("actividadDeportiva");
					String hora = req.getParameter("timepicker");
					
					
					String h = "";
					String m = "";
					char dosp = ':';
					boolean yaMin = false;
					for (int n = 0; n < hora.length(); n++) { 
						char c = hora.charAt (n);
						if (c == dosp) {
							yaMin = true;
						} else if (yaMin) {
							m = m + c;
						} else {
							h = h + c;
						}
						
					}
				
					
					
					//imagen
					String ext = "";
					String fileName = null;
					
					if ( req.getParts() != null ) {
					
						/*gets absolute path of the web application*/
				        String applicationPath = req.getServletContext().getRealPath("");
			
				        // constructs path of the directory to save uploaded file*/
				        String uploadFilePath = applicationPath + File.separator + "resources/img/clases";
		
				        // creates the save directory if it does not exists
				        File fileSaveDir = new File(uploadFilePath);
				        if (!fileSaveDir.exists()) {
				            fileSaveDir.mkdirs();
				        }
				     
				        fileName = nomC.toLowerCase().replaceAll("\\s", "");
				        String nomf = req.getPart("imagenClase").getSubmittedFileName();
				        ext = FilenameUtils.getExtension(nomf);
				        Part part = req.getPart("imagenClase");
				        part.write(uploadFilePath + File.separator + fileName + "." + ext);
						
					}
					
					
					
					GregorianCalendar calendarFei = new GregorianCalendar();
					calendarFei.setTime(feI);
					XMLGregorianCalendar xmlDateFei = null;
				
					GregorianCalendar calendarFact = new GregorianCalendar();
					calendarFact.setTime(Factual);
					XMLGregorianCalendar xmlDateFact = null;
						
					try {
			            xmlDateFei = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendarFei);
			            xmlDateFact = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendarFact);
			        }
			        catch (Exception e) {
			            e.printStackTrace();
			        }
					
					port.crearClase(nomC,xmlDateFei, nomP,Smin ,Smax ,url ,xmlDateFact , act, Integer.parseInt(h), Integer.parseInt(m),fileName + "." + ext);
					
					req.setAttribute("respuesta","La clase ha sido creada con exito");
				} catch (ClaseRepetidaException_Exception e) {
					req.setAttribute("respuesta","Error, ya existe una clase con ese nombre");
				} catch (Exception s) {
					req.setAttribute("respuesta","Error inesperado");
				}
			}
			
			RequestDispatcher dispatcher =req.getRequestDispatcher("/WEB-INF/clases/altaClase.jsp");
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
