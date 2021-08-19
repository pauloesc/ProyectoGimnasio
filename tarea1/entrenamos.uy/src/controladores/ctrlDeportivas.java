package controladores;

import java.util.Set;

import excepciones.ActividadDeportivaNoExisteException;
import excepciones.ActividadDeportivaRepetidaException;
import excepciones.InstitucionDeportivaRepetidaException;
import logica.IctrlDeportivas;
import logica.InstitucionDeportiva;
import manejadores.manejDeportivas;
;

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
        InstitucionDeportiva indep = mD.obtenerIDeportiva(n);
        if (indep != null)
            throw new InstitucionDeportivaRepetidaException("La institución deportiva " + n + " ya esta registrada.");

        indep = new InstitucionDeportiva(n, de, url);
        mD.agregarInstitucion(indep);
	}

	public void altaActividadDeportiva(String nid, String n, String de, Float dur, Float c, String fal)
			throws ActividadDeportivaRepetidaException {
		// TODO Auto-generated method stub
		
	}

	public void consultaActividadDeportiva(String nid, String n) throws ActividadDeportivaNoExisteException {
		// TODO Auto-generated method stub
		
	}
	
	public Set<String> darNombreInstituciones() {
		manejDeportivas mD = manejDeportivas.getinstance();
		return mD.darNombreInstituciones();
	}

	public Set<String> darNombresActividadesDeportivas(String inst) {
		manejDeportivas mD = manejDeportivas.getinstance();
		InstitucionDeportiva i = mD.obtenerIDeportiva(inst);
		
		return i.darNombresActividadesDeportivas();
	}
	
}
