package logica;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import excepciones.ClaseLlenaException;
import excepciones.ClaseYaCompradaException;

public class Socio extends Usuario {
	private Map<String,Compra> compCup;
	private Set<Registro> regs;
	
	public Socio(InfoBasicaSocio info) {
		
		super(	info.getNickname(),
				info.getNombre(),
				info.getApellido(),
				info.getCorreo(),
				info.getFechaNac() );
		
		compCup = new HashMap<String,Compra>();
		regs = new HashSet<Registro>();
	
	}
		
	public Set<String> mostrarNombreCuponerasDisponibles(String actDept) {
		Set<String> res = new HashSet<String>();
		 Calendar fechaActual = Calendar.getInstance();  
		 Date act = fechaActual.getTime();
		
		for(Compra c: compCup.values()) { 
		   
		    if ((c.clasesDisponibles(actDept) > 0) && (!c.comienzoCuponera().after(act)) && (!c.vencimientoCuponera().before(act))) {
		    	res.add(c.getNombreCuponera());
		    }

		}
		return res;
	}
	
	public void comprarClase(String actDep, Clase c, Float precio, boolean cuponera, String nomCuponera, Date fechaReg) throws ClaseYaCompradaException, ClaseLlenaException {
		
		for( Iterator<Registro> it = regs.iterator(); it.hasNext();) { 
		   if (it.next().getNombreClase() == c.getNombre()) {
			   throw new ClaseYaCompradaException("Clase ya comprada");
		   }
		}
	
		if (c.getActualSocios() >= c.getMaxSocios()) {
			throw new ClaseLlenaException("Clase llena");
		}
	
		Registro r = new Registro(c,precio,fechaReg);
		regs.add(r);
		
		if (cuponera) {
			Compra comp = compCup.get(nomCuponera);
			comp.descontarClase(actDep);
			r.aplicarDescuento(comp.getDescuento(),c);
			
		}
		
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
		for( Iterator<Registro> it = regs.iterator(); it.hasNext();) { 
			Registro aux = it.next();
			DtClase claseInfo = aux.ActividadSocio();
			i.agregarInfo(claseInfo);
		}
		
		return i;
	}
}
