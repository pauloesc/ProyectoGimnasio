package datatypes;

import java.util.Date;
import java.util.Map;
import java.util.Set;


import logica.InfoClases;


public class DataCuponera {

    
	private String nombre;
    private String descripcion;
    private Date fecha_ini;
	private Date fecha_fin;
	private Float descuento;
	private Date fecha_alta;
	private Set<ParActividad> clases;
	
	

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
	
	public Map<String,int> getClases() {
		return clases;
	}
	
	public void setClases(Map<String,int> clases) {
		this.clases = clases;
	}
}
