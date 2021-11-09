package logica;

import java.util.Calendar;
import java.util.Date;

public class Clase {
	private Date fechaInicio;
	private String nombre;
	private int minSocios;
	private int actualSocios;
	private int maxSocios;
	private int hora;
	private int min;
	private Date fechaReg;
	private String url;
	private Profesor profesor;
	private String imagen;
	
	public Clase(String nombre, Date Finicio, String prof, int Smin, int Smax, String url, Date FechaAlta, int hor, int minut, String img) {
		manejUsuarios mUsr = manejUsuarios.getInstance();
		Profesor profe = mUsr.darProfesor(prof);
		this.profesor = profe;
		
		this.nombre = nombre;
		this.fechaInicio = Finicio;
		this.minSocios = Smin;
		this.actualSocios = 0;
		this.maxSocios = Smax;
		this.url = url;
		this.fechaReg = FechaAlta;
		this.hora = hor;
		this.min = minut;
		this.imagen = img;
	}

	public String getNombre() {	
		return nombre;
	}
	
	
	public void sumarMiembroAClase() {
		actualSocios++;
	}
	
	public DtClase darDtClase() {
		Usuario prof = (Usuario) this.profesor;
		return new DtClase(this.fechaInicio, this.nombre, this.minSocios, this.actualSocios, this.maxSocios, this.url, this.fechaReg, prof.getNickname(), this.hora, this.min, manejADeportivas.getinstance().getNombreActividadDeClase(nombre), this.imagen);
	}
	
	public boolean esVigente() {
		// fecha actual
		Calendar fechaActual = Calendar.getInstance();  
		Date act = fechaActual.getTime();
		 
		return !act.after(fechaInicio);
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

	
	public boolean esDeProfesor(String usuario) {
		return this.profesor.getNickname().equals(usuario);
	}
}
