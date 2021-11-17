package logica;

import java.util.Date;

public class DtPremio {
	private String nomC;
	private String nomA;
	private Date fecha;
	
	public DtPremio(String nomC, String nomA, Date f){
		this.nomC = nomC;
		this.nomA = nomA;
		this.fecha = f;
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
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
}
