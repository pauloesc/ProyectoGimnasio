package logica;

import excepciones.ActividadDeportivaRepetidaException;
import excepciones.InstitucionDeportivaRepetidaException;
import excepciones.ActividadDeportivaNoExisteException;

/**
 * Interface del Controlador de Actividades e Instituciones Deportivas
 * @author mbarrera
 */
public interface IctrlDeportivas {
    
    /**
     * Alta de Institución Deportiva
     * @param n Nombre de la Institución Deportiva.
     * @param de Descripción de la Institución Deportiva.
     * @param url URL de la Institución Deportiva.
     * @throws InstitucionDeportivaRepetidaException Si el nombre ya se encuentra registrado en el sistema.
     */
    public abstract void altaInstDeportiva(String n, String de, String url) throws InstitucionDeportivaRepetidaException;
    
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
    public abstract void altaActividadDeportiva(String nid, String n, String de, Float dur, Float c, String fal) throws ActividadDeportivaRepetidaException;

    /**
     * Consulta de Actividad Deportiva
     * Muestra la información relacionada a la Actividad Deportiva indicada, incluyendo Clases y Cuponeras.
     * @param nid Nombre de la Institucion Deportiva.
     * @param n Nombre de la Actividad Deportiva.
     * @throws ActividadDeportivaNoExisteException Si el nombre no está registrada en el sistema.
     */
    public abstract void /*DataActividadDeportiva*/ consultaActividadDeportiva(String nid, String n) throws ActividadDeportivaNoExisteException;

}
