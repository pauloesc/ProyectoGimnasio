/**
 * 
 */
package manejadores;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import logica.Clase;
import logica.Profesor;
import logica.Usuario;

import datatypes.InfoBasicaUser;
import datatypes.InfoBasicaProfesor;

public class manejUsuarios {

	private static manejUsuarios instance = null;
	private Map<String,Usuario> usuarios;
	
	private manejUsuarios() {
		usuarios = new HashMap<String,Usuario>();
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
	
	public void CrearUsuario(InfoBasicaUser info) {
		
		boolean dispN = DisponibleNickname(info.getNickname());
		boolean dispC = DisponibleCorreo(info.getCorreo());
		
		
		if( info.getClass() == InfoBasicaProfesor.class ) {
			
			
			InfoBasicaProfesor dd = (InfoBasicaProfesor)info;
			Profesor prof = Profesor(dd);
		}
		else {
			userCreado = Socio(info);
		}
		
		this.usuarios.put(userCreado.getNickname(), userCreado)
		
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

		Usuario usr;
		boolean dispC = true;
		
		for (Iterator<Map.Entry<String, Usuario>> entries = usuarios.entrySet().iterator(); entries.hasNext(); ) {
		    Map.Entry<String, Usuario> entry = entries.next();
		    usr = entry.getValue();
		    
		    if ( usr.getEmail().equals(correo) ) {
		    	dispC = false;
		    }
		}
		return dispC;
	}
	
	
	
}
