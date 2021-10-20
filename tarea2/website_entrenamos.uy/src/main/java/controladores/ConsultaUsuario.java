package controladores;

import java.beans.Encoder;
import java.io.IOException;
import java.util.Base64;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excepciones.UsuarioInexistenteException;
import logica.DataCuponera;
import logica.DtActividadesDeportivas;
import logica.DtClase;
import logica.Fabrica;
import logica.IctrlUsuarios;
import logica.InfoActividadProfe;
import logica.InfoActividadSocio;
import logica.InfoBasicaUser;
import logica.InformacionActividad;

/**
 * Servlet implementation class ConsultaUsuario
 */
@WebServlet("/ConsultaUsuario")
public class ConsultaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		*traigo el controlador de usuario
		*/
		Fabrica f = Fabrica.getInstance();
		IctrlUsuarios ICU = f.getIctrlUsuarios();
		
		
		/**
		*obtengo el nickname del socio en la url
		*/
		 String user = (String) request.getParameter("usuarioNick");
		
		/**
		*compruebo si quien esta visitando el perfil es el propio usuario
		*/
		boolean usuarioPropio;
		String nickEnSesion = (String) request.getSession().getAttribute("nickname-user");
		if ( nickEnSesion.equals(user) ) {
			usuarioPropio = true;				
		}
		else {
			usuarioPropio = false;
		}
		
		
		

		/**
		*si el usuario no estaba en la url, entonces hago una redireccion al home
		*/
		if( user == null ) {
			response.sendRedirect("/website_entrenamos.uy/home");
		}
		
		
		/**
		*compruebo si es un socio.
		*tambien se comprueba si existe el usuario 
		*/
		boolean esSocio = true;
		try {
			esSocio = ICU.esSocio(user);
		}
		catch(UsuarioInexistenteException e) {
			/**
			*si hay algun problema
			*/
			response.sendRedirect("/website_entrenamos.uy/home");
		}
		
		
		/**
		*Declaro las variables de la informacion comun a ambos usuarios 
		*/
		InfoBasicaUser informacionUusario = null;
		Vector<String> usuariosSeguidores = null;
		Vector<String> usuariosSiguiendo = null;
		InformacionActividad informacioActividad = null;
		

		/**
		*llamo a la funciones para traer la informacion
		*/
		informacionUusario = ICU.InformacionBasicaUsuario(user);
		usuariosSeguidores = ICU.UsuariosSeguidores(user);
		usuariosSiguiendo = ICU.UsuariosSiguiendo(user);
		
		informacioActividad = ICU.InformacionActividad(informacionUusario.getNickname());
		
		
		if ( "denis".equals(user) ) {
			System.out.println("son iguales");
		}
		else {
			System.out.println("son diferentes");
		}

	
		/**
		 * informacion dependiente del tipo de usuario
		 * declaro las variables 
		*/
		Vector<DataCuponera> cuponerasSocio = null;
		InfoActividadProfe actDepsIngRech = null;
		if(esSocio) {
			cuponerasSocio = ICU.Cuponeras(user);			
		}
		else {
			actDepsIngRech = ICU.InformacionActDepEstadoIngRech(user);			
		}
		
		
		/**
		*declaro esta variable para guardar la informacion del socio
		*/
		Vector<DtClase> informacionSocio = null;
		informacionSocio = new Vector<DtClase>();
		/**
		*declaro esta variable para guardar la informacion del profesor
		*/
		Vector<DtActividadesDeportivas> informacionProfesor = null;
		informacionProfesor = new Vector<DtActividadesDeportivas>();
		
		
		/**
		 * hay que castera la informacion
		 * si es un socio,
		 * para guardar la informacion utilizamos la variable informacionSocio
		*/
		if( informacioActividad.getClass() == InfoActividadSocio.class ) {
			
			InfoActividadSocio oo = (InfoActividadSocio) informacioActividad;
			Vector<Object> vecGenerico = oo.obtenerVector();
			
			Iterator<Object> iterat = vecGenerico.iterator();
			while( iterat.hasNext() ) {
				Object aux =  iterat.next( );
				informacionSocio.add( (DtClase) aux );
			}
			
		}
		
		
		/**
		 * hay que castera la informacion
		 * si es un profesor,
		 * para guardar la informacion utilizamos la variable informacionProfesor
		*/
		else {
			InfoActividadProfe oo = (InfoActividadProfe) informacioActividad;
			Vector<Object> vecGenerico = oo.obtenerVector();
			
			Iterator<Object> iterat = vecGenerico.iterator();
			while( iterat.hasNext() ) {
				Object aux =  iterat.next( );
				informacionProfesor.add( (DtActividadesDeportivas) aux );
			}
			
		}
		
		
		/**
		 * si es un profesor.
		 * informacion de activiades ingresadas profesor.
		*/
		Vector<DtActividadesDeportivas> informacionProfesorActDepIngRech = new Vector<DtActividadesDeportivas>();
		if( actDepsIngRech != null ) {
			Vector<Object> vecGenerico2 = actDepsIngRech.obtenerVector();
			
			Iterator<Object> iteratt = vecGenerico2.iterator();
			while( iteratt.hasNext() ) {
				Object aux =  iteratt.next( );
				informacionProfesorActDepIngRech.add( (DtActividadesDeportivas) aux );
			}
			
			
		}  
		
		
		System.out.println("----------------------");
		System.out.println("----------------------");
		System.out.println("----------------------");
		System.out.println("----------------------");
		
		//nickname
		System.out.println("NICKNAE: " +user);
		
		//es socio
		if(esSocio) { System.out.println("SI ES SOCIO");
		}
		else { System.out.println("NO ES SOCIO");
		}
		
		//----------INICIO
		//activideades dep del profesor
		//Vector<DtActividadesDeportivas> informacionProfesor = null;
		if( informacionProfesor.size() > 0 ) {
			System.out.println("EL PROFESOR TIENE ACTIVIDADES DEPORTIVAS");
		}
		else {System.out.println("EL PROFESOR NO TIENE ACTIVIDADES DEPORTIVAS");
		}
		
		Iterator<DtActividadesDeportivas> actDepDelProfe = informacionProfesor.iterator();
		while( actDepDelProfe.hasNext() ) {
			DtActividadesDeportivas actDepDelProfe_info = actDepDelProfe.next();
			String abc = actDepDelProfe_info.getNombre();
			System.out.println(abc);
		}
		//----------FIN
		
		System.out.println("----------------------");
		System.out.println("----------------------");
		System.out.println("----------------------");
		System.out.println("----------------------");
		
		
		
		Vector<String> usuariosEnSistema = ICU.UsuariosEnSistemaNickName();

		request.setAttribute("usuarioEnSistema", usuariosEnSistema);
		request.setAttribute("esSocio", esSocio);
		request.setAttribute("infoUsuario", informacionUusario);
		request.setAttribute("infoSocio", informacionSocio);
		request.setAttribute("infoProfe", informacionProfesor);
		request.setAttribute("usersSeguidores", usuariosSeguidores);
		request.setAttribute("usersSiguiendo", usuariosSiguiendo);
		request.setAttribute("cuponeras", cuponerasSocio);
		request.setAttribute("actDepIngRech", informacionProfesorActDepIngRech);
		request.setAttribute("userPropio", usuarioPropio);
		request.getRequestDispatcher("/WEB-INF/usuario/consultaUsuario.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
