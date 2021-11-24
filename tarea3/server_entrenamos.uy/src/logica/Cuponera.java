package logica;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Cuponera {
	private String nombre;
	private String descripcion;
	private Date fechaIni;
	private Date fechaFin;
	private Float descuento;
	private Date fechaAlta;
	private boolean comprada; 
	private Set<InfoClases> info;
	private String imagen;

	public Cuponera(String nom, String des, Date ini, Date fin, Float disc, Date alta, String imag) {
		this.nombre = nom;
		this.descripcion = des;
		this.fechaIni = ini;
		this.fechaFin = fin;
		this.descuento = disc;
		this.fechaAlta = alta;
		this.info = new HashSet<InfoClases>();
		this.comprada = false;
		this.imagen = imag;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public Float getDescuento() {
		return descuento;
	}

	public Set<InfoClases> getInfo() {
		return info;
	}

	public void setInfo(Set<InfoClases> info) {
		this.info = info;
	}
	
	public Set<String> getListaActividades(){
		Set<String> resu = new HashSet<String>();
		if (!info.isEmpty()) {
		for (Iterator<InfoClases> iter=info.iterator(); iter.hasNext();) {
			resu.add(iter.next().getNombreActividadDeportiva());
		}
		}
		return resu;  
	}

	public float getCostoCuponera(){
		Float  resu = (float) 0;
		if (!info.isEmpty()) {
		for (Iterator<InfoClases> iter=info.iterator(); iter.hasNext();) {
			InfoClases clas= iter.next();
			resu=resu + (clas.getCantidad()*clas.getAct().getCosto());
		}
		}
		resu= (float) ((resu*(100.0-descuento))/100.0);
		return resu;  
	}
	
	public Set<String> getListaCategorias(){
		Set<String> resu = new HashSet<String>();
		if (!info.isEmpty()) {
		for (Iterator<InfoClases> iter=info.iterator(); iter.hasNext();) {
			resu.addAll(iter.next().getAct().darCategorias());
		}
		}
		return resu;  
	}
	
	
	
	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public void agregarActividad(ActividadDeportiva act, int numclase) {
		InfoClases nueva=new InfoClases(act, numclase);
		info.add(nueva);
	}

	
	public DataCuponera getDataCuponera() {
		Set<ParActividad> grupo = new HashSet<ParActividad>();
		
		if (!info.isEmpty()) {
		for (Iterator<InfoClases> iter = info.iterator(); iter.hasNext();) {
			InfoClases iterador = iter.next();
			String nom = iterador.getNombreActividadDeportiva();
			int numeroCantidad = iterador.getCantidad();
			
			if ( iterador.getAct().getEstado() == EstadoActi.ACEPTADA ) {
				ParActividad nuevo = new ParActividad(nom, numeroCantidad);
				grupo.add(nuevo);				
			}
			
		}
		}
		float costo= this.getCostoCuponera();
		Set<String> cat= this.getListaCategorias();
		String imagen=this.getImagen();
		
		DataCuponera resu= new DataCuponera(nombre, descripcion, fechaIni, fechaFin, descuento, fechaAlta, costo, grupo, cat, imagen);
		return resu;
	}

	public boolean isComprada() {
		return comprada;
	}

	public void setComprada(boolean comprada) {
		this.comprada = comprada;
	}
	
	public boolean cuponerahabilitada(Date fecha) {
		boolean resu=true;
		if (fecha.after(fechaFin))
			resu=false;
		return resu;
	}
	public String getImagen() {
    	return imagen;
    }
    
    public void setImagen(String uri) {
    	this.imagen = uri;
    }
}
