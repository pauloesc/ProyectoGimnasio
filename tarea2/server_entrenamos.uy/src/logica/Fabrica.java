package logica;

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
    
    public IctrlADeportivas getIctrlADeportivas() {
    	return (IctrlADeportivas) new ctrlADeportivas();
    }

    public IctrlIDeportivas getIctrlIDeportivas() {
    	return (IctrlIDeportivas) new ctrlIDeportivas();
    }
    
    public IctrlCuponeras getIctrlCuponeras() {
    	return new ctrlCuponeras();
    } 
    
    public IctrlClases getIctrlClases() {
    	return (IctrlClases) new ctrlClases();
    }
}
