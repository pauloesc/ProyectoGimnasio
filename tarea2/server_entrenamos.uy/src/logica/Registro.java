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
	
	public Registro(Clase clase, Float precio, Date fecha) {
		this.fecha = fecha;
		this.costo = precio;
		this.clase = clase;
		this.compra = null;
		
	}
	
	public String getNombreClase() {
		return clase.getNombre();
	}
	
	public void aplicarDescuento(float desc, Clase clase) {
		this.clase = clase;
		//aplica el descuento al precio total, desc es un porcentaje 
		this.costo = ((100-desc)*this.costo)/100;
	}

	public DtClase ActividadSocio() {
		return this.clase.darDtClase();
	}


}
