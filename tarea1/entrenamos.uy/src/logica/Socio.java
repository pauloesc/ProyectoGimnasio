package logica;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import datatypes.InfoBasicaSocio;

public class Socio extends Usuario {
	private Set<Compra> compCup;
	private Set<Registro> regs;

	public Socio(InfoBasicaSocio info) {
		
		super(	info.getNickname(),
				info.getNombre(),
				info.getApellido(),
				info.getCorreo(),
				new Date() );
		
		compCup = new HashSet<Compra>();
		regs = new HashSet<Registro>();
	
	}
		
	public Socio(String nickname, String nombre, String apellido, String email, Date fNacimiento, String descripcion,
			String bio, String website, String inst) {
		super(nickname, nombre, apellido, email, fNacimiento);
		
		compCup = new HashSet<Compra>();
		regs = new HashSet<Registro>();

	}
	
	public Set<String> mostrarNombreCuponerasDisponibles(String actDept) {
		Set<String> res = new HashSet<String>();
		
		for( Iterator<Compra> it = compCup.iterator(); it.hasNext();) { 
		    Compra c = it.next();
		   // falta chequear que la cuponera esté vigente
		    if (c.clasesDisponibles(actDept) > 0) {
		    	res.add(c.getNombreCuponera());
		    }

		}
		return res;
	}
	
}
