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
	
	public DtClase() {}
	
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


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setMinSocios(int minSocios) {
		this.minSocios = minSocios;
	}


	public void setActualSocios(int actualSocios) {
		this.actualSocios = actualSocios;
	}


	public void setMaxSocios(int maxSocios) {
		this.maxSocios = maxSocios;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}


	public void setNomProfesor(String nomProfesor) {
		this.nomProfesor = nomProfesor;
	}


	public void setHora(int hora) {
		this.hora = hora;
	}


	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}


	public void setNomAct(String nomAct) {
		this.nomAct = nomAct;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	//estos son los que van
	//estos son los que van
	
	//estos son los que van
	//estos son los que van
	
	
	
}
