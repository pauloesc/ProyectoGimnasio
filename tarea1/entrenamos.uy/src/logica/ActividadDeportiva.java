package logica;

import java.util.Date;
import java.util.Map;

/**
 * Representa a una Actividad Deportiva en el sistema con nombre, descripcion, duracion, costo, fecha_alta.
 * @author mbarrera
 */

public class ActividadDeportiva {
	private Map<String,Clase> clases;

    private String nombre;
    private String descripcion;
    private Float duracion;
    private Float costo;
    private Date fecha_alta;
    

    public ActividadDeportiva(String n, String de, Float dur, Float cost, Date fa) {
        this.nombre = n;
        this.descripcion = de;
        this.duracion = dur;
        this.costo = cost;
        this.fecha_alta = fa;
    }

    public void addClase(Clase c) {
	clases.put(c.getNombre(),c);
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

    public void setNombre(String n) {
        this.nombre = n;
    }

    public void setDescripcion(String de) {
        this.descripcion = de;
    }
    
    public void setDuracion(Float dur) {
        this.duracion = dur;
    }

    public void setCosto(Float cost) {
        this.costo = cost;
    }
    
    public void setFechaAlta(Date fa) {
        this.fecha_alta = fa;
    }

}
