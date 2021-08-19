package logica;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Representa a una Institucion Deportiva en el sistema con nombre, descripcion y url.
 * @author mbarrera
 */

public class InstitucionDeportiva {

    private String nombre;
    private String descripcion;
    private String url;
    private Map<String,ActividadDeportiva> actividades;

    public InstitucionDeportiva(String n, String de, String url) {
        this.nombre = n;
        this.descripcion = de;
        this.url = url;
        this.actividades = new HashMap<String,ActividadDeportiva>();
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

    public void setApellido(String de) {
        this.descripcion = de;
    }

    public void setCedulaIdentidad(String url) {
        this.url = url;
    }

    
    public Set<String> darNombresActividadesDeportivas() {
    	return actividades.keySet();
    }
}
