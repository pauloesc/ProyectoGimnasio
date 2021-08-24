package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import manejadores.manejDeportivas;
import logica.InstitucionDeportiva;
import logica.ActividadDeportiva;

/**
 * Test en JUnit del manejador Deportivas
 * @author mbarrera
 *
 */
class TestmanejDeportivas {


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		
		// testeo instituciones
		 
		manejDeportivas mD = manejDeportivas.getinstance();
		
		// caso vacio
		
		InstitucionDeportiva[] o = mD.getInstituciones();
		assertEquals(o, null);
		
		InstitucionDeportiva club0 = mD.buscarInstitucion("Aguada");
		assertEquals(club0, null);
		
		// caso prueba normal
		
		InstitucionDeportiva club1 = new InstitucionDeportiva("Lagomar CC", "Lagomar Country Club", "www.lagomar.uy");
		InstitucionDeportiva club2 = new InstitucionDeportiva("Bigua", "Club Bigua", "www.bigua.uy");
		InstitucionDeportiva club3 = new InstitucionDeportiva("Malvin", "Club Malvin", "www.malvin.uy");
		
		mD.agregarInstitucion(club3);
		mD.agregarInstitucion(club2);
		mD.agregarInstitucion(club1);
		
		o = mD.getInstituciones();
		
		assertEquals(o.length, 3);
		
		club0 = mD.buscarInstitucion("Malvin");
		assertEquals(club0, club3);
		
		Set<String> testset = new HashSet<String>();
		testset.add("Lagomar CC");
		testset.add("Bigua");
		testset.add("Malvin");
		Set<String> nombres = mD.darNombreInstituciones();
		assertEquals(testset, nombres);
		
		//testeo actividades
		
		manejDeportivas mD2 = manejDeportivas.getinstance();
		
		// caso vacio
		
		ActividadDeportiva[] p = mD2.getActividades();
		assertEquals(p, null);
		
		ActividadDeportiva act0 = mD2.buscarActividad("Salto Alto");
		assertEquals(act0, null);
		
		ActividadDeportiva act1 = new ActividadDeportiva("Natacion", "En la Piscina", 60f, 290f, new Date());
		mD2.agregarActividad(act1);
		
		p= mD.getActividades();
		
		assertEquals(p.length, 1);
	}

}
