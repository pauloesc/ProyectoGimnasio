package logica;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

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
	
	private String descPremios;
	private int cantPremios;
	private boolean sorteados;
	
	public Clase(String nombre, Date Finicio, String prof, int Smin, int Smax, String url, Date FechaAlta, int hor, int minut, String img, String descPremios, int cantPremios) {
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
		
		Set<String> premiados = manejUsuarios.getInstance().darGanadores(this.nombre);
		return new DtClase(this.fechaInicio, this.nombre, this.minSocios, this.actualSocios, this.maxSocios, this.url, this.fechaReg, prof.getNickname(), this.hora, this.min, manejADeportivas.getinstance().getNombreActividadDeClase(nombre), this.imagen, this.descPremios, this.cantPremios, this.sorteados, premiados);
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
	
	public int getCantPremios() {
		return this.cantPremios;
	}
	
	public void setSorteados(boolean s) {
		sorteados = s;
	}
	
	boolean getSorteados() {
		return sorteados;
	}

	
	public boolean esDeProfesor(String usuario) {
		return this.profesor.getNickname().equals(usuario);
	}
}
