package excepciones;

/**
 * Excepción utilizada para indicar la inexistencia de una Actividad Deportiva.
 * 
 * @author mbarrera
 *
 */
@SuppressWarnings("serial")
public class ActividadDeportivaNoExisteException extends Exception {

    public ActividadDeportivaNoExisteException(String string) {
        super(string);
    }
 }
