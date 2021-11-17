package logica;

import excepciones.ActividadDeportivaRepetidaException;
import excepciones.ActividadDeportivaNoExisteException;
import java.util.Date;
import java.util.Set;



/**
 * Interface del Controlador de Actividades Deportivas
 * @author mbarrera
 */
public interface IctrlADeportivas {
    
    /**
     * Alta de Actividad Deportiva
     * @param nid Nombre de la Institucion Deportiva.
     * @param n Nombre de la Actividad Deportiva.
     * @param de Descripción de la Actividad Deportiva.
     * @param dur Duración de la Actividad Deportiva.
     * @param c Costo de la Actividad Deportiva.
     * @param fal Fecha de alta de la Actividad Deportiva.
     * @throws ActividadDeportivaRepetidaException Si el nombre ya se encuentra registrado en el sistema.
     */
    public abstract void altaActividadDeportiva(String nid, String pid, String nom, String des, Float dur, Float cos, Date fal, Set<String> cats, String img) throws ActividadDeportivaRepetidaException;

    /**
     * Consulta de Actividad Deportiva
     * Muestra la información relacionada a la Actividad Deportiva indicada, incluyendo Clases y Cuponeras.
     * @param nid Nombre de la Institucion Deportiva.
     * @param n Nombre de la Actividad Deportiva.
     * @throws ActividadDeportivaNoExisteException Si el nombre no está registrada en el sistema.
     */
   // public abstract void /*DataActividadDeportiva*/ consultaActividadDeportiva(String nid, String n) throws ActividadDeportivaNoExisteException;

	public abstract DataActividad[] getActividades(String nid) throws ActividadDeportivaNoExisteException;

	public abstract DataActividad getDataActividad(String nom) throws ActividadDeportivaNoExisteException;

    public abstract Set<String> darNombresActividadesDeportivas(String inst);
    // muestra de las actividades deportivas de una institucion, utilizado en varios CU
    
    public abstract Set<String> getActividadesCategoria(String cat);
     
    public abstract void cargarDatosADeportivas();
    
    public abstract Set<String> mostrarClasesVigentesDeActividadDeportiva(String nomAct);
    
    public abstract void cambiarEstado(String nom, EstadoActi est);
    
    public abstract Set<String> getActividadesIngresadas() throws ActividadDeportivaNoExisteException;
    
    public abstract Set<DataActividad> buscarActividades(String query);
    
	public abstract Set<DataActividad> getDataActividadesIngresadas() throws ActividadDeportivaNoExisteException;
	
	public abstract Set<DtClase> getTodasLasClases();
}

