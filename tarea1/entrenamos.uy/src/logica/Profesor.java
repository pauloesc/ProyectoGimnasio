package logica;

import datatypes.InfoBasicaProfesor;
import java.util.Date;

public class Profesor extends Usuario {
	private String descripcion;
	private String bio;
	private String website;
	private InstitucionDeportiva inst;
	
	public String getNombreInstitucion() {
		return inst.getNombre();
	}

	public Profesor(InfoBasicaProfesor info) {
		
		Date temporal  = new Date();
		super(	info.getNickname(),
				info.getNombre(),
				info.getApellido(),
				info.getCorreo(),
				temporal );
		this.descripcion = info.getDesc();
		this.bio = info.getBibliografia();
		this.website = info.getUrl();
	}
	
	
	
}
