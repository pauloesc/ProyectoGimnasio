package logica;

import excepciones.InstitucionDeportivaRepetidaException;
import excepciones.InstitucionDeportivaNoExisteException;
import java.util.Set;



/**
 * Interface del Controlador de Actividades e Instituciones Deportivas
 * @author mbarrera
 */
public interface IctrlIDeportivas {
    
    /**
     * Alta de Institución Deportiva
     * @param n Nombre de la Institución Deportiva.
     * @param de Descripción de la Institución Deportiva.
     * @param url URL de la Institución Deportiva.
     * @throws InstitucionDeportivaRepetidaException Si el nombre ya se encuentra registrado en el sistema.
     */
    public abstract void altaInstitucion(String nom, String des, String url) throws InstitucionDeportivaRepetidaException;
    
    public abstract DataInstitucion getInstitucion(String nombre) throws InstitucionDeportivaNoExisteException;
    
	public abstract DataInstitucion[] getInstituciones() throws InstitucionDeportivaNoExisteException;

	public abstract Set<String> darNombreInstituciones();
    // muestra los nombres de todas las instituciones deportivas, utilizado en varios CU
    
    public abstract void cargarDatosIDeportivas();
}

