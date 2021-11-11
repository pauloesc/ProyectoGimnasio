/**
 * 
 */
package Publicadores;

/**
 * @author efviodo
 *
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import excepciones.UsuarioDisponibilidadException;
import excepciones.UsuarioInexistenteException;
import logica.DataCuponera;
import logica.IctrlUsuarios;
import logica.InfoActividadProfe;
import logica.InfoActividadSocio;
import logica.InfoBasicaUser;
import logica.InformacionActividad;
import logica.Profesor;
import logica.Socio;
import logica.Usuario;
import logica.WrapperDataCuponera;
import logica.WrapperListString;
import logica.WrapperSetString;
import logica.ctrlUsuarios;

import java.util.List;
import java.util.Set;
import java.util.Vector;

import logica.InfoBasicaSocio;
import logica.InfoBasicaProfesor;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class WebServicesControladorUsuario {

    private Endpoint endpoint = null;
    //Constructor
    public WebServicesControladorUsuario(){}

    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9128/ControladorUsuario", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }

    
    @WebMethod
    public WrapperSetString mostrarNombreProfesoresDeInstitucion(String inst){
    	IctrlUsuarios cu = new ctrlUsuarios();
    	WrapperSetString envoltura = new WrapperSetString();
    	envoltura.setSet( cu.mostrarNombreProfesoresDeInstitucion(inst) );
        return envoltura;
    }
    
    @WebMethod
    public void altaUsuario(InfoBasicaUser user) throws UsuarioDisponibilidadException{
    	IctrlUsuarios cu = new ctrlUsuarios();
    	cu.altaUsuario(user);
    }
    
    
    @WebMethod
    public WrapperListString institucionesEnSistema(){
    	IctrlUsuarios cu = new ctrlUsuarios();
    	WrapperListString envoltura = new WrapperListString();
    	envoltura.setLista( cu.institucionesEnSistema() );
        return envoltura;
    }
    
    
    @WebMethod
    public InformacionActividad informacionActividad(String usuario) {
    	IctrlUsuarios cu = new ctrlUsuarios();
    	InformacionActividad aRetornar = cu.informacionActividad(usuario);
    	return aRetornar;
    }
    
    
    @WebMethod
    public void actualizarInformacionUsuario(InfoBasicaUser actualizacion) {
    	IctrlUsuarios cu = new ctrlUsuarios();
    	cu.actualizarInformacionUsuario(actualizacion);
    }
    
    
    @WebMethod
    public InfoBasicaUser informacionBasicaUsuario(String usuario) {
    	IctrlUsuarios cu = new ctrlUsuarios();
    	return cu.informacionBasicaUsuario(usuario);
    }
    
    
    @WebMethod
    public WrapperListString usuariosEnSistemaNickName(){
    	IctrlUsuarios cu = new ctrlUsuarios();
    	WrapperListString envoltura = new WrapperListString();
    	envoltura.setLista(cu.usuariosEnSistemaNickName());
    	return envoltura;
    	
    }
    
    
    @WebMethod
    public WrapperSetString  mostrarCuponerasDisponibles(String nick, String actDept){
    	IctrlUsuarios cu = new ctrlUsuarios();
    	WrapperSetString envoltura = new WrapperSetString();
    	envoltura.setSet( cu.mostrarCuponerasDisponibles(nick, actDept) );
    	return envoltura;
    	
    }
    
    @WebMethod
	public WrapperSetString mostrarNicknameSocios() {
    	IctrlUsuarios cu = new ctrlUsuarios();
    	WrapperSetString envoltura = new WrapperSetString();
    	envoltura.setSet( cu.mostrarNicknameSocios() );
		return envoltura;
	}
    
    
    @WebMethod
    public void seguirUsuario(String seguidor, String seguido) {
    	IctrlUsuarios cu = new ctrlUsuarios();
    	cu.seguirUsuario(seguidor, seguido);
    }
    
    
    @WebMethod
    public void dejarDeSeguirUsuario(String seguidor, String seguido) {
    	IctrlUsuarios cu = new ctrlUsuarios();
    	cu.dejarDeSeguirUsuario(seguidor, seguido);
    }
    
    
    @WebMethod
    public boolean esSocio(String nick) throws UsuarioInexistenteException {
    	IctrlUsuarios cu = new ctrlUsuarios();
    	return cu.esSocio(nick);
    }
    
    @WebMethod
    public String autenticarUsario(String nickname, String email, String contrasena){
    	IctrlUsuarios cu = new ctrlUsuarios();
    	return cu.autenticarUsario(nickname, email, contrasena);
    }
    
    
    @WebMethod
    public String getNicknameUsuario(String email){
    	IctrlUsuarios cu = new ctrlUsuarios();
    	return cu.getNicknameUsuario(email);
    }
    
    
    @WebMethod
    public WrapperListString usuariosSiguiendo(String nickname){
    	IctrlUsuarios cu = new ctrlUsuarios();
    	WrapperListString wr = new WrapperListString();
    	wr.setLista( cu.usuariosSiguiendo(nickname) );
    	return wr;
    }
    
    @WebMethod
    public WrapperListString usuariosSeguidores(String nickname){
    	IctrlUsuarios cu = new ctrlUsuarios();
    	WrapperListString wr = new WrapperListString();
    	wr.setLista( cu.usuariosSeguidores(nickname) );
    	return wr;
    }
    
    
    @WebMethod
    public WrapperDataCuponera cuponeras(String nickname){
    	IctrlUsuarios cu = new ctrlUsuarios();
    	WrapperDataCuponera envoltorio = new WrapperDataCuponera();
    	envoltorio.setLista(cu.cuponeras(nickname));
    	return envoltorio;    	
    }
	
	
    @WebMethod
    public InfoActividadProfe informacionActDepEstadoIngRech(String nickname){
    	IctrlUsuarios cu = new ctrlUsuarios();
    	InfoActividadProfe envoltorio = cu.informacionActDepEstadoIngRech(nickname);
    	return envoltorio;
    	
    }
    
    
    @WebMethod
    public Boolean usuarioSigueAUsuario(String usuario1, String usuario2){
        IctrlUsuarios cu = new ctrlUsuarios();
        return cu.usuarioSigueAUsuario(usuario1, usuario2);
    }
    
    
    /**
     * forzar a que se incluya en el wsdl types el siguiente tipo
     */
    
    /**
    @WebMethod
    public InfoBasicaSocio sinProposito1() {
    	InfoBasicaSocio s = new InfoBasicaSocio();
    	return s;
    }
    
    @WebMethod
    public InfoBasicaProfesor sinProposito2() {
    	InfoBasicaProfesor s = new InfoBasicaProfesor();
    	return s;
    }
    
    @WebMethod
    public InfoActividadProfe sinProposito3() {
    	InfoActividadProfe s = new InfoActividadProfe();
    	return s;
    }
    
    @WebMethod
    public InfoActividadSocio sinProposito4() {
    	InfoActividadSocio s = new InfoActividadSocio();
    	return s;
    }
    */
    
    
    /**
     * forzar a que se incluya en el wsdl types
     */

    
}

