package logica;

import java.util.Date;

public class DtPremio {
	private String nomC;
	private String nomA;
	private String descripcionPremio;
	private Date fechaClase;
	private Date fecha;
	
	public DtPremio(String nomC, String nomA, String desc, Date f, Date fclase){
		this.nomC = nomC;
		this.nomA = nomA;
		this.fecha = f;
		this.descripcionPremio = desc;
		this.fechaClase = fclase;
	}
	
	public DtPremio() {
	}

	public String getNomC() {
		return nomC;
	}
	public void setNomC(String nomC) {
		this.nomC = nomC;
	}
	public String getNomA() {
		return nomA;
	}
	public void setNomA(String nomA) {
		this.nomA = nomA;
	}
	public Date getFecha() {
		return fecha;
	}
	public Date getFechaClase() {
		return fechaClase;
	}
	public void setFechaClase(Date fec) {
		this.fechaClase = fec;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDescrPremio() {
		return descripcionPremio;
	}
	public void setDescrPremio(String desc) {
		this.descripcionPremio = desc;
	}
	
}
