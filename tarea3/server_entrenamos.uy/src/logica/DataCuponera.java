package logica;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



public class DataCuponera {

    
	private String nombre;
    private String descripcion;
    private Date fechaIni;
	private Date fechaFin;
	private Float descuento;
	private Date fechaAlta;
	private Float costo;
	private String imagen;
	
	private Set<ParActividad> clases;
	private Set<String> categorias;
	private Set<String> instituciones=null;
	
	
	 public DataCuponera() {
	        this.setNombre(new String());
	        this.setDescripcion(new String());
	        this.setDescuento((float) 0);
	        this.setFechaIni(new Date());
	        this.setFechaFin(new Date());
	        this.setFechaAlta(new Date());
	        this.setCosto((float) 0);
	        this.setClases(new HashSet<ParActividad>());
	        this.setCategorias(new HashSet<String>());
	    }
	
	public DataCuponera(String nombre, String descripcion, Date fechaIni, Date fechaFin, Float descuento,
			Date fechaAlta, Float costo, Set<ParActividad> clases, Set<String> categorias, String img) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.descuento = descuento;
		this.fechaAlta = fechaAlta;
		this.costo=costo;
		this.clases = clases;
		this.categorias= categorias;
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
	
	public Date getFechaIni() {
		return fechaIni;
	}
	
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public Float getDescuento() {
		return descuento;
	}
	
	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}
	
	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fecha_alta) {
		this.fechaAlta = fecha_alta;
	}
	
	public Set<ParActividad> getClases() {
		return clases;
	}
	
	public void setClases(Set<ParActividad> clases) {
		this.clases = clases;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public Set<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<String> categorias) {
		this.categorias = categorias;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Set<String> getInstituciones() {
		return instituciones;
	}

	public void setInstituciones(Set<String> instituciones) {
		this.instituciones = instituciones;
	}
}
