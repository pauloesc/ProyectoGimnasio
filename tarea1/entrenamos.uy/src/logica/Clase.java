package logica;

import java.util.Calendar;
import java.util.Date;

import datatypes.DtClase;
import manejadores.manejUsuarios;

public class Clase {
	private Date fechaInicio;
	private String nombre;
	private int minSocios;
	private int actualSocios;
	private int maxSocios;
	private Date fechaReg;
	private String url;
	private Profesor profesor;
	
	public Clase(String nombre, Date Finicio, String prof, int Smin, int Smax, String url, Date FechaAlta) {
		manejUsuarios m = manejUsuarios.getInstance();
		Profesor p = m.darProfesor(prof);
		this.profesor = p;
		
		this.nombre = nombre;
		this.fechaInicio = Finicio;
		this.minSocios = Smin;
		this.actualSocios = 0;
		this.maxSocios = Smax;
		this.url = url;
		this.fechaReg = FechaAlta;
	}

	public String getNombre() {	
		return nombre;
	}
	
	
	public void sumarMiembroAClase() {
		actualSocios++;
	}
	
	public DtClase darDtClase() {
		Usuario prof = (Usuario)this.profesor;
		return new DtClase(this.fechaInicio, this.nombre, this.minSocios, this.actualSocios, this.maxSocios, this.url, this.fechaReg, prof.getNickname());
	}
	
	public boolean esVigente() {
		// fecha actual
		Calendar fechaActual = Calendar.getInstance();  
		Date act = fechaActual.getTime();
		 
		return ((!act.after(fechaInicio)));
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public int getActualSocios() {
		return actualSocios;
	}

	public int getMaxSocios() {
		return maxSocios;
	}

	
	public boolean EsDeProfesor(String usuario) {
		return (usuario == this.profesor.getNickname());
	}
}
