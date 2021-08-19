package controladores;

import excepciones.ActividadDeportivaNoExisteException;
import excepciones.ActividadDeportivaRepetidaException;
import excepciones.InstitucionDeportivaRepetidaException;
import logica.IctrlDeportivas;
import logica.InstitucionDeportiva;
import logica.ActividadDeportiva;
import manejadores.manejDeportivas;
import java.util.Date;

/**
 * Controlador de Actividades e Instituciones Deportivas
 * @author mbarrera
 *
 */

public class ctrlDeportivas implements IctrlDeportivas{
	
	 public ctrlDeportivas() {
	 }

	public void altaInstitucion(String n, String de, String url) throws InstitucionDeportivaRepetidaException {
		manejDeportivas mD = manejDeportivas.getinstance();
        InstitucionDeportiva indep = mD.buscarInstitucion(n);
        if (indep != null)
            throw new InstitucionDeportivaRepetidaException("La institución deportiva " + n + " ya esta registrada.");

        indep = new InstitucionDeportiva(n, de, url);
        mD.agregarInstitucion(indep);
	}

	public void altaActividadDeportiva(String nid, String n, String de, Float dur, Float c, Date fal) throws ActividadDeportivaRepetidaException {
		manejDeportivas mD = manejDeportivas.getinstance();
        ActividadDeportiva actdep = mD.buscarActividad(n);
        if (actdep != null)
            throw new ActividadDeportivaRepetidaException("La actividad deportiva " + n + " ya esta registrada.");

        actdep = new ActividadDeportiva(n, de, dur, c, fal);
        mD.agregarActividad(actdep);
		//asociar a la institucion
	}

	public void consultaActividadDeportiva(String nid, String n) throws ActividadDeportivaNoExisteException {
		// TODO Auto-generated method stub
		
	}

}
