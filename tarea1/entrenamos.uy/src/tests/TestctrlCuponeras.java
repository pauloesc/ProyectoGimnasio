package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.ActividadDeportivaNoExisteException;
import excepciones.ActividadDeportivaRepetidaException;
import excepciones.CuponeraNoExisteException;
import excepciones.CuponeraRepetidaException;
import excepciones.InstitucionDeportivaRepetidaException;
import logica.DataCuponera;
import logica.Fabrica;
import logica.IctrlADeportivas;
import logica.IctrlCuponeras;
import logica.IctrlIDeportivas;
import logica.ParActividad;
import logica.manejADeportivas;
import logica.manejCuponeras;



class TestctrlCuponeras {

	private static IctrlCuponeras ctrlCuponeras;
	private static IctrlADeportivas ctrlDeportivas;
	private static IctrlIDeportivas ctrlInsti;
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		ctrlInsti = fabrica.getIctrlIDeportivas();
		ctrlDeportivas = fabrica.getIctrlADeportivas();
		ctrlCuponeras = fabrica.getIctrlCuponeras();
		ctrlInsti.cargarDatosIDeportivas();
		ctrlDeportivas.cargarDatosADeportivas();
		ctrlCuponeras.cargarDatosCuponeras();
		manejCuponeras.getinstance().EliminarManjeador();
		manejADeportivas.getinstance().EliminarManjeador();
	
	}

	@Test
	void testlistarCuponeraFal(){
		
		manejCuponeras.getinstance().EliminarManjeador();
		assertThrows(CuponeraNoExisteException.class, () ->{ctrlCuponeras.listarCuponeras();});
	
}
	
	
	@Test
	void testregistrarCuponeraExito() {
		manejCuponeras.getinstance().EliminarManjeador();
		Date fi=null;
		Date ff=null;
		Date fa=null;
		try {
			fi = new SimpleDateFormat("dd/MM/yy").parse("01/08/21");
			ff = new SimpleDateFormat("dd/MM/yy").parse("31/08/21");
			fa=  new SimpleDateFormat("dd/MM/yy").parse("01/07/21");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ctrlCuponeras.registrarCuponera("social","Deportes y Socialización",fi,ff,20f,fa);
		} catch (CuponeraRepetidaException e) {
			e.printStackTrace();
		}
		
		  DataCuponera res=new DataCuponera();
		try {
			 res= ctrlCuponeras.mostrarCuponera("social");
		} catch (CuponeraNoExisteException e) {
			e.printStackTrace();
		}	
			
			assertEquals(res.getNombre(), "social", "El nombre de la cuponera no es correcto");
			assertEquals(res.getDescripcion(), "Deportes y Socialización","Las descripción no es la correcta") ;
			assertEquals(res.getFecha_ini(), fi, "La fecha inicial no es la correcta");
			assertEquals(res.getFecha_fin(), ff, "La fecha final no es la correcta");
			assertEquals(res.getDescuento(), 20f, "El descuento no es el correcto");
			assertEquals(res.getFecha_alta(), fa, "La fecha de alta no es la correcta");
			
			
		} 

	@Test
void testregistrarCuponeraRepite() {
		manejCuponeras.getinstance().EliminarManjeador();
	Date fi=null;
	Date ff=null;
	Date fa=null;
	try {
		fi = new SimpleDateFormat("dd/MM/yy").parse("02/08/21");
		ff = new SimpleDateFormat("dd/MM/yy").parse("31/08/21");
		fa=  new SimpleDateFormat("dd/MM/yy").parse("01/07/21");
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		ctrlCuponeras.registrarCuponera("Flexibilidad","Actividades de flexibilidad",fi,ff,20f,fa);
	} catch (CuponeraRepetidaException e) {
		e.printStackTrace();
	}
	assertThrows(CuponeraRepetidaException.class, () -> {ctrlCuponeras.registrarCuponera("Flexibilidad","Actividades de flexibilidad",new SimpleDateFormat("dd/MM/yy").parse("02/08/21"),new SimpleDateFormat("dd/MM/yy").parse("31/08/21"),20f,new SimpleDateFormat("dd/MM/yy").parse("01/07/21"));});

}
	
	@Test
	void testlistarCuponerasExito() {
		manejCuponeras.getinstance().EliminarManjeador();
		
		Date fi=null;
		Date ff=null;
		Date fa=null;
		try {
			fi = new SimpleDateFormat("dd/MM/yy").parse("05/08/21");
			ff = new SimpleDateFormat("dd/MM/yy").parse("31/08/21");
			fa=  new SimpleDateFormat("dd/MM/yy").parse("01/07/21");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ctrlCuponeras.registrarCuponera("Baile","Actividades de danza",fi,ff,10f,fa);
			ctrlCuponeras.registrarCuponera("Didactica","Actividades creativas",fi,ff,10f,fa);
		} catch (CuponeraRepetidaException e) {
			e.printStackTrace();
		}
		Set<String> rest=new HashSet<String>();
		try {
			rest= ctrlCuponeras.listarCuponeras();
		}catch (CuponeraNoExisteException e) {
			e.printStackTrace();
		}	
	
		Set<String> com=new HashSet<String>();
		com.add("Baile");
		com.add("Didactica");
		assertEquals(rest,com, "Los sets no son iguales");
	
}



	@Test
	void testagregarActividadExito() {
		manejCuponeras.getinstance().EliminarManjeador();Date fi=null;
		Date ff=null;
		Date fa=null;
		try {
			fi = new SimpleDateFormat("dd/MM/yy").parse("05/08/21");
			ff = new SimpleDateFormat("dd/MM/yy").parse("31/08/21");
			fa=  new SimpleDateFormat("dd/MM/yy").parse("01/07/21");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			ctrlCuponeras.registrarCuponera("Baile2","Actividades2",fi,ff,10f,fa);
		}catch (CuponeraRepetidaException e) {
			e.printStackTrace();
		}
		
		try {
			ctrlInsti.altaInstitucion("Ald", "deporte","url");
		} catch (InstitucionDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ctrlDeportivas.altaActividadDeportiva("Ald", "Volei", "dep", 30f, 300f, fi);
		} catch (ActividadDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ctrlCuponeras.agregarActividad("Baile2","Volei", 20);	
		}catch (ActividadDeportivaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		DataCuponera res=new DataCuponera();
			try {
				 res= ctrlCuponeras.mostrarCuponera("Baile2");
			} catch (CuponeraNoExisteException e) {
				e.printStackTrace();
			}	
		
		Set<ParActividad> cont=res.getClases();
		String contenidonombre = null;
		int contenidonum = 0;
		if (!cont.isEmpty()) {
			Iterator<ParActividad> iter=cont.iterator();
		    boolean encontre=false;
			while (!encontre && iter.hasNext()) {
				ParActividad it=iter.next();
				if (it.getNombre()=="Volei" && it.getNumclase()==20){
				   contenidonombre=it.getNombre();
				   contenidonum = it.getNumclase();
				   encontre=true;
				}
				
			}
		}
		
			assertEquals(contenidonombre, "Volei", "El nombre de la actividad es correcto");
			assertEquals(contenidonum, 20, "El numero de clases es correcto");
			assertEquals(res.getNombre(), "Baile2", "El nombre de la cuponera es correcto");
			
	}
	@Test
	void testagregarActividadFail() {
		manejCuponeras.getinstance().EliminarManjeador();
		Date fi=null;
		Date ff=null;
		Date fa=null;
		try {
			fi = new SimpleDateFormat("dd/MM/yy").parse("05/08/21");
			ff = new SimpleDateFormat("dd/MM/yy").parse("31/08/21");
			fa=  new SimpleDateFormat("dd/MM/yy").parse("01/07/21");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			ctrlCuponeras.registrarCuponera("Baile3","Actividades2",fi,ff,10f,fa);
		}catch (CuponeraRepetidaException e) {
			e.printStackTrace();
		}
		
		try {
			ctrlCuponeras.agregarActividad("Baile3","Volei", 20);	
			
		}catch (ActividadDeportivaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertThrows(ActividadDeportivaRepetidaException.class, () -> {ctrlCuponeras.agregarActividad("Baile3","Volei", 20);});
		
	}
		
	/*public DataCuponera mostrarCuponera (String nomCup) throws CuponeraNoExisteException*/
	@Test
	void testDataCuponeraFail () {
		assertThrows(CuponeraNoExisteException.class, () -> {ctrlCuponeras.mostrarCuponera("Bai");});	
		
	}
	
	
	/*public Set<String> listarActividadesfaltantes(String nomcup, String nominst) throws ActividadDeportivaNoExisteException*/
	
	@Test
	void testlistarActividadesfaltantesExito1() {
		manejCuponeras.getinstance().EliminarManjeador();
		
		Date fi=null;
		Date ff=null;
		Date fa=null;
		try {
			fi = new SimpleDateFormat("dd/MM/yy").parse("05/08/21");
			ff = new SimpleDateFormat("dd/MM/yy").parse("31/08/21");
			fa=  new SimpleDateFormat("dd/MM/yy").parse("01/07/21");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			ctrlCuponeras.registrarCuponera("Baile4","Actividades2",fi,ff,10f,fa);
		}catch (CuponeraRepetidaException e) {
			e.printStackTrace();
		}
		
		try {
			ctrlInsti.altaInstitucion("Ald2", "deporte","url");
		} catch (InstitucionDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ctrlDeportivas.altaActividadDeportiva("Ald2", "Volei2", "dep", 30f, 300f, fi);
			ctrlDeportivas.altaActividadDeportiva("Ald2", "Volei3", "dep", 30f, 300f, fi);
			ctrlDeportivas.altaActividadDeportiva("Ald2", "Volei4", "dep", 30f, 300f, fi);
			ctrlDeportivas.altaActividadDeportiva("Ald2", "Volei5", "dep", 30f, 300f, fi);
		} catch (ActividadDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			ctrlCuponeras.agregarActividad("Baile4","Volei2", 20);	
			ctrlCuponeras.agregarActividad("Baile4","Volei5", 20);
		}catch (ActividadDeportivaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<String> resu=new HashSet<String>();
		try {
			resu=ctrlCuponeras.listarActividadesfaltantes("Baile4", "Ald2");
		} catch (ActividadDeportivaNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set<String> esperado=new HashSet<String>();
		esperado.add("Volei3");
		esperado.add("Volei4");
		
		assertEquals(resu,esperado, "Los sets no son iguales");
	
		
	}
	 
	@Test
	void testlistarActividadesfaltantesExito2() {
		manejCuponeras.getinstance().EliminarManjeador();
		
		Date fi=null;
		Date ff=null;
		Date fa=null;
		try {
			fi = new SimpleDateFormat("dd/MM/yy").parse("05/08/21");
			ff = new SimpleDateFormat("dd/MM/yy").parse("31/08/21");
			fa=  new SimpleDateFormat("dd/MM/yy").parse("01/07/21");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			ctrlCuponeras.registrarCuponera("Baile5","Actividades2",fi,ff,10f,fa);
		}catch (CuponeraRepetidaException e) {
			e.printStackTrace();
		}
		
		try {
			ctrlInsti.altaInstitucion("Ald3", "deporte","url");
		} catch (InstitucionDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ctrlDeportivas.altaActividadDeportiva("Ald3", "Volei6", "dep", 30f, 300f, fi);
			ctrlDeportivas.altaActividadDeportiva("Ald3", "Volei7", "dep", 30f, 300f, fi);
		} catch (ActividadDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		Set<String> resu=new HashSet<String>();
		try {
			resu=ctrlCuponeras.listarActividadesfaltantes("Baile5", "Ald3");
		} catch (ActividadDeportivaNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set<String> esperado=new HashSet<String>();
		esperado.add("Volei6");
		esperado.add("Volei7");
		
		assertEquals(resu,esperado, "Los sets no son iguales");
	
		
	}
	

	@Test
	void testlistarActividadesfaltantesFail() {
		manejCuponeras.getinstance().EliminarManjeador();
		
		Date fi=null;
		Date ff=null;
		Date fa=null;
		try {
			fi = new SimpleDateFormat("dd/MM/yy").parse("05/08/21");
			ff = new SimpleDateFormat("dd/MM/yy").parse("31/08/21");
			fa=  new SimpleDateFormat("dd/MM/yy").parse("01/07/21");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			ctrlCuponeras.registrarCuponera("Baile6","Actividades2",fi,ff,10f,fa);
		}catch (CuponeraRepetidaException e) {
			e.printStackTrace();
		}
		
		try {
			ctrlInsti.altaInstitucion("Ald4", "deporte","url");
		} catch (InstitucionDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ctrlDeportivas.altaActividadDeportiva("Ald4", "Volei8", "dep", 30f, 300f, fi);
			ctrlDeportivas.altaActividadDeportiva("Ald4", "Volei9", "dep", 30f, 300f, fi);
		} catch (ActividadDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ctrlCuponeras.agregarActividad("Baile6","Volei8", 20);	
			ctrlCuponeras.agregarActividad("Baile6","Volei9", 20);
		}catch (ActividadDeportivaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
					
		assertThrows(ActividadDeportivaNoExisteException.class, () -> {ctrlCuponeras.listarActividadesfaltantes("Baile6", "Ald4");});
	
		
	}
	
	/*public Set<String> getCuponerasActividad(String nac) throws CuponeraNoExisteException */
	

	@Test
	void testgetCuponeraActividadExito() {
		manejCuponeras.getinstance().EliminarManjeador();
		
		Date fi=null;
		Date ff=null;
		Date fa=null;
		try {
			fi = new SimpleDateFormat("dd/MM/yy").parse("05/08/21");
			ff = new SimpleDateFormat("dd/MM/yy").parse("31/08/21");
			fa=  new SimpleDateFormat("dd/MM/yy").parse("01/07/21");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			ctrlCuponeras.registrarCuponera("ACC1","Actividades2",fi,ff,10f,fa);
			ctrlCuponeras.registrarCuponera("ACC2","Actividades2",fi,ff,10f,fa);
			ctrlCuponeras.registrarCuponera("ACC3","Actividades2",fi,ff,10f,fa);
		}catch (CuponeraRepetidaException e) {
			e.printStackTrace();
		}
	
		try {
			ctrlInsti.altaInstitucion("Alp", "deporte","url");
		} catch (InstitucionDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ctrlDeportivas.altaActividadDeportiva("Alp", "Volt1", "dep", 30f, 300f, fi);
			ctrlDeportivas.altaActividadDeportiva("Alp", "Volt2", "dep", 30f, 300f, fi);
		} catch (ActividadDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ctrlCuponeras.agregarActividad("ACC1","Volt1", 20);	
			ctrlCuponeras.agregarActividad("ACC1","Volt2", 20);
			ctrlCuponeras.agregarActividad("ACC2","Volt1", 20);	
			ctrlCuponeras.agregarActividad("ACC3","Volt2", 20);
		
		}catch (ActividadDeportivaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set<String> resu=new HashSet<String>();
		try {
			resu=ctrlCuponeras.getCuponerasActividad("Volt2");
		} catch (CuponeraNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set<String> esperado=new HashSet<String>();
		esperado.add("ACC1");
		esperado.add("ACC3");
		
		assertEquals(resu,esperado, "Los sets no son iguales");
	
	}
	
	@Test
	void testgetCuponeraActividadfail1() {
		manejCuponeras.getinstance().EliminarManjeador();
		
		Date fi=null;
		Date ff=null;
		Date fa=null;
		try {
			fi = new SimpleDateFormat("dd/MM/yy").parse("05/08/21");
			ff = new SimpleDateFormat("dd/MM/yy").parse("31/08/21");
			fa=  new SimpleDateFormat("dd/MM/yy").parse("01/07/21");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			ctrlInsti.altaInstitucion("Alp1", "deporte","url");
		} catch (InstitucionDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ctrlDeportivas.altaActividadDeportiva("Alp1", "Volt3", "dep", 30f, 300f, fi);
			ctrlDeportivas.altaActividadDeportiva("Alp1", "Volt4", "dep", 30f, 300f, fi);
		} catch (ActividadDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
					
		assertThrows(CuponeraNoExisteException.class, () -> {ctrlCuponeras.getCuponerasActividad("Volt2");});
		
	}
	
	@Test
	void testgetCuponeraActividadfail2() {
		manejCuponeras.getinstance().EliminarManjeador();
		
		Date fi=null;
		Date ff=null;
		Date fa=null;
		try {
			fi = new SimpleDateFormat("dd/MM/yy").parse("05/08/21");
			ff = new SimpleDateFormat("dd/MM/yy").parse("31/08/21");
			fa=  new SimpleDateFormat("dd/MM/yy").parse("01/07/21");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			ctrlCuponeras.registrarCuponera("ACC4","Actividades2",fi,ff,10f,fa);
		}catch (CuponeraRepetidaException e) {
			e.printStackTrace();
		}
	
		try {
			ctrlInsti.altaInstitucion("Alp2", "deporte","url");
		} catch (InstitucionDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ctrlDeportivas.altaActividadDeportiva("Alp2", "Volt5", "dep", 30f, 300f, fi);
			ctrlDeportivas.altaActividadDeportiva("Alp2", "Volt6", "dep", 30f, 300f, fi);
		} catch (ActividadDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ctrlCuponeras.agregarActividad("ACC4","Volt6", 20);	
		
		}catch (ActividadDeportivaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertThrows(CuponeraNoExisteException.class, () -> {ctrlCuponeras.getCuponerasActividad("Volt5");});
	}
	
	
}


