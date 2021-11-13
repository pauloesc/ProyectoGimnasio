package controladores;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import logica.InfoBasicaProfesor;
import logica.InfoBasicaUser;
import publicadores.ActividadDeportivaRepetidaException_Exception;
import publicadores.WebServicesADeportivas;
import publicadores.WebServicesADeportivasService;

import org.apache.commons.io.FilenameUtils;

import net.java.dev.jaxb.array.StringArray;


@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, 	// 10 MB 
        maxFileSize=1024*1024*50,      	// 50 MB
        maxRequestSize=1024*1024*100)
public class AltaActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static WebServicesADeportivasService serviceActividades;
	private static WebServicesADeportivas portActividades;
	
	private static final String UPLOAD_DIR = "resources/img/actividades";

	public AltaActividad() {
		super();
		
		serviceActividades = new WebServicesADeportivasService();
		portActividades = serviceActividades.getWebServicesADeportivasPort();

	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String ninst = req.getParameter("institucionDeportiva");
		String nprof = (String) req.getSession().getAttribute("nickname-user");
		String nact = req.getParameter("nombreActividad");
		String descrip = req.getParameter("descripcionActividad");
		String dur = req.getParameter("duracionActividad");
		String cost = req.getParameter("costoActividad");
		String fileName = null;
		String ext = null;
		if ( req.getParts() != null ) {
			/*gets absolute path of the web application*/
	        String applicationPath = req.getServletContext().getRealPath("");
	        // constructs path of the directory to save uploaded file*/
	        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
	        
	        // creates the save directory if it does not exists
	        File fileSaveDir = new File(uploadFilePath);
	        if (!fileSaveDir.exists()) {
	            fileSaveDir.mkdirs();
	        }
	        
	        fileName = nact.toLowerCase().replaceAll("\\s", "");
	        String nomf = req.getPart("imagenActividad").getSubmittedFileName();
	        ext = FilenameUtils.getExtension(nomf);
	        Part part = req.getPart("imagenActividad");
	        part.write(uploadFilePath + File.separator + fileName + "." + ext);
			
		}
		
        
		Date date = new Date();
	
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		XMLGregorianCalendar xmlDate = null;
	
		try {
            xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		List<String> cats = Arrays.asList(req.getParameterValues("categoriasActividad"));
		StringArray catsenv = (StringArray) cats;
		
		try {
			portActividades.altaActividadDeportiva(ninst, nprof, nact, descrip, Float.parseFloat(dur),
					Float.parseFloat(cost), xmlDate, catsenv, fileName+ "." + ext);
			req.setAttribute("msjAlta", "La Actividad Deportiva se ha registrado con éxito.");
			req.setAttribute("estadoAlta", true);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ActividadDeportivaRepetidaException_Exception e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/WEB-INF/actividades/altaActividadDeportiva.jsp").forward(req, resp);
	}

	public static Set<String> getActividadesInst(String inst) {
		List<String> actsarr = portActividades.darNombresActividadesDeportivas(inst).getItem();
		Set<String> acts = new HashSet<String>(actsarr);
		return acts;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		InfoBasicaUser usr;
		try {
			usr = Login.getUsuarioLogueado(request);
		} 
		catch(Exception ex) {
			usr = null;
		}
		if (usr instanceof InfoBasicaProfesor) {
			InfoBasicaProfesor ibp = (InfoBasicaProfesor) usr;
			
			request.setAttribute("institucion", ibp.getInstitucion());
			request.setAttribute("estadoAlta", null);
			request.getRequestDispatcher("/WEB-INF/actividades/altaActividadDeportiva.jsp").forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath() + "/home");  
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InfoBasicaUser usr;
		try {
			usr = Login.getUsuarioLogueado(request);
		} 
		catch(Exception ex) {
			usr = null;
		}
		if (usr instanceof InfoBasicaProfesor) {
			InfoBasicaProfesor ibp = (InfoBasicaProfesor) usr;			
			request.setAttribute("institucion", ibp.getInstitucion());
			processRequest(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath() + "/home");  
		}
	}
	
}
