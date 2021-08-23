package logica;

import java.util.Date;
import java.util.Set;

import datatypes.DataCuponera;
import excepciones.ActividadDeportivaNoExisteException;
import excepciones.CuponeraNoExisteException;
import excepciones.CuponeraRepetidaException;



public interface IctrlCuponeras {
	
	public abstract boolean registrarCuponera(String nombre, String descrip, Date fecha_ini, Date fecha_fin, Float descuento, Date fecha_alta) throws CuponeraRepetidaException;
	public abstract Set<String> listarCuponeras() throws CuponeraNoExisteException;
	
	public abstract Set<String> listarActividadesfaltantes(String nomcup, String nominst)throws ActividadDeportivaNoExisteException;
	
	public abstract void agregarActividad(String nomcup,String act,int numclase) ;

	public abstract DataCuponera mostrarCuponera (String nomCup); 

}
