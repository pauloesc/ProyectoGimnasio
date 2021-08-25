package logica;

import datatypes.InfoBasicaProfesor;
import datatypes.InfoBasicaUser;
import java.util.Date;

import manejadores.manejADeportivas;
import manejadores.manejIDeportivas;

public class Profesor extends Usuario {
	private String descripcion;
	private String bio;
	private String website;
	private InstitucionDeportiva inst;
	
	public String getNombreInstitucion() {
		return inst.getNombre();
	}

	public Profesor(InfoBasicaProfesor info) {
		
		super(	info.getNickname(),
				info.getNombre(),
				info.getApellido(),
				info.getCorreo(),
				new Date() );
		this.descripcion = info.getDesc();
		this.bio = info.getBibliografia();
		this.website = info.getUrl();
		this.asociarInstitucion(info.getInstitucion());
	}
	
	

	public Profesor(String nickname, String nombre, String apellido, String email, Date fNacimiento, String descripcion,
			String bio, String website, String inst) {
		super(nickname, nombre, apellido, email, fNacimiento);
		this.descripcion = descripcion;
		this.bio = bio;
		this.website = website;
		asociarInstitucion(inst);
	}

	public void asociarInstitucion(String nomInst) {
		
		manejIDeportivas mID = manejIDeportivas.getinstance();
		this.inst = mID.buscarInstitucion(nomInst);
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public InstitucionDeportiva getInst() {
		return inst;
	}

	public void setInst(InstitucionDeportiva inst) {
		this.inst = inst;
	}
	
	
	
	
	
}
