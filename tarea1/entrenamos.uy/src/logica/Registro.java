package logica;

import datatypes.DtClase;

public class Registro {

	private Clase clase = null;
	
	public Registro() {
		
	}

	public DtClase ActividadSocio() {
		return this.clase.darDtClase();
	}
		
}
