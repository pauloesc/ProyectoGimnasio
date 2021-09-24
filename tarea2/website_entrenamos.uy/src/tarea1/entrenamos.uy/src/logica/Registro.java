/**
 * 
 */
package logica;

import java.util.Date;

public class Registro {
	
	private Date fecha;
	private float costo;
	private Clase clase = null;
	private Compra compra;
	
	public Registro(Clase c, Float pr, Date f) {
		this.fecha = f;
		this.costo = pr;
		this.clase = c;
		this.compra = null;
		
	}
	
	public String getNombreClase() {
		return clase.getNombre();
	}
	
	public void aplicarDescuento(float desc, Clase c) {
		this.clase = c;
		//aplica el descuento al precio total, desc es un porcentaje 
		this.costo = ((100-desc)*this.costo)/100;
	}

	public DtClase ActividadSocio() {
		return this.clase.darDtClase();
	}


}
