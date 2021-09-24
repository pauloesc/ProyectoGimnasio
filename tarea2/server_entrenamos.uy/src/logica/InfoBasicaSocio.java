package logica;
import java.util.Date;

public class InfoBasicaSocio extends InfoBasicaUser {

	public InfoBasicaSocio(String nickname, String nombre, String apellido, String correo, Date fechaNac, String pass) {
		super(nickname, nombre, apellido, correo, fechaNac, pass);
	}
	
}
