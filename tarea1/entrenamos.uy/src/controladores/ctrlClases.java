/**
 * 
 */
package controladores;


import java.util.Date;

import excepciones.ClaseRepetidaException;
import logica.ActividadDeportiva;
import logica.Clase;
import manejadores.manejClases;
import manejadores.manejDeportivas;

public class ctrlClases {
	
	private manejClases manejador;
	
	public ctrlClases() {
		this.manejador = manejClases.getInstance();
	}
	
	public void crearClase(String nombre, Date Finicio, String prof, int Smin, int Smax, String url, Date FechaAlta, String nomAct) throws ClaseRepetidaException {
		Clase c = manejador.findClase(nombre);
		
		if (c == null) {
			throw new ClaseRepetidaException("Nombre existente");
		}
	
		c = new Clase(nombre, Finicio, prof, Smin, Smax, url, FechaAlta);
		
		manejDeportivas MD = manejDeportivas.getinstance();
		ActividadDeportiva ad = MD.buscarActividad(nomAct);
		
		ad.addClase(c);
	}
}
