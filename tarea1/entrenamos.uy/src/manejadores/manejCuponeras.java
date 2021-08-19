package manejadores;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import logica.InstitucionDeportiva;
import logica.ActividadDeportiva;
import logica.Cuponera;

public class manejCuponeras {
	private Map<String, Cuponera> Cuponeras;
	
    private static manejCuponeras instancia = null;

    private manejCuponeras() {
        institucionesDeportivas = new HashMap<String, InstitucionDeportiva>();
    }
    
    public static manejDeportivas getinstance() {
        if (instancia == null)
            instancia = new manejDeportivas();
        return instancia;
    }
}
