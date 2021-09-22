/**
 * 
 */
package logica;


import java.util.Set;

import excepciones.CategoriaExistenteException;

public class ctrlCategorias implements IctrlCategorias {
	
	private manejCategorias manejador;
	
	public ctrlCategorias() {
		this.manejador = manejCategorias.getInstance();
	}
	
	public void altaCategoria(String nom) throws CategoriaExistenteException {
		if (manejador.findCategoria(nom) != null) {
			throw new CategoriaExistenteException("Nombre existente");
		} else {
			manejador.agregarCategoria(nom);
		}
	}
	
	public Set<String> getCategorias() {
		Set<String> categorias = manejador.getCategorias();
		return categorias;
	}
	
	public void cargarCategorias() {
		try {
			altaCategoria("Al aire libre");
			altaCategoria("Deportes");
			altaCategoria("Fitness");
			altaCategoria("Gimnasia");
		} catch (CategoriaExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	
	
}
