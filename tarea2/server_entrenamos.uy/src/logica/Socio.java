package logica;

import java.util.ArrayList;
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
		
		if (compCup.size() != 0) {
			for (Compra c: compCup.values()) { 
				
			    if (c.clasesDisponibles(actDept) > 0 && !c.comienzoCuponera().after(act) && !c.vencimientoCuponera().before(act)) {
			    	res.add(c.getNombreCuponera());
			    }
	
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
		
		InfoActividadSocio infoAct = new InfoActividadSocio();
		
		List<DtClase> infoRetornar = new Vector<DtClase>();
		
		for ( Iterator<Registro> it = regs.iterator(); it.hasNext();) { 
			Registro aux = it.next();
			DtClase claseInfo = aux.actividadSocio();
			infoRetornar.add(claseInfo);
		}
		infoAct.setClases(infoRetornar);
		
		return infoAct;
	}
	
	public List<DataCuponera> cuponeras(){
		
		Vector<DataCuponera> vec = new Vector<DataCuponera>();
		
		 Map<String, Compra> map = compCup;
		for (Map.Entry<String, Compra> entry : map.entrySet()) {
			Compra comp = entry.getValue();
			DataCuponera info = comp.darInformacionCuponera();
			vec.add(info);
		}
		return vec;
	}
	
	public boolean tineClase(String nomC) {
		for (Registro r: regs){
			   if (r.getNombreClase().equals(nomC)) {
				   return true;
			   }
			}
		return false;
	}
	
	public void setPremio(String nomC) {
		for (Registro r: regs){ 
			   if (r.getNombreClase().equals(nomC)) {
				   r.setFGanadoPremio();
			   }
			}
	}
	
	public void setPremio(String nomC, Date f) {
		for (Registro r: regs){ 
			   if (r.getNombreClase().equals(nomC)) {
				   r.setFGanadoPremio(f);
			   }
			}
	}
	
	public boolean getPremio(String nomC){
		for (Registro r: regs){ 
			   if (r.getNombreClase().equals(nomC) && r.getfGanadoPremio() != null) {
				  return true;
			   }
			}
		return false;
	}
	
	public List<DtPremio> getMisPremios() {
		List<DtPremio> res = new ArrayList<DtPremio>();
		
		for (Registro r: regs){ 
			   if (r.getfGanadoPremio() != null) {
				   res.add(r.getDtPremio());
			   }
			}
		
		//ordenar la pinche lista por fecha
		
		//pinche implementacion por bubble sort
		int n = res.size();
	       for (int i = 0; i < n-1; i++)
	           for (int j = 0; j < n-i-1; j++)
	               if (res.get(j).getFecha().before(res.get(j+1).getFecha()))	{
	            	   
	                    // swap arr[j+1] and arr[j]
	                    DtPremio temp = res.get(j);
	                    res.set(j,res.get(j+1)); 
	                    res.set(j+1,temp);
	                }
		return res;
	}
}
