package logica;

import java.util.HashSet;
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
        this.nombre = n;
        this.descripcion = de;
        this.url = url;
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

}
