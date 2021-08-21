package logica;

import controladores.ctrlCuponeras;
import controladores.ctrlClases;
import controladores.ctrlDeportivas;
import controladores.ctrlUsuarios;
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

    public IctrlUsuarios getIctrlUsuarios() {
        return (IctrlUsuarios) new ctrlUsuarios();
    }
    
    public IctrlDeportivas getIctrlDeportivas() {
    	return (IctrlDeportivas) new ctrlDeportivas();
    }

    public IctrlCuponeras getIctrlCuponeras() {
    	return new ctrlCuponeras();
    } 
    
    public IctrlClases getIctrlClases() {
    	return (IctrlClases) new ctrlClases();
    }
}
