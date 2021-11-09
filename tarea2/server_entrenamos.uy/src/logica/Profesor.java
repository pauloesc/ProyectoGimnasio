package logica;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class Profesor extends Usuario {
	private String descripcion;
	private String bio;
	private String website;
	private InstitucionDeportiva inst;
	private Set<ActividadDeportiva> actDep = new HashSet<ActividadDeportiva>();
	
	public String getNombreInstitucion() {
		return inst.getNombre();
	}

	public Profesor(InfoBasicaProfesor info) {
		
		super(	info.getNickname(),
				info.getNombre(),
				info.getApellido(),
				info.getCorreo(),
				info.getFechaNac(),
				info.getpass(),
				info.getImagen());
		this.descripcion = info.getDesc();
		this.bio = info.getBibliografia();
		this.website = info.getUrl();
		
		manejIDeportivas manejadorInsDeportivas =  manejIDeportivas.getinstance();
		this.inst = manejadorInsDeportivas.buscarInstitucion(info.getInstitucion());
	}
	
	

	public Profesor(String nickname, String nombre, String apellido, String email, Date fNacimiento, String descripcion,
			String bio, String website, String inst, String contrasena, String img) {
		super(nickname, nombre, apellido, email, fNacimiento, contrasena, img);
		this.descripcion = descripcion;
		this.bio = bio;
		this.website = website;
		manejIDeportivas manejadorInstDeportivas =  manejIDeportivas.getinstance();
		this.inst = manejadorInstDeportivas.buscarInstitucion(inst);
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
	public InfoBasicaUser informacion() {	
		InfoBasicaUser DtInformacion = new InfoBasicaProfesor(
			this.getNickname(),
			this.getNombre(),
			this.getApellido(),
			this.getEmail(),
			this.getFNacimiento(),
			this.getContrasena(),
			this.getImagen(),
			this.getNombreInstitucion(),
			this.getDescripcion(),
			this.getBio(),
			this.getWebsite()
			);
			return DtInformacion;
	}
	
	@Override
	public InformacionActividad informacionActividad(String usuario) {
		return this.inst.informacionProfesor(usuario);
	}
	
	public void asociarseActividadDeportiva( ActividadDeportiva actDep) {
		this.actDep.add(actDep);
	}

	public InfoActividadProfe informacionActDepEstadoIngRech() {
		
		InfoActividadProfe infoRetorno = new InfoActividadProfe(
											this.getNombre(),
											this.getDescripcion(),
											this.getWebsite());
        
		List<DtActividadesDeportivas> ListaDeActividades = new Vector<DtActividadesDeportivas>();
		
		Iterator<ActividadDeportiva> aDepInstancia = actDep.iterator();
        while (aDepInstancia.hasNext()) {
        	
        	ActividadDeportiva actDeportiva = aDepInstancia.next(); 
        	if ( actDeportiva.getEstado() == EstadoActi.RECHAZADA || actDeportiva.getEstado() == EstadoActi.INGRESADA  ) {

        		DtActividadesDeportivas DtAD = actDeportiva.dtActividadesDeportivasSinInfoClases();
        		ListaDeActividades.add(DtAD);
        		
        	}
        	
        }
        infoRetorno.setActividadesDep(ListaDeActividades);
        return infoRetorno;
	}
	
}
