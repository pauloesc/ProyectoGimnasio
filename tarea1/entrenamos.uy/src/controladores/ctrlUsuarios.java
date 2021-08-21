/**
 * 
 */
package controladores;

import java.util.Set;

import logica.IctrlUsuarios;
import manejadores.manejUsuarios;

/**
 * @author mbarrera
 *
 */
public class ctrlUsuarios implements IctrlUsuarios {
	
	private manejUsuarios manejador;
	
	public ctrlUsuarios() {
		manejador = manejUsuarios.getInstance();
	}
	
	public Set<String> mostrarNombreProfesoresDeInstitucion(String inst) {
		return manejador.mostrarNombreProfesoresDeInstitucion(inst);
	}
	
}
