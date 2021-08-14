package logica;

import controladores.ctrlDeportivas;
/**
 * Fábrica para la construcción de un controlador de usuarios (uno distinto para cada invocación).
 * Se implementa en base al patrón Singleton.
 * @author mbarrera
 *
 */
public class Fabrica {

    private static Fabrica instancia;

    private Fabrica() {
    };

    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }

  //  public IctrlUsuario getIControladorUsuario() {
        //return new ctrlUsuario();
 //   }
    public IctrlDeportivas getIctrlDeportivas() {
    	return new ctrlDeportivas();
    }

}
