package logica;
import java.util.Vector;

public class InformacionActividad {

	protected Vector<Object> vector= new Vector<Object>();
	
	public void agregarInfo(Object o) {
		vector.add(o);
	}
 	
	public Vector<Object> obtenerVector() {
		return this.vector;
	}
}
