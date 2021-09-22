package logica;


public class InfoActividadSocio extends InformacionActividad {
	
	public InfoActividadSocio() {}
	
	
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
