/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import excepciones.InstitucionDeportivaRepetidaException;
import excepciones.UsuarioDisponibilidadException;
import excepciones.UsuarioInexistenteException;
import logica.DataCuponera;
import logica.InfoActividadProfe;
import logica.InfoBasicaProfesor;
import logica.InfoBasicaSocio;
import logica.InfoBasicaUser;
import logica.InformacionActividad;
import logica.ctrlIDeportivas;
import logica.ctrlUsuarios;
import logica.manejIDeportivas;

/**
 * @author pe
 *
 */
class ctrlUsuariosTest {

	/**
	 * Test method for {@link logica.ctrlUsuarios#mostrarNombreProfesoresDeInstitucion(java.lang.String)}.
	 */
	@Test
	void testMostrarNombreProfesoresDeInstitucion() {
		
		//preparacion de datos
		ctrlUsuarios cu = new ctrlUsuarios();
		ctrlIDeportivas cid = new ctrlIDeportivas();
		
		//creo las instituciones
		try {
		cid.altaInstitucion("inst1", "desc1", "url1");
		cid.altaInstitucion("inst2", "desc2", "url2");
		cid.altaInstitucion("inst3", "desc3", "url3");
		}
		catch( InstitucionDeportivaRepetidaException e) {
			
		}
		
		//creo profes y los asocio a inst1
		InfoBasicaUser p1 = new InfoBasicaProfesor(	"nick p1",		"nombre p1",
													"apellido p1",	"correo p1",
													new Date(),"0", "",  "inst1",
													"descp p1", 	"bibliog p1",
													"url p1");
		
		InfoBasicaUser p2 = new InfoBasicaProfesor(	"nick p2",		"nombre p2",
													"apellido p2",	"correo p2",
													new Date(),"0", "",	"inst1",
													"descp p2", 	"bibliog p2",
													"url p2" );
		
		InfoBasicaUser p3 = new InfoBasicaProfesor(	"nick p3",		"nombre p3",
													"apellido p3",	"correo p3",
													new Date(),"0", "",	"inst2",
													"descp p3", 	"bibliog p3",
													"url p3" );
		try {
			cu.altaUsuario(p1);
			cu.altaUsuario(p2);
			cu.altaUsuario(p3);
		}catch(UsuarioDisponibilidadException e){
			
		}
		
		Set<String> entrada1 = new HashSet<String>();
		entrada1.add("nick p1");
		entrada1.add("nick p2");
		
		Set<String> entrada2 = new HashSet<String>();
		entrada2.add("nick p3");
		
		
		
		Set<String> respuesta1 = cu.mostrarNombreProfesoresDeInstitucion("inst1");
		Set<String> respuesta2 = cu.mostrarNombreProfesoresDeInstitucion("inst2");

		//verificacion
		assertEquals( entrada1, respuesta1, "problema1" );
		assertEquals( entrada2, respuesta2, "problema2" );
		
		cu.elimiarManjeador();
		manejIDeportivas.elimiarManjeador();
		
		cu = null;
		cid = null;
	}

	/**
	 * Test method for {@link logica.ctrlUsuarios#altaUsuario(logica.InfoBasicaUser)}.
	 */
	
	
	@Test
	void testAltaUsuario() {
		
		//preparacion de datos
		ctrlUsuarios cu = new ctrlUsuarios();
		
		ctrlIDeportivas cid = new ctrlIDeportivas();
		
		//creo las instituciones
		try {
		cid.altaInstitucion("inst1", "desc1", "url1");
		cid.altaInstitucion("inst2", "desc2", "url2");
		cid.altaInstitucion("inst3", "desc3", "url3");
		}
		catch( InstitucionDeportivaRepetidaException e) {
			
		}
		
		//creo profes
		InfoBasicaProfesor p1 = new InfoBasicaProfesor(	"nick p1",		"nombre p1",
													"apellido p1",	"correo p1",
													new Date(),"0", "",	"inst1",
													"descp p1", 	"bibliog p1",
													"url p1" );
		
		InfoBasicaProfesor p2 = new InfoBasicaProfesor(	"nick p2",		"nombre p2",
													"apellido p2",	"correo p2",
													new Date(),"0", "",	"inst1",
													"descp p2", 	"bibliog p2",
													"url p2");
		//creo socios
		InfoBasicaSocio s1 = new InfoBasicaSocio(	"nick s1",		"nombre s1",
													"apellido s1",	"correo s1",
													new Date(),"0" , "");
		
		InfoBasicaSocio s2 = new InfoBasicaSocio(	"nick s2",		"nombre s2",
													"apellido s2",	"correo s2",
													new Date(),"0" , "");
		
		

		
		try {
			cu.altaUsuario(p1);
			cu.altaUsuario(p2);
			cu.altaUsuario(s1);
			cu.altaUsuario(s2);

		}catch(UsuarioDisponibilidadException e){
			
		}
		
		InfoBasicaUser respuesta_p1 = cu.informacionBasicaUsuario("nick p1");
		InfoBasicaUser respuesta_p2 = cu.informacionBasicaUsuario("nick p2");
		InfoBasicaUser respuesta_s1 = cu.informacionBasicaUsuario("nick s1");
		InfoBasicaUser respuesta_s2 = cu.informacionBasicaUsuario("nick s2");
		
		//compruebo si son instancias de lo que corresponde
		assertTrue(respuesta_p1 instanceof InfoBasicaProfesor, "no es instanciap1");
		assertTrue(respuesta_p2 instanceof InfoBasicaProfesor, "no es instanciap2");
		assertTrue(respuesta_s1 instanceof InfoBasicaSocio, "no es instanciass1");
		assertTrue(respuesta_s2 instanceof InfoBasicaSocio, "no es instancias2");

		//casteo las respuestas
		InfoBasicaProfesor respuesta_p1_casteo = (InfoBasicaProfesor)respuesta_p1;
		InfoBasicaProfesor respuesta_p2_casteo = (InfoBasicaProfesor)respuesta_p2;
		InfoBasicaSocio respuesta_s1_casteo = (InfoBasicaSocio)respuesta_s1;
		InfoBasicaSocio respuesta_s2_casteo = (InfoBasicaSocio)respuesta_s2;
		
		//compruebo que se crea y se devulve el mismo objeto
		assertTrue( p1.sonIguales(respuesta_p1_casteo), "son dif");
		assertTrue( p2.sonIguales(respuesta_p2_casteo), "son dif");
		assertTrue( s1.sonIguales(respuesta_s1_casteo), "son dif");
		assertTrue( s2.sonIguales(respuesta_s2_casteo), "son dif");

		//segunda parte
		//segunda parte
		//prueba de usuarios con identificadores repetidos y funcionamiento de try
		//creo un profe con datos iguales pero dif nickname
		
		InfoBasicaProfesor p1_1 = new InfoBasicaProfesor( 	"nick p1_1",		"nombre p1",
															"apellido p1",	"correo p1",
															new Date(),"0", "",	"inst1",
															"descp p1", 	"bibliog p1",
															"url p1");
		
		//creo un profe con datos iguales pero dif correo
		InfoBasicaProfesor p1_2 = new InfoBasicaProfesor(	"nick p1",		"nombre p1",
															"apellido p1",	"correo p1_2",
															new Date(),"0", "",	"inst1",
															"descp p1", 	"bibliog p1",
															"url p1");
		
		//creo socios el mismo socio que antes (s1)
		InfoBasicaSocio s1_1 = new InfoBasicaSocio(	"nick s1",		"nombre s1",
													"apellido s1",	"correo s1",
													new Date(),"0" , "");
		
		try {
			cu.altaUsuario(p1_1);
			cu.altaUsuario(p1_2);
			cu.altaUsuario(s1_1);

		}catch(UsuarioDisponibilidadException e){
			
		}
		
		final ctrlUsuarios cuCopia = cu;
		assertThrows( UsuarioDisponibilidadException.class, ()-> {cuCopia.altaUsuario(p1_1);} );
		assertThrows( UsuarioDisponibilidadException.class, ()-> {cuCopia.altaUsuario(p1_2);} );
		assertThrows( UsuarioDisponibilidadException.class, ()-> {cuCopia.altaUsuario(s1_1);} );
		
		//tambien testeo la funcion
		//autenticarUsario(String nickname, String email, String contrasena)
		//datos a utilizar
		/**
		 * "nick s1","nombre s1","apellido s1",	"correo s1",new Date(),"0" , "");
		 */
				
		String respuestaNicknameValido = cu.autenticarUsario("nick s1", null, "0");
		String respuestaNicknameInvalido = cu.autenticarUsario("nic", null, "0");
		
		String respuestaCorreoValido = cu.autenticarUsario(null, "correo s1", "0");
		String respuestaCorreoInvalido = cu.autenticarUsario(null, "corr", "0");
		
		String respuestaFallida1 = cu.autenticarUsario("nick s1", null, "1");
		String respuestaFallida2 = cu.autenticarUsario(null, "correo s1", "1");
		
	    assertTrue( respuestaNicknameValido == null , "la autenticacion no fue exitosa, problema");
	    assertTrue( respuestaNicknameInvalido != null , "la autenticacion fue exitosa, problema");
	    
	    assertTrue( respuestaCorreoValido == null , "la autenticacion no fue exitosa, problema");
	    assertTrue( respuestaCorreoInvalido != null , "la autenticacion fue exitosa, problema");

		
		manejIDeportivas.elimiarManjeador();
		cu.elimiarManjeador();
		
		cu=null;
		cid = null;
		
	}


	/**
	 * Test method for {@link logica.ctrlUsuarios#InstitucionesEnSistema()}.
	 */
	@Test
	void testInstitucionesEnSistema() {
		
		ctrlUsuarios cu = new ctrlUsuarios();
		ctrlIDeportivas cid = new ctrlIDeportivas();
		
		//cargo algunas instituciones
		try {
			cid.altaInstitucion("institucion1", "desc inst 1", "url inst 1");
			cid.altaInstitucion("institucion2", "desc inst 2", "url inst 2");
			cid.altaInstitucion("institucion3", "desc inst 3", "url inst 3");
		} catch (InstitucionDeportivaRepetidaException e) {
			
		}
		
		Vector<String> vecDatosEntrada = new Vector<String>();
		vecDatosEntrada.add("institucion1");
		vecDatosEntrada.add("institucion2");
		vecDatosEntrada.add("institucion3");
		
		//utilizo carga de datos
		List<String> vecDatosRespuesta = cu.institucionesEnSistema();
		
		
		//si lo de adentro es falso dispara el assert
		
		
		boolean mismo1 = (vecDatosEntrada.size() == vecDatosRespuesta.size()); 
		boolean mismo2 = vecDatosEntrada.containsAll(vecDatosRespuesta);
		boolean mismo3 = vecDatosRespuesta.containsAll(vecDatosEntrada);
		
	    assertTrue(mismo1 & mismo2 & mismo3, "Las instituciones ingresadas y devueltas no coinciden");

		
		manejIDeportivas.elimiarManjeador();
		cu.elimiarManjeador();
		cu=null;
		cid = null;
		
	}

	/**
	 * Test method for {@link logica.ctrlUsuarios#InformacionActividad(java.lang.String)}.
	 */
	@Test
	void testInformacionActividad() {
		
		ctrlUsuarios cu = new ctrlUsuarios();
		
		ctrlIDeportivas cid = new ctrlIDeportivas();
		
		//cargo institucion para usuarios
		try {
			cid.altaInstitucion("inst1", "desc inst 1", "url inst 1");
		} catch (InstitucionDeportivaRepetidaException e) {
			
		}
		
		//creo profes
		InfoBasicaProfesor p1 = new InfoBasicaProfesor(	"nick p1",		"nombre p1",
													"apellido p1",	"correo p1",
													new Date(),"0", "",	"inst1",
													"descp p1", 	"bibliog p1",
													"url p1");
		
		InfoBasicaProfesor p2 = new InfoBasicaProfesor(	"nick p2",		"nombre p2",
													"apellido p2",	"correo p2",
													new Date(),"0", "",	"inst1",
													"descp p2", 	"bibliog p2",
													"url p2");
		//creo socios
		InfoBasicaSocio s1 = new InfoBasicaSocio(	"nick s1",		"nombre s1",
													"apellido s1",	"correo s1",
													new Date(),"0" , "");
		
		InfoBasicaSocio s2 = new InfoBasicaSocio(	"nick s2",		"nombre s2",
													"apellido s2",	"correo s2",
													new Date(),"0" , "");
		
		try {
			cu.altaUsuario(p1);
			cu.altaUsuario(p2);
			cu.altaUsuario(s1);
			cu.altaUsuario(s2);
		}catch(UsuarioDisponibilidadException e){
			
		}
		
		//como solo estan cargados los profesores y los socios
		//tiene que ser vacia la actividad
		 InformacionActividad info_p1 = cu.informacionActividad("nick p1");
		 InformacionActividad info_p2 = cu.informacionActividad("nick p2");
		 //compruebo que sea vacia la info.
		 assertTrue( info_p1.obtenerVector().isEmpty() );
		 assertTrue( info_p2.obtenerVector().isEmpty() );
		 
		 InformacionActividad info_s1 = cu.informacionActividad("nick p1");
		 InformacionActividad info_s2 = cu.informacionActividad("nick p2");
		 //compruebo que sea vacia la info.
		 assertTrue( info_s1.obtenerVector().isEmpty() );
		 assertTrue( info_s2.obtenerVector().isEmpty() );
		 
		
			manejIDeportivas.elimiarManjeador();
			cu.elimiarManjeador();
			cu=null;
			cid = null;
	}

	/**
	 * Test method for {@link logica.ctrlUsuarios#ActualizarInformacionUsuario(logica.InfoBasicaUser)}.
	 */
	@Test
	void testActualizarInformacionUsuario() {
		
		//preparacion de datos
		ctrlUsuarios cu = new ctrlUsuarios();
		ctrlIDeportivas cid = new ctrlIDeportivas();
		
		//creo las instituciones
		try {
		cid.altaInstitucion("inst1", "desc1", "url1");
		cid.altaInstitucion("inst2", "desc2", "url2");
		cid.altaInstitucion("inst3", "desc3", "url3");
		}
		catch( InstitucionDeportivaRepetidaException e) {
			
		}
		
		//creo profes y los asocio a inst1
		InfoBasicaProfesor p1 = new InfoBasicaProfesor(	"nick p1",		"nombre p1",
													"apellido p1",	"correo p1",
													new Date(),"0", "",	"inst1",
													"descp p1", 	"bibliog p1",
													"url p1");
		
		InfoBasicaProfesor p2 = new InfoBasicaProfesor(	"nick p2",		"nombre p2",
													"apellido p2",	"correo p2",
													new Date(),"0", "",	"inst1",
													"descp p2", 	"bibliog p2",
													"url p2");
		
		//creo socios
		InfoBasicaSocio s1 = new InfoBasicaSocio(	"nick s1",		"nombre s1",
													"apellido s1",	"correo s1",
													new Date(),"0" , "");
		
		InfoBasicaSocio s2 = new InfoBasicaSocio(	"nick s2",		"nombre s2",
													"apellido s2",	"correo s2",
													new Date(),"0" , "");
		
		try {
			cu.altaUsuario(p1);
			cu.altaUsuario(p2);
			cu.altaUsuario(s1);
			cu.altaUsuario(s2);
		}catch(UsuarioDisponibilidadException e){
			
		}
		
		//cambio la info del profesor p1
		InfoBasicaProfesor p1M = new InfoBasicaProfesor("nick p1",		"nombre p1M",
														"apellido p1M",	"correo p1",
														new Date(),"", "", 	"inst1",
														"descp p1M", 	"bibliog p1M",
														"url p1M");
		
		InfoBasicaProfesor p2M = new InfoBasicaProfesor("nick p2",		"nombre p2M",
														"apellido p2M",	"correo p2",
														new Date(),"", "",	"inst1",
														"descp p2M", 	"bibliog p2M",
														"url p2M");
		
		//modifico socios
		InfoBasicaSocio s1M = new InfoBasicaSocio(	"nick s1",		"nombre s1M",
													"apellido s1M",	"correo s1",
													new Date(),"" , "");
		
		InfoBasicaSocio s2M = new InfoBasicaSocio(	"nick s2",		"nombre s2M",
													"apellido s2M",	"correo s2",
													new Date(),"" , "");
		
		
		cu.actualizarInformacionUsuario(p1M);
		cu.actualizarInformacionUsuario(p2M);
		cu.actualizarInformacionUsuario(s1M);
		cu.actualizarInformacionUsuario(s2M);
		
		//traigo la info desde el sistema
		InfoBasicaUser p1M_Respuesta = cu.informacionBasicaUsuario("nick p1");
		InfoBasicaUser p2M_Respuesta = cu.informacionBasicaUsuario("nick p2");
		InfoBasicaUser s1M_Respuesta = cu.informacionBasicaUsuario("nick s1");
		InfoBasicaUser s2M_Respuesta = cu.informacionBasicaUsuario("nick s2");

		assertTrue( p1M.sonIguales( (InfoBasicaProfesor)p1M_Respuesta  ), "Info diferente" );
		assertTrue( p2M.sonIguales( (InfoBasicaProfesor)p2M_Respuesta  ), "Info diferente" );
		assertTrue( s1M.sonIguales( (InfoBasicaSocio)s1M_Respuesta  ), "Info diferente" );
		assertTrue( s2M.sonIguales( (InfoBasicaSocio)s2M_Respuesta  ), "Info diferente" );
		
		manejIDeportivas.elimiarManjeador();
		cu.elimiarManjeador();
		cu=null;
		cid = null;
		
	}

	/**
	 * Test method for {@link logica.ctrlUsuarios#InformacionBasicaUsuario(java.lang.String)}.
	 */
	@Test
	void testInformacionBasicaUsuario() {
		
		//preparacion de datos
		ctrlUsuarios cu = new ctrlUsuarios();
		ctrlIDeportivas cid = new ctrlIDeportivas();
		
		//creo las instituciones
		try {
		cid.altaInstitucion("inst1", "desc1", "url1");
		cid.altaInstitucion("inst2", "desc2", "url2");
		cid.altaInstitucion("inst3", "desc3", "url3");
		}
		catch( InstitucionDeportivaRepetidaException e) {
			
		}
		
		//creo profes
		InfoBasicaProfesor p1 = new InfoBasicaProfesor(	"nick p1",		"nombre p1",
													"apellido p1",	"correo p1",
													new Date(),"0", "",	"inst1",
													"descp p1", 	"bibliog p1",
													"url p1" );
		
		InfoBasicaProfesor p2 = new InfoBasicaProfesor(	"nick p2",		"nombre p2",
													"apellido p2",	"correo p2",
													new Date(),"0", "",	"inst1",
													"descp p2", 	"bibliog p2",
													"url p2" );
		//creo socios
		InfoBasicaSocio s1 = new InfoBasicaSocio(	"nick s1",		"nombre s1",
													"apellido s1",	"correo s1",
													new Date(),"0" , "");
		
		InfoBasicaSocio s2 = new InfoBasicaSocio(	"nick s2",		"nombre s2",
													"apellido s2",	"correo s2",
													new Date(),"0" , "");
		
		try {
			cu.altaUsuario(p1);
			cu.altaUsuario(p2);
			cu.altaUsuario(s1);
			cu.altaUsuario(s2);

		}catch(UsuarioDisponibilidadException e){
			
		}
		
		InfoBasicaUser respuesta_p1 = cu.informacionBasicaUsuario("nick p1");
		InfoBasicaUser respuesta_p2 = cu.informacionBasicaUsuario("nick p2");
		InfoBasicaUser respuesta_s1 = cu.informacionBasicaUsuario("nick s1");
		InfoBasicaUser respuesta_s2 = cu.informacionBasicaUsuario("nick s2");
		
		InfoBasicaProfesor respuesta_p1_casteo = (InfoBasicaProfesor)respuesta_p1;
		InfoBasicaProfesor respuesta_p2_casteo = (InfoBasicaProfesor)respuesta_p2;
		InfoBasicaSocio respuesta_s1_casteo = (InfoBasicaSocio)respuesta_s1;
		InfoBasicaSocio respuesta_s2_casteo = (InfoBasicaSocio)respuesta_s2;
		
		assertTrue( p1.sonIguales(respuesta_p1_casteo), "No son iguales" );
		assertTrue( p2.sonIguales(respuesta_p2_casteo), "No son iguales" );
		assertTrue( s1.sonIguales(respuesta_s1_casteo), "No son iguales" );
		assertTrue( s2.sonIguales(respuesta_s2_casteo), "No son iguales" );
		
		manejIDeportivas.elimiarManjeador();
		cu.elimiarManjeador();
		cu=null;
		cid = null;
		
	}

	/**
	 * Test method for {@link logica.ctrlUsuarios#UsuariosEnSistemaNickName()}.
	 */
	@Test
	void testUsuariosEnSistemaNickName() {
		
		ctrlUsuarios cu = new ctrlUsuarios();
		
		//creo profes
		InfoBasicaProfesor p1 = new InfoBasicaProfesor(	"nick p1",		"nombre p1",
													"apellido p1",	"correo p1",
													new Date(),"0", "",	"inst1",
													"descp p1", 	"bibliog p1",
													"url p1" );
		
		InfoBasicaProfesor p2 = new InfoBasicaProfesor(	"nick p2",		"nombre p2",
													"apellido p2",	"correo p2",
													new Date(),"0", "",	"inst1",
													"descp p2", 	"bibliog p2",
													"url p2" );
		//creo socios
		InfoBasicaSocio s1 = new InfoBasicaSocio(	"nick s1",		"nombre s1",
													"apellido s1",	"correo s1",
													new Date(),"0", "" );
		
		InfoBasicaSocio s2 = new InfoBasicaSocio(	"nick s2",		"nombre s2",
													"apellido s2",	"correo s2",
													new Date(),"0", "" );
		
		Vector<String> datosIngresados = new Vector<String>();
		datosIngresados.add(p1.getNickname());
		datosIngresados.add(p2.getNickname());
		datosIngresados.add(s1.getNickname());
		datosIngresados.add(s2.getNickname());

		try {
			cu.altaUsuario(p1);
			cu.altaUsuario(p2);
			cu.altaUsuario(s1);
			cu.altaUsuario(s2);

		}catch(UsuarioDisponibilidadException e){
			
		}
		
		List<String> respuesta = cu.usuariosEnSistemaNickName();
		
		boolean mismo1 = (datosIngresados.size() == respuesta.size()); 
		boolean mismo2 = datosIngresados.containsAll(respuesta);
		boolean mismo3 = respuesta.containsAll(datosIngresados);
		
	    assertTrue(mismo1 & mismo2 & mismo3, "Las instituciones ingresadas y devueltas no coinciden");
		
		cu.elimiarManjeador();
		cu=null;
		
	}

	/**
	 * Test method for {@link logica.ctrlUsuarios#MostrarCuponerasDisponibles(java.lang.String, java.lang.String)}.
	 */
	@Ignore
	void testMostrarCuponerasDisponibles() {
		fail("sd");
	}

	/**
	 * Test method for {@link logica.ctrlUsuarios#mostrarNicknameSocios()}.
	 */
	@Test
	void testMostrarNicknameSocios() {
		
		ctrlUsuarios cu = new ctrlUsuarios();
		
		//creo profes
		InfoBasicaProfesor p1 = new InfoBasicaProfesor(	"nick p1",		"nombre p1",
													"apellido p1",	"correo p1",
													new Date(),"0", "",	"inst1",
													"descp p1", 	"bibliog p1",
													"url p1");
		
		InfoBasicaProfesor p2 = new InfoBasicaProfesor(	"nick p2",		"nombre p2",
													"apellido p2",	"correo p2",
													new Date(),"0", "",	"inst1",
													"descp p2", 	"bibliog p2",
													"url p2");
		//creo socios
		InfoBasicaSocio s1 = new InfoBasicaSocio(	"nick s1",		"nombre s1",
													"apellido s1",	"correo s1",
													new Date(),"0", "" );
		
		InfoBasicaSocio s2 = new InfoBasicaSocio(	"nick s2",		"nombre s2",
													"apellido s2",	"correo s2",
													new Date(),"0", "" );
		
		//datos esperados
		Set<String> datosEsperados = new HashSet<String>();
		datosEsperados.add(s1.getNickname());
		datosEsperados.add(s2.getNickname());

		try {
			cu.altaUsuario(p1);
			cu.altaUsuario(p2);
			cu.altaUsuario(s1);
			cu.altaUsuario(s2);
		}catch(UsuarioDisponibilidadException e){
			
		}
		
		Set<String> respuesta = cu.mostrarNicknameSocios();
		
		boolean mismo1 = (datosEsperados.size() == respuesta.size()); 
		boolean mismo2 = datosEsperados.containsAll(respuesta);
		boolean mismo3 = respuesta.containsAll(datosEsperados);
		
	    assertTrue(mismo1 & mismo2 & mismo3, "Los socios esperados no coiniden con los recibidos");
		
		cu.elimiarManjeador();
		cu=null;
	}

	/**
	 * Test method for {@link logica.ctrlUsuarios#cargarUsuarios()}.
	 */

	@Test
	void testUsuariosSiguiendo(){
	
		//preparacion de datos
		ctrlUsuarios cu = new ctrlUsuarios();
		ctrlIDeportivas cid = new ctrlIDeportivas();
		
		//creo las instituciones
		try {
			cid.altaInstitucion("inst1", "desc1", "url1");
			cid.altaInstitucion("inst2", "desc2", "url2");
			cid.altaInstitucion("inst3", "desc3", "url3");
		}
		catch( InstitucionDeportivaRepetidaException e) {
			
		}
		
		//creo profes
		InfoBasicaProfesor p1 = new InfoBasicaProfesor(	"nick p1",		"nombre p1",
													"apellido p1",	"correo p1",
													new Date(),"0", "",	"inst1",
													"descp p1", 	"bibliog p1",
													"url p1" );
		
		InfoBasicaProfesor p2 = new InfoBasicaProfesor(	"nick p2",		"nombre p2",
													"apellido p2",	"correo p2",
													new Date(),"0", "",	"inst1",
													"descp p2", 	"bibliog p2",
													"url p2");
		//creo socios
		InfoBasicaSocio s1 = new InfoBasicaSocio(	"nick s1",		"nombre s1",
													"apellido s1",	"correo s1",
													new Date(),"0" , "");
		
		InfoBasicaSocio s2 = new InfoBasicaSocio(	"nick s2",		"nombre s2",
													"apellido s2",	"correo s2",
													new Date(),"0" , "");
		
		
		
		
		try {
			cu.altaUsuario(p1);
			cu.altaUsuario(p2);
			cu.altaUsuario(s1);
			cu.altaUsuario(s2);
		
		}catch(UsuarioDisponibilidadException e){
			
		}
		
		//prueba 1
		cu.seguirUsuario("nick p1", "nick p2");
		cu.seguirUsuario("nick p1", "nick s1");
		
		List<String> siguiendo = null;
		siguiendo = cu.usuariosSiguiendo("nick p1");
		
		Set<String> NicknameSiguiendo = new HashSet<String>();
		NicknameSiguiendo.add("nick p2");
		NicknameSiguiendo.add("nick s1");
		
		Set<String> set_siguiendo = new HashSet<String>(siguiendo);
		Set<String> set_NicknameSiguiendo = new HashSet<String>(NicknameSiguiendo);
		
		boolean mismo1 = (set_siguiendo.size() == set_NicknameSiguiendo.size()); 
		boolean mismo2 = set_siguiendo.containsAll(set_NicknameSiguiendo);
		boolean mismo3 = set_NicknameSiguiendo.containsAll(set_siguiendo);
	    assertTrue(mismo1 & mismo2 & mismo3, "Los socios esperados no coiniden con los recibidos");
		
	    
	  //prueba 2
		cu.seguirUsuario("nick p2", "nick p1");
		cu.seguirUsuario("nick p2", "nick s1");
		cu.seguirUsuario("nick p2", "nick s2");
		
		List<String> siguiendo2 = null;
		siguiendo2 = cu.usuariosSiguiendo("nick p1");
		
		Set<String> NicknameSiguiendo2 = new HashSet<String>();
		NicknameSiguiendo2.add("nick p1");
		NicknameSiguiendo2.add("nick s1");
		NicknameSiguiendo2.add("nick s2");
		
		Set<String> set_siguiendo2 = new HashSet<String>(siguiendo2);
		Set<String> set_NicknameSiguiendo2 = new HashSet<String>(NicknameSiguiendo);
		
		mismo1 = (set_siguiendo2.size() == set_NicknameSiguiendo2.size()); 
		mismo2 = set_siguiendo2.containsAll(set_NicknameSiguiendo2);
		mismo3 = set_NicknameSiguiendo2.containsAll(set_siguiendo2);
	    assertTrue(mismo1 & mismo2 & mismo3, "Los socios esperados no coiniden con los recibidos");

		manejIDeportivas.elimiarManjeador();
		cu.elimiarManjeador();
		
		cu=null;
		cid = null;
		
	}
	@Test
	void testUsuariosSeguidores(){
		
		//preparacion de datos
		ctrlUsuarios cu = new ctrlUsuarios();
		ctrlIDeportivas cid = new ctrlIDeportivas();
		
		
		//creo las instituciones
		try {
			cid.altaInstitucion("inst1", "desc1", "url1");
			cid.altaInstitucion("inst2", "desc2", "url2");
			cid.altaInstitucion("inst3", "desc3", "url3");
		}
		catch( InstitucionDeportivaRepetidaException e) {
			
		}
		
		//creo profes
		InfoBasicaProfesor p1 = new InfoBasicaProfesor(	"nick p1",		"nombre p1",
													"apellido p1",	"correo p1",
													new Date(),"0", "",	"inst1",
													"descp p1", 	"bibliog p1",
													"url p1" );
		
		InfoBasicaProfesor p2 = new InfoBasicaProfesor(	"nick p2",		"nombre p2",
													"apellido p2",	"correo p2",
													new Date(),"0", "",	"inst1",
													"descp p2", 	"bibliog p2",
													"url p2");
		//creo socios
		InfoBasicaSocio s1 = new InfoBasicaSocio(	"nick s1",		"nombre s1",
													"apellido s1",	"correo s1",
													new Date(),"0" , "");
		
		InfoBasicaSocio s2 = new InfoBasicaSocio(	"nick s2",		"nombre s2",
													"apellido s2",	"correo s2",
													new Date(),"0" , "");
		
		
		
		
		try {
			cu.altaUsuario(p1);
			cu.altaUsuario(p2);
			cu.altaUsuario(s1);
			cu.altaUsuario(s2);
		
		}catch(UsuarioDisponibilidadException e){
			
		}
		
		//prueba 1
		cu.seguirUsuario("nick p1", "nick s1");
		cu.seguirUsuario("nick p2", "nick s1");
		cu.seguirUsuario("nick s2", "nick s1");
		
		List<String> Seguidores = null;
		Seguidores = cu.usuariosSeguidores("nick s1");
		
		Set<String> NicknameSeguidores = new HashSet<String>();
		NicknameSeguidores.add("nick p1");
		NicknameSeguidores.add("nick p2");
		NicknameSeguidores.add("nick s2");
		
		Set<String> set_Seguidores = new HashSet<String>(Seguidores);
		Set<String> set_NicknameSiguiendo = new HashSet<String>(NicknameSeguidores);
		
		boolean mismo1 = (set_Seguidores.size() == set_NicknameSiguiendo.size()); 
		boolean mismo2 = set_Seguidores.containsAll(set_NicknameSiguiendo);
		boolean mismo3 = set_NicknameSiguiendo.containsAll(set_Seguidores);
	    assertTrue(mismo1 & mismo2 & mismo3, "Los socios esperados no coiniden con los recibidos");
		
		
		manejIDeportivas.elimiarManjeador();
		cu.elimiarManjeador();
		
		cu=null;
		cid = null;
		
		
	}

	@Test
	void seguirUsuarios() {
		ctrlUsuarios cu = new ctrlUsuarios();
		
		
		InfoBasicaUser p1 = new InfoBasicaSocio(	"nick1",		"nombre p1",
						"apellido p1",	"correo p1",
						new Date(),"0", "");
		
		InfoBasicaUser p2 = new InfoBasicaSocio(	"nick2",		"nombre p2",
						"apellido p2",	"correo p2",
						new Date(),"0", "");
		
		InfoBasicaUser p3 = new InfoBasicaSocio(	"nick3",		"nombre p3",
						"apellido p3",	"correo p3",
						new Date(),"0", "");
		
		try {
			cu.altaUsuario(p1);
			cu.altaUsuario(p2);
			cu.altaUsuario(p3);
		} catch (Exception asd) {
			fail("Test fallllllló");
		}
		
		
		try {
			cu.seguirUsuario("nick1","nick2");
			cu.seguirUsuario("nick1","nick3");
			assertEquals(0,0);
		} catch (Exception ex) {
			fail("Test falló");
		}
		
		
		try {
			cu.dejarDeSeguirUsuario("nick1","nick2");
			cu.dejarDeSeguirUsuario("nick1","nick3");
			assertEquals(0,0);
		} catch (Exception eex) {
			fail("Test falló");
		}
		
		
		
		cu.elimiarManjeador();
		cu=null;
		
	}
	
	@Test
	void getNicknameUsuario() {
		
		
		//preparacion de datos
		ctrlUsuarios cu = new ctrlUsuarios();
		ctrlIDeportivas cid = new ctrlIDeportivas();
		
		//creo las instituciones
		try {
		cid.altaInstitucion("inst1", "desc1", "url1");
		cid.altaInstitucion("inst2", "desc2", "url2");
		cid.altaInstitucion("inst3", "desc3", "url3");
		}
		catch( InstitucionDeportivaRepetidaException e) {
			
		}
		
		//creo profes y los asocio a inst1
		InfoBasicaUser p1 = new InfoBasicaProfesor(	"nick p1",		"nombre p1",
													"apellido p1",	"correo p1",
													new Date(),"0", "",  "inst1",
													"descp p1", 	"bibliog p1",
													"url p1");
		
		InfoBasicaUser p2 = new InfoBasicaProfesor(	"nick p2",		"nombre p2",
													"apellido p2",	"correo p2",
													new Date(),"0", "",	"inst1",
													"descp p2", 	"bibliog p2",
													"url p2" );
		
		InfoBasicaUser p3 = new InfoBasicaProfesor(	"nick p3",		"nombre p3",
													"apellido p3",	"correo p3",
													new Date(),"0", "",	"inst2",
													"descp p3", 	"bibliog p3",
													"url p3" );
		try {
			cu.altaUsuario(p1);
			cu.altaUsuario(p2);
			cu.altaUsuario(p3);
		}catch(UsuarioDisponibilidadException e){
			
		}
		
		
		String respuesta1 = cu.getNicknameUsuario( "correo p2" );
		String respuesta2 = cu.getNicknameUsuario( "tiene que fallar" );
		
		assertTrue( respuesta1.equals("nick p2")  , "el nickname no coincide, problema");
		assertTrue( respuesta2 == null  , "idintifico a un usuario con un correo q no exite");
		
		//preparacion de datos
		cu.elimiarManjeador();
		
	}
	
	
	@Test
	void cuponeras() {
	
		//preparacion de datos
		ctrlUsuarios cu = new ctrlUsuarios();

		//creo socios
		InfoBasicaSocio s1 = new InfoBasicaSocio(	"nick s1",		"nombre s1",
													"apellido s1",	"correo s1",
													new Date(),"0" , "");
		
		try {
			cu.altaUsuario(s1);	
		}catch(UsuarioDisponibilidadException e){
			
		}
		
		List<DataCuponera> listaCuponerasDelUsuario = cu.cuponeras("nick s1");
		assertTrue( listaCuponerasDelUsuario.size() == 0, "problema, se supone que no tiene cuponeras" );
	
		cu.elimiarManjeador();
	}
	
	
	@Test
	void testInformacionActDepEstadoIngRech() {
		
		//preparacion de datos
		ctrlUsuarios cu = new ctrlUsuarios();
		ctrlIDeportivas cid = new ctrlIDeportivas();
		
		//creo las instituciones
		try {
		cid.altaInstitucion("inst1", "desc1", "url1");
		}
		catch( InstitucionDeportivaRepetidaException e) {
			
		}
		
		//creo profes
		InfoBasicaProfesor p1 = new InfoBasicaProfesor(	"nick p1",		"nombre p1",
													"apellido p1",	"correo p1",
													new Date(),"0", "",	"inst1",
													"descp p1", 	"bibliog p1",
													"url p1" );

		try {
			cu.altaUsuario(p1);
		}catch(UsuarioDisponibilidadException e){
		}
	
		InfoActividadProfe info =  cu.informacionActDepEstadoIngRech("nick p1");
		List<Object> infoLista =   info.obtenerVector();
		assertTrue( infoLista.size() == 0 , "problema, no hay actividades ingresadas"  );
		
		cu.elimiarManjeador();
	}
	
	
	@Test
	void testEsSocio() {
		
		//preparacion de datos
		ctrlUsuarios cu = new ctrlUsuarios();
		
		ctrlIDeportivas cid = new ctrlIDeportivas();
		
		//creo las instituciones
		try {
		cid.altaInstitucion("inst1", "desc1", "url1");
		}
		catch( InstitucionDeportivaRepetidaException e) {
			
		}
		
		//creo profes
		InfoBasicaProfesor p1 = new InfoBasicaProfesor(	"nick p1",		"nombre p1",
													"apellido p1",	"correo p1",
													new Date(),"0", "",	"inst1",
													"descp p1", 	"bibliog p1",
													"url p1" );

		InfoBasicaSocio s2 = new InfoBasicaSocio(	"nick s2",		"nombre s2",
													"apellido s2",	"correo s2",
													new Date(),"0" , "");
		
		try {
			cu.altaUsuario(p1);
			cu.altaUsuario(s2);

		}catch(UsuarioDisponibilidadException e){
		}
	
		
		boolean esSocio = false;
		try {
			esSocio = cu.esSocio("nick s2");
		} catch (UsuarioInexistenteException e) {
			
		} 
		assertTrue( esSocio, "problema, nick s2 es un socio" );
		
		//testeo otro caso
		//con un profesor
		esSocio = true;
		try {
			esSocio = cu.esSocio("nick p1");
		} catch (UsuarioInexistenteException e) {
			
		} 
		assertTrue( esSocio == false, "problema, nick p1 es un profe" );
		
		
		//testeo cuando no exite el usuario con el nickname
		final ctrlUsuarios cuCopia = cu;
		assertThrows( UsuarioInexistenteException.class, ()-> {cuCopia.esSocio("cualquierCosa");} );
		
		cu.elimiarManjeador();
	}
}
