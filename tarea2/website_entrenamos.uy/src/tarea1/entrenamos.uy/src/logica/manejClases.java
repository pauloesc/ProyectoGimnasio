/**
 * 
 */
package logica;

import java.util.HashMap;
import java.util.Map;

public class manejClases {
	
	private static manejClases instance = null;
	private Map<String,Clase> clases;
	
	private manejClases() {
		clases = new HashMap<String,Clase>();
	}
	
	
	
	public static manejClases getInstance() {
		if (instance == null) {
			instance = new manejClases();
		}
		return instance;
	}
	
	public Clase findClase(String c) {
		return clases.get(c);
	}
	
	public void agregarClase(Clase c) {
		clases.put(c.getNombre(), c);
	}
}
