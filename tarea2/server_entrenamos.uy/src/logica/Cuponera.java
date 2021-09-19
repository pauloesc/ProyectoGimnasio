package logica;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Cuponera {
	private String nombre;
	private String descripcion;
	private Date fecha_ini;
	private Date fecha_fin;
	private Float descuento;
	private Date fecha_alta;
	private boolean comprada; 
	private Set <InfoClases> info;

	public Cuponera(String nom, String des, Date ini, Date fin, Float disc, Date alta) {
		this.nombre = nom;
		this.descripcion = des;
		this.fecha_ini = ini;
		this.fecha_fin = fin;
		this.descuento = disc;
		this.fecha_alta = alta;
		this.info = new HashSet<InfoClases>();
		this.comprada = false;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFecha_ini() {
		return fecha_ini;
	}

	public Date getFecha_fin() {
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
	
	public Set <String> getListaActividades(){
		Set <String> resu = new HashSet<String>();
		if (!info.isEmpty()) {
		for (Iterator<InfoClases> iter=info.iterator();iter.hasNext();) {
			resu.add(iter.next().getNombreActividadDeportiva());
		}
		}
		return resu;  
	}

	public float getCostoCuponera(){
		Float  resu = (float) 0;
		if (!info.isEmpty()) {
		for (Iterator<InfoClases> iter=info.iterator();iter.hasNext();) {
			InfoClases clas= iter.next();
			resu=resu + (clas.getCantidad()*clas.getAct().getCosto());
		}
		}
		resu= (float) ((resu*(100.0-descuento))/100.0);
		return resu;  
	}
	
	public Set <String> getListaCategorias(){
		Set <String> resu = new HashSet<String>();
		if (!info.isEmpty()) {
		for (Iterator<InfoClases> iter=info.iterator();iter.hasNext();) {
			resu.addAll(iter.next().getAct().darCategorias());
		}
		}
		return resu;  
	}
	
	
	
	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public void agregarActividad (ActividadDeportiva act, int numclase) {
		InfoClases nueva=new InfoClases (act, numclase);
		info.add(nueva);
	}

	
	public DataCuponera getDataCuponera() {
		Set <ParActividad> grupo= new HashSet<ParActividad>();
		
		if (!info.isEmpty()) {
		for (Iterator<InfoClases> iter=info.iterator();iter.hasNext();) {
			InfoClases it=iter.next();
			String nom=it.getNombreActividadDeportiva();
			int    n=it.getCantidad();
			ParActividad nuevo= new ParActividad (nom,n);
			grupo.add(nuevo);
		}
		}
		float costo= this.getCostoCuponera();
		Set <String> cat= this.getListaCategorias();
		DataCuponera resu= new DataCuponera(nombre,descripcion,fecha_ini,fecha_fin, descuento, fecha_alta, costo, grupo, cat);
		return resu;
	}

	public boolean isComprada() {
		return comprada;
	}

	public void setComprada(boolean comprada) {
		this.comprada = comprada;
	}
}
