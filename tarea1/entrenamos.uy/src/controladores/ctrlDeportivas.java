package controladores;

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

	@Override
	public void altaInstDeportiva(String n, String de, String url) throws InstitucionDeportivaRepetidaException {
		// TODO Auto-generated method stub
		manejDeportivas mD = manejDeportivas.getinstance();
        InstitucionDeportiva indep = mD.obtenerIDeportiva(n);
        if (indep != null)
            throw new InstitucionDeportivaRepetidaException("La institución deportiva " + n + " ya esta registrada.");

        indep = new InstitucionDeportiva(n, de, url);
        mD.addIDeportiva(indep);
	}

	@Override
	public void altaActividadDeportiva(String nid, String n, String de, Float dur, Float c, String fal)
			throws ActividadDeportivaRepetidaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consultaActividadDeportiva(String nid, String n) throws ActividadDeportivaNoExisteException {
		// TODO Auto-generated method stub
		
	}

}
