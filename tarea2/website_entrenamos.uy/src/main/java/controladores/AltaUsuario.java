package controladores;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.io.FilenameUtils;

import excepciones.UsuarioDisponibilidadException;
import logica.Fabrica;
import logica.IctrlUsuarios;
import logica.InfoBasicaProfesor;
import logica.InfoBasicaSocio;
import logica.InfoBasicaUser;
import publicadores.WebServicesControladorUsuarioService;

/**
 * Servlet implementation class AltaUsuario
 */

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100)

@WebServlet("/AltaUsuario")
public class AltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//---------------------------
		WebServicesControladorUsuarioService serviceCUP = new WebServicesControladorUsuarioService();
		publicadores.WebServicesControladorUsuario port = serviceCUP.getWebServicesControladorUsuarioPort();
		//---------------------------		
		
		/**
		*traigo las instituciones
		*/
		publicadores.WrapperListString auxInstEnSistem =  port.institucionesEnSistema();
		List<String> instEnSistem = auxInstEnSistem.getLista();
		
		request.setAttribute("instituciones", instEnSistem);
		request.getRequestDispatcher("/WEB-INF/usuario/AltaUsuario.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//amo esta linea de codigo
		request.setCharacterEncoding("UTF-8");
		
		String nickname = request.getParameter("nickname");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String fecha = request.getParameter("fecha");
		String pass = request.getParameter("pass");
		String passVerificacion = request.getParameter("passVerificacion");
		String esProfesor = request.getParameter("esProfesor");
		String institucion = request.getParameter("institucion");
		String descripcion = request.getParameter("descripcion");
		String bibliografia = request.getParameter("bibliografia");
		String web = request.getParameter("web");
		
		//auxiliares
		publicadores.InfoBasicaUser info = null;
		String img = "";
		
		
		//imagen
		String ext = "";
		String fileName = null;
		
		if ( request.getParts() != null ) {
		
			/*gets absolute path of the web application*/
	        String applicationPath = request.getServletContext().getRealPath("");

	        // constructs path of the directory to save uploaded file*/
	        String uploadFilePath = applicationPath + File.separator + "resources/img/usuarios";

	        // creates the save directory if it does not exists
	        File fileSaveDir = new File(uploadFilePath);
	        if (!fileSaveDir.exists()) {
	            fileSaveDir.mkdirs();
	        }
	     
	        fileName = nickname.toLowerCase().replaceAll("\\s", "");
	        String nomf = request.getPart("imagenUsuario").getSubmittedFileName();
	        ext = FilenameUtils.getExtension(nomf);
	        Part part = request.getPart("imagenUsuario");
	        part.write(uploadFilePath + File.separator + fileName + "." + ext);
			img = "./resources/img/usuarios/" + fileName + "." + ext;
			System.out.println(img);
		}
		
		
		
		
		/**
		 *proceso la fecha en el formato que viene
		 */
		Date feI = null;
		try {
			feI = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		} catch (ParseException e1) {
		}
		
		/**
		 *proceso la fecha en el formato que quiero
		 */
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = formato.format(feI);

		/**
		 *genero la fecha a guardar en el sistema
		 */
		Date fechaFormateadaDate = null;
		try {
			fechaFormateadaDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
		} catch (ParseException e1) {
		}
		
		//si es profesor
		if( esProfesor != null && esProfesor.equals("on") ) {
			
			publicadores.InfoBasicaProfesor infoP = new publicadores.InfoBasicaProfesor();
			infoP.setNickname(nickname);
			infoP.setNombre(nombre);
			infoP.setApellido(apellido);
			infoP.setCorreo(email);
			//infoP.setFechaNac(fechaFormateadaDate);
			GregorianCalendar c = new GregorianCalendar();
			c.setTime( new Date() );
			XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			infoP.setPass(pass);
			infoP.setImg(img);
			infoP.setInstitucion(institucion);
			infoP.setDesc(descripcion);
			infoP.setBibliografia(bibliografia);
			infoP.setUrl(web);
			
			
			/**
			publicadores.InfoBasicaProfesor infoP = new publicadores.InfoBasicaProfesor(
																nickname,
																nombre,
																apellido,
																email,
																fechaFormateadaDate,
																pass,
																img,
																institucion,
																descripcion,
																bibliografia,
																web);
			
			
			info = infoP;
			*/
			
			
		}
		//si es socio
		else {
			
			publicadores.InfoBasicaSocio infoS = new publicadores.InfoBasicaSocio(
																nickname,
																nombre,
																apellido,
																email,
																fechaFormateadaDate,
																pass,
																img);
			info = infoS;
			
		}
		
		/**
		*traigo el controlador de usuario
		*/
		Fabrica f = Fabrica.getInstance();
		IctrlUsuarios ICU = f.getIctrlUsuarios();

		//indica si existio algun error
		boolean altaUsuarioEstado;
		String MensajeRespuesta;
		/**
		*cargo el usuario
		*/
		try {
			ICU.altaUsuario(info);
			altaUsuarioEstado = true;
			MensajeRespuesta = "El usuario se ha cargado con exito";
		} catch (UsuarioDisponibilidadException e) {
			altaUsuarioEstado = false;
			MensajeRespuesta = e.getMessage().toString();
		}
		
		
		/**
		System.out.println( nickname  );
		System.out.println( nombre  );
		System.out.println( apellido  );
		System.out.println( email  );
		System.out.println( fecha  );
		System.out.println( pass  );
		System.out.println( passVerificacion );
		System.out.println( esProfesor );
		System.out.println( institucion  );
		System.out.println( descripcion  );
		System.out.println( bibliografia  );
		System.out.println( web  );
		*/
		
		/**
		*traigo las instituciones
		*/
		List<String> instEnSistem =  ICU.institucionesEnSistema();
		request.setAttribute("instituciones", instEnSistem);
		
		request.setAttribute("altaUsuarioEstado", altaUsuarioEstado);
		request.setAttribute("MensajeRespuesta", MensajeRespuesta);
		request.getRequestDispatcher("/WEB-INF/usuario/AltaUsuario.jsp").forward(request, response);
		
	}

}
