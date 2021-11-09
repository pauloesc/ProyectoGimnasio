package logica;
import java.util.List;
import java.util.Vector;

public class InformacionActividad {

	private List<Object> vector = new Vector<Object>();
	
	
	public InformacionActividad() {
	}

	public void agregarInfo(Object parametroObj) {
		vector.add(parametroObj);
	}
 	
	public List<Object> obtenerVector() {
		return this.vector;
	}

	//estos ultimos son los que van
	//los otros deberian de borrarse
	public List<Object> getVector() {
		return vector;
	}

	public void setVector(List<Object> vector) {
		this.vector = vector;
	}
	
	
}
