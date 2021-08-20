package manejadores;

/**
 * Clase que conserva la colección global de Actividades e Instituciones Deportivas del sistema.
 * Se identifican por su nombre.
 * Se implementa en base al patrón Singleton.
 * @author mbarrera
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import logica.InstitucionDeportiva;
import logica.ActividadDeportiva;

public class manejDeportivas {
	private Map<String, InstitucionDeportiva> institucionesDeportivas;
	private Map<String, ActividadDeportiva> actividadesDeportivas;
	
    private static manejDeportivas instancia = null;

    private manejDeportivas() {
        institucionesDeportivas = new HashMap<String, InstitucionDeportiva>();
        actividadesDeportivas = new HashMap<String, ActividadDeportiva>();
    }
    
    public static manejDeportivas getinstance() {
        if (instancia == null)
            instancia = new manejDeportivas();
        return instancia;
    }
	
    public void agregarInstitucion(InstitucionDeportiva insdep) {
        String nombre = insdep.getNombre();
        institucionesDeportivas.put(nombre, insdep);
    }

    public InstitucionDeportiva buscarInstitucion(String nombre) {
        return ((InstitucionDeportiva) institucionesDeportivas.get(nombre));
    }

    public InstitucionDeportiva[] getInstituciones() {
        if (institucionesDeportivas.isEmpty())
            return null;
        else {
            Collection<InstitucionDeportiva> insdeps = institucionesDeportivas.values();
            Object[] o = insdeps.toArray();
            InstitucionDeportiva[] institucionesdeportivas = new InstitucionDeportiva[o.length];
            for (int i = 0; i < o.length; i++) {
                institucionesdeportivas[i] = (InstitucionDeportiva) o[i];
            }

            return institucionesdeportivas;
        }
    }
    
    public void agregarActividad(ActividadDeportiva actdep) {
        String nombre = actdep.getNombre();
        actividadesDeportivas.put(nombre, actdep);
    }

    public ActividadDeportiva buscarActividad(String nombre) {
        return ((ActividadDeportiva) actividadesDeportivas.get(nombre));
    }

    public ActividadDeportiva[] getActividades() {
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
    }
	}
