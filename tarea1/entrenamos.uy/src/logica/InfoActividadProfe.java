package logica;

import java.util.Iterator;

public class InfoActividadProfe extends InformacionActividad {

	private String nombre;
	private String desc;
	private String url;
	
	public InfoActividadProfe(String nombre,String desc,String url) {
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

	
	public void imp() {
		
		System.out.println("info de institucion");
		System.out.println("Nombre: " + this.nombre);
		System.out.println("descripcion" + this.desc);
		System.out.println("web" +this.url);
		System.out.println("info de institucion");
		
		Iterator<Object> ff = this.vector.iterator();
		
		while(ff.hasNext()) {
		
			DtActividadesDeportivas uu = (DtActividadesDeportivas) ff.next();
			
			uu.imp();
			
		}
		
	}
	
}
