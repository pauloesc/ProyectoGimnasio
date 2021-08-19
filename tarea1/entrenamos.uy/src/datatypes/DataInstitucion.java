package datatypes;

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

}
