package logica;

import java.text.SimpleDateFormat;

/**
 * Representa a una Actividad Deportiva en el sistema con nombre, descripcion, duracion, costo, fecha_alta.
 * @author mbarrera
 */

public class ActividadDeportiva {

    private String nombre;
    private String descripcion;
    private Float duracion;
    private Float costo;
    private SimpleDateFormat fecha_alta;
    

    public ActividadDeportiva(String n, String de, Float dur, Float cost, SimpleDateFormat fa) {
        this.nombre = n;
        this.descripcion = de;
        this.duracion = dur;
        this.costo = cost;
        this.fecha_alta = fa;
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
    
    public SimpleDateFormat getFechaAlta() {
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
    
    public void setFechaAlta(SimpleDateFormat fa) {
        this.fecha_alta = fa;
    }

}
