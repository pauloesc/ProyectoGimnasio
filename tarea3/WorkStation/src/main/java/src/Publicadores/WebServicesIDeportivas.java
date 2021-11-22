package src.Publicadores;

import java.io.FileReader;
import java.util.Properties;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import src.excepciones.InstitucionDeportivaNoExisteException;
import src.excepciones.InstitucionDeportivaRepetidaException;
import src.logica.DataInstitucion;
import src.logica.Fabrica;
import src.logica.IctrlIDeportivas;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class WebServicesIDeportivas {
	
	  
	    
	private IctrlIDeportivas controller = Fabrica.getInstance()
			.getIctrlIDeportivas();
	
    private Endpoint endpoint = null;
    
    // Constructor 
    public WebServicesIDeportivas() {}
    
    @WebMethod(exclude = true)
    public void publicar(){
    	
    	Properties p = null;
    	try {
	    	FileReader reader=new FileReader("/entrenamosUy/conf.properties");  
	    	p=new Properties();  
	    	p.load(reader); 
    	} catch (Exception e) {}
    		
    		String url = p.getProperty("urlIDeportivas");
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
    public void altaInstitucion(String nom, String des, String url) 
    		throws InstitucionDeportivaRepetidaException {
    	
    	controller.altaInstitucion(nom, des, url);
    }
    
    @WebMethod
    public DataInstitucion[] getInstituciones() 
    		throws InstitucionDeportivaNoExisteException {
    	
    	return controller.getInstituciones();
    }
    
    @WebMethod
    public DataInstitucion getInstitucion(String nombre) 
    		throws InstitucionDeportivaNoExisteException {
    	
    	return controller.getInstitucion(nombre);
    }
    
    @WebMethod
    public String[] darNombreInstituciones() {
    	
    	return controller.darNombreInstituciones().toArray(new String[0]);
    }
    
    @WebMethod
    public DataInstitucion newDataInstitucion()
    {
    	return new DataInstitucion();
    }
}
