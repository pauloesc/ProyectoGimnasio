package Publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import excepciones.CategoriaExistenteException;
import logica.Fabrica;
import logica.IctrlCategorias;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class WebServicesCategorias {
	
	private IctrlCategorias controller = Fabrica.getInstance()
			.getIctrlCategorias();
	
    private Endpoint endpoint = null;
    
    // Constructor 
    public WebServicesCategorias() {}
    
    @WebMethod(exclude = true)
    public void publicar(){
    	endpoint = Endpoint
    			.publish("http://localhost:9129/ctrlCategorias", this);
    }
    
    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
    	return endpoint;
    }
    
    /*	*****************
     * 	METODOS EXPUESTOS
     *  *****************
     */
    
    @WebMethod
    public void altaCategoria(String nom) 
    		throws CategoriaExistenteException {
    	
    	controller.altaCategoria(nom);
    }
    
    @WebMethod
    public String[] getCategorias() {
    	
    	return controller.getCategorias().toArray( new String[0] );
    }
    
}
