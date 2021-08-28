package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.ActividadDeportivaRepetidaException;
import excepciones.CuponeraNoExisteException;
import excepciones.CuponeraRepetidaException;
import logica.Cuponera;
import logica.DataCuponera;
import logica.DtClase;
import logica.Fabrica;
import logica.IctrlADeportivas;
import logica.IctrlCuponeras;
import logica.IctrlIDeportivas;
import logica.InfoClases;
import logica.ParActividad;



class TestctrlCuponeras {

	private static IctrlCuponeras ctrlCuponeras;
	

	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		IctrlIDeportivas IID = fabrica.getIctrlIDeportivas();
		IctrlADeportivas IAD = fabrica.getIctrlADeportivas();
		ctrlCuponeras = fabrica.getIctrlCuponeras();
		IID.cargarDatosIDeportivas();
		IAD.cargarDatosADeportivas();
	
	}

	@Test
	void testlistarCuponeraFal(){
		
		assertThrows(CuponeraNoExisteException.class, () ->{ctrlCuponeras.listarCuponeras();});
	
}
	
	
	@Test
	void testregistrarCuponeraExito() {
		
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


	/* agregarActividad(String nomcup,String act,int numclase) throws ActividadDeportivaRepetidaException*/
	
	@Test
	void testagregarActividad() {
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
			ctrlCuponeras.registrarCuponera("Baile2","Actividades2",fi,ff,10f,fa);
		}catch (CuponeraRepetidaException e) {
			e.printStackTrace();
		}
		
		try {
			ctrlCuponeras.agregarActividad("Baile2","Voleibol", 20);	
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
				if (it.getNombre()=="Voleibol" && it.getNumclase()==20){
				   contenidonombre=it.getNombre();
				   contenidonum = it.getNumclase();
				   encontre=true;
				}
				
			}
		}
		
			assertEquals(contenidonombre, "Voleibol", "El nombre de la actividad es correcto");
			assertEquals(contenidonum, 20, "El numero de clases es correcto");
			assertEquals(res.getNombre(), "Baile2", "El nombre de la cuponera es correcto");
			
	}
		
		
		
	
	
	
	
	
	 
	
	@AfterAll
	public static void fin() {
		ctrlCuponeras.cargarDatosCuponeras();
	}
	

	
}

