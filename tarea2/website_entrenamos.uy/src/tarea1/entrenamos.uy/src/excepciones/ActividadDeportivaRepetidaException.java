package excepciones;

/**
 * Excepción utilizada para indicar la existencia de una actividad deportiva repetida en el sistema.
 * 
 * @author mbarrera
 *
 */
@SuppressWarnings("serial")
public class ActividadDeportivaRepetidaException extends Exception {

    public ActividadDeportivaRepetidaException(String string) {
        super(string);
    }

}
