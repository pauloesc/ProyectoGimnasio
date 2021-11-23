package src.logica;

import java.util.Date;
import java.util.List;
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
    private Date fechaAlta;
    private List<DtClase> clases = new  Vector<DtClase>();
    private EstadoActi estado;

    public DtActividadesDeportivas() {}
    
    public DtActividadesDeportivas(String nombre, String descripcion, Float duracion, Float costo, Date fecha_alta) {
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setDuracion(duracion);
        this.setCosto(costo);
        this.setFechaAlta(fecha_alta);
    }

    /* Sirve para mostrar textualmente el nombre de la Actividad Deportiva, por ejemplo en un ComboBox
     */
    public String toString() {
        return getNombre();
    }

    public void agregarDtClase(DtClase dataTypePorParametro ) {
    	this.clases.add(dataTypePorParametro);
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getDuracion() {
		return duracion;
	}

	public void setDuracion(Float duracion) {
		this.duracion = duracion;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public List<DtClase> getClases() {
		return clases;
	}

	public void setClases(List<DtClase> clases) {
		this.clases = clases;
	}

	public EstadoActi getEstado() {
		return estado;
	}

	public void setEstado(EstadoActi estado) {
		this.estado = estado;
	}
	
}
