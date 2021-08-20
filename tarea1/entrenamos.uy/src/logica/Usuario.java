package logica;

import java.util.Date;

public class Usuario {
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
	
}
