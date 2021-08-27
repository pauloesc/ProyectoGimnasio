package logica;

import java.util.Date;

public abstract class Usuario {
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private Date FNacimiento;
	
	
	public String getNickname() {
		return nickname;
	}


	public Usuario(String nickname, String nombre, String apellido, String email, Date fNacimiento) {
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		FNacimiento = fNacimiento;
	}

	public Usuario(InfoBasicaUser info) {
		this.nickname = info.getNickname();
		this.nombre = info.getNombre();
		this.apellido = info.getApellido();
		this.email = info.getCorreo();
		FNacimiento = info.getFechaNac();
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getFNacimiento() {
		return FNacimiento;
	}


	public void setFNacimiento(Date fNacimiento) {
		FNacimiento = fNacimiento;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	public abstract InfoBasicaUser Informacion();
	
	public abstract InformacionActividad InformacionActividad(String usuario);
	
}
