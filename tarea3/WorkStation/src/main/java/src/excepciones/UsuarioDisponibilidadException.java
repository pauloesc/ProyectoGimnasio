package src.excepciones;

/**
 * Excepción utilizada para indicar la inexistencia de una Actividad Deportiva en el sistema.
 * 
 * @author mbarrera
 *
 */
@SuppressWarnings("serial")
public class UsuarioDisponibilidadException extends Exception {

    public UsuarioDisponibilidadException(String string) {
        super(string);
    }
}
