package logica;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class InformacionActividad {

	protected Set<Object> vector= new HashSet<Object>();
	
	public void agregarInfo(Object parametroObj) {
		vector.add(parametroObj);
	}
 	
	public Set<Object> obtenerVector() {
		return this.vector;
	}
}
