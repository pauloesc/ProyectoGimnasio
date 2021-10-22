
package logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import excepciones.ActividadDeportivaNoExisteException;
import excepciones.ActividadDeportivaRepetidaException;
import excepciones.CuponeraCompradaException;
import excepciones.CuponeraNoExisteException;
import excepciones.CuponeraRepetidaException;



public class ctrlCuponeras implements IctrlCuponeras {
	
	public ctrlCuponeras() {
	 }
	
	public boolean registrarCuponera(String nombre, String descrip, Date fecha_ini, Date fecha_fin, Float descuento, Date fecha_alta) throws CuponeraRepetidaException {
		manejCuponeras manejadorCuponeras = manejCuponeras.getinstance();
        boolean registrada = manejadorCuponeras.exiteCuponera(nombre);
        if (registrada)
            throw new CuponeraRepetidaException("La cuponera " + nombre + " ya esta registrada.");

        manejadorCuponeras.agregarCuponera(nombre, descrip, fecha_ini, fecha_fin, descuento, fecha_alta);
        return false;
	}

	public Set<String> listarCuponeras() throws CuponeraNoExisteException {
		manejCuponeras manejadorCuponeras = manejCuponeras.getinstance();
		Set<String> resu=manejadorCuponeras.listarcuponeras();
		if (resu.size()==0)
			throw new CuponeraNoExisteException("No existen Cuponeras registradas");

		return resu;
	}
	
	public Set<String> listarActividadesfaltantes(String nomcup, String nominst) throws ActividadDeportivaNoExisteException{
		manejCuponeras manejadorCuponeras = manejCuponeras.getinstance();
		Cuponera cup = manejadorCuponeras.getCuponera(nomcup);
		Set <String> ListAct=cup.getListaActividades();
		manejIDeportivas mID = manejIDeportivas.getinstance();
		InstitucionDeportiva inst = mID.buscarInstitucion(nominst);
		Set <String> ListInst = inst.darNombresActividadesDeportivas();
		if ((ListAct!=null) && (ListInst!=null)) 
			ListInst.removeAll(ListAct);
	
		if (ListInst.size()==0) {
			throw new ActividadDeportivaNoExisteException("Todas las actividades deportivas de la instituciòn fueron agregadas"); 
		}
		return ListInst;
	}
	
	public void agregarActividad(String nomcup,String act,int numclase) throws ActividadDeportivaRepetidaException {
		manejCuponeras manejadorCuponeras = manejCuponeras.getinstance();
		Cuponera cup = manejadorCuponeras.getCuponera(nomcup);
		manejADeportivas manejadorActDep = manejADeportivas.getinstance();
		ActividadDeportiva activ = manejadorActDep .buscarActividad(act);
		if (cup.getListaActividades().contains(act))
			throw new ActividadDeportivaRepetidaException("La actividad deportiva ya ha sido registrada en la cuponera");
		cup.agregarActividad(activ, numclase);
	}
	
	public DataCuponera mostrarCuponera (String nomCup) throws CuponeraNoExisteException {
		manejCuponeras manejadorCuponeras = manejCuponeras.getinstance();
		Cuponera cup=manejadorCuponeras.getCuponera(nomCup);
		if (cup==null)
			throw new CuponeraNoExisteException("La cuponera no se ha registrado en el sistema");
		
		return manejadorCuponeras.mostrarCuponera(nomCup);		
	}
	
	public Set<String> getCuponerasActividad(String nac) throws CuponeraNoExisteException {
        manejCuponeras manejadorCuponeras = manejCuponeras.getinstance();
        Set<Cuponera> cuponeras = manejadorCuponeras.getCuponerasDeActividad(nac);
        if (!cuponeras.isEmpty()) {
        	
        	Set<String> cups = new HashSet<String>();
        	Iterator<Cuponera> iteradorCuponeras = cuponeras.iterator();
            while(iteradorCuponeras.hasNext()){            	
               cups.add(iteradorCuponeras.next().getNombre());
            }

            return cups;
        } else
            throw new CuponeraNoExisteException("No existen Cuponeras en el sistema para la Actividad Deportiva seleccionada.");

    }
	
	
	public Set<String>listarcuponeraslibres() throws CuponeraNoExisteException {
		manejCuponeras manejadorCuponeras = manejCuponeras.getinstance();
		Set<String> resu=manejadorCuponeras.listarcuponeraslibres();
		if (resu.size()==0)
			throw new CuponeraNoExisteException("No existen Cuponeras para poder agregar actividades");

		return resu;
		
	}
	
	public void comprarCuponera (Date fecha, String cuponera, String nomsocio) throws CuponeraCompradaException{
		manejUsuarios manejadorUsuario=manejUsuarios.getInstance();
		Socio sos= (Socio)manejadorUsuario.findUsuario(nomsocio);
		if (!sos.tieneCuponera(cuponera)) {
			manejCuponeras manejadorCuponeras = manejCuponeras.getinstance();
			Cuponera cup=manejadorCuponeras.getCuponera(cuponera);
			if (cup.cuponerahabilitada(fecha)) {
				Set<String> acts=cup.getListaActividades();
				sos.comprarCuponera(fecha, cup, acts);
				cup.setComprada(true);
			}else {
				throw new CuponeraCompradaException ("La cuponera no está en vigencia");
			}
		}else
		  throw new CuponeraCompradaException ("El socio ya tiene adquerida esta cuponera");
	}
	
	
	public Set<String> getCuponerasCategoria(String cat) {
		manejCuponeras mCup = manejCuponeras.getinstance();
		Set<String> resu=mCup.getCuponerasdeCategoria(cat);
		return resu;
    }
	
	public Set<String> getCuponerasAD(String act) {
		manejCuponeras mCup = manejCuponeras.getinstance();
		Set<String> resu=mCup.getCuponerasAD(act);
		return resu;
    } 
	
	public Set<String> getCuponerasInstitucion(String inst){
		Set<String> resu = new HashSet<String>();
		
		manejIDeportivas mID = manejIDeportivas.getinstance();
		InstitucionDeportiva instDep = mID.buscarInstitucion(inst);
		Set<String>  dad=instDep.darNombresActividadesDeportivas();
		
		manejCuponeras mCup = manejCuponeras.getinstance();
		for (Iterator<String> iter=dad.iterator();iter.hasNext();) {
			String act=iter.next();
			Set<Cuponera> list=mCup.getCuponerasDeActividad(act);
			for (Iterator<Cuponera> iter2=list.iterator();iter2.hasNext();) {
				Cuponera cup=iter2.next();
				    resu.add(cup.getNombre());
			}
		}
		return resu;
	}
	
		
	
	public void cargarDatosCuponeras() {
		
		Date fecha1 = null, fecha2 = null, fecha3 = null, fecha4 = null, fecha5 = null, fecha6 = null, fecha7 = null, fecha8 = null, fecha9 = null, fecha10 = null;
		
		try {
			fecha1 = new SimpleDateFormat("dd/MM/yy").parse("01/05/21");
			fecha2 = new SimpleDateFormat("dd/MM/yy").parse("31/07/21");
			fecha3 = new SimpleDateFormat("dd/MM/yy").parse("30/04/21");
			fecha4 = new SimpleDateFormat("dd/MM/yy").parse("01/08/21");
			fecha5 = new SimpleDateFormat("dd/MM/yy").parse("30/09/21");
			fecha6 = new SimpleDateFormat("dd/MM/yy").parse("15/07/21");
			fecha7 = new SimpleDateFormat("dd/MM/yy").parse("15/08/21");
			fecha8  = new SimpleDateFormat("dd/MM/yy").parse("15/11/21");
			fecha9  = new SimpleDateFormat("dd/MM/yy").parse("01/08/21");
			fecha10 = new SimpleDateFormat("dd/MM/yy").parse("30/07/21");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		//cargo cuponeras
		try {
			registrarCuponera("Pelota", "Deportes con pelota.",fecha1,fecha2,20f,fecha3);
			registrarCuponera("Gimnasia", "Aeróbica y aparatos.",fecha4,fecha5,30f,fecha6);
			registrarCuponera("Músculos", "Pesas.",fecha7,fecha8 ,10f,fecha9 );
		} catch (CuponeraRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		try {
			agregarActividad("Pelota", "Voleibol", 7);
			agregarActividad("Pelota", "Basquetbol", 18);
			agregarActividad("Gimnasia", "Aeróbica", 2);
			agregarActividad("Gimnasia", "Aparatos y pesas", 8);
		    agregarActividad ("Músculos", "Kickboxing", 11);
		    agregarActividad ("Músculos", "Aparatos y pesas", 12);
		} catch (ActividadDeportivaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	try {
		comprarCuponera(fecha10 , "Pelota", "guille");
		comprarCuponera(fecha10 , "Gimnasia", "m1k4");
		comprarCuponera(fecha10 , "Gimnasia", "caro");
		comprarCuponera(fecha10 , "Músculos", "sergiop");
		comprarCuponera(fecha10 , "Músculos", "andy");
		comprarCuponera(fecha10 , "Pelota", "Emi71");
		
		
	} catch (CuponeraCompradaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
	
	
	
	

