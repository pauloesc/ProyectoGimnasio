package logica;

import java.util.Map;

public class ActividadDeportiva {
	private Map<String,Clase> clases;
	
	
	public void addClase(Clase c) {
		clases.put(c.getNombre(),c);
	}
}
