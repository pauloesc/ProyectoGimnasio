
package src.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import src.excepciones.*;



public class ctrlCuponeras implements IctrlCuponeras {
	
	public ctrlCuponeras() {
	 }
	
	public boolean registrarCuponera(String nombre, String descrip, Date fecha_ini, Date fecha_fin, Float descuento, Date fecha_alta, String imagen) throws CuponeraRepetidaException {
		manejCuponeras manejadorCuponeras = manejCuponeras.getinstance();
        boolean registrada = manejadorCuponeras.exiteCuponera(nombre);
        if (registrada)
            throw new CuponeraRepetidaException("La cuponera " + nombre + " ya esta registrada.");

        manejadorCuponeras.agregarCuponera(nombre, descrip, fecha_ini, fecha_fin, descuento, fecha_alta, imagen);
        return false;
	}

	public Set<String> listarCuponeras() throws CuponeraNoExisteException {
		manejCuponeras manejadorCuponeras = manejCuponeras.getinstance();
		Set<String> resu=manejadorCuponeras.listarcuponeras();
		if (resu.size()==0)
			throw new CuponeraNoExisteException("No existen Cuponeras registradas");

		return resu;
	}
	
	public Set<String> listarActividadesfaltantes(String nomcup, String nominst) throws ActividadDeportivaNoExisteException {
		manejCuponeras manejadorCuponeras = manejCuponeras.getinstance();
		Cuponera cup = manejadorCuponeras.getCuponera(nomcup);
		Set<String> ListAct=cup.getListaActividades();
		manejIDeportivas mID = manejIDeportivas.getinstance();
		InstitucionDeportiva inst = mID.buscarInstitucion(nominst);
		Set<String> ListInst = inst.darNombresActividadesDeportivas();
		if ( ListAct!=null && ListInst!=null ) 
			ListInst.removeAll(ListAct);
	
		if (ListInst.size()==0) 
			throw new ActividadDeportivaNoExisteException("Todas las actividades deportivas de la instituciòn fueron agregadas"); 
		
		return ListInst;
	}
	
	public void agregarActividad(String nomcup, String act, int numclase) throws ActividadDeportivaRepetidaException {
		manejCuponeras manejadorCuponeras = manejCuponeras.getinstance();
		Cuponera cup = manejadorCuponeras.getCuponera(nomcup);
		manejADeportivas manejadorActDep = manejADeportivas.getinstance();
		ActividadDeportiva activ = manejadorActDep .buscarActividad(act);
		if (cup.getListaActividades().contains(act))
			throw new ActividadDeportivaRepetidaException("La actividad deportiva ya ha sido registrada en la cuponera");
		cup.agregarActividad(activ, numclase);
	}
	
	public DataCuponera mostrarCuponera(String nomCup) throws CuponeraNoExisteException {
		manejCuponeras manejadorCuponeras = manejCuponeras.getinstance();
		manejIDeportivas manejadorInstituciones= manejIDeportivas.getinstance();
		
		Set<String> instituciones = manejadorInstituciones.darNombreInstituciones();
		Set<String> instdata= new HashSet<String>();
		
		for (Iterator<String> iter=instituciones.iterator(); iter.hasNext(); ) {
			String inst=iter.next();
			Set<String> resu= getCuponerasInstitucion(inst); 
			if (resu.contains(nomCup)) {
			 instdata.add(inst);	
			}
		}

		Cuponera cup=manejadorCuponeras.getCuponera(nomCup);
		if (cup==null)
			throw new CuponeraNoExisteException("La cuponera no se ha registrado en el sistema");
		
		DataCuponera resu=manejadorCuponeras.mostrarCuponera(nomCup);
		resu.setInstituciones(instdata);
	
		return resu;		
	}
	
	public Set<String> getCuponerasActividad(String nac) throws CuponeraNoExisteException {
        manejCuponeras manejadorCuponeras = manejCuponeras.getinstance();
        Set<Cuponera> cuponeras = manejadorCuponeras.getCuponerasDeActividad(nac);
        if (!cuponeras.isEmpty()) {
        	
        	Set<String> cups = new HashSet<String>();
        	Iterator<Cuponera> iteradorCuponeras = cuponeras.iterator();
            while (iteradorCuponeras.hasNext()){            	
               cups.add(iteradorCuponeras.next().getNombre());
            }

            return cups;
        } else
            throw new CuponeraNoExisteException("No existen Cuponeras en el sistema para la Actividad Deportiva seleccionada.");

    }
	
	
	public Set<String> listarcuponeraslibres() throws CuponeraNoExisteException {
		manejCuponeras manejadorCuponeras = manejCuponeras.getinstance();
		Set<String> resu=manejadorCuponeras.listarcuponeraslibres();
		if (resu.size()==0)
			throw new CuponeraNoExisteException("No existen Cuponeras para poder agregar actividades");

		return resu;
		
	}
	
	public void comprarCuponera(Date fecha, String cuponera, String nomsocio) throws CuponeraCompradaException{
		manejUsuarios manejadorUsuario=manejUsuarios.getInstance();
		Socio sos= (Socio) manejadorUsuario.findUsuario(nomsocio);
		if (!sos.tieneCuponera(cuponera)) {
			manejCuponeras manejadorCuponeras = manejCuponeras.getinstance();
			Cuponera cup=manejadorCuponeras.getCuponera(cuponera);
			if (cup.cuponerahabilitada(fecha)) {
				Set<String> acts=cup.getListaActividades();
				sos.comprarCuponera(fecha, cup, acts);
				cup.setComprada(true);
			}else {
				throw new CuponeraCompradaException("La cuponera no está en vigencia");
			}
		}else
		  throw new CuponeraCompradaException("El socio ya tiene adquerida esta cuponera");
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
		for (Iterator<String> iter=dad.iterator(); iter.hasNext();) {
			String act=iter.next();
			Set<Cuponera> list=mCup.getCuponerasDeActividad(act);
			for (Iterator<Cuponera> iter2=list.iterator(); iter2.hasNext();) {
				Cuponera cup=iter2.next();
				    resu.add(cup.getNombre());
			}
		}
		return resu;
	}
	
		
	
	public void cargarDatosCuponeras() {
		
		Date fecha1 = null, fecha2 = null, fecha3 = null, fecha4 = null, fecha5 = null, fecha6 = null, fecha7 = null, fecha8 = null, fecha9 = null, fecha10 = null, fecha11 = null, fecha12 = null;
		
		try {
			fecha1 = new SimpleDateFormat("dd/MM/yy").parse("01/05/21");
			fecha2 = new SimpleDateFormat("dd/MM/yy").parse("31/07/21");
			fecha3 = new SimpleDateFormat("dd/MM/yy").parse("30/04/21");
			
			fecha4 = new SimpleDateFormat("dd/MM/yy").parse("01/08/21");
			fecha5 = new SimpleDateFormat("dd/MM/yy").parse("30/09/21");
			fecha6 = new SimpleDateFormat("dd/MM/yy").parse("15/07/21");
			
			fecha7 = new SimpleDateFormat("dd/MM/yy").parse("15/08/21");
			fecha8  = new SimpleDateFormat("dd/MM/yy").parse("15/12/21");
			fecha9  = new SimpleDateFormat("dd/MM/yy").parse("18/07/21");
			
			fecha10 = new SimpleDateFormat("dd/MM/yy").parse("01/10/21");
			fecha11 = new SimpleDateFormat("dd/MM/yy").parse("31/12/21");
			fecha12 = new SimpleDateFormat("dd/MM/yy").parse("01/09/21");
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		//cargo cuponeras
		try {
			registrarCuponera("Pelota", "Deportes con pelota.", fecha1, fecha2, 20f, fecha3, "b1.jpg");
			registrarCuponera("Gimnasia", "Aeróbica y aparatos.", fecha4, fecha5, 30f, fecha6, "b2.jpg");
			registrarCuponera("Músculos", "Pesas.", fecha7, fecha8 , 10f, fecha9, "b3.jpg" );
			registrarCuponera("Pista", "Entrenamiento de Atletismo", fecha10, fecha11 , 15f, fecha12, "b4.jpg" );
		} catch (CuponeraRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		try {
			agregarActividad("Pelota", "Voleibol", 7);
			agregarActividad("Pelota", "Basquetbol", 18);
			agregarActividad("Gimnasia", "Aeróbica", 2);
			agregarActividad("Gimnasia", "Aparatos y pesas", 8);
		    agregarActividad("Músculos", "Kickboxing", 11);
		    agregarActividad("Músculos", "Aparatos y pesas", 12);
		    agregarActividad("Pista", "Atletismo", 20);
		} catch (ActividadDeportivaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Date fechaCompra = null;
		Date fechaCompra2 = null;
		try {
			fechaCompra = new SimpleDateFormat("dd/MM/yy").parse("30/07/21");
			fechaCompra2 = new SimpleDateFormat("dd/MM/yy").parse("02/10/21");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	try {
		comprarCuponera(fechaCompra , "Pelota", "guille");
		comprarCuponera(fechaCompra , "Gimnasia", "m1k4");
		comprarCuponera(fechaCompra , "Gimnasia", "caro");
		comprarCuponera(fechaCompra , "Músculos", "sergiop");
		comprarCuponera(fechaCompra , "Músculos", "andy");
		comprarCuponera(fechaCompra , "Pelota", "Emi71");
		
		comprarCuponera(fechaCompra2 , "Pista", "caro");
		
	} catch (CuponeraCompradaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public Set<DataCuponera> buscarCuponeras(String consulta) throws CuponeraNoExisteException {
		Set<Cuponera> resu = manejCuponeras.getinstance().buscarCuponeras(consulta);
		Set<DataCuponera> resucupo= new HashSet<DataCuponera>();
		for (Iterator<Cuponera> iter=resu.iterator(); iter.hasNext(); ) {
		   Cuponera cupo=iter.next();
		   DataCuponera cupodata;
		   cupodata = mostrarCuponera(cupo.getNombre());
	
		   resucupo.add(cupodata);
		}	
			
		return resucupo;
	}
}
	
	
	
	

