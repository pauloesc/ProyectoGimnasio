package logica;

import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import datatypes.DtClase;
import datatypes.InfoActividadSocio;
import datatypes.InfoBasicaSocio;
import datatypes.InfoBasicaUser;
import datatypes.InformacionActividad;

public class Socio extends Usuario {

	private Vector<Registro> registros = new Vector<Registro>();
	
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
	
	@Override
	public InformacionActividad InformacionActividad(String usuario) {
		
		InformacionActividad i = new InfoActividadSocio();
		
		Iterator<Registro> regs = registros.iterator();
		
		while(regs.hasNext()){
			
			Registro aux = regs.next();
			DtClase claseInfo = aux.ActividadSocio();
			i.agregarInfo(claseInfo);
			
		}
		return i;
	}
}
