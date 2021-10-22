/**
 * 
 */
package logica;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import excepciones.ClaseLlenaException;
import excepciones.ClaseNoExisteException;
import excepciones.ClaseRepetidaException;
import excepciones.ClaseYaCompradaException;

public class ctrlClases implements IctrlClases {
	
	private manejClases manejador;
	
	public ctrlClases() {
		this.manejador = manejClases.getInstance();
	}
	
	public void crearClase(String nombre, Date Finicio, String prof, int Smin, int Smax, String url, Date FechaAlta, String nomAct, Integer hora, Integer minuto) throws ClaseRepetidaException {
		Clase clase = manejador.findClase(nombre);
		
		if (clase != null) {
			throw new ClaseRepetidaException("Nombre existente");
		}
	
		clase = new Clase(nombre, Finicio, prof, Smin, Smax, url, FechaAlta, hora, minuto);
		
		manejADeportivas ManejadorDep = manejADeportivas.getinstance();
		ActividadDeportiva actividadDeportiva = ManejadorDep.buscarActividad(nomAct);
		
		actividadDeportiva.addClase(clase);
		manejador.agregarClase(clase);
	}
	
	public Set<String> mostrarClasesDeActividadDeportiva(String nomAct) throws ClaseNoExisteException {
		manejADeportivas manejadorActDep = manejADeportivas.getinstance();
		ActividadDeportiva actividadDep = manejadorActDep.buscarActividad(nomAct);
		if (!actividadDep.darNombreClases().isEmpty())
			return actividadDep.darNombreClases();
		else 
			throw new ClaseNoExisteException("No existen Clases en el sistema para la Actividad Deportiva seleccionada.");
	}
	
	public DtClase darDtClase(String nomClas) {
		Clase clase = manejador.findClase(nomClas);
		if (clase!=null) {
			return clase.darDtClase();
		} else {
			return null;
		}
	}
	
	public void registrarSocioAClase(String nick, String actDep, String clas, boolean cuponera, String nomCuponera, Date fechaReg) throws ClaseYaCompradaException, ClaseLlenaException {
		manejUsuarios  manejadorUsuario = manejUsuarios.getInstance();
		manejClases manejadorClases = manejClases.getInstance();
		manejADeportivas mad = manejADeportivas.getinstance();
		
		Socio usr = (Socio)manejadorUsuario.findUsuario(nick);
		Clase clase = manejadorClases.findClase(clas);
		float precio = mad.getPrecio(actDep);
		
		usr.comprarClase(actDep, clase, precio, cuponera, nomCuponera, fechaReg);
		clase.sumarMiembroAClase();

	}
	
	public void cargarDatosClases() {
		//fechas de inicio
		Date fecha1 = null, fecha2 = null, fecha3 = null, fecha4 = null, fecha5 = null, fecha6 = null, fecha7 = null, fecha8 = null, fecha9 = null, fecha10 = null, fecha11 = null, fecha12 = null, fecha13 = null, fecha14 = null, fecha15 = null, fecha16 = null, fecha17 = null;
		//fechas de registro
		Date fr1 = null, fr2 = null, fr3 = null, fr4 = null, fr5 = null, fr6 = null, fr7 = null, fr8 = null, fr9 = null, fr10 = null, fr11 = null, fr12 = null, fr13 = null, fr14 = null, fr15 = null, fr16 = null, fr17 = null;
		try {
			fecha1 = new SimpleDateFormat("dd/MM/yy").parse("15/04/21");
			fecha2 = new SimpleDateFormat("dd/MM/yy").parse("01/05/21");
			fecha3 = new SimpleDateFormat("dd/MM/yy").parse("01/06/21");
			fecha4 = new SimpleDateFormat("dd/MM/yy").parse("10/06/21");
			fecha5 = new SimpleDateFormat("dd/MM/yy").parse("10/07/21");
			fecha6 = new SimpleDateFormat("dd/MM/yy").parse("10/08/21");
			fecha7 = new SimpleDateFormat("dd/MM/yy").parse("15/08/21");
			fecha8 = new SimpleDateFormat("dd/MM/yy").parse("31/08/21");
			fecha9 = new SimpleDateFormat("dd/MM/yy").parse("30/09/21");
			fecha10 = new SimpleDateFormat("dd/MM/yy").parse("01/09/21");
			fecha11 = new SimpleDateFormat("dd/MM/yy").parse("30/09/21");
			fecha12 = new SimpleDateFormat("dd/MM/yy").parse("15/10/21");
			fecha13 = new SimpleDateFormat("dd/MM/yy").parse("25/09/21");
			fecha14 = new SimpleDateFormat("dd/MM/yy").parse("25/10/21");
			fecha15 = new SimpleDateFormat("dd/MM/yy").parse("25/11/21");
			fecha16 = new SimpleDateFormat("dd/MM/yy").parse("01/09/21");
			fecha17 = new SimpleDateFormat("dd/MM/yy").parse("01/10/21");
			
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
			
			crearClase("Calistenia", fecha1, "viktor", 1, 5, "https://www.musculos.com/Calistenia", fr1, "Aparatos y pesas", 15, 30);
			crearClase("Peso libre", fecha2, "viktor", 1, 5, "https://www.musculos.com/pesolibre", fr2, "Aparatos y pesas", 17, 00);
			crearClase("Aparatos", fecha3, "viktor", 1, 7, "https://www.musculos.com/aparatos", fr3, "Aparatos y pesas", 18, 00);
			crearClase("Voleibol", fecha4, "denis", 10, 21, "https://telon.com.uy/voley", fr4, "Voleibol", 19, 00);
			crearClase("Braza", fecha5, "Nelson", 2, 6, "https://telon.com.uy/natacionB", fr5, "Voleibol", 20, 00);
			crearClase("Mariposa", fecha6, "Nelson", 2, 6, "https://telon.com.uy/natacionM", fr6, "Voleibol", 17, 45);
			crearClase("Aeróbica niños", fecha7, "clazar", 5, 10, "https://www.inatural.com/aeroni", fr7, "Aeróbica", 16, 30);
			crearClase("Aeróbico adulto mayor", fecha8, "clazar", 5, 12, "https://www.inatural.com/aeroam", fr8, "Aeróbica", 19, 30);
			crearClase("Aeróbica", fecha9, "clazar", 5, 20, "https://www.inatural.com/aerogral", fr9, "Aeróbica", 20, 00);
			crearClase("Boxeo I", fecha10, "TheBoss", 1, 4, "https://www.musculos.com/boxeo1", fr10, "Kickboxing", 19, 30);
			crearClase("Boxeo II", fecha11, "TheBoss", 2, 2, "https://www.musculos.com/boxeo2", fr11, "Kickboxing", 17, 00);
			crearClase("Músculos para boxeo", fecha12, "viktor", 1, 5, "https://www.musculos.com/muscbox", fr12, "Kickboxing", 20, 00);
			crearClase("100 M", fecha13, "lale", 3, 10, "https://telon.com.uy/100m", fr13, "Atletismo", 19, 00);
			crearClase("200 M", fecha14, "lale", 3, 10, "https://telon.com.uy/200m", fr14, "Atletismo", 18, 30);
			crearClase("Posta", fecha15, "lale", 8, 16, "https://telon.com.uy/posta", fr15, "Atletismo", 17, 45);
			crearClase("Basquet I", fecha16, "aldo", 10, 15, "https://telon.com.uy/bball1", fr16, "Basquetbol", 21, 00);
			crearClase("Basquet II", fecha17, "aldo", 10, 10, "https://telon.com.uy/bball2", fr17, "Basquetbol", 21, 00);
			
		} catch (Exception e) {
			// errores al ingresar las fechas o al registrar clases
		}
	
	}
	
	public void cargarRegistroAClases() {
		Date fecha1 = null, fecha2 = null, fecha3 = null, fecha4 = null, fecha5 = null, fecha6 = null, fecha7 = null, fecha8 = null, fecha9 = null, fecha10 = null, fecha11 = null, fecha12 = null, fecha13 = null, fecha14 = null, fecha15 = null, fecha16 = null, fecha17 = null;
		Date f18 = null, f19 = null, f20 = null, f21 = null, f22 = null, f23 = null, f24 = null, f25 = null, f26 = null, f27 = null, f28 = null, f29 = null, f30 = null, f31 = null, f32 = null, f33 = null, f34 = null;
		Date f35 = null, f36 = null, f37 = null, f38 = null, f39 = null, f40 = null, f41 = null, f42 = null, f43 = null, f44 = null, f45 = null, f46 = null;
		
		try {
			fecha1 = new SimpleDateFormat("dd/MM/yy").parse("09/04/21");
			fecha2 = new SimpleDateFormat("dd/MM/yy").parse("10/04/21");
			fecha3 = new SimpleDateFormat("dd/MM/yy").parse("12/04/21");
			fecha4 = new SimpleDateFormat("dd/MM/yy").parse("15/04/21");
			fecha5 = new SimpleDateFormat("dd/MM/yy").parse("20/04/21");
			fecha6 = new SimpleDateFormat("dd/MM/yy").parse("25/04/21");
			fecha7 = new SimpleDateFormat("dd/MM/yy").parse("28/04/21");
			fecha8 = new SimpleDateFormat("dd/MM/yy").parse("16/04/21");
			fecha9 = new SimpleDateFormat("dd/MM/yy").parse("15/05/21");
			fecha10 = new SimpleDateFormat("dd/MM/yy").parse("20/05/21");
			fecha11 = new SimpleDateFormat("dd/MM/yy").parse("05/05/21");
			fecha12 = new SimpleDateFormat("dd/MM/yy").parse("10/05/21");
			fecha13 = new SimpleDateFormat("dd/MM/yy").parse("15/05/21");
			fecha14 = new SimpleDateFormat("dd/MM/yy").parse("20/05/21");
			fecha15 = new SimpleDateFormat("dd/MM/yy").parse("08/06/21");
			fecha16 = new SimpleDateFormat("dd/MM/yy").parse("13/06/21");
			fecha17 = new SimpleDateFormat("dd/MM/yy").parse("25/06/21");
			f18 = new SimpleDateFormat("dd/MM/yy").parse("05/07/21");
			f19 = new SimpleDateFormat("dd/MM/yy").parse("11/07/21");
			f20 = new SimpleDateFormat("dd/MM/yy").parse("18/07/21");
			f21 = new SimpleDateFormat("dd/MM/yy").parse("19/07/21");
			f22 = new SimpleDateFormat("dd/MM/yy").parse("17/08/21");
			f23 = new SimpleDateFormat("dd/MM/yy").parse("20/08/21");
			f24 = new SimpleDateFormat("dd/MM/yy").parse("23/08/21");
			f25 = new SimpleDateFormat("dd/MM/yy").parse("15/08/21");
			f26 = new SimpleDateFormat("dd/MM/yy").parse("26/08/21");
			f27 = new SimpleDateFormat("dd/MM/yy").parse("19/07/21");
			f28 = new SimpleDateFormat("dd/MM/yy").parse("16/08/21");
			f29 = new SimpleDateFormat("dd/MM/yy").parse("24/08/21");
			f30 = new SimpleDateFormat("dd/MM/yy").parse("01/08/21");
			f31 = new SimpleDateFormat("dd/MM/yy").parse("30/08/21");
			f32 = new SimpleDateFormat("dd/MM/yy").parse("16/08/21");
			f33 = new SimpleDateFormat("dd/MM/yy").parse("16/08/21");
			f34 = new SimpleDateFormat("dd/MM/yy").parse("01/09/21");
			f35 = new SimpleDateFormat("dd/MM/yy").parse("05/09/21");
			f36 = new SimpleDateFormat("dd/MM/yy").parse("16/08/21");
			f37 = new SimpleDateFormat("dd/MM/yy").parse("03/09/21");
			f38 = new SimpleDateFormat("dd/MM/yy").parse("16/08/21");
			f39 = new SimpleDateFormat("dd/MM/yy").parse("06/09/21");
			f40 = new SimpleDateFormat("dd/MM/yy").parse("01/09/21");
			f41 = new SimpleDateFormat("dd/MM/yy").parse("16/08/21");
			f42 = new SimpleDateFormat("dd/MM/yy").parse("20/08/21");
			f43 = new SimpleDateFormat("dd/MM/yy").parse("31/08/21");
			f44 = new SimpleDateFormat("dd/MM/yy").parse("16/08/21");
			f45 = new SimpleDateFormat("dd/MM/yy").parse("20/08/21");
			f46 = new SimpleDateFormat("dd/MM/yy").parse("02/09/21");
			
			
			registrarSocioAClase("caro", "Aparatos y pesas", "Calistenia", false, "", fecha1);
			registrarSocioAClase("sergiop", "Aparatos y pesas", "Calistenia", false, "", fecha2);
			registrarSocioAClase("andy", "Aparatos y pesas", "Calistenia", false, "", fecha3);
			registrarSocioAClase("andy", "Aparatos y pesas", "Peso libre", false, "", fecha4);
			registrarSocioAClase("tonyp", "Aparatos y pesas", "Peso libre", false, "", fecha5);
			registrarSocioAClase("caro", "Aparatos y pesas", "Peso libre", false, "", fecha6);
			registrarSocioAClase("m1k4", "Aparatos y pesas", "Peso libre", false, "", fecha7);
			registrarSocioAClase("charly", "Aparatos y pesas", "Aparatos", false, "", fecha8);
			registrarSocioAClase("caro", "Aparatos y pesas", "Aparatos", false, "", fecha9);
			registrarSocioAClase("m1k4", "Aparatos y pesas", "Aparatos", false, "", fecha10);
			registrarSocioAClase("Emi71", "Voleibol", "Voleibol", false, "", fecha11);
			registrarSocioAClase("euge", "Voleibol", "Voleibol", false, "", fecha12);
			registrarSocioAClase("sergiop", "Voleibol", "Voleibol", false, "", fecha13);
			registrarSocioAClase("tonyp", "Voleibol", "Voleibol", false, "", fecha14);
			registrarSocioAClase("guille", "Voleibol", "Braza", false, "", fecha15);
			registrarSocioAClase("euge", "Voleibol", "Braza", false, "", fecha16);
			registrarSocioAClase("m1k4", "Voleibol", "Braza", false, "", fecha17);
			registrarSocioAClase("charly", "Voleibol", "Mariposa", false, "", f18);
			registrarSocioAClase("sergiop", "Voleibol", "Mariposa", false, "", f19);
			registrarSocioAClase("andy", "Voleibol", "Mariposa", false, "", f20);
			registrarSocioAClase("m1k4", "Aeróbica", "Aeróbica niños", true, "Gimnasia", f21);
			registrarSocioAClase("Emi71", "Aeróbica", "Aeróbico adulto mayor", false, "", f22);
			registrarSocioAClase("guille", "Aeróbica", "Aeróbico adulto mayor", false, "", f23);
			registrarSocioAClase("andy", "Aeróbica", "Aeróbico adulto mayor", false, "", f24);
			registrarSocioAClase("caro", "Aeróbica", "Aeróbica", true, "Gimnasia", f25);
			registrarSocioAClase("euge", "Aeróbica", "Aeróbica", false, "", f26);
			registrarSocioAClase("andy", "Kickboxing", "Boxeo I", true, "Músculos", f27);
			registrarSocioAClase("tonyp", "Kickboxing", "Boxeo I", false, "", f28);
			registrarSocioAClase("m1k4", "Kickboxing", "Boxeo I", false, "", f29);
			registrarSocioAClase("sergiop", "Kickboxing", "Boxeo II", true, "Músculos", f30);
			registrarSocioAClase("guille", "Kickboxing", "Boxeo II", false, "", f31);
			registrarSocioAClase("Emi71", "Kickboxing", "Músculos para boxeo", false, "", f32);
			registrarSocioAClase("caro", "Kickboxing", "Músculos para boxeo", false, "", f33);
			registrarSocioAClase("euge", "Kickboxing", "Músculos para boxeo", false, "", f34);
			registrarSocioAClase("sergiop", "Kickboxing", "Músculos para boxeo", false, "", f35);
			registrarSocioAClase("guille", "Atletismo", "100 M", false, "", f36);
			registrarSocioAClase("charly", "Atletismo", "100 M", false, "", f37);
			registrarSocioAClase("Emi71", "Atletismo", "200 M", false, "", f38);
			registrarSocioAClase("charly", "Atletismo", "200 M", false, "", f39);
			registrarSocioAClase("caro", "Atletismo", "Posta", false, "", f40);
			registrarSocioAClase("sergiop", "Basquetbol", "Basquet I", false, "", f41);
			registrarSocioAClase("Emi71", "Basquetbol", "Basquet I", false, "", f42);
			registrarSocioAClase("tonyp", "Basquetbol", "Basquet I", false, "", f43);
			registrarSocioAClase("andy", "Basquetbol", "Basquet II", false, "", f44);
			registrarSocioAClase("tonyp", "Basquetbol", "Basquet II", false, "", f45);
			registrarSocioAClase("caro", "Basquetbol", "Basquet II", false, "", f46);
			
			
		} catch (Exception e) {
			
		}
	
	}
	
}
