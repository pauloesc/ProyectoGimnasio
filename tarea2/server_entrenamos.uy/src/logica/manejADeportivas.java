package logica;


/**
 * Clase que conserva la colección global de Actividades Deportivas del sistema.
 * Se identifican por su nombre.
 * Se implementa en base al patrón Singleton.
 * @author mbarrera
 */

import java.util.HashMap;
import java.util.Map;


public class manejADeportivas {
	private Map<String, ActividadDeportiva> actividadesDeportivas;
	
    private static manejADeportivas instancia = null;

    private manejADeportivas() {
        actividadesDeportivas = new HashMap<String, ActividadDeportiva>();
    }
    
    public static manejADeportivas getinstance() {
        if (instancia == null)
            instancia = new manejADeportivas();
        return instancia;
    }

    public void agregarActividad(ActividadDeportiva actdep) {
        String nombre = actdep.getNombre();
        actividadesDeportivas.put(nombre, actdep);
    }

    public ActividadDeportiva buscarActividad(String nombre) {
        return ((ActividadDeportiva) actividadesDeportivas.get(nombre));
    }

  /*  public ActividadDeportiva[] getActividades() {
        if (actividadesDeportivas.isEmpty())
            return null;
        else {
            Collection<ActividadDeportiva> actdeps = actividadesDeportivas.values();
            Object[] o = actdeps.toArray();
            ActividadDeportiva[] actividadesdeportivas = new ActividadDeportiva[o.length];
            for (int i = 0; i < o.length; i++) {
                actividadesdeportivas[i] = (ActividadDeportiva) o[i];
            }

            return actividadesdeportivas;
        }
    }*/
    
    public float getPrecio(String actDep) {
    	return actividadesDeportivas.get(actDep).getCosto();
    }
    public void EliminarManjeador() {
		instancia.actividadesDeportivas.clear();
		instancia=null;
	}
	
}
