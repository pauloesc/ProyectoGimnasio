package logica;

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
		
		super(	info.getNickname(),
				info.getNombre(),
				info.getApellido(),
				info.getCorreo(),
				info.getFechaNac() );
		this.descripcion = info.getDesc();
		this.bio = info.getBibliografia();
		this.website = info.getUrl();
		
		manejIDeportivas ee =  manejIDeportivas.getinstance();
		this.inst = ee.buscarInstitucion(info.getInstitucion());
	}
	
	

	public Profesor(String nickname, String nombre, String apellido, String email, Date fNacimiento, String descripcion,
			String bio, String website, String inst) {
		super(nickname, nombre, apellido, email, fNacimiento);
		this.descripcion = descripcion;
		this.bio = bio;
		this.website = website;
		manejIDeportivas ee =  manejIDeportivas.getinstance();
		this.inst = ee.buscarInstitucion(inst);
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
	
	
	@Override
	public InfoBasicaUser Informacion() {	
		InfoBasicaUser rt = new InfoBasicaProfesor(
			this.getNickname(),
			this.getNombre(),
			this.getApellido(),
			this.getEmail(),
			this.getFNacimiento(),
			this.getNombreInstitucion(),
			this.getDescripcion(),
			this.getBio(),
			this.getWebsite()
			);
			return rt;
	}
	
	@Override
	public InformacionActividad InformacionActividad(String usuario) {
		return this.inst.InformacionProfesor(usuario);
	}
	
}
