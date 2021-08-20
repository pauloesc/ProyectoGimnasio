
package controladores;

import java.util.Date;

import excepciones.CuponeraRepetidaException;
import logica.IctrlCuponeras;
import manejadores.manejCuponeras;


public class ctrlCuponeras implements IctrlCuponeras {
	
	public ctrlCuponeras() {
	 }
	
	public boolean registrarCuponera(String nombre, String descrip, Date fecha_ini, Date fecha_fin, Float descuento, Date fecha_alta) throws CuponeraRepetidaException {
		manejCuponeras mC = manejCuponeras.getinstance();
        boolean registrada = mC.exiteCuponera(nombre);
        if (registrada)
            throw new CuponeraRepetidaException("La cuponera " + nombre + " ya esta registrada.");

        mC.agregarCuponera(nombre, descrip, fecha_ini, fecha_fin, descuento, fecha_alta);
        return false;
	}

	
}
