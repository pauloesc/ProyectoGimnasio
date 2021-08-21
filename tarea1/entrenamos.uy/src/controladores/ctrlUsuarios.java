/**
 * 
 */
package controladores;

import java.util.Set;

import datatypes.InfoBasicaUser;
import datatypes.InformacionActividad;
import logica.IctrlUsuarios;
import manejadores.manejUsuarios;

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
	

	public Set<String> InstitucionesEnSistema() {
		
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
