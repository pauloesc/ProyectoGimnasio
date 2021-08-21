package controladores;

import java.util.Set;

import excepciones.ActividadDeportivaNoExisteException;
import excepciones.ActividadDeportivaRepetidaException;
import excepciones.InstitucionDeportivaRepetidaException;
import excepciones.InstitucionDeportivaNoExisteException;
import logica.IctrlDeportivas;
import logica.InstitucionDeportiva;
import logica.ActividadDeportiva;
import datatypes.DataActividad;
import datatypes.DataInstitucion;
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
        InstitucionDeportiva indep = mD.buscarInstitucion(nid);
        indep.addActividadDeportiva(actdep);
	}

	public void consultaActividadDeportiva(String nid, String n) throws ActividadDeportivaNoExisteException {
		// TODO Auto-generated method stub
		
	}
	
	public DataInstitucion[] getInstituciones() throws InstitucionDeportivaNoExisteException {
        manejDeportivas mD = manejDeportivas.getinstance();
        InstitucionDeportiva[] insdeps = mD.getInstituciones();

        if (insdeps != null) {
            DataInstitucion[] did = new DataInstitucion[insdeps.length];
            InstitucionDeportiva institucion;

            // Para separar lógica de presentación, no se deben devolver las Instituciones,
            // sino los DataInstitucion
            for (int i = 0; i < insdeps.length; i++) {
                institucion = insdeps[i];
                did[i] = new DataInstitucion(institucion.getNombre(), institucion.getDescripcion(), institucion.getURL());
            }

            return did;
        } else
            throw new InstitucionDeportivaNoExisteException("No existen Instituciones Deportivas registradas");

    }

	public DataActividad[] getActividades(String nid) throws ActividadDeportivaNoExisteException {
        manejDeportivas mD = manejDeportivas.getinstance();
        InstitucionDeportiva indep = mD.buscarInstitucion(nid);
        ActividadDeportiva[] actsdeps = indep.getActividades();

        if (actsdeps != null) {
            DataActividad[] dad = new DataActividad[actsdeps.length];
            ActividadDeportiva actividad;

            // Para separar lógica de presentación, no se deben devolver las Actividades,
            // sino los DataActividad asociados a la Institución seleccionada.
            for (int i = 0; i < actsdeps.length; i++) {
                actividad = actsdeps[i];
                dad[i] = new DataActividad(actividad.getNombre(), actividad.getDescripcion(), actividad.getDuracion(), actividad.getCosto(), actividad.getFechaAlta());
            }

            return dad;
        } else
            throw new ActividadDeportivaNoExisteException("No existen Actividades Deportivas en el sistema para la Institucón Deportiva seleccionada.");

    }

	public DataActividad getDataActividad(String n) throws ActividadDeportivaNoExisteException {
		manejDeportivas mD = manejDeportivas.getinstance();
		ActividadDeportiva actividad = mD.buscarActividad(n);
		DataActividad dtact = new DataActividad(actividad.getNombre(), actividad.getDescripcion(), actividad.getDuracion(), actividad.getCosto(), actividad.getFechaAlta());
		return dtact;	
	}

	public Set<String> darNombreInstituciones() {
		manejDeportivas mD = manejDeportivas.getinstance();
		return mD.darNombreInstituciones();
	}

	public Set<String> darNombresActividadesDeportivas(String inst) {
		manejDeportivas mD = manejDeportivas.getinstance();
		InstitucionDeportiva i = mD.buscarInstitucion(inst);
		
		return i.darNombresActividadesDeportivas();
	}

}
