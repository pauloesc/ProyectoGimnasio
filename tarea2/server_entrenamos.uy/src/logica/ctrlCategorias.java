/**
 * 
 */
package logica;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import excepciones.CategoriaExistenteException;
import excepciones.ClaseLlenaException;
import excepciones.ClaseNoExisteException;
import excepciones.ClaseRepetidaException;
import excepciones.ClaseYaCompradaException;
import excepciones.CuponeraNoExisteException;

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
	
	
}
