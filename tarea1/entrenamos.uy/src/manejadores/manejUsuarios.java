/**
 * 
 */
package manejadores;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import logica.Clase;
import logica.Profesor;
import logica.Usuario;

public class manejUsuarios {

	private static manejUsuarios instance = null;
	private Map<String,Usuario> usuarios;
	
	private manejUsuarios() {
		usuarios = new HashMap<String,Usuario>();
	}
	
	
	
	public static manejUsuarios getInstance() {
		if (instance == null) {
			instance = new manejUsuarios();
		}
		return instance;
	}
	
	public Profesor darProfesor(String nom) {
		return (Profesor) usuarios.get(nom);
	}
	
	public Set<String> mostrarNombreProfesoresDeInstitucion(String inst) {
		Set<String> res = new HashSet<String>();
		Usuario usr;
		
		for (Iterator<Map.Entry<String, Usuario>> entries = usuarios.entrySet().iterator(); entries.hasNext(); ) {
		    Map.Entry<String, Usuario> entry = entries.next();
		    usr = entry.getValue();
		    
		    if (usr.getClass() == Profesor.class) {
		    	Profesor p = (Profesor) usr;
		    	if (p.getNombreInstitucion() == inst) {
		    		res.add(usr.getNickname());
		    	}
		    }
		}
	
		return res;
	}
}
