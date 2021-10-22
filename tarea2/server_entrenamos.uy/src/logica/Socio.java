package logica;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import excepciones.ClaseLlenaException;
import excepciones.ClaseYaCompradaException;

public class Socio extends Usuario {
	private Map<String, Compra> compCup;
	private Set<Registro> regs;
	
	public Socio(InfoBasicaSocio info) {
		
		super(	info.getNickname(),
				info.getNombre(),
				info.getApellido(),
				info.getCorreo(),
				info.getFechaNac(),
				info.getpass(),
				info.getImagen());	
		
		compCup = new HashMap<String, Compra>();
		regs = new HashSet<Registro>();
	
	}
		
	public Set<String> mostrarNombreCuponerasDisponibles(String actDept) {
		Set<String> res = new HashSet<String>();
		 Calendar fechaActual = Calendar.getInstance();  
		 Date act = fechaActual.getTime();
		
		for (Compra c: compCup.values()) { 
		   
		    if (c.clasesDisponibles(actDept) > 0 && !c.comienzoCuponera().after(act) && !c.vencimientoCuponera().before(act)) {
		    	res.add(c.getNombreCuponera());
		    }

		}
		return res;
	}
	
	public void comprarClase(String actDep, Clase clase, Float precio, boolean cuponera, String nomCuponera, Date fechaReg) throws ClaseYaCompradaException, ClaseLlenaException {
		
		for ( Iterator<Registro> it = regs.iterator(); it.hasNext();){ 
		   if (it.next().getNombreClase() == clase.getNombre()) {
			   throw new ClaseYaCompradaException("Clase ya comprada");
		   }
		}
	
		if (clase.getActualSocios() >= clase.getMaxSocios()) {
			throw new ClaseLlenaException("Clase llena");
		}
	
		Registro registro = new Registro(clase, precio, fechaReg);
		regs.add(registro);
		
		if (cuponera) {
			Compra comp = compCup.get(nomCuponera);
			comp.descontarClase(actDep);
			registro.aplicarDescuento(comp.getDescuento(), clase);
			
		}
		
	}
	
	public boolean tieneCuponera(String nombre) {
		Set<String> claves = compCup.keySet();
		return claves.contains(nombre);
	}
	
	public Compra darCompra(String nombre) {
		return compCup.get(nombre);
	}
	
	public void comprarCuponera(Date fecha, Cuponera cup, Set<String> act) {
		Compra   nueva= new Compra(fecha, cup, act);
		this.compCup.put(cup.getNombre(), nueva);
	}
	
	
	
	
	@Override
	public InfoBasicaUser informacion() {	
		InfoBasicaUser DtInfoBasicUser = new InfoBasicaSocio(
			this.getNickname(),
			this.getNombre(),
			this.getApellido(),
			this.getEmail(),
			this.getFNacimiento(),
			this.getContrasena(),
			this.getImagen()
			);
			return DtInfoBasicUser;
	}
	
	@Override
	public InformacionActividad informacionActividad(String usuario) {
		
		InformacionActividad infoAct = new InfoActividadSocio();		
		for ( Iterator<Registro> it = regs.iterator(); it.hasNext();) { 
			Registro aux = it.next();
			DtClase claseInfo = aux.ActividadSocio();
			infoAct.agregarInfo(claseInfo);
		}
		
		return infoAct;
	}
	
	public List<DataCuponera> cuponeras(){
		
		Vector<DataCuponera> vec = new Vector<DataCuponera>();
		
		 Map<String, Compra> map = compCup;
		for (Map.Entry<String, Compra> entry : map.entrySet()) {
			Compra comp = entry.getValue();
			DataCuponera info = comp.DarInformacionCuponera();
			vec.add(info);
		}
		return vec;
	}
}
