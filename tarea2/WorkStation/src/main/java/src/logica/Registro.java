/**
 * 
 */
package src.logica;

import java.util.Calendar;
import java.util.Date;

public class Registro {
	
	private Date fecha;
	private float costo;
	private Clase clase = null;
	private Compra compra;
	private Date fGanadoPremio;
	
	public Registro(Clase clase, Float precio, Date fecha) {
		this.fecha = fecha;
		this.costo = precio;
		this.clase = clase;
		this.compra = null;
		this.fGanadoPremio = null;
		
	}
	
	public String getNombreClase() {
		return clase.getNombre();
	}
	
	public void aplicarDescuento(float desc, Clase clase) {
		this.clase = clase;
		//aplica el descuento al precio total, desc es un porcentaje 
		this.costo = ((100-desc)*this.costo)/100;
	}

	public DtClase actividadSocio() {
		return this.clase.darDtClase();
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public Compra getCompra() {
		return compra;
	}
	
	public Date getfGanadoPremio() {
		return fGanadoPremio;
	}

	public void setFGanadoPremio() {
		// registra el premio con la fecha actual del sistema
		Calendar fechaActual = Calendar.getInstance();  
		this.fGanadoPremio = fechaActual.getTime();
	}
	
	public void setFGanadoPremio(Date f) {  
		this.fGanadoPremio = f;
	}

	public DtPremio getDtPremio() {
		return new DtPremio(clase.getNombre(),manejADeportivas.getinstance().getNombreActividadDeClase(clase.getNombre()),clase.getDescPremios(),fGanadoPremio, clase.getFechaInicio());
	}

}
