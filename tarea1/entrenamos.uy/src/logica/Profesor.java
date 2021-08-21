package logica;

public class Profesor extends Usuario {
	private String descripcion;
	private String bio;
	private String website;
	private InstitucionDeportiva inst;
	
	public String getNombreInstitucion() {
		return inst.getNombre();
	}
}
