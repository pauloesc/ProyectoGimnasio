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
	private String urlVideo;
	private Profesor profesor;
	private String imagen;
	private String descPremios;
	private int cantPremios;
	private boolean sorteados;
	
	public Clase(String nombre, Date Finicio, String prof, int Smin, int Smax, String url, String urlVideo, Date FechaAlta, int hor, int minut, String img, String descPremios, int cantPremios) {
		manejUsuarios mUsr = manejUsuarios.getInstance();
		Profesor profe = mUsr.darProfesor(prof);
		this.profesor = profe;
		
		this.nombre = nombre;
		this.fechaInicio = Finicio;
		this.minSocios = Smin;
		this.actualSocios = 0;
		this.maxSocios = Smax;
		this.url = url;
		this.urlVideo = urlVideo;
		this.fechaReg = FechaAlta;
		this.hora = hor;
		this.min = minut;
		this.imagen = img;
		this.descPremios = descPremios;
		this.cantPremios = cantPremios;
		this.sorteados= false;
	}

	public String getNombre() {	
		return nombre;
	}
	
	
	public void sumarMiembroAClase() {
		actualSocios++;
	}
	
	public DtClase darDtClase() {
		Usuario prof = (Usuario) this.profesor;
		manejADeportivas ma = manejADeportivas.getinstance();
		return new DtClase(this.fechaInicio, this.nombre, this.minSocios, this.actualSocios, this.maxSocios, this.url, this.urlVideo, this.fechaReg, prof.getNickname(), this.hora, this.min, ma.getNombreActividadDeClase(nombre), this.imagen, this.descPremios, this.cantPremios, this.sorteados, ma.getEstado(ma.getNombreActividadDeClase(nombre)));
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

	public boolean isSorteados() {
		return sorteados;
	}

	public void setSorteados(boolean sorteados) {
		this.sorteados = sorteados;
	}

	public int getCantPremios() {
		return cantPremios;
	}
	
	public String getDescPremios() {
		return descPremios;
	}
}
