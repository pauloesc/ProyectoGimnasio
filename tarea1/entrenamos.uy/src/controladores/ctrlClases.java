/**
 * 
 */
package controladores;


import java.util.Date;
import java.util.Set;

import datatypes.DtClase;
import excepciones.ClaseRepetidaException;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.IctrlClases;
import manejadores.manejClases;
import manejadores.manejDeportivas;

public class ctrlClases implements IctrlClases {
	
	private manejClases manejador;
	
	public ctrlClases() {
		this.manejador = manejClases.getInstance();
	}
	
	public void crearClase(String nombre, Date Finicio, String prof, int Smin, int Smax, String url, Date FechaAlta, String nomAct) throws ClaseRepetidaException {
		Clase c = manejador.findClase(nombre);
		
		if (c != null) {
			throw new ClaseRepetidaException("Nombre existente");
		}
	
		c = new Clase(nombre, Finicio, prof, Smin, Smax, url, FechaAlta);
		
		manejDeportivas MD = manejDeportivas.getinstance();
		ActividadDeportiva ad = MD.buscarActividad(nomAct);
		
		ad.addClase(c);
		manejador.agregarClase(c);
	}
	
	public Set<String> mostrarClasesDeActividadDeportiva(String nomAct) {
		manejDeportivas md = manejDeportivas.getinstance();
		ActividadDeportiva ad = md.buscarActividad(nomAct);
		return ad.darNombreClases();
	}
	
	public DtClase darDtClase(String nomClas) {
		Clase c = manejador.findClase(nomClas);
		return c.darDtClase();
	}
}
