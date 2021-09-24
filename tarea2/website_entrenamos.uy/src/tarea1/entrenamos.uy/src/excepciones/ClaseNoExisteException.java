/**
 * 
 */
package excepciones;


@SuppressWarnings("serial")
public class ClaseNoExisteException extends Exception{
	public ClaseNoExisteException(String string) {
        super(string);
    }
}
