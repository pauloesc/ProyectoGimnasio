package logica;
import java.util.Date;


public class InfoBasicaProfesor extends InfoBasicaUser {

	private String institucion;
	private String desc;
	private String bibliografia;
	private String url;
	
	public InfoBasicaProfesor() {}
	
	public InfoBasicaProfesor(String nickname, String nombre, String apellido, String correo, Date fechaNac, String pass, String img, String institucion, String des, String bibliografia, String url ) {
		super(nickname, nombre, apellido, correo, fechaNac, pass, img);
		
		this.institucion = institucion;
		this.desc = des;
		this.bibliografia = bibliografia;
		this.url = url;
		
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getBibliografia() {
		return bibliografia;
	}


	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getInstitucion() {
		return institucion;
	}


	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}
	
	public boolean sonIguales( InfoBasicaProfesor parametroInfoProfe ) {

		InfoBasicaUser aux = (InfoBasicaUser) parametroInfoProfe;
		
		if ( (parametroInfoProfe.sonIguales(aux))& 
			(this.getInstitucion() == parametroInfoProfe.getInstitucion())&
			(this.getDesc() == parametroInfoProfe.getDesc())&
			(this.getBibliografia() == parametroInfoProfe.getBibliografia())&
			(this.getUrl() == parametroInfoProfe.getUrl())) {
			
			return true;
		}
		else {
			return false;
		}
	} 
		
	@Override
	public String queEs() {
		return "profesor";
	}
	
}
