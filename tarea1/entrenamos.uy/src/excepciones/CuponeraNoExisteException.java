package excepciones;

/**
 * Excepción utilizada para indicar la inexistencia de una Cuponera en el sistema.
 * 
 * @author mbarrera
 *
 */
@SuppressWarnings("serial")
public class CuponeraNoExisteException extends Exception {

    public CuponeraNoExisteException(String string) {
        super(string);
    }
}
