package logica;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Representa a una Actividad Deportiva en el sistema con nombre, descripcion, duracion, costo, fecha_alta.
 * @author mbarrera
 */

public class ActividadDeportiva {
	private Map<String,Clase> clases;

    private String nombre;
    private String descripcion;
    private Float duracion;
    private Float costo;
    private Date fecha_alta;
    

    public ActividadDeportiva(String n, String de, Float dur, Float cost, Date fa) {
    	this.setNombre(n);
        this.setDescripcion(de);
        this.setDuracion(dur);
        this.setCosto(cost);
        this.setFechaAlta(fa);
        this.clases = new HashMap<String,Clase>();
        
        
    }

    public void addClase(Clase c) {
	clases.put(c.getNombre(),c);
    }

    public Set<String> darNombreClases() {
    	return clases.keySet();
    }
    
    public Set<String> darNombreClasesVigentes(){
    	
    	Set<String> res = new HashSet<String>();
    	
    	if (!clases.isEmpty()) {
	    	for (Clase c : clases.values()) {	

	    		if (c.esVigente()) {
	    			res.add(c.getNombre());
	    		}
	    	}
    	}
    	
    	return res;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Float getDuracion() {
        return duracion;
    }
    
    public Float getCosto() {
        return costo;
    }
    
    public Date getFechaAlta() {
        return fecha_alta;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public void setDescripcion(String de) {
        this.descripcion = de;
    }
    
    public void setDuracion(Float dur) {
        this.duracion = dur;
    }

    public void setCosto(Float cost) {
        this.costo = cost;
    }
    
    public void setFechaAlta(Date fa) {
        this.fecha_alta = fa;
    }

    public DtActividadesDeportivas InformacionProfesor(String usuario) {
    	
    	DtActividadesDeportivas i = new DtActividadesDeportivas( this.nombre, this.descripcion, this.duracion, this.costo, this.fecha_alta );
    	
    	Iterator<Map.Entry<String,Clase>> Iter =  this.clases.entrySet().iterator();
    	
    	while (Iter.hasNext()) {
    	    Map.Entry<String, Clase> datos = Iter.next();
    	    
    	    Clase c = datos.getValue();
    	    
    	    if (c.EsDeProfesor(usuario)) {
    	    	i.agregarDtClase(c.darDtClase());
    	    }
    	    
    	}
    	return i;
    }
    
}
