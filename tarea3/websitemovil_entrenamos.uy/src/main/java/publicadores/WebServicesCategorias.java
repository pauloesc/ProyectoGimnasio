
package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import net.java.dev.jaxb.array.StringArray;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WebServicesCategorias", targetNamespace = "http://publicadores/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    net.java.dev.jaxb.array.ObjectFactory.class,
    publicadores.ObjectFactory.class
})
public interface WebServicesCategorias {


    /**
     * 
     * @param arg0
     * @throws CategoriaExistenteException_Exception
     */
    @WebMethod
    @Action(input = "http://publicadores/WebServicesCategorias/altaCategoriaRequest", output = "http://publicadores/WebServicesCategorias/altaCategoriaResponse", fault = {
        @FaultAction(className = CategoriaExistenteException_Exception.class, value = "http://publicadores/WebServicesCategorias/altaCategoria/Fault/CategoriaExistenteException")
    })
    public void altaCategoria(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws CategoriaExistenteException_Exception
    ;

    /**
     * 
     * @return
     *     returns net.java.dev.jaxb.array.StringArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicadores/WebServicesCategorias/getCategoriasRequest", output = "http://publicadores/WebServicesCategorias/getCategoriasResponse")
    public StringArray getCategorias();

}
