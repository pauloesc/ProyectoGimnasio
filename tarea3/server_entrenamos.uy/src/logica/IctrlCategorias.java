package logica;

import java.util.Set;

import excepciones.CategoriaExistenteException;


public interface IctrlCategorias {
 
	public abstract void altaCategoria(String nom) throws CategoriaExistenteException;
	public abstract void cargarCategorias();
	public abstract Set<String> getCategorias();
}
