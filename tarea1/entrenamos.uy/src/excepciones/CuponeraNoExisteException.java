package excepciones;

/**
 * Excepción utilizada para indicar la inexistencia de una cuponera en el sistema.
 
 */
@SuppressWarnings("serial")
public class CuponeraNoExisteException extends Exception {

    public CuponeraNoExisteException(String string) {
        super(string);
    }
}
