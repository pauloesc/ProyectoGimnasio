package logica;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Vector;

public class InformacionActividad {

	protected List<Object> vector= new Vector<Object>();
	
	public void agregarInfo(Object parametroObj) {
		vector.add(parametroObj);
	}
 	
	public List<Object> obtenerVector() {
		return this.vector;
	}
}
