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

import java.util.List;
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
         endpoint = Endpoint.publish("http://localhost:9128/ControladorUsuarios", this);
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
}

