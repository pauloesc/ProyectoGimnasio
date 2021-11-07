package logica;

public class InfoActividadProfe extends InformacionActividad {

	private String nombre;
	private String desc;
	private String url;
	
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
	
	
	
}
