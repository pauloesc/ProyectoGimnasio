package logica;

import java.util.Date;

import datatypes.InfoBasicaSocio;
import datatypes.InfoBasicaUser;

public class Socio extends Usuario {

	public Socio(InfoBasicaSocio info) {
		
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
	
	@Override
	public InfoBasicaUser Informacion() {	
		InfoBasicaUser rt = new InfoBasicaSocio(
			this.getNickname(),
			this.getNombre(),
			this.getApellido(),
			this.getEmail(),
			this.getFNacimiento()
			);
			return rt;
	}
	
}
