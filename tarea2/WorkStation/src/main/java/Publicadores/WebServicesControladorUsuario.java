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
import java.io.FileReader;
import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import src.excepciones.UsuarioDisponibilidadException;
import src.excepciones.UsuarioInexistenteException;

import src.logica.*;


import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class WebServicesControladorUsuario {

    private Endpoint endpoint = null;
    //Constructor
    public WebServicesControladorUsuario(){}

    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar(){
    	Properties p = null;
    	try {
	    	FileReader reader=new FileReader("/entrenamosUy/conf.properties");  
	    	p=new Properties();  
	    	p.load(reader); 
    	} catch (Exception e) {}
    		
    		String url = p.getProperty("urlUsuarioWorkStation");
    		endpoint = Endpoint.publish(url, this);
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
    public WrapperStringNull autenticarUsario(String nickname, String email, String contrasena){
    	IctrlUsuarios cu = new ctrlUsuarios();
    	WrapperStringNull envoltura = new WrapperStringNull();
    	envoltura.setInformacion(cu.autenticarUsario(nickname, email, contrasena));
    	return envoltura;
    }
    
    @WebMethod
    public WrapperStringNull autenticarUsarioMovil(String nickname, String email, String contrasena){
    	IctrlUsuarios cu = new ctrlUsuarios();
    	WrapperStringNull envoltura = new WrapperStringNull();
    	envoltura.setInformacion(cu.autenticarUsarioMovil(nickname, email, contrasena));
    	return envoltura;
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
    
    
    @WebMethod
    public  WrapperListString getGanadoresDeClase(String nomC){
    	WrapperListString envoltura = new WrapperListString();
    	IctrlUsuarios cu = new ctrlUsuarios();
    	envoltura.setLista(cu.getGanadoresDeClase(nomC));
    	
    	return envoltura;
    	
    }
    
    
    @WebMethod
    public WrapperListDtPremio getPremiosDeUsuario(String nomU) {
    	IctrlUsuarios cu = new ctrlUsuarios();
    	WrapperListDtPremio w = new WrapperListDtPremio();
    	w.setList(cu.getPremiosDeUsuario(nomU));
    	return w;
    }
    
    /**
     * forzar a que se incluya en el wsdl types el siguiente tipo
     */
    
    
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
    
    
    /**
     * forzar a que se incluya en el wsdl types
     */
    
    
    @WebMethod
    public InfoActividadProfe todasLasActividadesDeUnProfesor(String usuario) {
    	IctrlUsuarios cu = new ctrlUsuarios();
    	InfoActividadProfe aRetornar = cu.todasLasActividadesDeUnProfesor(usuario);
    	return aRetornar;
    }
    
    
    @WebMethod
    public WrapperListaUsuarios darParticipantes(String nomClase) {
    	IctrlUsuarios cu = new ctrlUsuarios();
    	List<InfoBasicaSocio> info = cu.darParticipantes( nomClase );
    	WrapperListaUsuarios retornar = new WrapperListaUsuarios();
    	retornar.setListaUsuarioss(info);
    	return retornar;
    }

    
}

