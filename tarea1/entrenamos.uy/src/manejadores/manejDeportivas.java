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

public class manejDeportivas {
	private Map<String, InstitucionDeportiva> institucionesDeportivas;
    private static manejDeportivas instancia = null;

    private manejDeportivas() {
        institucionesDeportivas = new HashMap<String, InstitucionDeportiva>();
    }
    
    public static manejDeportivas getinstance() {
        if (instancia == null)
            instancia = new manejDeportivas();
        return instancia;
    }
	
    public void addIDeportiva(InstitucionDeportiva insdep) {
        String nombre = insdep.getNombre();
        institucionesDeportivas.put(nombre, insdep);
    }

    public InstitucionDeportiva obtenerIDeportiva(String nombre) {
        return ((InstitucionDeportiva) institucionesDeportivas.get(nombre));
    }

    public InstitucionDeportiva[] getIDeportivas() {
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

}
