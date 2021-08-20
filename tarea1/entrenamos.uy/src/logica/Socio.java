package logica;

import java.util.Date;

import datatypes.InfoBasicaProfesor;

public class Socio extends Usuario {

	public Socio(InfoBasicaProfesor info) {
		
		super(	info.getNickname(),
				info.getNombre(),
				info.getApellido(),
				info.getCorreo(),
				new Date() );
	}
	
	public Socio(String nickname, String nombre, String apellido, String email, Date fNacimiento, String descripcion,
			String bio, String website, String inst) {
		super(nickname, nombre, apellido, email, fNacimiento);

	}
	
}
