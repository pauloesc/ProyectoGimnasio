/**
 * 
 */
package logica;

import java.util.HashMap;
import java.util.Map;

public class manejCategorias {
	
	private static manejCategorias instance = null;
	private Map<String,categoria> categorias;
	
	private manejCategorias() {
		categorias = new HashMap<String,categoria>();
	}
	
	
	
	public static manejCategorias getInstance() {
		if (instance == null) {
			instance = new manejCategorias();
		}
		return instance;
	}
	
	public void agregarCategoria(String nom) {
		categoria c = new categoria(nom);
		categorias.put(nom, c);
	}
	
	public categoria findCategoria(String nom) {
		return categorias.get(nom);
	}
}
