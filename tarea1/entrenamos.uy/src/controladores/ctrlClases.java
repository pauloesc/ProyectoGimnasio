/**
 * 
 */
package controladores;


import java.util.Date;
import java.util.Set;

import datatypes.DtClase;
import excepciones.ClaseLlenaException;
import excepciones.ClaseRepetidaException;
import excepciones.ClaseYaCompradaException;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.IctrlClases;
import logica.Socio;
import manejadores.manejClases;
import manejadores.manejUsuarios;
import manejadores.manejADeportivas;

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
		
		manejADeportivas MD = manejADeportivas.getinstance();
		ActividadDeportiva ad = MD.buscarActividad(nomAct);
		
		ad.addClase(c);
		manejador.agregarClase(c);
	}
	
	public Set<String> mostrarClasesDeActividadDeportiva(String nomAct) {
		manejADeportivas md = manejADeportivas.getinstance();
		ActividadDeportiva ad = md.buscarActividad(nomAct);
		return ad.darNombreClases();
	}
	
	public DtClase darDtClase(String nomClas) {
		Clase c = manejador.findClase(nomClas);
		return c.darDtClase();
	}
	
	public void registrarSocioAClase(String nick, String actDep, String clas, boolean cuponera, String nomCuponera, Date fechaReg) throws ClaseYaCompradaException, ClaseLlenaException {
		manejUsuarios  mu = manejUsuarios.getInstance();
		manejClases mc = manejClases.getInstance();
		manejADeportivas mad = manejADeportivas.getinstance();
		
		Socio usr = (Socio)mu.findUsuario(nick);
		Clase c = mc.findClase(clas);
		float precio = mad.getPrecio(actDep);
		
		usr.comprarClase(actDep, c, precio, cuponera, nomCuponera, fechaReg);
		c.sumarMiembroAClase();

	}
}
