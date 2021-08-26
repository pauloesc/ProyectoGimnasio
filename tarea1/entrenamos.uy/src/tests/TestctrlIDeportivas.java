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
			ctrlIDeportivas.altaInstitucion("Instituto prueba", "Es una prueba", "https://test.com.uy");
			DataInstitucion dataInst = ctrlIDeportivas.getInstitucion("Instituto prueba");
			assertEquals(dataInst.getNombre(), "Instituto prueba");
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
	
	void testGetInstitucionesOK()
	{
		try
		{
			DataInstitucion[] dataInstituciones = ctrlIDeportivas.getInstituciones();
			
			assertEquals(dataInstituciones[0].getNombre(), "Instituto Natural");
			assertEquals(dataInstituciones[0].getDescripcion(), "Clases de gimnasia, aeróbica, spinning y yoga.");
			assertEquals(dataInstituciones[0].getURL(), "https://www.inatural.com");
			
			assertEquals(dataInstituciones[1].getNombre(), "Fuerza Bruta");
			assertEquals(dataInstituciones[1].getDescripcion(), "Gimnasio especializado en el desarrollo de la musculatura.");
			assertEquals(dataInstituciones[1].getURL(), "https://www.musculos.com/");
			
			assertEquals(dataInstituciones[2].getNombre(), "Telón");
			assertEquals(dataInstituciones[2].getDescripcion(), "Actividades deportivas para todas las edades.");
			assertEquals(dataInstituciones[2].getURL(), "https://telon.com.uy");
			
			assertEquals(dataInstituciones[3].getNombre(), "Olympic");
			assertEquals(dataInstituciones[3].getDescripcion(), "Gimnasia y Aparatos");
			assertEquals(dataInstituciones[3].getURL(), "https://www.olympic21.com/");
		}
		catch (InstitucionDeportivaNoExisteException e)
		{
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
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
	
	void testGetInstitucionNoExiste()
	{
		assertThrows(InstitucionDeportivaNoExisteException.class, () ->
			{
				ctrlIDeportivas.getInstitucion("No existe");
			}
		);
	}
}
