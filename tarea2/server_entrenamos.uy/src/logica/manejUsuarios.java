/**
 * 
 */
package logica;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import excepciones.UsuarioDisponibilidadException;

import java.util.Vector;


public class manejUsuarios {

	private static manejUsuarios instance = null;
	private Map<String, Usuario> usuarios;
	private Map<String, Usuario> usuariosEmail;
	
	private manejUsuarios() {
		usuarios = new HashMap<String, Usuario>();
		usuariosEmail = new HashMap<String, Usuario>();
	}
	
	
	
	public static manejUsuarios getInstance() {
		if (instance == null) {
			instance = new manejUsuarios();
		}
		return instance;
	}
	
	public Profesor darProfesor(String nom) {
		return (Profesor) usuarios.get(nom);
	}
	
	public Set<String> mostrarNombreProfesoresDeInstitucion(String inst) {
		Set<String> res = new HashSet<String>();
		Usuario usr;
		
		for (Iterator<Map.Entry<String, Usuario>> entries = usuarios.entrySet().iterator(); entries.hasNext(); ) {
		    Map.Entry<String, Usuario> entry = entries.next();
		    usr = entry.getValue();
		    
		    if (usr.getClass() == Profesor.class) {
		    	Profesor profe = (Profesor) usr;
		    	if (profe.getNombreInstitucion() == inst) {
		    		res.add(usr.getNickname());
		    	}
		    }
		}
	
		return res;
	}
	
	public void crearUsuario(InfoBasicaUser info) throws UsuarioDisponibilidadException {
		
		boolean dispN = disponibleNickname(info.getNickname());
		boolean dispC = disponibleCorreo(info.getCorreo());
		
		if ( !dispC ) {			
			throw new UsuarioDisponibilidadException("No esta disponible el correo: " + info.getCorreo() );
		}
		if ( !dispN ) {			
			throw new UsuarioDisponibilidadException("No esta disponible el nickname: " + info.getNickname());
		}
		
		
		Usuario userCreado = null;
		
		if ( info.getClass() == InfoBasicaProfesor.class ) {
			
			userCreado = new Profesor( (InfoBasicaProfesor) info );
		}
		else {
			userCreado = new Socio( (InfoBasicaSocio) info );
		}
		
		this.usuarios.put(userCreado.getNickname(), userCreado);
		this.usuariosEmail.put(userCreado.getEmail(), userCreado);
		
	}
	
	
	public boolean disponibleNickname(String nickname) {
		Usuario user = this.usuarios.get(nickname);
		if (user == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean disponibleCorreo(String correo) {
		Usuario user = this.usuariosEmail.get(correo);
		if (user == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public List<String> usuariosNickName(){
		
		Set<String> vec= new HashSet<>();
		
		Iterator<Map.Entry<String, Usuario>> usr = this.usuarios.entrySet().iterator();
		
		while (usr.hasNext()){
			Map.Entry<String, Usuario> entry = usr.next();
			Usuario user = entry.getValue();
			
			vec.add(user.getNickname());
		}
		
		return vec;
		
	}
	
	public Usuario findUsuario(String nick) {
		return usuarios.get(nick);
	}
	
	public Usuario findUsuarioPorEmail(String email) {
		return usuariosEmail.get(email);
	}
	
	public InfoBasicaUser informacionBasicaUsuario(String usuario) {
		
		Usuario user = this.usuarios.get(usuario);
		return  user.informacion();
	}
	
	public InformacionActividad informacionActividad(String usuario) {
		Usuario user = this.usuarios.get(usuario);
		return  user.informacionActividad(usuario);
	}
	
	public Set<String> mostrarNicknameSocios() {
		Set<String> res = new HashSet<String>();
		for (Usuario u : usuarios.values()) {	
			if (u.getClass() == Socio.class) {
				res.add(u.getNickname());
			}
    	} 
		return res;
	}
	
	public void elimiarManjeador() {
		manejUsuarios.instance=null;
		usuarios.clear();
	}
	
	public void actualizarInformacionUsuario(InfoBasicaUser actualizacion){
		
		Usuario usuario = findUsuario( actualizacion.getNickname() );
		
		usuario.setNombre(actualizacion.getNombre());
		usuario.setApellido(actualizacion.getApellido());
		usuario.setEmail(actualizacion.getCorreo());
		usuario.setFNacimiento(actualizacion.getFechaNac());
	
		
		if ( actualizacion.getClass() == InfoBasicaProfesor.class ) {
		
			if ( usuario.getClass() == Profesor.class ) {
				
				InfoBasicaProfesor aux_actualizacion = (InfoBasicaProfesor) actualizacion;
				
				Profesor auxP = (Profesor) usuario;
				auxP.setBio(aux_actualizacion.getBibliografia());
				auxP.setDescripcion(aux_actualizacion.getDesc());
				auxP.setWebsite(aux_actualizacion.getUrl());
				
			}
			
		}
		
	}
	
}
