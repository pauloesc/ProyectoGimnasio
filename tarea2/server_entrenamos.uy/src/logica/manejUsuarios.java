/**
 * 
 */
package logica;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import excepciones.UsuarioDisponibilidadException;

import java.util.Vector;


public class manejUsuarios {

	private static manejUsuarios instance = null;
	private Map<String,Usuario> usuarios;
	private Map<String,Usuario> usuariosEmail;
	
	private manejUsuarios() {
		usuarios = new HashMap<String,Usuario>();
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
		    	Profesor p = (Profesor) usr;
		    	if (p.getNombreInstitucion() == inst) {
		    		res.add(usr.getNickname());
		    	}
		    }
		}
	
		return res;
	}
	
	public void CrearUsuario(InfoBasicaUser info, String contrasena) throws UsuarioDisponibilidadException {
		
		boolean dispN = DisponibleNickname(info.getNickname());
		boolean dispC = DisponibleCorreo(info.getCorreo());
		
		if ( !dispC ) {			
			throw new UsuarioDisponibilidadException("No esta disponible el correo: " + info.getCorreo() );
		}
		if ( !dispN ) {			
			throw new UsuarioDisponibilidadException("No esta disponible el nickname: " + info.getNickname());
		}
		
		
		Usuario userCreado = null;
		
		if( info.getClass() == InfoBasicaProfesor.class ) {
			
			userCreado = new Profesor( (InfoBasicaProfesor)info, contrasena );
		}
		else {
			userCreado = new Socio( (InfoBasicaSocio)info, contrasena );
		}
		
		this.usuarios.put(userCreado.getNickname(), userCreado);
		this.usuariosEmail.put(userCreado.getEmail(), userCreado);
		
	}
	
	
	public boolean DisponibleNickname(String nickname) {
		Usuario e = this.usuarios.get(nickname);
		if(e == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean DisponibleCorreo(String correo) {
		Usuario e = this.usuariosEmail.get(correo);
		if(e == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public Vector<String> usuariosNickName(){
		
		Vector<String> vec= new Vector<>();
		
		Iterator<Map.Entry<String,Usuario>> usr = this.usuarios.entrySet().iterator();
		
		while(usr.hasNext()){
			Map.Entry<String, Usuario> entry = usr.next();
			Usuario u = entry.getValue();
			
			vec.add(u.getNickname());
		}
		
		return vec;
		
	}
	
	public Usuario findUsuario(String nick) {
		return usuarios.get(nick);
	}
	
	public Usuario findUsuarioPorEmail(String email) {
		return usuariosEmail.get(email);
	}
	
	public InfoBasicaUser InformacionBasicaUsuario(String usuario) {
		
		Usuario e = this.usuarios.get(usuario);
		return  e.Informacion();
	}
	
	public InformacionActividad InformacionActividad(String usuario) {
		Usuario e = this.usuarios.get(usuario);
		return  e.InformacionActividad(usuario);
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
	
	public void ElimiarManjeador() {
		manejUsuarios.instance=null;
		usuarios.clear();
	}
	
	public void ActualizarInformacionUsuario(InfoBasicaUser actualizacion){
		
		Usuario u = findUsuario( actualizacion.getNickname() );
		
		u.setNombre(actualizacion.getNombre());
		u.setApellido(actualizacion.getApellido());
		u.setEmail(actualizacion.getCorreo());
		u.setFNacimiento(actualizacion.getFechaNac());
	
		
		if ( actualizacion.getClass() == InfoBasicaProfesor.class ) {
		
			if( u.getClass() == Profesor.class ) {
				
				InfoBasicaProfesor aux_actualizacion = (InfoBasicaProfesor)actualizacion;
				
				Profesor auxP = (Profesor)u;
				auxP.setBio(aux_actualizacion.getBibliografia());
				auxP.setDescripcion(aux_actualizacion.getDesc());
				auxP.setWebsite(aux_actualizacion.getUrl());
				
			}
			
		}
		
	}
}
