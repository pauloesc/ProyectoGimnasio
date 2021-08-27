
package logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import excepciones.ActividadDeportivaNoExisteException;
import excepciones.ActividadDeportivaRepetidaException;
import excepciones.CuponeraNoExisteException;
import excepciones.CuponeraRepetidaException;



public class ctrlCuponeras implements IctrlCuponeras {
	
	public ctrlCuponeras() {
	 }
	
	public boolean registrarCuponera(String nombre, String descrip, Date fecha_ini, Date fecha_fin, Float descuento, Date fecha_alta) throws CuponeraRepetidaException {
		manejCuponeras mC = manejCuponeras.getinstance();
        boolean registrada = mC.exiteCuponera(nombre);
        if (registrada)
            throw new CuponeraRepetidaException("La cuponera " + nombre + " ya esta registrada.");

        mC.agregarCuponera(nombre, descrip, fecha_ini, fecha_fin, descuento, fecha_alta);
        return false;
	}

	public Set<String> listarCuponeras() throws CuponeraNoExisteException {
		manejCuponeras mC = manejCuponeras.getinstance();
		Set<String> resu=mC.listarcuponeras();
		if (resu.size()==0)
			throw new CuponeraNoExisteException("No existen Cuponeras registradas");

		return resu;
	}
	
	public Set<String> listarActividadesfaltantes(String nomcup, String nominst) throws ActividadDeportivaNoExisteException{
		manejCuponeras mC = manejCuponeras.getinstance();
		Cuponera cup = mC.getCuponera(nomcup);
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
		manejCuponeras mC = manejCuponeras.getinstance();
		Cuponera cup = mC.getCuponera(nomcup);
		manejADeportivas mD= manejADeportivas.getinstance();
		ActividadDeportiva activ = mD.buscarActividad(act);
		if (cup.getListaActividades().contains(act))
			throw new ActividadDeportivaRepetidaException("La actividad deportiva ya ha sido registrada en la cuponera");
		cup.agregarActividad(activ, numclase);
	}
	
	public DataCuponera mostrarCuponera (String nomCup) throws CuponeraNoExisteException {
		manejCuponeras mC = manejCuponeras.getinstance();
		Cuponera cup=mC.getCuponera(nomCup);
		if (cup==null)
			throw new CuponeraNoExisteException("La cuponera no se ha registrado en el sistema");
		
		return mC.mostrarCuponera(nomCup);		
	}
	
	public Set<String> getCuponerasActividad(String nac) throws CuponeraNoExisteException {
        manejCuponeras mC = manejCuponeras.getinstance();
        Set<Cuponera> cuponeras = mC.getCuponerasDeActividad(nac);
        if (!cuponeras.isEmpty()) {
        	
        	Set<String> cups = new HashSet<String>();
        	Iterator<Cuponera> it = cuponeras.iterator();
            while(it.hasNext()){            	
               cups.add(it.next().getNombre());
            }

            return cups;
        } else
            throw new CuponeraNoExisteException("No existen Cuponeras en el sistema para la Actividad Deportiva seleccionada.");

    }
	
	public void cargarDatosCuponeras() {
		
		Date f1 = null, f2 = null, f3 = null, f4 = null, f5 = null, f6 = null, f7 =null, f8=null, f9=null;
		try {
			f1 = new SimpleDateFormat("dd/MM/yy").parse("01/05/21");
			f2 = new SimpleDateFormat("dd/MM/yy").parse("31/07/21");
			f3 = new SimpleDateFormat("dd/MM/yy").parse("30/04/21");
			f4 = new SimpleDateFormat("dd/MM/yy").parse("01/08/21");
			f5 = new SimpleDateFormat("dd/MM/yy").parse("30/09/21");
			f6 = new SimpleDateFormat("dd/MM/yy").parse("15/07/21");
			f7 = new SimpleDateFormat("dd/MM/yy").parse("15/08/21");
			f8 = new SimpleDateFormat("dd/MM/yy").parse("15/11/21");
			f9 = new SimpleDateFormat("dd/MM/yy").parse("01/08/21");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		//cargo cuponeras
		try {
			registrarCuponera("Pelota", "Deportes con pelota.",f1,f2,20f,f3);
			registrarCuponera("Gimnasia", "Aeróbica y aparatos.",f4,f5,30f,f6);
			registrarCuponera("Músculos", "Pesas.",f7,f8,10f,f9);
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
	}
	
}
