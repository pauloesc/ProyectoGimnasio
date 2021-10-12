package logica;

import java.util.Set;

import excepciones.InstitucionDeportivaRepetidaException;
import excepciones.InstitucionDeportivaNoExisteException;

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
	
	public DataInstitucion getInstitucion(String nombre) throws InstitucionDeportivaNoExisteException
	{
		InstitucionDeportiva institucion = manejIDeportivas.getinstance().buscarInstitucion(nombre);
		if (institucion == null)
			throw new InstitucionDeportivaNoExisteException("No existe institucion " + nombre);
		
		return new DataInstitucion(institucion.getNombre(), institucion.getDescripcion(), institucion.getURL());
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
			altaInstitucion("Telon", "Actividades deportivas para todas las edades.", "https://telon.com.uy");
			altaInstitucion("Olympic", "Gimnasia y Aparatos", "https://www.olympic21.com/");
		} catch (InstitucionDeportivaRepetidaException e) {
			//e.printStackTrace();
		}
	}

}
