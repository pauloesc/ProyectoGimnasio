package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.ActividadDeportivaNoExisteException;
import excepciones.ActividadDeportivaRepetidaException;
import logica.DataActividad;
import logica.Fabrica;
import logica.IctrlADeportivas;
import logica.IctrlIDeportivas;

/**
 * Test en JUnit del Controlador Actividades Deportivas
 * @author mbarrera
 */

class TestctrlADeportivas {

	private static IctrlADeportivas ctrlADeportivas;
	private static IctrlIDeportivas ctrlIDeportivas;
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		ctrlADeportivas = fabrica.getIctrlADeportivas();
		ctrlIDeportivas = fabrica.getIctrlIDeportivas();
		ctrlIDeportivas.cargarDatosIDeportivas();
		ctrlADeportivas.cargarDatosADeportivas();
	}

	@Test
	void testAltaActividadDeportivaOK() {
		Date f1 = null;
		try {
			f1 = new SimpleDateFormat("dd/MM/yy").parse("08/12/20");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			ctrlADeportivas.altaActividadDeportiva("Instituto Natural", "Arqueria", "Tiro con arco", 120f, 900f, f1);
			DataActividad dact = ctrlADeportivas.getDataActividad("Arqueria");
			assertEquals(dact.getNombre(), "Arqueria");
			assertEquals(dact.getDescripcion(), "Tiro con arco");
			assertEquals(dact.getDuracion(), 120f);
			assertEquals(dact.getCosto(), 900f);
			assertEquals(dact.getFechaAlta(), f1);
		} catch (ActividadDeportivaRepetidaException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} catch (ActividadDeportivaNoExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	void testAltaActividadDeportivaRepetida() {
		Date f2 = null;
		try {
			f2 = new SimpleDateFormat("dd/MM/yy").parse("07/07/21");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			ctrlADeportivas.altaActividadDeportiva("Telón", "Nado Sincronizado", "Equipo olimpico", 180f, 1500f, f2);
		} catch (ActividadDeportivaRepetidaException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} 
		assertThrows(ActividadDeportivaRepetidaException.class, () -> {ctrlADeportivas.altaActividadDeportiva("Olympic", "Nado Sincronizado", "Equipo olimpico", 180f, 1500f, new SimpleDateFormat("dd/MM/yy").parse("07/07/21"));});
	}
	
	@Test
	void testGetActividadesNoExiste() {
		assertThrows(ActividadDeportivaNoExisteException.class, () -> {ctrlADeportivas.getActividades("Olympic");});
	}
	
	@Test
	void testGetDataActividadNoExiste() {
		assertThrows(ActividadDeportivaNoExisteException.class, () -> {ctrlADeportivas.getActividades("Olympic");});
	}
	
	@Test
	void testdarNombresActividadesDeportivas() {
		
		Set<String> setA;
		Set<String> nomin;
		
		nomin = ctrlADeportivas.darNombresActividadesDeportivas("Instituto Natural");
		setA = new HashSet<String>();
		setA.add("Aeróbica");
		setA.add("Arqueria");
		
		assertEquals(setA, nomin);
		
	}
	
	@Test
	void testmostrarClasesVigentesDeActividadDeportivaVacio() {
		
		Set<String> setA = new HashSet<String>();
		Set<String> clasesVigentes;
		
		clasesVigentes = ctrlADeportivas.mostrarClasesVigentesDeActividadDeportiva("Arqueria");
		
		assertEquals(setA, clasesVigentes);
	}
	
	@Test
	void testmostrarClasesVigentesDeActividadDeportivaOK() {
		
		Set<String> setA = new HashSet<String>();
		Set<String> clasesVigentes;
		
		
		
		clasesVigentes = ctrlADeportivas.mostrarClasesVigentesDeActividadDeportiva("Basquetbol");

		
		assertEquals(setA, clasesVigentes);
	}

}
