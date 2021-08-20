package manejadores;

import java.util.Date;
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

	public boolean exiteCuponera(String nombre) {
	
		return (Cuponeras.get(nombre)!=null);
	}

	public void agregarCuponera(String nom, String des, Date ini, Date fin, Float disc, Date alta) {
		Cuponera cupo; 
		cupo= new Cuponera(nom, des, ini,fin, disc, alta);
		Cuponeras.put(nom, cupo);
	}
}
