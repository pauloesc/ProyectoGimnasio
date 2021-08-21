package logica;

import java.util.Date;

import excepciones.CuponeraRepetidaException;



public interface IctrlCuponeras {
	
	public abstract boolean registrarCuponera(String nombre, String descrip, Date fecha_ini, Date fecha_fin, Float descuento, Date fecha_alta) throws CuponeraRepetidaException;
}
