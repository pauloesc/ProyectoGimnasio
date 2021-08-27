package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.InstitucionDeportivaNoExisteException;
import excepciones.InstitucionDeportivaRepetidaException;
import logica.DataInstitucion;
import logica.Fabrica;
import logica.IctrlIDeportivas;

/**
 * Test en JUnit del Controlador de Instituciones
 * @author jp
 */

class TestctrlIDeportivas {

	private static IctrlIDeportivas ctrlIDeportivas;
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		ctrlIDeportivas = fabrica.getIctrlIDeportivas();
		ctrlIDeportivas.cargarDatosIDeportivas();
	}

	@Test
	void testAltaInstitucionOK() 
	{
		try 
		{
			ctrlIDeportivas.altaInstitucion("Instituto prueba 2", "Es una prueba", "https://test.com.uy");
			DataInstitucion dataInst = ctrlIDeportivas.getInstitucion("Instituto prueba 2");
			assertEquals(dataInst.getNombre(), "Instituto prueba 2");
			assertEquals(dataInst.getDescripcion(), "Es una prueba");
			assertEquals(dataInst.getURL(), "https://test.com.uy");
		}
		catch (InstitucionDeportivaNoExisteException e)
		{
			fail(e.getMessage());
			e.printStackTrace();
		}
		catch (InstitucionDeportivaRepetidaException e)
		{
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	void testAltaInstitucionRepetidaException()
	{
		try
		{
			ctrlIDeportivas.altaInstitucion("Instituto prueba", "Es una prueba", "https://test.com.uy");
		}
		catch (InstitucionDeportivaRepetidaException e)
		{
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertThrows(InstitucionDeportivaRepetidaException.class, () -> 
			{
				ctrlIDeportivas.altaInstitucion("Instituto prueba", "Es una prueba", "https://test.com.uy");
			}
		);
	}
	
	@Test
	void testGetInstitucionesOK()
	{
		try
		{
			DataInstitucion[] dataInstituciones = ctrlIDeportivas.getInstituciones();
			
			assertTrue(Arrays.asList(dataInstituciones).contains(new DataInstitucion(
					"Instituto Natural", "Clases de gimnasia, aeróbica, spinning y yoga.", "https://www.inatural.com")));
			
			assertTrue(Arrays.asList(dataInstituciones).contains(new DataInstitucion(
					"Fuerza Bruta", "Gimnasio especializado en el desarrollo de la musculatura.", "https://www.musculos.com/")));
			
			assertTrue(Arrays.asList(dataInstituciones).contains(new DataInstitucion(
					"Telón", "Actividades deportivas para todas las edades.", "https://telon.com.uy")));
			
			assertTrue(Arrays.asList(dataInstituciones).contains(new DataInstitucion(
					"Olympic", "Gimnasia y Aparatos", "https://www.olympic21.com/")));
			
			assertTrue(Arrays.asList(dataInstituciones).contains(new DataInstitucion(
					"Instituto prueba", "Es una prueba", "https://test.com.uy")));
			
			assertTrue(Arrays.asList(dataInstituciones).contains(new DataInstitucion(
					"Instituto prueba 2", "Es una prueba", "https://test.com.uy")));
			
			assertEquals(dataInstituciones.length, 6);
		}
		catch (InstitucionDeportivaNoExisteException e)
		{
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	void testGetInstitucionOK()
	{
		try
		{
			DataInstitucion dataInst = ctrlIDeportivas.getInstitucion("Fuerza Bruta");
			
			assertEquals(dataInst.getNombre(), "Fuerza Bruta");
			assertEquals(dataInst.getDescripcion(), "Gimnasio especializado en el desarrollo de la musculatura.");
			assertEquals(dataInst.getURL(), "https://www.musculos.com/");
		}
		catch (InstitucionDeportivaNoExisteException e)
		{
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	void testGetInstitucionNoExiste()
	{
		assertThrows(InstitucionDeportivaNoExisteException.class, () ->
			{
				ctrlIDeportivas.getInstitucion("No existe");
			}
		);
	}
}