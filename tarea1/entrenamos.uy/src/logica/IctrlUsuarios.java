package logica;
import java.util.Set;
import datatypes.InfoBasicaUser;
import datatypes.InformacionActividad;

//import excepciones.UsuarioNoExisteException;
//import excepciones.UsuarioRepetidoException;

/**
 * @author mbarrera
 *
 */
public interface IctrlUsuarios {
    
	public abstract Set<String> mostrarNombreProfesoresDeInstitucion(String inst);
	
    /**
     * Registra al usuario en el sistema.
     * @param n Nombre del usuario.
     * @param ap Apellido del usuario.
     * @param ci Cédula del usuario.
     * @throws UsuarioRepetidoException Si la cédula del usuario se encuentra registrada en el sistema.
     */
  //  public abstract void registrarUsuario(String n, String ap, String ci) throws UsuarioRepetidoException;

    /**
     * Retorna la información de un usuario con la cédula indicada.
     * @param ci Cédula del usuario.
     * @return Información del usuario.
     * @throws UsuarioNoExisteException Si la cédula del usuario no está registrada en el sistema.
     */
  //  public abstract DataUsuario verInfoUsuario(String ci) throws UsuarioNoExisteException;

    /**
     * Retorna la información de todos los usuarios registrados en el sistema.
     * @return Información de los usuarios del sistema.
     * @throws UsuarioNoExisteException Si no existen usuarios registrados en el sistema.
     */
  //  public abstract DataUsuario[] getUsuarios() throws UsuarioNoExisteException;
	
	//creado por Paulo
	public abstract void altaUsuario(InfoBasicaUser user);
	public abstract Set<String> InstitucionesEnSistema();
	public abstract InformacionActividad InformacionActividad(String usuario);
	public abstract void ActualizarInformacionUsuario(InfoBasicaUser actualizacion);
	public abstract InfoBasicaUser InformacionBasicaUsuario(String usuario);
	public abstract Set<String> UsuariosEnSistemaNickName();
	
	//fincreado
	
}
