/**
 * 
 */
package logica;


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
	
	public void cargarCategorias() {
		manejador.agregarCategoria("Al aire libre");
		manejador.agregarCategoria("Deportes");
		manejador.agregarCategoria("Fitness");
		manejador.agregarCategoria("Gimnasia");
	}
	
	
}
