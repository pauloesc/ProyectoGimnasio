package excepciones;

/**
 * Excepción utilizada para indicar la existencia de una institución deportiva repetida en el sistema.
 * 
 * @author mbarrera
 *
 */
@SuppressWarnings("serial")
public class InstitucionDeportivaRepetidaException extends Exception {

    public InstitucionDeportivaRepetidaException(String string) {
        super(string);
    }

}
