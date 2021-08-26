/**
 * 
 */
package controladores;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import datatypes.DtClase;
import excepciones.ClaseLlenaException;
import excepciones.ClaseRepetidaException;
import excepciones.ClaseYaCompradaException;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.IctrlClases;
import logica.Socio;
import manejadores.manejClases;
import manejadores.manejUsuarios;
import manejadores.manejADeportivas;

public class ctrlClases implements IctrlClases {
	
	private manejClases manejador;
	
	public ctrlClases() {
		this.manejador = manejClases.getInstance();
	}
	
	public void crearClase(String nombre, Date Finicio, String prof, int Smin, int Smax, String url, Date FechaAlta, String nomAct) throws ClaseRepetidaException {
		Clase c = manejador.findClase(nombre);
		
		if (c != null) {
			throw new ClaseRepetidaException("Nombre existente");
		}
	
		c = new Clase(nombre, Finicio, prof, Smin, Smax, url, FechaAlta);
		
		manejADeportivas MD = manejADeportivas.getinstance();
		ActividadDeportiva ad = MD.buscarActividad(nomAct);
		
		ad.addClase(c);
		manejador.agregarClase(c);
	}
	
	public Set<String> mostrarClasesDeActividadDeportiva(String nomAct) {
		manejADeportivas md = manejADeportivas.getinstance();
		ActividadDeportiva ad = md.buscarActividad(nomAct);
		return ad.darNombreClases();
	}
	
	public DtClase darDtClase(String nomClas) {
		Clase c = manejador.findClase(nomClas);
		return c.darDtClase();
	}
	
	public void registrarSocioAClase(String nick, String actDep, String clas, boolean cuponera, String nomCuponera, Date fechaReg) throws ClaseYaCompradaException, ClaseLlenaException {
		manejUsuarios  mu = manejUsuarios.getInstance();
		manejClases mc = manejClases.getInstance();
		manejADeportivas mad = manejADeportivas.getinstance();
		
		Socio usr = (Socio)mu.findUsuario(nick);
		Clase c = mc.findClase(clas);
		float precio = mad.getPrecio(actDep);
		
		usr.comprarClase(actDep, c, precio, cuponera, nomCuponera, fechaReg);
		c.sumarMiembroAClase();

	}
	
	public void cargarDatosClases() {
		//fechas de inicio
		Date f1 = null, f2 = null, f3 = null, f4 = null, f5 = null, f6 = null, f7 = null, f8 = null, f9 = null, f10 = null, f11 = null, f12 = null, f13 = null, f14 = null, f15 = null, f16 = null, f17 = null;
		//fechas de registro
		Date fr1 = null, fr2 = null, fr3 = null, fr4 = null, fr5 = null, fr6 = null, fr7 = null, fr8 = null, fr9 = null, fr10 = null, fr11 = null, fr12 = null, fr13 = null, fr14 = null, fr15 = null, fr16 = null, fr17 = null;
		try {
			f1 = new SimpleDateFormat("dd/MM/yy").parse("15/04/21");
			f2 = new SimpleDateFormat("dd/MM/yy").parse("01/05/21");
			f3 = new SimpleDateFormat("dd/MM/yy").parse("01/06/21");
			f4 = new SimpleDateFormat("dd/MM/yy").parse("10/06/21");
			f5 = new SimpleDateFormat("dd/MM/yy").parse("10/07/21");
			f6 = new SimpleDateFormat("dd/MM/yy").parse("10/08/21");
			f7 = new SimpleDateFormat("dd/MM/yy").parse("15/08/21");
			f8 = new SimpleDateFormat("dd/MM/yy").parse("31/08/21");
			f9 = new SimpleDateFormat("dd/MM/yy").parse("30/09/21");
			f10 = new SimpleDateFormat("dd/MM/yy").parse("01/09/21");
			f11 = new SimpleDateFormat("dd/MM/yy").parse("30/09/21");
			f12 = new SimpleDateFormat("dd/MM/yy").parse("15/10/21");
			f13 = new SimpleDateFormat("dd/MM/yy").parse("25/09/21");
			f14 = new SimpleDateFormat("dd/MM/yy").parse("25/10/21");
			f15 = new SimpleDateFormat("dd/MM/yy").parse("25/11/21");
			f16 = new SimpleDateFormat("dd/MM/yy").parse("01/09/21");
			f17 = new SimpleDateFormat("dd/MM/yy").parse("01/10/21");
			
			fr1 = new SimpleDateFormat("dd/MM/yy").parse("31/03/21");
			fr2 = new SimpleDateFormat("dd/MM/yy").parse("31/03/21");
			fr3 = new SimpleDateFormat("dd/MM/yy").parse("31/03/21");
			fr4 = new SimpleDateFormat("dd/MM/yy").parse("20/04/21");
			fr5 = new SimpleDateFormat("dd/MM/yy").parse("20/04/21");
			fr6 = new SimpleDateFormat("dd/MM/yy").parse("20/04/21");
			fr7 = new SimpleDateFormat("dd/MM/yy").parse("30/05/21");
			fr8 = new SimpleDateFormat("dd/MM/yy").parse("30/05/21");
			fr9 = new SimpleDateFormat("dd/MM/yy").parse("30/05/21");
			fr10 = new SimpleDateFormat("dd/MM/yy").parse("07/06/21");
			fr11 = new SimpleDateFormat("dd/MM/yy").parse("07/06/21");
			fr12 = new SimpleDateFormat("dd/MM/yy").parse("07/06/21");
			fr13 = new SimpleDateFormat("dd/MM/yy").parse("08/07/21");
			fr14 = new SimpleDateFormat("dd/MM/yy").parse("08/07/21");
			fr15 = new SimpleDateFormat("dd/MM/yy").parse("08/07/21");
			fr16 = new SimpleDateFormat("dd/MM/yy").parse("31/07/21");
			fr17 = new SimpleDateFormat("dd/MM/yy").parse("31/07/21");
			
			crearClase("Calistenia",f1,"viktor",1,5,"https://www.musculos.com/Calistenia",fr1,"Aparatos y pesas");
			crearClase("Peso libre",f2,"viktor",1,5,"https://www.musculos.com/pesolibre",fr2,"Aparatos y pesas");
			crearClase("Aparatos",f3,"viktor",1,7,"https://www.musculos.com/aparatos",fr3,"Aparatos y pesas");
			crearClase("Voleibol",f4,"denis",10,21,"https://telon.com.uy/voley",fr4,"Voleibol");
			crearClase("Braza",f5,"Nelson",2,6,"https://telon.com.uy/natacionB",fr5,"Voleibol");
			crearClase("Mariposa",f6,"Nelson",2,6,"https://telon.com.uy/natacionM",fr6,"Voleibol");
			crearClase("Aeróbica niños",f7,"clazar",5,10,"https://www.inatural.com/aeroni",fr7,"Aeróbica");
			crearClase("Aeróbico adulto mayor",f8,"clazar",5,12,"https://www.inatural.com/aeroam",fr8,"Aeróbica");
			crearClase("Aeróbica",f9,"clazar",5,20,"https://www.inatural.com/aerogral",fr9,"Aeróbica");
			crearClase("Boxeo I",f10,"TheBoss",1,4,"https://www.musculos.com/boxeo1",fr10,"Kickboxing");
			crearClase("Boxeo II",f11,"TheBoss",2,2,"https://www.musculos.com/boxeo2",fr11,"Kickboxing");
			crearClase("Músculo para boxeo",f12,"viktor",1,5,"https://www.musculos.com/muscbox",fr12,"Kickboxing");
			crearClase("100 M",f13,"lale",3,10,"https://telon.com.uy/100m",fr13,"Atletismo");
			crearClase("200 M",f14,"lale",3,10,"https://telon.com.uy/200m",fr14,"Atletismo");
			crearClase("Posta",f15,"lale",8,16,"https://telon.com.uy/posta",fr15,"Atletismo");
			crearClase("Basquet I",f16,"aldo",10,15,"https://telon.com.uy/bball1",fr16,"Basquetbol");
			crearClase("Basquet II",f17,"aldo",10,10,"https://telon.com.uy/bball2",fr17,"Basquetbol");
			
		} catch (Exception e) {
			// errores al ingresar las fechas o al registrar clases
		}
	
		
		
	
	}
	
	
}
