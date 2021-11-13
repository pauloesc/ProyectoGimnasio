package Publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import excepciones.InstitucionDeportivaNoExisteException;
import excepciones.InstitucionDeportivaRepetidaException;
import logica.DataInstitucion;
import logica.Fabrica;
import logica.IctrlIDeportivas;

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
    	endpoint = Endpoint
    			.publish("http://localhost:9129/ctrlInstituciones", this);
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
