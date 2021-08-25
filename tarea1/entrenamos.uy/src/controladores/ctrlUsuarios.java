/**
 * 
 */
package controladores;

import java.util.Set;

import datatypes.InfoBasicaUser;
import datatypes.InformacionActividad;
import logica.IctrlUsuarios;
import manejadores.manejUsuarios;

import java.util.Vector;

import manejadores.manejADeportivas;
import manejadores.manejIDeportivas;

import java.util.Iterator;

import excepciones.UsuarioDisponibilidadException;

public class ctrlUsuarios implements IctrlUsuarios {
	
	private manejUsuarios manejador;
	
	public ctrlUsuarios() {
		this.manejador = manejUsuarios.getInstance();
	}
	
	public Set<String> mostrarNombreProfesoresDeInstitucion(String inst) {
		return this.manejador.mostrarNombreProfesoresDeInstitucion(inst);
	}

	//paulo
	public void altaUsuario(InfoBasicaUser user) throws UsuarioDisponibilidadException {
		
		//cuando se crea el controlador ya ahi se trae el manejador  
		try{
			this.manejador.CrearUsuario(user);
		}catch(UsuarioDisponibilidadException e){
			throw e;
		}
		
	}
	

	public Vector<String> InstitucionesEnSistema() {
		
		manejIDeportivas mID = manejIDeportivas.getinstance();
		Set<String> set;
		set = mID.darNombreInstituciones();
		Iterator<String> iterate_value = set.iterator();
		
		Vector<String> vector = new Vector<String>();
		
		while(iterate_value.hasNext()){
			
			String e = iterate_value.next().toString();
			vector.add(e);
		}
		
		return vector;
		
	}
	
	public InformacionActividad InformacionActividad(String usuario) {
		
		InformacionActividad IA = null;
		return IA;
		
	}
	
	public void ActualizarInformacionUsuario(InfoBasicaUser actualizacion){
		
	}
	
	public InfoBasicaUser InformacionBasicaUsuario(String usuario) {
		
		InfoBasicaUser IBU = null;
		return IBU;
		
	}
	
	public Vector<String> UsuariosEnSistemaNickName(){
		
		return this.manejador.usuariosNickName();
		
	}
	
	//paulo
	
}
