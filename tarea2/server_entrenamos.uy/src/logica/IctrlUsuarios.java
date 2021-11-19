package logica;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.jws.WebMethod;

import excepciones.UsuarioDisponibilidadException;
import excepciones.UsuarioInexistenteException;

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
	public abstract void altaUsuario(InfoBasicaUser user) throws UsuarioDisponibilidadException;
	public abstract List<String> institucionesEnSistema();
	public abstract InformacionActividad informacionActividad(String usuario);
	public abstract void actualizarInformacionUsuario(InfoBasicaUser actualizacion);
	public abstract InfoBasicaUser informacionBasicaUsuario(String usuario);
	public abstract List<String> usuariosEnSistemaNickName();
	//fincreado
	
	public abstract void seguirUsuario(String seguidor, String seguido);
	public abstract void dejarDeSeguirUsuario(String seguidor, String seguido);
	
	public abstract Set<String> mostrarCuponerasDisponibles(String nick, String actDept);
	public abstract Set<String> mostrarNicknameSocios();
	
	public abstract String autenticarUsario(String nickname, String email, String contrasena);
	public abstract String autenticarUsarioMovil(String nickname, String email, String contrasena);
	public abstract String getNicknameUsuario(String email);

	
	public abstract void cargarUsuarios();
	
	public abstract List<String> usuariosSiguiendo(String nickname);
	public abstract List<String> usuariosSeguidores(String nickname);
	public abstract InfoActividadProfe informacionActDepEstadoIngRech(String nickname);
	
	//retorna true si el usuario es un socio, si es un profesor retorna false, si no existe retorna una excepcion
	public abstract boolean esSocio(String nick) throws UsuarioInexistenteException;
	
	public abstract List<DataCuponera> cuponeras(String nickname);
	
	public abstract boolean usuarioSigueAUsuario(String usuario1, String suario2);
	
	public abstract List<String> getGanadoresDeClase(String nomC);
	
	public abstract List<DtPremio> getPremiosDeUsuario(String nomU);
	
    public abstract InfoActividadProfe todasLasActividadesDeUnProfesor(String usuario);
  
    public abstract List<InfoBasicaSocio> darParticipantes(String nomC);
    
}
