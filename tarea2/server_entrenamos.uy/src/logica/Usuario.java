package logica;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public abstract class Usuario {
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private String contrasena;
	private Date FNacimiento;
	private Vector<String> imagenes;
	private Map<String, Usuario> seguidos;
	
	
	public String getNickname() {
		return nickname;
	}

	public String getContrasena()
	{
		return contrasena;
	}
	
	public Usuario(String nickname, String nombre, String apellido, String email, Date fNacimiento,
			String contrasena) 
	{
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasena = contrasena;
		FNacimiento = fNacimiento;
		imagenes = new Vector<String>();
		seguidos = new HashMap<String, Usuario>();
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
	
	public void setContrasena(String contrasena)
	{
		this.contrasena = contrasena;
	}
	
	
	public abstract InfoBasicaUser Informacion();
	
	public abstract InformacionActividad InformacionActividad(String usuario);
	
	public void seguir(Usuario u) {
		seguidos.put(u.getNombre(), u);
	}
	
	public void dejarDeSeguir(Usuario u) {
		seguidos.remove(u.getNombre());
	}
	
}
