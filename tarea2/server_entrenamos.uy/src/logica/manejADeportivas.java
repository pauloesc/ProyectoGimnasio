package logica;


import java.util.Collection;

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
        return (ActividadDeportiva) actividadesDeportivas.get(nombre);
    }

    public ActividadDeportiva[] getActividades() {
        if (actividadesDeportivas.isEmpty())
            return null;
        else {
            Collection<ActividadDeportiva> actdeps = actividadesDeportivas.values();
            Object[] obj = actdeps.toArray();
            ActividadDeportiva[] actividadesdeportivas = new ActividadDeportiva[obj.length];
            for (int i = 0; i < obj.length; i++) {
                actividadesdeportivas[i] = (ActividadDeportiva) obj[i];
            }

            return actividadesdeportivas;
        }
    }
    
    public String getNombreActividadDeClase(String nom) {
    	//encuentra el nombre de la actividad deportiva que tiene a la clase con nombre nom
    	for (ActividadDeportiva a: actividadesDeportivas.values()) {
    		if (a.darNombreClases().contains(nom)) {
    			return a.getNombre();
    		}
    	}
    	return "";
    }

    
    public float getPrecio(String actDep) {
    	return actividadesDeportivas.get(actDep).getCosto();
    }
    
    public void EliminarManjeador() {
		instancia.actividadesDeportivas.clear();
		instancia=null;
	}
	
}
