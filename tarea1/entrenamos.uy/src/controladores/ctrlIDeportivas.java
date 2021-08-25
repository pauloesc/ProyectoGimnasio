package controladores;

import java.util.Set;

import excepciones.ActividadDeportivaNoExisteException;
import excepciones.ActividadDeportivaRepetidaException;
import excepciones.InstitucionDeportivaRepetidaException;
import excepciones.InstitucionDeportivaNoExisteException;
import logica.IctrlIDeportivas;
import logica.InstitucionDeportiva;
import logica.ActividadDeportiva;
import datatypes.DataActividad;
import datatypes.DataInstitucion;
import manejadores.manejADeportivas;
import manejadores.manejIDeportivas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Controlador de Instituciones Deportivas
 * @author mbarrera
 *
 */

public class ctrlIDeportivas implements IctrlIDeportivas{
	
	 public ctrlIDeportivas() {
	 }

	public void altaInstitucion(String n, String de, String url) throws InstitucionDeportivaRepetidaException {
		manejIDeportivas mID = manejIDeportivas.getinstance();
        InstitucionDeportiva indep = mID.buscarInstitucion(n);
        if (indep != null)
            throw new InstitucionDeportivaRepetidaException("La institución deportiva " + n + " ya esta registrada.");

        indep = new InstitucionDeportiva(n, de, url);
        mID.agregarInstitucion(indep);
	}
	
	public DataInstitucion[] getInstituciones() throws InstitucionDeportivaNoExisteException {
        manejIDeportivas mID = manejIDeportivas.getinstance();
        InstitucionDeportiva[] insdeps = mID.getInstituciones();

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

	public Set<String> darNombreInstituciones() {
		manejIDeportivas mID = manejIDeportivas.getinstance();
		return mID.darNombreInstituciones();
	}

	public void cargarDatosIDeportivas() {
		
		//cargo instituciones deportivas
		try {
			altaInstitucion("Instituto Natural", "Clases de gimnasia, aeróbica, spinning y yoga.", "https://www.inatural.com");
			altaInstitucion("Fuerza Bruta", "Gimnasio especializado en el desarrollo de la musculatura.", "https://www.musculos.com/");
			altaInstitucion("Telón", "Actividades deportivas para todas las edades.", "https://telon.com.uy");
			altaInstitucion("Olympic", "Gimnasia y Aparatos", "https://www.olympic21.com/");
		} catch (InstitucionDeportivaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
