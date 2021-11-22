package src.logica;

/**
 * Datatype para transportar la información de una Institucion Deportiva entre capa lógica y de presentación.
 * En Java los datatypes se definen con setters y getters, y se denominan JavaBean.
 * @author mbarrera
 *
 */
public class DataInstitucion {

    private String nombre;
	private String descripcion;
    private String url;

    public DataInstitucion() {
        this.setNombre(new String());
        this.setDescripcion(new String());
        this.setUrl(new String());
    }

    public DataInstitucion(String nombre, String descripcion, String url) {
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setUrl(url);
    }

    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

    /* Sirve para mostrar textualmente el nombre de la Institución Deportiva, por ejemplo en un ComboBox
     */
    public String toString() {
        return getNombre();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) 
            return true;
        
        if (!(obj instanceof DataInstitucion)) {
            return false;
        }
        
        DataInstitucion dataInst = (DataInstitucion) obj;
        if (nombre == dataInst.getNombre() && descripcion == dataInst.getDescripcion() && url == dataInst.getUrl())
        	return true;
        else
        	return false;
    }
    
    @Override
    public int hashCode() {
        int res = 17;
        res = 31 * res + nombre.hashCode();
        res = 31 * res + descripcion.hashCode();
        res = 31 * res + url.hashCode();
        return res;
    }
}