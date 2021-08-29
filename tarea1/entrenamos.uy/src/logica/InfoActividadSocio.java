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
	
	public boolean SonIguales( InfoBasicaSocio i ) {

		InfoBasicaUser aux = (InfoBasicaUser)i;
		
		if( (i.SonIguales(aux))) {
			return true;
		}
		else {
			return false;
		}
	} 
	
}
