package logica;

import java.util.Date;
import java.util.Set;

import excepciones.ClaseLlenaException;
import excepciones.ClaseNoExisteException;
import excepciones.ClaseRepetidaException;
import excepciones.ClaseYaCompradaException;

//import excepciones.UsuarioNoExisteException;
//import excepciones.UsuarioRepetidoException;

/**
 * @author mbarrera
 *
 */
public interface IctrlClases {
 
	public abstract void crearClase(String nombre, Date Finicio, String prof, int Smin, int Smax, String url, Date FechaAlta, String nomAct, Integer ho, Integer mi) throws ClaseRepetidaException;
	
	public abstract Set<String> mostrarClasesDeActividadDeportiva(String nomAct) throws ClaseNoExisteException;
	
	public abstract DtClase darDtClase(String nomClas);
	
	public void registrarSocioAClase(String nick, String actDep, String clas, boolean cuponera, String nomCuponera, Date fechaReg) throws ClaseYaCompradaException, ClaseLlenaException;

	public abstract void cargarDatosClases();
	public abstract void cargarRegistroAClases();
}
