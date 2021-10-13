package controladores;

import excepciones.ActividadDeportivaRepetidaException;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import logica.Fabrica;
import logica.IctrlADeportivas;
import logica.InfoBasicaProfesor;
import logica.InfoBasicaUser;



@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, 	// 10 MB 
        maxFileSize=1024*1024*50,      	// 50 MB
        maxRequestSize=1024*1024*100)
public class AltaActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static IctrlADeportivas ctrlADeportivas = Fabrica.getInstance().getIctrlADeportivas();
	private static final String UPLOAD_DIR = "resources/img";

	public AltaActividad() {
		super();

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
		if (req.getParameter("imagenActividad") != null ) {
			/*gets absolute path of the web application*/
	        String applicationPath = req.getServletContext().getRealPath("");
	        // constructs path of the directory to save uploaded file*/
	        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
	        
	        // creates the save directory if it does not exists
	        File fileSaveDir = new File(uploadFilePath);
	        if (!fileSaveDir.exists()) {
	            fileSaveDir.mkdirs();
	        }
			
	        
	        //Get all the parts from request and write it to the file on server
	        for (Part part : req.getParts()) {
	            fileName = part.getSubmittedFileName();
	            part.write(uploadFilePath + File.separator + fileName);
	        }
		}
		
        
		Date date = new Date();
		Set<String> cats = new HashSet<>(Arrays.asList(req.getParameterValues("categoriasActividad")));
		try {
			ctrlADeportivas.altaActividadDeportiva(ninst, nprof, nact, descrip, Float.parseFloat(dur),
					Float.parseFloat(cost), date, cats, fileName);
			req.setAttribute("msjAlta", "La Actividad Deportiva se ha registrado con éxito.");
			req.setAttribute("estadoAlta", true);
		} catch (ActividadDeportivaRepetidaException e) {
			req.setAttribute("msjAlta", e.getMessage());
			req.setAttribute("estadoAlta", false);
		}
		req.getRequestDispatcher("/WEB-INF/actividades/altaActividadDeportiva.jsp").forward(req, resp);
	}

	public static Set<String> getActividadesInst(String inst) {
		Set<String> acts = Fabrica.getInstance().getIctrlADeportivas().darNombresActividadesDeportivas(inst);
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
			processRequest(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath() + "/home");  
		}
	}
	
}
