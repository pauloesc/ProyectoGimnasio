package src.logica;

import java.util.List;

public class InfoActividadProfe extends InformacionActividad {

	private String nombre;
	private String desc;
	private String url;
	
	private List<DtActividadesDeportivas> actividadesDep = null;
	
	public InfoActividadProfe() {
	}
	
	public InfoActividadProfe(String nombre, String desc, String url) {
		this.nombre=nombre;
		this.desc = desc;
		this.url = url;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDesc() {
		return desc;
	}

	public String getUrl() {
		return url;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<DtActividadesDeportivas> getActividadesDep() {
		return actividadesDep;
	}

	public void setActividadesDep(List<DtActividadesDeportivas> actividadesDep) {
		this.actividadesDep = actividadesDep;
	}
	
	
	
}
