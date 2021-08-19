package excepciones;

/**
 * Excepción utilizada para indicar la inexistencia de una Institucion Deportiva en el sistema.
 * 
 * @author mbarrera
 *
 */
@SuppressWarnings("serial")
public class InstitucionDeportivaNoExisteException extends Exception {

    public InstitucionDeportivaNoExisteException(String string) {
        super(string);
    }
}
