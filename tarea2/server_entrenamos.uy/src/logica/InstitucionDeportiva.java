package logica;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Representa a una Institucion Deportiva en el sistema con nombre, descripcion y url.
 * @author mbarrera
 */

public class InstitucionDeportiva {

    private String nombre;
    private String descripcion;
    private String url;
    private Set<ActividadDeportiva> actividadesDeportivasInst;

    public InstitucionDeportiva(String nomb, String desc, String url) {
        this.setNombre(nomb);
        this.setDescripcion(desc);
        this.setURL(url);
        this.actividadesDeportivasInst = new HashSet<ActividadDeportiva>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getURL() {
        return url;
    }

    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public void setDescripcion(String des) {
        this.descripcion = des;
    }

    public void setURL(String url) {
        this.url = url;
    }
    
    public void addActividadDeportiva(ActividadDeportiva act) {
        this.actividadesDeportivasInst.add(act);
    }

	public ActividadDeportiva[] getActividades() {
		if (actividadesDeportivasInst.isEmpty())
            return null;
        else {
            Object[] obj = actividadesDeportivasInst.toArray();
            ActividadDeportiva[] actividadesdeportivas = new ActividadDeportiva[obj.length];
            for (int i = 0; i < obj.length; i++) {
                actividadesdeportivas[i] = (ActividadDeportiva) obj[i];
            }

            return actividadesdeportivas;
        }
    }

	public Set<String> darNombresActividadesDeportivas() {
		Set<String> res = new HashSet<String>();    	
		for ( Iterator<ActividadDeportiva> iter = this.actividadesDeportivasInst.iterator(); iter.hasNext();) { 
		    String nomact = (String) iter.next().getNombre();
		    res.add(nomact);
		}
		return res;
    }
	
	public InformacionActividad informacionProfesor(String usuario) {
		
		InformacionActividad infoac = new InfoActividadProfe( this.nombre, this.descripcion, this.url );
	
		Iterator<ActividadDeportiva> info = this.actividadesDeportivasInst.iterator();
	
		while (info.hasNext()) {
			
			ActividadDeportiva aux = info.next();
			DtActividadesDeportivas aux_ad = aux.informacionProfesor(usuario);
			
			//si la actividad deportiva tiene clases adentro...
			if ( ! (aux_ad.getClases().isEmpty()) ) {
				infoac.agregarInfo(aux_ad);				
			}
			
		}
				
		return infoac;		
	}
	
}
