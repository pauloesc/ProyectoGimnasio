package logica;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



public class DataCuponera {

    
	private String nombre;
    private String descripcion;
    private Date fecha_ini;
	private Date fecha_fin;
	private Float descuento;
	private Date fecha_alta;
	private Float costo;
	
	private Set<ParActividad> clases;
	private Set <String> categorias;
	
	
	 public DataCuponera() {
	        this.setNombre(new String());
	        this.setDescripcion(new String());
	        this.setDescuento((float) 0);
	        this.setFecha_ini(new Date());
	        this.setFecha_fin(new Date());
	        this.setFecha_alta(new Date());
	        this.setCosto((float) 0);
	        this.setClases(new HashSet<ParActividad>());
	        this.setCategorias(new HashSet<String>());
	    }
	
	public DataCuponera(String nombre, String descripcion, Date fecha_ini, Date fecha_fin, Float descuento,
			Date fecha_alta, Float costo, Set<ParActividad> clases, Set<String> categorias) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha_ini = fecha_ini;
		this.fecha_fin = fecha_fin;
		this.descuento = descuento;
		this.fecha_alta = fecha_alta;
		this.costo=costo;
		this.clases = clases;
		this.categorias= categorias;
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
	
	public Date getFecha_ini() {
		return fecha_ini;
	}
	
	public void setFecha_ini(Date fecha_ini) {
		this.fecha_ini = fecha_ini;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}
	
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	
	public Float getDescuento() {
		return descuento;
	}
	
	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}
	
	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
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

	public Set <String> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set <String> categorias) {
		this.categorias = categorias;
	}
}
