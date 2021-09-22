/**
 * 
 */
package logica;

import java.util.HashMap;
import java.util.Map;

public class manejCategorias {
	
	private static manejCategorias instance = null;
	
	private Map<String,Categoria> categorias;
	
	private manejCategorias() {
		categorias = new HashMap<String,Categoria>();
	}
	
	public static manejCategorias getInstance() {
		if (instance == null) {
			instance = new manejCategorias();
		}
		return instance;
	}
	
	public void agregarCategoria(String nom) {
		Categoria c = new Categoria(nom);
		categorias.put(nom, c);
	}
	
	public Categoria findCategoria(String nom) {
		return categorias.get(nom);
	}
}
