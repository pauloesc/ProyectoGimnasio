/**
 * 
 */
package manejadores;

import java.util.HashMap;
import java.util.Map;

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
}
