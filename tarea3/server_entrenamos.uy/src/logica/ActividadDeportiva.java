package logica;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import logica.manejADeportivas;
/**
 * Actividad Deportiva en con nombre, descripcion, duracion, costo, fecha_alta.

 * @author mbarrera
 */

public class ActividadDeportiva {

	private Map<String, Clase> clases;
	private String nombre;
	private String descripcion;
	private Float duracion;
	private Float costo;
	private Date fechaAlta;
	private Profesor creador;
	private Map<String, Categoria> categorias;
	private EstadoActi estado = null;
	private String imagen;
    
    public ActividadDeportiva(String nombre, Profesor profe, String descrip, Float dur, Float cost, Date fechaAlta, Map<String, Categoria> cats, String imag) {
    	this.setNombre(nombre);
    	this.setCreador(profe);
        this.setDescripcion(descrip);
        this.setDuracion(dur);
        this.setCosto(cost);
        this.setFechaAlta(fechaAlta);
        this.clases = new HashMap<String, Clase>();
        this.categorias = cats;
        this.estado = EstadoActi.INGRESADA;
        this.imagen = imag;
    }

    public void addClase(Clase clase) {
    	clases.put(clase.getNombre(), clase);
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
        return fechaAlta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setDuracion(Float duracion) {
        this.duracion = duracion;
    }

    public void setCosto(Float cost) {
        this.costo = cost;
    }
    
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public DtActividadesDeportivas informacionProfesor(String usuario) {
    	
    	DtActividadesDeportivas info = new DtActividadesDeportivas( this.nombre, this.descripcion, this.duracion, this.costo, this.fechaAlta );
    	
    	Iterator<Map.Entry<String, Clase>> iter =  this.clases.entrySet().iterator();
    	
    	while (iter.hasNext()) {
    	    Map.Entry<String, Clase> datos = iter.next();
    	    
    	    Clase clase = datos.getValue();
    	    
    	    if (clase.esDeProfesor(usuario)) {
    	    	info.agregarDtClase(clase.darDtClase());
    	    }
    	    
    	}
    	return info;
    }
    
    public Set<String> darCategorias() {
    	return categorias.keySet();
    }
    
    public void setCategorias(Set<String> cats) {
    	manejCategorias manCategorias = manejCategorias.getInstance();
    	
    	for (Iterator<String> it = cats.iterator(); it.hasNext();) { 
    		Categoria cat = manCategorias.findCategoria(it.next());
    		categorias.put(cat.getNombre(), cat);	
		}
    }
    
    public void setEstado(EstadoActi est) {
    	this.estado = est;
    }
    
    public EstadoActi getEstado() {
    	return estado;
    }
    
    public DtActividadesDeportivas dtActividadesDeportivasSinInfoClases() {
    	DtActividadesDeportivas info = new DtActividadesDeportivas( this.nombre, this.descripcion, this.duracion, this.costo, this.fechaAlta );
    	info.setEstado(this.estado);
    	return info;
    }
    
    public Profesor getCreador() {
    	return creador;
    }
    
    public void setCreador(Profesor profe) {
    	this.creador = profe;
    }
    
    public String getImagen() {
    	return imagen;
    }
    
    public void setImagen(String uri) {
    	this.imagen = uri;
    }
}
