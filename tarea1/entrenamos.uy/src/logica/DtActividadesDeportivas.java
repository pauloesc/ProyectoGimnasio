package logica;

import java.util.Date;
import java.util.Vector;

/**
 * Datatype para transportar la información de una Actividad Deportiva entre capa lógica y de presentación.
 * En Java los datatypes se definen con setters y getters, y se denominan JavaBean.
 * @author mbarrera
 */

public class DtActividadesDeportivas {

    private String nombre;
    private String descripcion;
    private Float duracion;
    private Float costo;
    private Date fecha_alta;
    private Vector<DtClase> clases = new  Vector<DtClase>();

    public DtActividadesDeportivas(String nombre, String descripcion, Float duracion, Float costo, Date fecha_alta) {
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setDuracion(duracion);
        this.setCosto(costo);
        this.setFechaAlta(fecha_alta);
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

    public void agregarDtClase(DtClase dt ) {
    	this.clases.add(dt);
    }

	public Vector<DtClase> getClases() {
		return clases;
	}
    
	
}
