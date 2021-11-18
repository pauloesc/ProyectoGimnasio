package controladores;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import publicadores.IOException_Exception;
import publicadores.WebServicesADeportivas;
import publicadores.WebServicesADeportivasService;
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
      
	private static WebServicesADeportivasService serviceActividades;
	private static WebServicesADeportivas portActividades;
	
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
		
		serviceActividades = new WebServicesADeportivasService();
		portActividades = serviceActividades.getWebServicesADeportivasPort();
		
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
		
		if ( !request.getPart("imagenUsuario").getSubmittedFileName().equals("") ) {
			
	        fileName = nickname.toLowerCase().replaceAll("\\s", "");
	        String nomf = request.getPart("imagenUsuario").getSubmittedFileName();
	        ext = FilenameUtils.getExtension(nomf);
	        Part part = request.getPart("imagenUsuario");
	        InputStream file = part.getInputStream();
	        byte[] bytearr = IOUtils.toByteArray(file);
			
	        try {
				portActividades.saveFile(bytearr, fileName + "." + ext);
			} catch (IOException_Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        img = ""+fileName+"."+ext; 
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
		
		GregorianCalendar c = new GregorianCalendar();
		c.setTime( fechaFormateadaDate );
		XMLGregorianCalendar date2 = null;
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//si es profesor
		if( esProfesor != null && esProfesor.equals("on") ) {
			
			publicadores.InfoBasicaProfesor infoP = new publicadores.InfoBasicaProfesor();
			infoP.setNickname(nickname);
			infoP.setNombre(nombre);
			infoP.setApellido(apellido);
			infoP.setCorreo(email);
			infoP.setFechaNac(date2);
			infoP.setPass(pass);
			infoP.setImg(img);
			infoP.setInstitucion(institucion);
			infoP.setDesc(descripcion);
			infoP.setBibliografia(bibliografia);
			infoP.setUrl(web);
			
			info = infoP;
		
		}
		//si es socio
		else {
			
			publicadores.InfoBasicaSocio infoS = new publicadores.InfoBasicaSocio();
			infoS.setNickname(nickname);
			infoS.setNombre(nombre);
			infoS.setApellido(apellido);
			infoS.setCorreo(email);
			infoS.setFechaNac(date2);
			infoS.setPass(pass);
			infoS.setImg(img);
			
			info = infoS;
			
		}
		
		//---------------------------
		WebServicesControladorUsuarioService serviceCUP = new WebServicesControladorUsuarioService();
		publicadores.WebServicesControladorUsuario port = serviceCUP.getWebServicesControladorUsuarioPort();
		//---------------------------	

		//indica si existio algun error
		boolean altaUsuarioEstado;
		String MensajeRespuesta;
		/**
		*cargo el usuario
		*/
		try {
			port.altaUsuario(info);
			altaUsuarioEstado = true;
			MensajeRespuesta = "El usuario se ha cargado con exito";
		} catch (publicadores.UsuarioDisponibilidadException_Exception e) {
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
		publicadores.WrapperListString auxInstEnSistem = port.institucionesEnSistema();
		List<String> instEnSistem = auxInstEnSistem.getLista();
		request.setAttribute("instituciones", instEnSistem);
		
		request.setAttribute("altaUsuarioEstado", altaUsuarioEstado);
		request.setAttribute("MensajeRespuesta", MensajeRespuesta);
		request.getRequestDispatcher("/WEB-INF/usuario/AltaUsuario.jsp").forward(request, response);
		
	}

}
