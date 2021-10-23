package logica;


public class InfoActividadSocio extends InformacionActividad {
	
	public InfoActividadSocio() {}
	
	
	public boolean sonIguales( InfoBasicaSocio inf ) {

		InfoBasicaUser aux = (InfoBasicaUser) inf;
		
		if ( inf.sonIguales(aux)) {
			return true;
		}
		else {
			return false;
		}
	} 
	
}
