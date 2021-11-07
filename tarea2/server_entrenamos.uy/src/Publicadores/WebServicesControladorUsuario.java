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

import excepciones.UsuarioInexistenteException;
import logica.IctrlUsuarios;
import logica.InfoBasicaUser;
import logica.InformacionActividad;
import logica.WrapperListString;
import logica.ctrlUsuarios;

import java.util.List;
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
    public String chau(){
        //Logica l = new Logica();
        return "chau";
    }
    
    @WebMethod
    public Boolean usuarioSigueAUsuario(String usuario1, String usuario2){
        IctrlUsuarios cu = new ctrlUsuarios();
        return cu.usuarioSigueAUsuario(usuario1, usuario2);
    }
    
    @WebMethod
    public boolean esSocio(String nick) throws UsuarioInexistenteException {
    	IctrlUsuarios cu = new ctrlUsuarios();
    	return cu.esSocio(nick);
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
    public InfoBasicaUser informacionBasicaUsuario(String usuario) {
    	IctrlUsuarios cu = new ctrlUsuarios();
    	return cu.informacionBasicaUsuario(usuario);
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
    
    /**
     * forzar a que se incluya en el wsdl types
     */
    
    
    @WebMethod
    public InformacionActividad informacionActividad(String usuario) {
    	IctrlUsuarios cu = new ctrlUsuarios();
    	InformacionActividad aRetornar = cu.informacionActividad(usuario);
    	return aRetornar;
    }
    
}

