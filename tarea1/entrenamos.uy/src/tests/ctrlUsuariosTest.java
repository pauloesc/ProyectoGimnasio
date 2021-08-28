/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import excepciones.InstitucionDeportivaRepetidaException;
import excepciones.UsuarioDisponibilidadException;
import logica.InfoBasicaProfesor;
import logica.InfoBasicaUser;
import logica.ctrlIDeportivas;
import logica.ctrlUsuarios;

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
		
	}

	/**
	 * Test method for {@link logica.ctrlUsuarios#altaUsuario(logica.InfoBasicaUser)}.
	 */
	@Test
	void testAltaUsuario() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link logica.ctrlUsuarios#InstitucionesEnSistema()}.
	 */
	@Test
	void testInstitucionesEnSistema() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link logica.ctrlUsuarios#InformacionActividad(java.lang.String)}.
	 */
	@Test
	void testInformacionActividad() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link logica.ctrlUsuarios#ActualizarInformacionUsuario(logica.InfoBasicaUser)}.
	 */
	@Test
	void testActualizarInformacionUsuario() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link logica.ctrlUsuarios#InformacionBasicaUsuario(java.lang.String)}.
	 */
	@Test
	void testInformacionBasicaUsuario() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link logica.ctrlUsuarios#UsuariosEnSistemaNickName()}.
	 */
	@Test
	void testUsuariosEnSistemaNickName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link logica.ctrlUsuarios#MostrarCuponerasDisponibles(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testMostrarCuponerasDisponibles() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link logica.ctrlUsuarios#mostrarNicknameSocios()}.
	 */
	@Test
	void testMostrarNicknameSocios() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link logica.ctrlUsuarios#cargarUsuarios()}.
	 */
	@Test
	void testCargarUsuarios() {
		fail("Not yet implemented");
	}

}
