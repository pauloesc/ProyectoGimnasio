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
	private String urlVideo;
	private Date fechaReg;
	private String nomProfesor;
	private int hora;
	private int minuto;
	private String nomAct;
	private String imagen;
	private String descPremios;
	private int cantPremios;
	private boolean sorteados;
	
	private EstadoActi estadoActividad;
	
	public DtClase() {}
	
	public DtClase(Date fecha, String nombre, int minSocios, int actualSocios, int maxSocios, String url, String urlvideo, Date fechaReg, String nomProfesor, int hor, int min, String nomAct, String img, String descPremios, int cantPremios, boolean sorteados, EstadoActi estadoActividad) {
		this.fecha = fecha;
		this.nombre = nombre;
		this.minSocios = minSocios;
		this.actualSocios = actualSocios;
		this.maxSocios = maxSocios;
		this.url = url;
		this.urlVideo = urlvideo;
		this.fechaReg = fechaReg;
		this.nomProfesor = nomProfesor;
		this.hora = hor;
		this.minuto = min;
		this.nomAct = nomAct;
		this.imagen = img;
		this.descPremios = descPremios;
		this.cantPremios=cantPremios;
		this.sorteados=sorteados;
		this.estadoActividad = estadoActividad;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMinSocios() {
		return minSocios;
	}

	public void setMinSocios(int minSocios) {
		this.minSocios = minSocios;
	}

	public int getActualSocios() {
		return actualSocios;
	}

	public void setActualSocios(int actualSocios) {
		this.actualSocios = actualSocios;
	}

	public int getMaxSocios() {
		return maxSocios;
	}

	public void setMaxSocios(int maxSocios) {
		this.maxSocios = maxSocios;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public String getNomProfesor() {
		return nomProfesor;
	}

	public void setNomProfesor(String nomProfesor) {
		this.nomProfesor = nomProfesor;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public String getNomAct() {
		return nomAct;
	}

	public void setNomAct(String nomAct) {
		this.nomAct = nomAct;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDescPremios() {
		return descPremios;
	}

	public void setDescPremios(String descPremios) {
		this.descPremios = descPremios;
	}

	public int getCantPremios() {
		return cantPremios;
	}

	public void setCantPremios(int cantPremios) {
		this.cantPremios = cantPremios;
	}

	public boolean isSorteados() {
		return sorteados;
	}

	public void setSorteados(boolean sorteados) {
		this.sorteados = sorteados;
	}

	public EstadoActi getEstadoActividad() {
		return estadoActividad;
	}

	public void setEstadoActividad(EstadoActi estadoActividad) {
		this.estadoActividad = estadoActividad;
	}

	public String getUrlVideo() {
		return urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}
	
}
