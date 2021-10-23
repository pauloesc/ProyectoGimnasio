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
import excepciones.CuponeraCompradaException;
import excepciones.CuponeraNoExisteException;
import excepciones.CuponeraRepetidaException;
import excepciones.InstitucionDeportivaRepetidaException;
import excepciones.UsuarioDisponibilidadException;
import logica.DataCuponera;
import logica.EstadoActi;
import logica.Fabrica;
import logica.IctrlADeportivas;
import logica.IctrlCuponeras;
import logica.IctrlIDeportivas;
import logica.IctrlUsuarios;
import logica.InfoBasicaProfesor;
import logica.InfoBasicaSocio;
import logica.InfoBasicaUser;
import logica.ParActividad;
import logica.Socio;
import logica.ctrlUsuarios;
import logica.manejADeportivas;
import logica.manejCuponeras;
import logica.manejUsuarios;



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
		IctrlUsuarios IU = fabrica.getIctrlUsuarios();
		IU.cargarUsuarios();
		ctrlCuponeras.cargarDatosCuponeras();
		manejCuponeras.getinstance().eliminarManjeador();
		manejADeportivas.getinstance().eliminarManjeador();
	
	}

	@Test
	void testlistarCuponeraFal(){
		
		manejCuponeras.getinstance().eliminarManjeador();
		assertThrows(CuponeraNoExisteException.class, () ->{ctrlCuponeras.listarCuponeras();});
	
}
	
	@Test
	void testlistarCuponeraLibresFal(){
		
		manejCuponeras.getinstance().eliminarManjeador();
		assertThrows(CuponeraNoExisteException.class, () ->{ctrlCuponeras.listarcuponeraslibres();});
	
}
	
	
	
	@Test
	void testregistrarCuponeraExito() {
		manejCuponeras.getinstance().eliminarManjeador();
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
			ctrlCuponeras.registrarCuponera("social","Deportes y Socialización",fi,ff,20f,fa,null);
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
			assertEquals(res.getFechaIni(), fi, "La fecha inicial no es la correcta");
			assertEquals(res.getFechaFin(), ff, "La fecha final no es la correcta");
			assertEquals(res.getDescuento(), 20f, "El descuento no es el correcto");
			assertEquals(res.getFechaAlta(), fa, "La fecha de alta no es la correcta");
			
			
		} 

	@Test
void testregistrarCuponeraRepite() {
		manejCuponeras.getinstance().eliminarManjeador();
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
		ctrlCuponeras.registrarCuponera("Flexibilidad","Actividades de flexibilidad",fi,ff,20f,fa, null);
	} catch (CuponeraRepetidaException e) {
		e.printStackTrace();
	}
	assertThrows(CuponeraRepetidaException.class, () -> {ctrlCuponeras.registrarCuponera("Flexibilidad","Actividades de flexibilidad",new SimpleDateFormat("dd/MM/yy").parse("02/08/21"),new SimpleDateFormat("dd/MM/yy").parse("31/08/21"),20f,new SimpleDateFormat("dd/MM/yy").parse("01/07/21"), null);});

}
	
	@Test
	void testlistarCuponerasExito() {
		manejCuponeras.getinstance().eliminarManjeador();
		
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
			ctrlCuponeras.registrarCuponera("Baile","Actividades de danza",fi,ff,10f,fa,null);
			ctrlCuponeras.registrarCuponera("Didactica","Actividades creativas",fi,ff,10f,fa,null);
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
		manejCuponeras.getinstance().eliminarManjeador();Date fi=null;
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
			ctrlCuponeras.registrarCuponera("Baile2","Actividades2",fi,ff,10f,fa,null);
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
			ctrlDeportivas.altaActividadDeportiva("Ald", null, "Volei", "dep", 30f, 300f, fi, new HashSet<String>(), null);
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
		manejCuponeras.getinstance().eliminarManjeador();
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
			ctrlCuponeras.registrarCuponera("Baile3","Actividades2",fi,ff,10f,fa,null);
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
		manejCuponeras.getinstance().eliminarManjeador();
		ctrlUsuarios ctrlUs = new ctrlUsuarios();
		
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
			ctrlCuponeras.registrarCuponera("Baile4","Actividades2",fi,ff,10f,fa,null);
		}catch (CuponeraRepetidaException e) {
			e.printStackTrace();
		}
		
		try {
			ctrlInsti.altaInstitucion("Ald2", "deporte","url");
		} catch (InstitucionDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		InfoBasicaUser l1 = new InfoBasicaProfesor(	"nick p1",		"nombre p1",
				"apellido p1",	"correo p1",
				new Date(),"0", "",  "Ald2",
				"descp p1", 	"bibliog p1",
				"url p1");
		
		try {
			ctrlUs.altaUsuario(l1);
		
		}catch(UsuarioDisponibilidadException e){
			
		}
		
					
		try {
			ctrlDeportivas.altaActividadDeportiva("Ald2", "nick p1", "Volei2", "dep", 30f, 300f, fi, new HashSet<String>(), null);
			ctrlDeportivas.altaActividadDeportiva("Ald2", "nick p1", "Volei3", "dep", 30f, 300f, fi, new HashSet<String>(), null);
			ctrlDeportivas.altaActividadDeportiva("Ald2", "nick p1", "Volei4", "dep", 30f, 300f, fi, new HashSet<String>(), null);
			ctrlDeportivas.altaActividadDeportiva("Ald2", "nick p1", "Volei5", "dep", 30f, 300f, fi, new HashSet<String>(), null);
		} catch (ActividadDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ctrlDeportivas.cambiarEstado("Volei2", EstadoActi.ACEPTADA);
		ctrlDeportivas.cambiarEstado("Volei3", EstadoActi.ACEPTADA);
		ctrlDeportivas.cambiarEstado("Volei4", EstadoActi.ACEPTADA);
		ctrlDeportivas.cambiarEstado("Volei5", EstadoActi.ACEPTADA);
		
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
		manejCuponeras.getinstance().eliminarManjeador();
		ctrlUsuarios ctrlUs = new ctrlUsuarios();
		
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
			ctrlCuponeras.registrarCuponera("Baile5","Actividades2",fi,ff,10f,fa,null);
		}catch (CuponeraRepetidaException e) {
			e.printStackTrace();
		}
		
		try {
			ctrlInsti.altaInstitucion("Ald3", "deporte","url");
		} catch (InstitucionDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		InfoBasicaUser o1 = new InfoBasicaProfesor(	"nick o1",		"nombre o1",
				"apellido p1",	"correo o1",
				new Date(),"0", "",  "Ald3",
				"descp p1", 	"bibliog p1",
				"url p1");
		
		try {
			ctrlUs.altaUsuario(o1);
		
		}catch(UsuarioDisponibilidadException e){
			
		}
		
		
		
		try {
			ctrlDeportivas.altaActividadDeportiva("Ald3", "nick o1", "Volei6", "dep", 30f, 300f, fi, new HashSet<String>(), null);
			ctrlDeportivas.altaActividadDeportiva("Ald3", "nick o1", "Volei7", "dep", 30f, 300f, fi, new HashSet<String>(), null);
		} catch (ActividadDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ctrlDeportivas.cambiarEstado("Volei6", EstadoActi.ACEPTADA);
		ctrlDeportivas.cambiarEstado("Volei7", EstadoActi.ACEPTADA);
		
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
		manejCuponeras.getinstance().eliminarManjeador();
		
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
			ctrlCuponeras.registrarCuponera("Baile6","Actividades2",fi,ff,10f,fa,null);
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
			ctrlDeportivas.altaActividadDeportiva("Ald4", null, "Volei8", "dep", 30f, 300f, fi, new HashSet<String>(), null);
			ctrlDeportivas.altaActividadDeportiva("Ald4", null, "Volei9", "dep", 30f, 300f, fi, new HashSet<String>(), null);
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
		manejCuponeras.getinstance().eliminarManjeador();
		
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
			ctrlCuponeras.registrarCuponera("ACC1","Actividades2",fi,ff,10f,fa,null);
			ctrlCuponeras.registrarCuponera("ACC2","Actividades2",fi,ff,10f,fa,null);
			ctrlCuponeras.registrarCuponera("ACC3","Actividades2",fi,ff,10f,fa,null);
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
			ctrlDeportivas.altaActividadDeportiva("Alp", null, "Volt1", "dep", 30f, 300f, fi, new HashSet<String>(), null);
			ctrlDeportivas.altaActividadDeportiva("Alp", null, "Volt2", "dep", 30f, 300f, fi, new HashSet<String>(), null);
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
		manejCuponeras.getinstance().eliminarManjeador();
		
		Date fi=null;

		try {
			fi = new SimpleDateFormat("dd/MM/yy").parse("05/08/21");

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
			ctrlDeportivas.altaActividadDeportiva("Alp1", null, "Volt3", "dep", 30f, 300f, fi, new HashSet<String>(), null);
			ctrlDeportivas.altaActividadDeportiva("Alp1", null, "Volt4", "dep", 30f, 300f, fi, new HashSet<String>(), null);
		} catch (ActividadDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
					
		assertThrows(CuponeraNoExisteException.class, () -> {ctrlCuponeras.getCuponerasActividad("Volt2");});
		
	}
	
	@Test
	void testgetCuponeraActividadfail2() {
		manejCuponeras.getinstance().eliminarManjeador();
		
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
			ctrlCuponeras.registrarCuponera("ACC4","Actividades2",fi,ff,10f,fa, null);
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
			ctrlDeportivas.altaActividadDeportiva("Alp2", null, "Volt5", "dep", 30f, 300f, fi, new HashSet<String>(), null);
			ctrlDeportivas.altaActividadDeportiva("Alp2", null, "Volt6", "dep", 30f, 300f, fi, new HashSet<String>(), null);
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
	
	@Test
	void testlistarcuponerasfail2() {
		manejCuponeras.getinstance().eliminarManjeador();
		
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
			ctrlCuponeras.registrarCuponera("ACC5","Actividades2",fi,ff,10f,fa, null);
		}catch (CuponeraRepetidaException e) {
			e.printStackTrace();
		}
	
		try {
			ctrlInsti.altaInstitucion("Alp3", "deporte1","url");
		} catch (InstitucionDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ctrlDeportivas.altaActividadDeportiva("Alp3", null, "Vold1", "dep", 30f, 300f, fi, new HashSet<String>(), null);
		} catch (ActividadDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ctrlCuponeras.agregarActividad("ACC5","Vold1", 20);	
			manejCuponeras.getinstance().getCuponera("ACC5").setComprada(true);
		
		}catch (ActividadDeportivaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertThrows(CuponeraNoExisteException.class, () ->{ctrlCuponeras.listarcuponeraslibres();});
	}
	
	@Test
	void testlistarcuponeraspass() {
		manejCuponeras.getinstance().eliminarManjeador();
		
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
			ctrlCuponeras.registrarCuponera("ACC6","Actividades2",fi,ff,10f,fa, null);
		}catch (CuponeraRepetidaException e) {
			e.printStackTrace();
		}
	
		try {
			ctrlInsti.altaInstitucion("Alp4", "deporte1","url");
		} catch (InstitucionDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ctrlDeportivas.altaActividadDeportiva("Alp4", null, "Vold2", "dep", 30f, 300f, fi, new HashSet<String>(), null);
		} catch (ActividadDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ctrlCuponeras.agregarActividad("ACC6","Vold2", 20);	
		
		}catch (ActividadDeportivaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Set<String> resu=new HashSet<String>();
		try {
		    resu= ctrlCuponeras.listarcuponeraslibres();	
		
		}catch (CuponeraNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set<String> esperado=new HashSet<String>();
		esperado.add("ACC6");
		
		assertEquals(resu,esperado, "Los sets no son iguales");
	}
	/*comprarCuponera (Date fecha, String cuponera, String nomsocio) throws CuponeraCompradaException*/
	
	@Test
	void compraCuponerapass() {
		ctrlUsuarios ctrlUs = new ctrlUsuarios();
		
		
		Date fi=null;
		Date ff=null;
		Date fa=null;
		Date fcompra=null;
		try {
			fi = new SimpleDateFormat("dd/MM/yy").parse("05/08/21");
			ff = new SimpleDateFormat("dd/MM/yy").parse("12/12/21");
			fa=  new SimpleDateFormat("dd/MM/yy").parse("01/07/21");
			fcompra= new SimpleDateFormat("dd/MM/yy").parse("22/11/21");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			ctrlCuponeras.registrarCuponera("ACU1","Actividades2",fi,ff,10f,fa,null);
		}catch (CuponeraRepetidaException e) {
			e.printStackTrace();
		}
	
		try {
			ctrlInsti.altaInstitucion("Ari1", "deporte1","url");
		} catch (InstitucionDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		InfoBasicaUser ll1 = new InfoBasicaProfesor(	"nick ll1",		"nombre ll1",
				"apellido p1",	"correo ll1",
				new Date(),"0", "",  "Ari1",
				"descp p1", 	"bibliog p1",
				"url p1");
		
		try {
			ctrlUs.altaUsuario(ll1);
		
		}catch(UsuarioDisponibilidadException e){
			
		}
		
		
		
		
		try {
			ctrlDeportivas.altaActividadDeportiva("Ari1", "nick ll1", "Vas1", "dep", 30f, 300f, fi, new HashSet<String>(), null);
		} catch (ActividadDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ctrlDeportivas.cambiarEstado("Vas1", EstadoActi.ACEPTADA);
		
		
		
		try {
			ctrlCuponeras.agregarActividad("ACU1","Vas1", 20);	
		
		}catch (ActividadDeportivaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InfoBasicaSocio t1= new InfoBasicaSocio("ab", "nombre t1", "apellido t1", "correo t1",new Date(),"0", "");

		
		try {
		
			ctrlUs.altaUsuario(t1);
			
		}catch(UsuarioDisponibilidadException e){

		}
		
		try {
		   ctrlCuponeras.comprarCuponera(fcompra, "ACU1","ab");	
		
		}catch (CuponeraCompradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Socio sus= (Socio) manejUsuarios.getInstance().findUsuario("ab");
		String resu= sus.darCompra("ACU1").getCup().getNombre();
				
		
		assertEquals(resu,"ACU1", "La compra tiene la misma cuponera");
		
		ctrlUs.elimiarManjeador();
	}
	
	@Test
	void compraCuponerafail1() {
		ctrlUsuarios ctrlUs = new ctrlUsuarios();
		
		
		Date fi=null;
		Date ff=null;
		Date fa=null;
		Date fcompra = null;
		try {
			fi = new SimpleDateFormat("dd/MM/yy").parse("05/08/21");
			ff = new SimpleDateFormat("dd/MM/yy").parse("31/08/21");
			fa=  new SimpleDateFormat("dd/MM/yy").parse("01/07/21");
			fcompra = new SimpleDateFormat("dd/MM/yy").parse("15/09/21");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			ctrlCuponeras.registrarCuponera("ACU2","Actividades2",fi,ff,10f,fa,null);
		}catch (CuponeraRepetidaException e) {
			e.printStackTrace();
		}
	
		try {
			ctrlInsti.altaInstitucion("Ari12", "deporte1","url");
		} catch (InstitucionDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ctrlDeportivas.altaActividadDeportiva("Ari12", null, "Vas2", "dep", 30f, 300f, fi, new HashSet<String>(), null);
		} catch (ActividadDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ctrlCuponeras.agregarActividad("ACU2","Vas2", 20);	
		
		}catch (ActividadDeportivaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InfoBasicaSocio t2= new InfoBasicaSocio("ab2", "nombre t1", "apellido t1", "correo t2",new Date(), "0", "");

		
		try {
		
			ctrlUs.altaUsuario(t2);
			
		}catch(UsuarioDisponibilidadException e){

		}
				
		
		assertThrows(CuponeraCompradaException.class, () ->{ ctrlCuponeras.comprarCuponera(new SimpleDateFormat("dd/MM/yy").parse("15/09/21"), "ACU2","ab2");});
		ctrlUs.elimiarManjeador();
		
	}
	
	
	@Test
	void compraCuponerafail2() {
		ctrlUsuarios ctrlUs = new ctrlUsuarios();
		
		
		Date fi=null;
		Date ff=null;
		Date fa=null;
		Date fcompra=null;
		try {
			fi = new SimpleDateFormat("dd/MM/yy").parse("05/08/21");
			ff = new SimpleDateFormat("dd/MM/yy").parse("31/08/21");
			fa=  new SimpleDateFormat("dd/MM/yy").parse("01/07/21");
			fcompra= new SimpleDateFormat("dd/MM/yy").parse("15/08/21");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			ctrlCuponeras.registrarCuponera("ACU3","Actividades2",fi,ff,10f,fa,null);
		}catch (CuponeraRepetidaException e) {
			e.printStackTrace();
		}
	
		try {
			ctrlInsti.altaInstitucion("Ari13", "deporte1","url");
		} catch (InstitucionDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ctrlDeportivas.altaActividadDeportiva("Ari13", null, "Vas3", "dep", 30f, 300f, fi, new HashSet<String>(), null);
		} catch (ActividadDeportivaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ctrlCuponeras.agregarActividad("ACU3","Vas3", 20);	
		
		}catch (ActividadDeportivaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InfoBasicaSocio t2= new InfoBasicaSocio("ab3", "nombre t1", "apellido t1", "correo t3",new Date(), "0", "");

		
		try {
		
			ctrlUs.altaUsuario(t2);
			
		}catch(UsuarioDisponibilidadException e){

		}
		try {
			   ctrlCuponeras.comprarCuponera(fcompra, "ACU3","ab3");	
			
			}catch (CuponeraCompradaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		
		assertThrows(CuponeraCompradaException.class, () ->{ ctrlCuponeras.comprarCuponera(new SimpleDateFormat("dd/MM/yy").parse("15/08/21"), "ACU3","ab3");});
		
		ctrlUs.elimiarManjeador();
		
	}
	
	
	
}


