package logica;


/**
 * Clase que conserva la colección global de Instituciones Deportivas del sistema.
 * Se identifican por su nombre.
 * Se implementa en base al patrón Singleton.
 * @author mbarrera
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class manejIDeportivas {
	private Map<String, InstitucionDeportiva> institucionesDeportivas;
	
    private static manejIDeportivas instancia = null;

    private manejIDeportivas() {
        institucionesDeportivas = new HashMap<String, InstitucionDeportiva>();
    }
    
    public static manejIDeportivas getinstance() {
        if (instancia == null)
            instancia = new manejIDeportivas();
        return instancia;
    }
	
    public void agregarInstitucion(InstitucionDeportiva insdep) {
        String nombre = insdep.getNombre();
        institucionesDeportivas.put(nombre, insdep);
    }

    public InstitucionDeportiva buscarInstitucion(String nombre) {
        return (InstitucionDeportiva) institucionesDeportivas.get(nombre);
    }

    public InstitucionDeportiva[] getInstituciones() {
        if (institucionesDeportivas.isEmpty())
            return null;
        else {
            Collection<InstitucionDeportiva> insdeps = institucionesDeportivas.values();
            Object[] obj = insdeps.toArray();
            InstitucionDeportiva[] institucionesdeportivas = new InstitucionDeportiva[obj.length];
            for (int i = 0; i < obj.length; i++) {
                institucionesdeportivas[i] = (InstitucionDeportiva) obj[i];
            }

            return institucionesdeportivas;
        }
    }

    public Set<String> darNombreInstituciones() {
    	return this.institucionesDeportivas.keySet();
    }
    
	public static void elimiarManjeador() {
		instancia.institucionesDeportivas.clear();
		instancia=null;
	}
}
