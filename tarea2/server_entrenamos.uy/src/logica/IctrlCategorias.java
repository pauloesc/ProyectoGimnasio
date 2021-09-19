package logica;

import java.util.Date;
import java.util.Set;

import excepciones.CategoriaExistenteException;
import excepciones.ClaseLlenaException;
import excepciones.ClaseNoExisteException;
import excepciones.ClaseRepetidaException;
import excepciones.ClaseYaCompradaException;


public interface IctrlCategorias {
 
	public abstract void altaCategoria(String nom) throws CategoriaExistenteException;
}
