package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import datatypes.DataInstitucion;
import excepciones.InstitucionDeportivaNoExisteException;
import excepciones.InstitucionDeportivaRepetidaException;
import logica.Fabrica;
import logica.IctrlIDeportivas;

/**
 * Test en JUnit del Controlador de Instituciones y Actividades Deportivas
 * @author moui
 */

class TestctrlDeportivas {

	private static IctrlIDeportivas ctrlDeportivas;
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
	//	ctrlDeportivas = fabrica.getIctrlDeportivas();
	}

	@Test
	void testAltaInstitucionOk() {
		try {
			ctrlDeportivas.altaInstitucion("Lagomar", "Club de Ciudad de la Costa", "https://lagomarcc.uy");
			DataInstitucion[] dinst = ctrlDeportivas.getInstituciones();
			assertEquals(dinst[0].getNombre(), "Lagomar");
			assertEquals(dinst[0].getDescripcion(), "Club de Ciudad de la Costa");
			assertEquals(dinst[0].getURL(), "https://lagomarcc.uy");
		} catch (InstitucionDeportivaRepetidaException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		} catch (InstitucionDeportivaNoExisteException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	void testAltaInstitucionRepetida() {
		/*try {
			ctrlU.registrarUsuario("Rodrigo1", "Quinta2", "87654321");
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertThrows(UsuarioRepetidoException.class, () -> {ctrlU.registrarUsuario("Rodrigo1", "Quinta2", "87654321");});
	}*/
		fail("Not yet implemented");
	}

	@Test
	void testaltaActividadDeportivaOK() {
		fail("Not yet implemented");
	}

	@Test
	void testaltaActividadDeportivaRepetida() {
		fail("Not yet implemented");
	}


	@Test
	void testGetActividadesOK() {
		fail("Not yet implemented");
	}
	
	@Test
	void testGetActividadesNoExiste() {
		fail("Not yet implemented");
	}

	@Test
	void testGetInstitucionesOK() {
		fail("Not yet implemented");
	}
	
	@Test
	void testGetInstitucionesNoExiste() {
		fail("Not yet implemented");
	}
	
	@Test
	void testDarNombreInstituciones() {
		fail("Not yet implemented");
	}
	
	@Test
	void testGetDataActividad() {
		fail("Not yet implemented");
	}

	@Test
	void testDarNombresActividadesDeportivas() {
		fail("Not yet implemented");
	}
}
