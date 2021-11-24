package src.logica;
import java.util.Date;

public class InfoBasicaSocio extends InfoBasicaUser {

	public InfoBasicaSocio() {}
	
	
	public InfoBasicaSocio(String nickname, String nombre, String apellido, String correo, Date fechaNac, String pass, String img) {
		super(nickname, nombre, apellido, correo, fechaNac, pass, img);
	}
	
	@Override
	public String queEs() {
		return "socio";
	}
	
}
