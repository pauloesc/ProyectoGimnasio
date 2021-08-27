package logica;
import java.util.Iterator;


public class InfoActividadSocio extends InformacionActividad {
	
	public InfoActividadSocio() {}
	
	
	public void imp() {
		
		Iterator<Object> ff = this.vector.iterator();
		
		while(ff.hasNext()) {
		
			DtClase uu = (DtClase) ff.next();
			
			uu.imp();	
		}	
	}
}
