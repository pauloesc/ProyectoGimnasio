package controladores;

import java.io.IOException;
import java.util.Date;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excepciones.UsuarioDisponibilidadException;
import logica.Fabrica;
import logica.IctrlUsuarios;
import logica.InfoBasicaProfesor;
import logica.InfoBasicaSocio;
import logica.InfoBasicaUser;

/**
 * Servlet implementation class AltaUsuario
 */
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
		
		
		/**
		*traigo el controlador de usuario
		*/
		Fabrica f = Fabrica.getInstance();
		IctrlUsuarios ICU = f.getIctrlUsuarios();
		
		/**
		*traigo las instituciones
		*/
		Vector<String> instEnSistem =  ICU.InstitucionesEnSistema();
		
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
		InfoBasicaUser info = null;
		Date objDate = new Date(); 
		String img = "";
		
		//si es profesor
		if( esProfesor.equals("on") ) {
			
			InfoBasicaProfesor infoP = new InfoBasicaProfesor(
																nickname,
																nombre,
																apellido,
																email,
																objDate,
																pass,
																img,
																institucion,
																descripcion,
																bibliografia,
																web);
			
			
			info = infoP;
			
		}
		//si es socio
		else {
			
			InfoBasicaSocio infoS = new InfoBasicaSocio(
																nickname,
																nombre,
																apellido,
																email,
																objDate,
																pass,
																img);
			info = infoS;
			
		}
		
		/**
		*traigo el controlador de usuario
		*/
		Fabrica f = Fabrica.getInstance();
		IctrlUsuarios ICU = f.getIctrlUsuarios();

		boolean error = false;
		
		/**
		*cargo el usuario
		*/
		try {
			ICU.altaUsuario(info);
		} catch (UsuarioDisponibilidadException e) {
			error = true;
		}
		
		request.setAttribute("error", error);
		
		
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
		
		doGet(request, response);
		
	}

}
