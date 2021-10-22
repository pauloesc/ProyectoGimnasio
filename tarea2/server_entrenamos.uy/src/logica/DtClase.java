/**
 * 
 */
package logica;

import java.util.Date;

public class DtClase {
	private Date fecha;
	private String nombre;
	private int minSocios;
	private int actualSocios;
	private int maxSocios;
	private String url;
	private Date fechaReg;
	private String nomProfesor;
	private int hora;
	private int minuto;
	private String nomAct;
	private String imagen;
	
	public DtClase(Date fecha, String nombre, int minSocios, int actualSocios, int maxSocios, String url, Date fechaReg, String nomProfesor, int hor, int min, String nomAct, String img) {
		this.fecha = fecha;
		this.nombre = nombre;
		this.minSocios = minSocios;
		this.actualSocios = actualSocios;
		this.maxSocios = maxSocios;
		this.url = url;
		this.fechaReg = fechaReg;
		this.nomProfesor = nomProfesor;
		this.hora = hor;
		this.minuto = min;
		this.nomAct = nomAct;
		this.imagen = img;
	}


		//getters
	
	public String getNomAct() {
		return nomAct;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public Date getFecha() {
		return fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public int getMinSocios() {
		return minSocios;
	}

	public int getActualSocios() {
		return actualSocios;
	}

	public int getMaxSocios() {
		return maxSocios;
	}

	public String getUrl() {
		return url;
	}

	public Date getFechaReg() {
		return fechaReg;
	}

	public String getNomProfesor() {
		return nomProfesor;
	}
	
	public Integer getHora() {
		return hora;
	}

	public Integer getMinuto() {
		return minuto;
	}

	
	@Override
	public String toString() {
		return this.nombre;
	}
	
	
}
