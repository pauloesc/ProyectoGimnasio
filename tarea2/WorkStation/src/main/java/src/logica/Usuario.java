package src.logica;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class Usuario {
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private String contrasena;
	private Date fechaNacimiento;
	private String imagen;
	private Map<String, Usuario> seguidos;
	private Map<String, Usuario> seguidores;
	
	
	public String getNickname() {
		return nickname;
	}

	public String getContrasena(){
		return contrasena;
	}
	
	public Usuario(String nickname, String nombre, String apellido, String email, Date fNacimiento,
			String contrasena, String imagen){
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasena = contrasena;
		fechaNacimiento = fNacimiento;
		this.imagen = imagen;
		seguidos = new HashMap<String, Usuario>();
		seguidores = new HashMap<String, Usuario>();
	}

	public Usuario(InfoBasicaUser info) {
		this.nickname = info.getNickname();
		this.nombre = info.getNombre();
		this.apellido = info.getApellido();
		this.email = info.getCorreo();
		fechaNacimiento = info.getFechaNac();
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
		return fechaNacimiento;
	}


	public void setFNacimiento(Date fNacimiento) {
		fechaNacimiento = fNacimiento;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public void setContrasena(String contrasena){
		this.contrasena = contrasena;
	}
	
	
	public abstract InfoBasicaUser informacion();
	
	public abstract InformacionActividad informacionActividad(String usuario);
	
	public void teSigo(Usuario usuario) {
		seguidores.put(usuario.getNickname(), usuario);
	}
	
	public void noTeSigo(Usuario usuario) {
		seguidores.remove(usuario.getNickname());
	}
	
	public void seguir(Usuario usuario) {
		seguidos.put(usuario.getNickname(), usuario);
		usuario.teSigo(this);
	}
	
	public void dejarDeSeguir(Usuario usuario) {
		seguidos.remove(usuario.getNickname());
		usuario.noTeSigo(this);
	}
	
	public List<String> seguidoresNickname(){
		Vector<String> vec = new Vector<String>();
		
		Map<String, Usuario> map = seguidores;
				for (Map.Entry<String, Usuario> entry : map.entrySet()) {
					Usuario usuario = entry.getValue();
					String nick = usuario.getNickname();
					vec.add(nick);
				}
		return vec;
	}
	
	public List<String> seguidosNickname(){
		Vector<String> vec = new Vector<String>();
		
		Map<String, Usuario> map = seguidos;
				for (Map.Entry<String, Usuario> entry : map.entrySet()) {
					Usuario usuario = entry.getValue();
					String nick = usuario.getNickname();
					vec.add(nick);
				}
		return vec;
	}
	
}
