/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import logica.DtClase;
import logica.Fabrica;
import logica.IctrlADeportivas;
import logica.IctrlClases;
import logica.IctrlCuponeras;
import logica.IctrlIDeportivas;
import logica.IctrlUsuarios;
import excepciones.ClaseLlenaException;
import excepciones.ClaseNoExisteException;
import excepciones.ClaseRepetidaException;
import excepciones.ClaseYaCompradaException;

/**
 * @author lucas
 *
 */
class TestctrlClases {

	private static IctrlClases IC;
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		IC = fabrica.getIctrlClases();
		
		// cargar algunos datos necesarios para las pruebas
		IctrlIDeportivas IID = fabrica.getIctrlIDeportivas();
		IctrlADeportivas IAD = fabrica.getIctrlADeportivas();
		IctrlUsuarios IU = fabrica.getIctrlUsuarios();
		IctrlCuponeras ICU = fabrica.getIctrlCuponeras();
		
		// IU.cargarDatosUsuarios();  -- sin implementar
		IID.cargarDatosIDeportivas();
		IAD.cargarDatosADeportivas();
		IU.cargarUsuarios();
		ICU.cargarDatosCuponeras();
		IC.cargarDatosClases();
		IC.cargarRegistroAClases();
		
	}
	
	@Test
	void creacionFeliz() {
		// tambien prueba darDtClase
		try {
			Date f1 = new SimpleDateFormat("dd/MM/yy").parse("15/04/21");
			Date f2 = new SimpleDateFormat("dd/MM/yy").parse("31/03/21");
		
			
			DtClase res = IC.darDtClase("Calistenia");
			
			assertEquals(res.getNombre(), "Calistenia");
			assertEquals(res.getActualSocios(), 3);
			assertEquals(res.getMaxSocios(), 5);
			assertEquals(res.getMinSocios(), 1);
			assertEquals(res.getNomProfesor(), "viktor");
			assertEquals(res.getUrl(), "https://www.musculos.com/Calistenia");
			assertEquals(res.getFecha(), f1);
			assertEquals(res.getFechaReg(), f2);
			assertEquals(res.getHora(), 15);
			assertEquals(res.getMinuto(), 30);
			
			
		} catch (Exception e) {
			fail("Test falló");
			e.printStackTrace();
		}
	}
	
	@Test
	void crearClaseRepetida() {
		try {
			Date f1 = new SimpleDateFormat("dd/MM/yy").parse("09/04/21");
			Date f2 = new SimpleDateFormat("dd/MM/yy").parse("09/03/21");
			IC.crearClase("Peso libre",f1,"viktor",1,3,"url", "youtube",f2,"Kickboxing",1,1,"","",0);
			fail("Test falló");
		} catch (ClaseRepetidaException e) {
			assertEquals(0,0);
		} catch (Exception e) {
			fail("Test falló");
		}
	}

	@Test
	void claseDeActividadDeportiva() throws ClaseNoExisteException {
		Set<String> res = IC.mostrarClasesDeActividadDeportiva("Aparatos y pesas");
		Set<String> verdadero = new HashSet<String>();
	
		verdadero.add("Calistenia");
		verdadero.add("Peso libre");
		verdadero.add("Aparatos");
		
		if (res.equals(verdadero)) {
			assertEquals(0,0);
		} else {
			fail("Test falló");
		}
	}
	
	@Test
	void registroAClasesYaComprada() {
		try {
			Date f1 = new SimpleDateFormat("dd/MM/yy").parse("09/04/21");
			IC.registrarSocioAClase("caro","Aparatos y pesas","Calistenia",false,"",f1);
			fail("Test falló");
		} catch (ClaseYaCompradaException e) {
			assertEquals(0,0);
		} catch (Exception e) {
			fail("Test falló");
		}
	}
	
	@Test
	void registroAClasesLlena() {
		try {
			Date f1 = new SimpleDateFormat("dd/MM/yy").parse("09/04/21");
			IC.registrarSocioAClase("Emi71","Kickboxing","Boxeo II",false,"",f1);
			fail("Test falló");
		} catch (ClaseLlenaException e) {
			assertEquals(0,0);
		} catch (Exception e) {
			fail("Test falló");
		}
	}
	
}
