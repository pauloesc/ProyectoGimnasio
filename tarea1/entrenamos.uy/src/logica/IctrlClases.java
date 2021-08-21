package logica;

import java.util.Date;
import java.util.Set;

import datatypes.DtClase;
import excepciones.ClaseRepetidaException;

//import excepciones.UsuarioNoExisteException;
//import excepciones.UsuarioRepetidoException;

/**
 * @author mbarrera
 *
 */
public interface IctrlClases {
 
	public abstract void crearClase(String nombre, Date Finicio, String prof, int Smin, int Smax, String url, Date FechaAlta, String nomAct) throws ClaseRepetidaException;
	
	public abstract Set<String> mostrarClasesDeActividadDeportiva(String nomAct);
	
	public abstract DtClase darDtClase(String nomClas);
}
