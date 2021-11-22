package Publicadores;

import java.io.FileReader;
import java.util.Properties;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import src.excepciones.CategoriaExistenteException;
import src.logica.Fabrica;
import src.logica.IctrlCategorias;

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
    	Properties p = null;
    	try {
	    	FileReader reader=new FileReader("/entrenamosUy/conf.properties");  
	    	p=new Properties();  
	    	p.load(reader); 
    	} catch (Exception e) {}
    		
    		String url = p.getProperty("urlCategoriasWorkStation");
    		endpoint = Endpoint.publish(url, this);
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
