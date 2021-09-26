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
	private String imagen;
	private Map<String, Usuario> seguidos;
	private Map<String, Usuario> seguidores;
	
	
	public String getNickname() {
		return nickname;
	}

	public String getContrasena()
	{
		return contrasena;
	}
	
	public Usuario(String nickname, String nombre, String apellido, String email, Date fNacimiento,
			String contrasena, String imagen) 
	{
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasena = contrasena;
		FNacimiento = fNacimiento;
		this.imagen = imagen;
		seguidos = new HashMap<String, Usuario>();
		seguidores = new HashMap<String, Usuario>();
	}

	public Usuario(InfoBasicaUser info) {
		this.nickname = info.getNickname();
		this.nombre = info.getNombre();
		this.apellido = info.getApellido();
		this.email = info.getCorreo();
		FNacimiento = info.getFechaNac();
		this.imagen = info.getImagen();
		seguidos = new HashMap<String, Usuario>();
		seguidores = new HashMap<String, Usuario>();
	
	}

	
	public String getNombre() {
		return nombre;
	}

	public String getImagen() {
		return imagen;
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
	
	public void teSigo(Usuario u) {
		seguidores.put(u.getNickname(), u);
	}
	
	public void noTeSigo(Usuario u) {
		seguidores.remove(u.getNickname());
	}
	
	public void seguir(Usuario u) {
		seguidos.put(u.getNickname(), u);
		u.teSigo(this);
	}
	
	public void dejarDeSeguir(Usuario u) {
		seguidos.remove(u.getNickname());
		u.noTeSigo(this);
	}
	
	public Vector<String> SeguidoresNickname(){
		Vector<String> vec = new Vector<String>();
		
		Map<String, Usuario> map = seguidores;
				for (Map.Entry<String, Usuario> entry : map.entrySet()) {
					Usuario u = entry.getValue();
					String nick = u.getNickname();
					vec.add(nick);
				}
		return vec;
	}
	
	public Vector<String> SeguidosNickname(){
		Vector<String> vec = new Vector<String>();
		
		Map<String, Usuario> map = seguidos;
				for (Map.Entry<String, Usuario> entry : map.entrySet()) {
					Usuario u = entry.getValue();
					String nick = u.getNickname();
					vec.add(nick);
				}
		return vec;
	}
	
}
