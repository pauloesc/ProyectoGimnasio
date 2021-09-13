package logica;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Representa a una Institucion Deportiva en el sistema con nombre, descripcion y url.
 * @author mbarrera
 */

public class InstitucionDeportiva {

    private String nombre;
    private String descripcion;
    private String url;
    private Set<ActividadDeportiva> actividadesDeportivasInst;

    public InstitucionDeportiva(String n, String de, String url) {
        this.setNombre(n);
        this.setDescripcion(de);
        this.setURL(url);
        this.actividadesDeportivasInst = new HashSet<ActividadDeportiva>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getURL() {
        return url;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public void setDescripcion(String de) {
        this.descripcion = de;
    }

    public void setURL(String url) {
        this.url = url;
    }
    
    public void addActividadDeportiva(ActividadDeportiva act) {
        this.actividadesDeportivasInst.add(act);
    }

	public ActividadDeportiva[] getActividades() {
		if (actividadesDeportivasInst.isEmpty())
            return null;
        else {
            Object[] o = actividadesDeportivasInst.toArray();
            ActividadDeportiva[] actividadesdeportivas = new ActividadDeportiva[o.length];
            for (int i = 0; i < o.length; i++) {
                actividadesdeportivas[i] = (ActividadDeportiva) o[i];
            }

            return actividadesdeportivas;
        }
    }

	public Set<String> darNombresActividadesDeportivas() {
		Set<String> res = new HashSet<String>();    	
		for( Iterator<ActividadDeportiva> it = this.actividadesDeportivasInst.iterator(); it.hasNext();) { 
		    String x = (String)it.next().getNombre();
		    res.add(x);
		}
		return res;
    }
	
	public InformacionActividad InformacionProfesor(String usuario) {
		
		InformacionActividad i = new InfoActividadProfe( this.nombre, this.descripcion, this.url );
	
		Iterator<ActividadDeportiva> info = this.actividadesDeportivasInst.iterator();
	
		while(info.hasNext()) {
			
			ActividadDeportiva aux = info.next();
			DtActividadesDeportivas aux_ad = aux.InformacionProfesor(usuario);
			
			i.agregarInfo(aux_ad);
		}
				
		return i;		
	}
	
}
