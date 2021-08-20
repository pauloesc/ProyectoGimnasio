package datatypes;
import java.util.Date;


public class InfoBasicaProfesor extends InfoBasicaUser {

	private String desc;
	private String bibliografia;
	private String url;
	
	
	public InfoBasicaProfesor(String nickname, String nombre, String apellido, String correo, Date fechaNac, String des, String bibliografia, String url ) {
		super(nickname, nombre, apellido, correo, fechaNac);
		
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
	
	
	
	
}
