package logica;

import java.util.List;

public class InfoActividadSocio extends InformacionActividad {
	
	private List<DtClase> clases = null;
	
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


	public List<DtClase> getClases() {
		return clases;
	}


	public void setClases(List<DtClase> clases) {
		this.clases = clases;
	} 
	
}
