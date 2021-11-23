package controladores;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publicadores.DtActividadesDeportivas;
import publicadores.UsuarioInexistenteException_Exception;
import publicadores.WebServicesControladorUsuarioService;

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
		
		
		//---------------------------
		WebServicesControladorUsuarioService serviceCUP = new WebServicesControladorUsuarioService();
		publicadores.WebServicesControladorUsuario port = serviceCUP.getWebServicesControladorUsuarioPort();
		//---------------------------		
		
		/**
		*obtengo el nickname del socio en la url
		*/
		 String user = (String) request.getParameter("usuarioNick");
		
		/**
		*compruebo si quien esta visitando el perfil es el propio usuario
		*/
		boolean usuarioPropio = false;
		boolean haySesion = false;
		boolean siguiendoUsuario = false;
		String nickEnSesion = (String) request.getSession().getAttribute("nickname-user");

		//si hay una sesion
		if( nickEnSesion != null ) {
			//si el perfil visitado coincide con el usuario en sesion
			if ( nickEnSesion.equals(user) ) {
				usuarioPropio = true;				
			}
			else {
				usuarioPropio = false;
				siguiendoUsuario = port.usuarioSigueAUsuario(nickEnSesion, user);
			}
			
			//si nickEnSesion diferente de null, entonces hay sesion
			haySesion = true;
		}
		else {
			haySesion = false;
			usuarioPropio = false;
		}
		
		
		

		/**
		*si el usuario no estaba en la url, entonces hago una redireccion al home
		*/
		if( user == null || user.equals("") ) {
			response.sendRedirect("ListarUsuarios");
			return;
		}
		
		
		/**
		*compruebo si es un socio.
		*tambien se comprueba si existe el usuario 
		*/
		boolean esSocio = true;
		try {
			esSocio = port.esSocio(user);
		}
		catch(UsuarioInexistenteException_Exception e) {
			/**
			*si hay algun problema
			*/
			response.sendRedirect("home");
			return;
		}
		
		/**
		*Declaro las variables de la informacion comun a ambos usuarios 
		*/
		publicadores.InfoBasicaUser informacionUusario = null;
		List<String> usuariosSeguidores = null;
		List<String> usuariosSiguiendo = null;
		publicadores.InformacionActividad informacioActividad = null;
		

		/**
		*llamo a la funciones para traer la informacion
		*/
		
						
		// informacion el usuario---------------------------
		informacionUusario = port.informacionBasicaUsuario(user);
		//---------------------------

		
		// seguidores del usuario---------------------------
		publicadores.WrapperListString usuariosSres = port.usuariosSeguidores(user);
		usuariosSeguidores = usuariosSres.getLista();
		//---------------------------
		
				
		// a quien esta siguiendo el usuario---------------------------
		publicadores.WrapperListString usuariosSdo = port.usuariosSiguiendo(user);
		usuariosSiguiendo = usuariosSdo.getLista();
		//---------------------------
		
		
		
		informacioActividad = port.informacionActividad(user);
		
		
		/**
		 * informacion dependiente del tipo de usuario
		 * declaro las variables 
		*/
		List<publicadores.DataCuponera> cuponerasSocio = null;
		
		publicadores.InfoActividadProfe actDepsIngRech = null;
		
		if(esSocio) {
			publicadores.WrapperDataCuponera informacionCuponeras = port.cuponeras(user);
			cuponerasSocio = informacionCuponeras.getLista();
			
		}
		else {
			actDepsIngRech = port.informacionActDepEstadoIngRech(user);			
		}
		
		List<publicadores.DtPremio> premios = null;
		if ( esSocio && usuarioPropio ) {
			premios = port.getPremiosDeUsuario(nickEnSesion).getList();
		}
		
		
		//--------------
		List<publicadores.DtActividadesDeportivas> todasLasActivDepDeProfesor = null;
		if(! esSocio) {
			todasLasActivDepDeProfesor = port.todasLasActividadesDeUnProfesor(user).getActividadesDep();
		}
		request.setAttribute("infoActivvProfe", todasLasActivDepDeProfesor);
		//--------------
		
		
		System.out.println("****--*-*-*-*-*");
		
		if( todasLasActivDepDeProfesor != null ) {
			
			Iterator<DtActividadesDeportivas> ititit = todasLasActivDepDeProfesor.iterator();
			
			while( ititit.hasNext() ) {
				
				DtActividadesDeportivas auxx = ititit.next();
				
				
				
				System.out.println(auxx.getNombre());
				System.out.println(auxx.getEstado());
				System.out.println(auxx.getDescripcion());
				System.out.println("****--*-*-*-*-*");
				
			}
			
			
		}
		
		
		
		/**
		*declaro esta variable para guardar la informacion del socio
		*/
		List<publicadores.DtClase> informacionSocio = null;
		/**
		*declaro esta variable para guardar la informacion del profesor
		*/
		List<publicadores.DtActividadesDeportivas> informacionProfesor = null;
		
		
		/**
		 * hay que castera la informacion
		 * si es un socio,
		 * para guardar la informacion utilizamos la variable informacionSocio
		*/
		if( informacioActividad.getClass() == publicadores.InfoActividadSocio.class ) {
			
			publicadores.InfoActividadSocio oo = (publicadores.InfoActividadSocio) informacioActividad;
			informacionSocio = oo.getClases();
			
		}
		
		
		/**
		 * hay que castera la informacion
		 * si es un profesor,
		 * para guardar la informacion utilizamos la variable informacionProfesor
		*/
		else {
			publicadores.InfoActividadProfe oo = (publicadores.InfoActividadProfe) informacioActividad;
			informacionProfesor =  oo.getActividadesDep();
			
		}
		
		
		/**
		 * si es un profesor.
		 * informacion de activiades ingresadas profesor.
		*/
		List<publicadores.DtActividadesDeportivas> informacionProfesorActDepIngRech = null;
		if( actDepsIngRech != null ) {
			informacionProfesorActDepIngRech = actDepsIngRech.getActividadesDep();
		}  
		
		
		request.setAttribute("esSocio", esSocio);
		request.setAttribute("infoUsuario", informacionUusario);
		request.setAttribute("infoSocio", informacionSocio);
		request.setAttribute("infoProfe", informacionProfesor);
		request.setAttribute("usersSeguidores", usuariosSeguidores);
		request.setAttribute("usersSiguiendo", usuariosSiguiendo);
		request.setAttribute("cuponeras", cuponerasSocio);
		request.setAttribute("premios", premios);
		request.setAttribute("actDepIngRech", informacionProfesorActDepIngRech);
		request.setAttribute("userPropio", usuarioPropio);
		request.setAttribute("haySesion", haySesion);
		request.setAttribute("siguiendoUsuario", siguiendoUsuario);
		
		
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
