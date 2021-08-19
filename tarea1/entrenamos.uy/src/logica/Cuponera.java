package logica;

import java.text.SimpleDateFormat;
import java.util.Set;

public class Cuponera {
	private String nombre;
	private String descripcion;
	private SimpleDateFormat fecha_ini;
	private SimpleDateFormat fecha_fin;
	private Float descuento;
	private Set <InfoClases> info;

	public Cuponera(String nom, String des, SimpleDateFormat ini, SimpleDateFormat fin, Float disc) {
		this.nombre = nom;
		this.descripcion = des;
		this.fecha_ini = ini;
		this.fecha_fin = fin;
		this.descuento = disc;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public SimpleDateFormat getFecha_ini() {
		return fecha_ini;
	}

	public SimpleDateFormat getFecha_fin() {
		return fecha_fin;
	}

	public Float getDescuento() {
		return descuento;
	}

	public Set <InfoClases> getInfo() {
		return info;
	}

	public void setInfo(Set <InfoClases> info) {
		this.info = info;
	}
	
	

}
