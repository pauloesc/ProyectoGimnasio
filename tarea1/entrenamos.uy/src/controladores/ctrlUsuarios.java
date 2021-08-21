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

import manejadores.manejDeportivas;
import java.util.Iterator;

/**
 * @author mbarrera
 *
 */
public class ctrlUsuarios implements IctrlUsuarios {
	
	private manejUsuarios manejador;
	
	public ctrlUsuarios() {
		this.manejador = manejUsuarios.getInstance();
	}
	
	public Set<String> mostrarNombreProfesoresDeInstitucion(String inst) {
		return this.manejador.mostrarNombreProfesoresDeInstitucion(inst);
	}

	//paulo
	public void altaUsuario(InfoBasicaUser user) {
		
		//traigo el controlador 
		//this.ctrlUsuarios();
		
		this.manejador.CrearUsuario(user);
		
	}
	

	public Vector<String> InstitucionesEnSistema() {
		
		manejDeportivas md = manejDeportivas.getinstance();
		Set<String> set;
		set = md.darNombreInstituciones();
		Iterator<String> iterate_value = set.iterator();
		
		Vector<String> vector = new Vector<String>();
		
		while(iterate_value.hasNext()){
			
			String e = iterate_value.next().toString();
			vector.add(e);
		}
		
		return vector;
		
	}
	
	public InformacionActividad InformacionActividad(String usuario) {
		
	}
	
	public void ActualizarInformacionUsuario(InfoBasicaUser actualizacion){
		
	}
	
	public InfoBasicaUser InformacionBasicaUsuario(String usuario) {
		
	}
	
	public Set<String> UsuariosEnSistemaNickName(){
		
	}
	
	//paulo
	
}
