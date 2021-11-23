package excepciones;

/**
 * Excepción utilizada para indicar la inexistencia de una Cuponera en el sistema.
 * 
 * @author mbarrera
 *
 */
@SuppressWarnings("serial")
public class CuponeraRepetidaException extends Exception {

    public CuponeraRepetidaException(String string) {
        super(string);
    }
}
