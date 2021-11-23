package src.logica;

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
    private Date fechaAlta;
    private EstadoActi estado;
    private Set<String> categorias;
    private String profesor;
    private String institucion;
    private String imagen;

    public DataActividad() {
        this.setNombre(new String());
        this.setDescripcion(new String());
        this.setDuracion((float) 0);
        this.setCosto((float) 0);
        this.setFechaAlta(new Date());
        this.setEstado(EstadoActi.INGRESADA);
        this.setCategorias(new HashSet<String>());
        this.setProfesor(new String());
        this.setInstitucion(new String());
    }

    public DataActividad(String nombre, String descripcion, Float duracion, Float costo, Date fechaAlta, EstadoActi est, Set<String> categ, String prof, String inst, String img) {
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setDuracion(duracion);
        this.setCosto(costo);
        this.setFechaAlta(fechaAlta);
        this.setEstado(est);
        this.setCategorias(categ);
        this.setProfesor(prof);
        this.setInstitucion(inst);
        this.setImagen(img);
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

	public EstadoActi getEstado() {
		return estado;
	}

	public void setEstado(EstadoActi estado) {
		this.estado = estado;
	}

	public Set<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<String> categorias) {
		this.categorias = categorias;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/* Sirve para mostrar textualmente el nombre de la Actividad Deportiva, por ejemplo en un ComboBox
     */
    public String toString() {
        return getNombre();
    }

}
