/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import excepciones.InstitucionDeportivaRepetidaException;
import excepciones.UsuarioDisponibilidadException;
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
													new Date(), 	"inst1",
													"descp p1", 	"bibliog p1",
													"url p1" );
		
		InfoBasicaUser p2 = new InfoBasicaProfesor(	"nick p2",		"nombre p2",
													"apellido p2",	"correo p2",
													new Date(), 	"inst1",
													"descp p2", 	"bibliog p2",
													"url p2" );
		
		InfoBasicaUser p3 = new InfoBasicaProfesor(	"nick p3",		"nombre p3",
													"apellido p3",	"correo p3",
													new Date(), 	"inst2",
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
		
		cu.ElimiarManjeador();
		manejIDeportivas.ElimiarManjeador();
		
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
													new Date(), 	"inst1",
													"descp p1", 	"bibliog p1",
													"url p1" );
		
		InfoBasicaProfesor p2 = new InfoBasicaProfesor(	"nick p2",		"nombre p2",
													"apellido p2",	"correo p2",
													new Date(), 	"inst1",
													"descp p2", 	"bibliog p2",
													"url p2" );
		//creo socios
		InfoBasicaSocio s1 = new InfoBasicaSocio(	"nick s1",		"nombre s1",
													"apellido s1",	"correo s1",
													new Date() );
		
		InfoBasicaSocio s2 = new InfoBasicaSocio(	"nick s2",		"nombre s2",
													"apellido s2",	"correo s2",
													new Date());
		
		

		
		try {
			cu.altaUsuario(p1);
			cu.altaUsuario(p2);
			cu.altaUsuario(s1);
			cu.altaUsuario(s2);

		}catch(UsuarioDisponibilidadException e){
			
		}
		
		InfoBasicaUser respuesta_p1 = cu.InformacionBasicaUsuario("nick p1");
		InfoBasicaUser respuesta_p2 = cu.InformacionBasicaUsuario("nick p2");
		InfoBasicaUser respuesta_s1 = cu.InformacionBasicaUsuario("nick s1");
		InfoBasicaUser respuesta_s2 = cu.InformacionBasicaUsuario("nick s2");
		
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
		assertTrue( p1.SonIguales(respuesta_p1_casteo), "son dif");
		assertTrue( p2.SonIguales(respuesta_p2_casteo), "son dif");
		assertTrue( s1.SonIguales(respuesta_s1_casteo), "son dif");
		assertTrue( s2.SonIguales(respuesta_s2_casteo), "son dif");

		//segunda parte
		//segunda parte
		//prueba de usuarios con identificadores repetidos y funcionamiento de try
		//creo un profe con datos iguales pero dif nickname
		
		InfoBasicaProfesor p1_1 = new InfoBasicaProfesor( 	"nick p1_1",		"nombre p1",
															"apellido p1",	"correo p1",
															new Date(), 	"inst1",
															"descp p1", 	"bibliog p1",
															"url p1" );
		
		//creo un profe con datos iguales pero dif correo
		InfoBasicaProfesor p1_2 = new InfoBasicaProfesor(	"nick p1",		"nombre p1",
															"apellido p1",	"correo p1_2",
															new Date(), 	"inst1",
															"descp p1", 	"bibliog p1",
															"url p1" );
		
		//creo socios el mismo socio que antes (s1)
		InfoBasicaSocio s1_1 = new InfoBasicaSocio(	"nick s1",		"nombre s1",
													"apellido s1",	"correo s1",
													new Date() );
		
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
		
		
		
		manejIDeportivas.ElimiarManjeador();
		cu.ElimiarManjeador();
		
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
		Vector<String> vecDatosRespuesta = cu.InstitucionesEnSistema();
		
		
		//si lo de adentro es falso dispara el assert
		
		
		boolean mismo1 = (vecDatosEntrada.size() == vecDatosRespuesta.size()); 
		boolean mismo2 = vecDatosEntrada.containsAll(vecDatosRespuesta);
		boolean mismo3 = vecDatosRespuesta.containsAll(vecDatosEntrada);
		
	    assertTrue(mismo1 & mismo2 & mismo3, "Las instituciones ingresadas y devueltas no coinciden");

		
		manejIDeportivas.ElimiarManjeador();
		cu.ElimiarManjeador();
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
													new Date(), 	"inst1",
													"descp p1", 	"bibliog p1",
													"url p1" );
		
		InfoBasicaProfesor p2 = new InfoBasicaProfesor(	"nick p2",		"nombre p2",
													"apellido p2",	"correo p2",
													new Date(), 	"inst1",
													"descp p2", 	"bibliog p2",
													"url p2" );
		//creo socios
		InfoBasicaSocio s1 = new InfoBasicaSocio(	"nick s1",		"nombre s1",
													"apellido s1",	"correo s1",
													new Date() );
		
		InfoBasicaSocio s2 = new InfoBasicaSocio(	"nick s2",		"nombre s2",
													"apellido s2",	"correo s2",
													new Date());
		
		try {
			cu.altaUsuario(p1);
			cu.altaUsuario(p2);
			cu.altaUsuario(s1);
			cu.altaUsuario(s2);
		}catch(UsuarioDisponibilidadException e){
			
		}
		
		//como solo estan cargados los profesores y los socios
		//tiene que ser vacia la actividad
		 InformacionActividad info_p1 = cu.InformacionActividad("nick p1");
		 InformacionActividad info_p2 = cu.InformacionActividad("nick p2");
		 //compruebo que sea vacia la info.
		 assertTrue( info_p1.obtenerVector().isEmpty() );
		 assertTrue( info_p2.obtenerVector().isEmpty() );
		 
		 InformacionActividad info_s1 = cu.InformacionActividad("nick p1");
		 InformacionActividad info_s2 = cu.InformacionActividad("nick p2");
		 //compruebo que sea vacia la info.
		 assertTrue( info_s1.obtenerVector().isEmpty() );
		 assertTrue( info_s2.obtenerVector().isEmpty() );
		 
		
			manejIDeportivas.ElimiarManjeador();
			cu.ElimiarManjeador();
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
													new Date(), 	"inst1",
													"descp p1", 	"bibliog p1",
													"url p1" );
		
		InfoBasicaProfesor p2 = new InfoBasicaProfesor(	"nick p2",		"nombre p2",
													"apellido p2",	"correo p2",
													new Date(), 	"inst1",
													"descp p2", 	"bibliog p2",
													"url p2" );
		
		//creo socios
		InfoBasicaSocio s1 = new InfoBasicaSocio(	"nick s1",		"nombre s1",
													"apellido s1",	"correo s1",
													new Date() );
		
		InfoBasicaSocio s2 = new InfoBasicaSocio(	"nick s2",		"nombre s2",
													"apellido s2",	"correo s2",
													new Date());
		
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
														new Date(), 	"inst1",
														"descp p1M", 	"bibliog p1M",
														"url p1M" );
		
		InfoBasicaProfesor p2M = new InfoBasicaProfesor("nick p2",		"nombre p2M",
														"apellido p2M",	"correo p2",
														new Date(), 	"inst1",
														"descp p2M", 	"bibliog p2M",
														"url p2M" );
		
		//modifico socios
		InfoBasicaSocio s1M = new InfoBasicaSocio(	"nick s1",		"nombre s1M",
													"apellido s1M",	"correo s1",
													new Date() );
		
		InfoBasicaSocio s2M = new InfoBasicaSocio(	"nick s2",		"nombre s2M",
													"apellido s2M",	"correo s2",
													new Date());
		
		
		cu.ActualizarInformacionUsuario(p1M);
		cu.ActualizarInformacionUsuario(p2M);
		cu.ActualizarInformacionUsuario(s1M);
		cu.ActualizarInformacionUsuario(s2M);
		
		//traigo la info desde el sistema
		InfoBasicaUser p1M_Respuesta = cu.InformacionBasicaUsuario("nick p1");
		InfoBasicaUser p2M_Respuesta = cu.InformacionBasicaUsuario("nick p2");
		InfoBasicaUser s1M_Respuesta = cu.InformacionBasicaUsuario("nick s1");
		InfoBasicaUser s2M_Respuesta = cu.InformacionBasicaUsuario("nick s2");

		assertTrue( p1M.SonIguales( (InfoBasicaProfesor)p1M_Respuesta  ), "Info diferente" );
		assertTrue( p2M.SonIguales( (InfoBasicaProfesor)p2M_Respuesta  ), "Info diferente" );
		assertTrue( s1M.SonIguales( (InfoBasicaSocio)s1M_Respuesta  ), "Info diferente" );
		assertTrue( s2M.SonIguales( (InfoBasicaSocio)s2M_Respuesta  ), "Info diferente" );
		
		manejIDeportivas.ElimiarManjeador();
		cu.ElimiarManjeador();
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
													new Date(), 	"inst1",
													"descp p1", 	"bibliog p1",
													"url p1" );
		
		InfoBasicaProfesor p2 = new InfoBasicaProfesor(	"nick p2",		"nombre p2",
													"apellido p2",	"correo p2",
													new Date(), 	"inst1",
													"descp p2", 	"bibliog p2",
													"url p2" );
		//creo socios
		InfoBasicaSocio s1 = new InfoBasicaSocio(	"nick s1",		"nombre s1",
													"apellido s1",	"correo s1",
													new Date() );
		
		InfoBasicaSocio s2 = new InfoBasicaSocio(	"nick s2",		"nombre s2",
													"apellido s2",	"correo s2",
													new Date());
		
		try {
			cu.altaUsuario(p1);
			cu.altaUsuario(p2);
			cu.altaUsuario(s1);
			cu.altaUsuario(s2);

		}catch(UsuarioDisponibilidadException e){
			
		}
		
		InfoBasicaUser respuesta_p1 = cu.InformacionBasicaUsuario("nick p1");
		InfoBasicaUser respuesta_p2 = cu.InformacionBasicaUsuario("nick p2");
		InfoBasicaUser respuesta_s1 = cu.InformacionBasicaUsuario("nick s1");
		InfoBasicaUser respuesta_s2 = cu.InformacionBasicaUsuario("nick s2");
		
		InfoBasicaProfesor respuesta_p1_casteo = (InfoBasicaProfesor)respuesta_p1;
		InfoBasicaProfesor respuesta_p2_casteo = (InfoBasicaProfesor)respuesta_p2;
		InfoBasicaSocio respuesta_s1_casteo = (InfoBasicaSocio)respuesta_s1;
		InfoBasicaSocio respuesta_s2_casteo = (InfoBasicaSocio)respuesta_s2;
		
		assertTrue( p1.SonIguales(respuesta_p1_casteo), "No son iguales" );
		assertTrue( p2.SonIguales(respuesta_p2_casteo), "No son iguales" );
		assertTrue( s1.SonIguales(respuesta_s1_casteo), "No son iguales" );
		assertTrue( s2.SonIguales(respuesta_s2_casteo), "No son iguales" );
		
		manejIDeportivas.ElimiarManjeador();
		cu.ElimiarManjeador();
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
													new Date(), 	"inst1",
													"descp p1", 	"bibliog p1",
													"url p1" );
		
		InfoBasicaProfesor p2 = new InfoBasicaProfesor(	"nick p2",		"nombre p2",
													"apellido p2",	"correo p2",
													new Date(), 	"inst1",
													"descp p2", 	"bibliog p2",
													"url p2" );
		//creo socios
		InfoBasicaSocio s1 = new InfoBasicaSocio(	"nick s1",		"nombre s1",
													"apellido s1",	"correo s1",
													new Date() );
		
		InfoBasicaSocio s2 = new InfoBasicaSocio(	"nick s2",		"nombre s2",
													"apellido s2",	"correo s2",
													new Date());
		
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
		
		Vector<String> respuesta = cu.UsuariosEnSistemaNickName();
		
		boolean mismo1 = (datosIngresados.size() == respuesta.size()); 
		boolean mismo2 = datosIngresados.containsAll(respuesta);
		boolean mismo3 = respuesta.containsAll(datosIngresados);
		
	    assertTrue(mismo1 & mismo2 & mismo3, "Las instituciones ingresadas y devueltas no coinciden");
		
		cu.ElimiarManjeador();
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
													new Date(), 	"inst1",
													"descp p1", 	"bibliog p1",
													"url p1" );
		
		InfoBasicaProfesor p2 = new InfoBasicaProfesor(	"nick p2",		"nombre p2",
													"apellido p2",	"correo p2",
													new Date(), 	"inst1",
													"descp p2", 	"bibliog p2",
													"url p2" );
		//creo socios
		InfoBasicaSocio s1 = new InfoBasicaSocio(	"nick s1",		"nombre s1",
													"apellido s1",	"correo s1",
													new Date() );
		
		InfoBasicaSocio s2 = new InfoBasicaSocio(	"nick s2",		"nombre s2",
													"apellido s2",	"correo s2",
													new Date());
		
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
		
		cu.ElimiarManjeador();
		cu=null;
	}

	/**
	 * Test method for {@link logica.ctrlUsuarios#cargarUsuarios()}.
	 */

}
