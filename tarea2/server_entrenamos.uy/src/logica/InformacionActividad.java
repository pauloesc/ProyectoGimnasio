package logica;
import java.util.Vector;

public class InformacionActividad {

	protected Vector<Object> vector= new Vector<Object>();
	
	public void agregarInfo(Object parametroObj) {
		vector.add(parametroObj);
	}
 	
	public Vector<Object> obtenerVector() {
		return this.vector;
	}
}
