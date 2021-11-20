package src.logica;
import java.util.Date;
public abstract class InfoBasicaUser {

	private String nickname;
	private String nombre;
	private String apellido;
	private String correo;
	private Date fechaNac;
	private String pass;
	private String img;

	public InfoBasicaUser() {}
	
	public InfoBasicaUser(String nickname, String nombre, String apellido, String correo, Date fechaNac, String pass, String img) {
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaNac = fechaNac;
		this.pass = pass;
		this.img = img;
	}

	
	public String getpass() {
		return pass;
	}
	
	public String getImagen() {
		return img;
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
    
	
	
	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public boolean sonIguales( InfoBasicaUser parametroInfoUser ) {
		
		if (
		(this.apellido == parametroInfoUser.getApellido())&
		(this.correo == parametroInfoUser.getCorreo())&
		(this.fechaNac == parametroInfoUser.getFechaNac())&
		(this.nickname == parametroInfoUser.getNickname())&
		(this.nombre == parametroInfoUser.getNombre())){
			return true;
		}
		
		else {
			return false;
			}
	}
	
	public abstract String queEs();
    
}
