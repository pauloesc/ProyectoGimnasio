package logica;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Datatype para transportar la información de una Actividad Deportiva entre capa lógica y de presentación.
 * En Java los datatypes se definen con setters y getters, y se denominan JavaBean.
 * @author mbarrera
 */

public class DataActividad {

    private String nombre;
    private String descripcion;
    private Float duracion;
    private Float costo;
    private Date fecha_alta;
    private EstadoActi estado;
    private Set<String> categorias;

    public DataActividad() {
        this.setNombre(new String());
        this.setDescripcion(new String());
        this.setDuracion((float) 0);
        this.setCosto((float) 0);
        this.setFechaAlta(new Date());
        this.setEstado(EstadoActi.INGRESADA);
        this.setCategorias(new HashSet<String>());
    }

    public DataActividad(String nombre, String descripcion, Float duracion, Float costo, Date fecha_alta, EstadoActi est, Set<String> categ) {
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setDuracion(duracion);
        this.setCosto(costo);
        this.setFechaAlta(fecha_alta);
        this.setEstado(est);
        this.setCategorias(categ);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Float getDuracion() {
        return duracion;
    }
    
    public Float getCosto() {
        return costo;
    }
    
    public Date getFechaAlta() {
        return fecha_alta;
    }
    
    public EstadoActi getEstado() {
    	return estado;
    }
    
    public Set<String> getCategorias() {
    	return categorias;
    }
    
    /* Sirve para mostrar textualmente el nombre de la Actividad Deportiva, por ejemplo en un ComboBox
     */
    public String toString() {
        return getNombre();
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private void setDuracion(Float duracion) {
        this.duracion = duracion;
    }
    
    private void setCosto(Float costo) {
        this.costo = costo;
    }
    
    private void setFechaAlta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }
    
    private void setEstado(EstadoActi est) {
    	this.estado = est;
    }
    
    private void setCategorias(Set<String> cat) {
    	this.categorias = cat;
    }

}
