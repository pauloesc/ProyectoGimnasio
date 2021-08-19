package manejadores;

import java.util.HashMap;
import java.util.Map;
import logica.Cuponera;

public class manejCuponeras {
	private Map<String, Cuponera> Cuponeras;
	
    private static manejCuponeras instancia = null;

    private manejCuponeras() {
        Cuponeras = new HashMap<String, Cuponera>();
    }
    
    public static manejCuponeras getinstance() {
        if (instancia == null)
            instancia = new manejCuponeras();
        return instancia;
    }
}
