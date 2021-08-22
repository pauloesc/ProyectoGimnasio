
package controladores;

import java.util.Date;
import java.util.Set;

import excepciones.CuponeraNoExisteException;
import excepciones.CuponeraRepetidaException;
import logica.Cuponera;
import logica.InstitucionDeportiva;
import logica.ActividadDeportiva;
import logica.IctrlCuponeras;
import manejadores.manejCuponeras;
import manejadores.manejDeportivas;
import datatypes.DataCuponera;



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
	
	public Set<String> listarActividadesfaltantes(String nomcup, String nominst) {
		manejCuponeras mC = manejCuponeras.getinstance();
		Cuponera cup = mC.getCuponera(nomcup);
		Set <String> ListAct=cup.getListaActividades();
		manejDeportivas mD= manejDeportivas.getinstance();
		InstitucionDeportiva inst = mD.buscarInstitucion(nominst);
		Set <String> ListInst = inst.darNombresActividadesDeportivas();
		ListInst.removeAll(ListAct);
		
		return ListInst;
	}
	
	public void agregarActividad(String nomcup,String act,int numclase) {
		manejCuponeras mC = manejCuponeras.getinstance();
		Cuponera cup = mC.getCuponera(nomcup);
		manejDeportivas mD= manejDeportivas.getinstance();
		ActividadDeportiva activ = mD.buscarActividad(act);
		cup.agregarActividad(activ, numclase);
	}
	
	public DataCuponera mostrarCuponera (String nomCup) {
		manejCuponeras mC = manejCuponeras.getinstance();
		return mC.mostrarCuponera(nomCup);		
	}
	
	
}
