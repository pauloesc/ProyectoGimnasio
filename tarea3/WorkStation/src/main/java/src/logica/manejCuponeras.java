package src.logica;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class manejCuponeras {
	private Map<String, Cuponera> cuponeras;
	
    private static manejCuponeras instancia = null;

    private manejCuponeras() {
        cuponeras = new HashMap<String, Cuponera>();
    }
    
    public static manejCuponeras getinstance() {
        if (instancia == null)
            instancia = new manejCuponeras();
        return instancia;
    }

	public boolean exiteCuponera(String nombre) {
	
		return cuponeras.get(nombre)!=null;
	}

	public void agregarCuponera(String nom, String des, Date ini, Date fin, Float disc, Date alta, String imagen) {
		Cuponera cupo; 
		cupo = new Cuponera(nom, des, ini, fin, disc, alta, imagen);
		cuponeras.put(nom, cupo);
	}
	
	public Set<String> listarcuponeras(){
		return this.cuponeras.keySet();
	}
	
	
	public Set<String> listarcuponeraslibres(){
		Set<String> resu= new HashSet<String>();
		for (Iterator<String> iter=cuponeras.keySet().iterator(); iter.hasNext();) {
			Cuponera cup=cuponeras.get(iter.next());
			if (!cup.isComprada()) {
			    resu.add(cup.getNombre());
			}
		}
		return resu;
	}
	
	
	
	
	
	public Cuponera getCuponera(String nombre) {
	    return this.cuponeras.get(nombre);	
	}

	
	public DataCuponera mostrarCuponera(String nomCup) {
		Cuponera cup=cuponeras.get(nomCup);
		return cup.getDataCuponera();
		
	}
	
	public Set<Cuponera> getCuponerasDeActividad(String actividad){
		Set<Cuponera> resu= new HashSet<Cuponera>();
		for (Iterator<String> iter=cuponeras.keySet().iterator(); iter.hasNext();) {
			Cuponera cup=cuponeras.get(iter.next());
			Set<String> list=cup.getListaActividades();
			if (list.contains(actividad)) {
			    resu.add(cup);
			}
		}
		
		return resu;
	}
	
	public Set<String> getCuponerasAD(String actividad){
		Set<String> resu= new HashSet<String>();
		for (Iterator<String> iter=cuponeras.keySet().iterator(); iter.hasNext();) {
			Cuponera cup=cuponeras.get(iter.next());
			Set<String> list=cup.getListaActividades();
			if (list.contains(actividad)) {
			    resu.add(cup.getNombre());
			}
		}
		
		return resu;
	}
	
	
	
	public Set<String> getCuponerasdeCategoria(String categoria){
		Set<String> resu= new HashSet<String>();
		for (Iterator<String> iter=cuponeras.keySet().iterator(); iter.hasNext();) {
			Cuponera cup=cuponeras.get(iter.next());
			Set<String> list=cup.getListaCategorias();		
			if (list.contains(categoria)) {
			    resu.add(cup.getNombre());
			}
		}
		return resu;
	}
	
	
	public void eliminarManjeador() {
		instancia.cuponeras.clear();
		instancia=null;
	}
	
	public Set<Cuponera> buscarCuponeras(String consulta) {
		if (consulta != null) {
			Set<Cuponera> resultado = new HashSet<Cuponera>();
			for ( Cuponera cup : cuponeras.values() ) {
				if ( cup.getNombre().toLowerCase().contains(consulta) ||
						cup.getDescripcion().toLowerCase().contains(consulta) ) {
					resultado.add(cup);
				}
			}
			return resultado;
			
		} else {
			// Devolver todas las cuponeras
			Set<Cuponera> res = new HashSet<Cuponera>();
			for ( Cuponera cup : cuponeras.values() ) {
				res.add( cup );
			}
			return res;
		}
	}
}
