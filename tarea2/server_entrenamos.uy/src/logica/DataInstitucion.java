package logica;

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
        this.setURL(new String());
    }

    public DataInstitucion(String nombre, String descripcion, String url) {
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setURL(url);
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

    /* Sirve para mostrar textualmente el nombre de la Institución Deportiva, por ejemplo en un ComboBox
     */
    public String toString() {
        return getNombre();
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private void setURL(String url) {
        this.url = url;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (o == this) 
            return true;
        
        if (!(o instanceof DataInstitucion)) {
            return false;
        }
        
        DataInstitucion dataInst = (DataInstitucion)o;
        if (nombre == dataInst.getNombre() && descripcion == dataInst.getDescripcion() && url == dataInst.getURL())
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