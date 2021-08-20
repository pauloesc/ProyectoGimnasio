
package controladores;

import java.util.Date;

import excepciones.CuponeraRepetidaException;
import logica.IctrlCuponeras;
import manejadores.manejCuponeras;
import manejadores.manejDeportivas;


public class ctrlCuponeras implements IctrlCuponeras {
	
	public ctrlCuponeras() {
	 }
	
	public bool registrarCuponera(String nombre, String direccion, Date fecha_ini, Date fecha_fin, Float descuento, Date fecha_alta) throws CuponeraRepetidaException {
		manejCuponeras mC = manejCuponeras.getinstance();
        ActividadDeportiva actdep = mD.buscarActividad(n);
        if (actdep != null)
            throw new ActividadDeportivaRepetidaException("La actividad deportiva " + n + " ya esta registrada.");

        actdep = new ActividadDeportiva(n, de, dur, c, fal);
        mD.agregarActividad(actdep);
        InstitucionDeportiva indep = mD.buscarInstitucion(nid);
        indep.addActividadDeportiva(actdep);
	}

	
}
