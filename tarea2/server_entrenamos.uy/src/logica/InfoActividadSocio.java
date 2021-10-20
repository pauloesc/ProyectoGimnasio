package logica;


public class InfoActividadSocio extends InformacionActividad {
	
	public InfoActividadSocio() {}
	
	
	public boolean SonIguales( InfoBasicaSocio inf ) {

		InfoBasicaUser aux = (InfoBasicaUser)inf;
		
		if( (inf.SonIguales(aux))) {
			return true;
		}
		else {
			return false;
		}
	} 
	
}
