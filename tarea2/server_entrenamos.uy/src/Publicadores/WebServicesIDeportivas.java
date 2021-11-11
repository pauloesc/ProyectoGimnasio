/**
 * 
 */
package Publicadores;

/**
 * @author agaletta
 *
 */


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;


import excepciones.InstitucionDeportivaNoExisteException;
import excepciones.InstitucionDeportivaRepetidaException;
import logica.Fabrica;
import logica.IctrlIDeportivas;
import logica.WrapperSetString;
import logica.DataInstitucion;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class WebServicesIDeportivas {
	
	private Fabrica fabrica = Fabrica.getInstance();
	private IctrlIDeportivas ctrlInst = fabrica.getIctrlIDeportivas();
	
    private Endpoint endpoint = null;
    //Constructor
    public WebServicesIDeportivas(){}

    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9128/CtrlInstDeportivas", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
   
    @WebMethod
    public void altaInstitucion(String nom, String des, String url) throws InstitucionDeportivaRepetidaException {
       ctrlInst.altaInstitucion(nom, des, url);
    }
    
    @WebMethod
    public DataInstitucion getInstitucion(String nombre) throws InstitucionDeportivaNoExisteException {
    	return ctrlInst.getInstitucion(nombre);
    }
    
    @WebMethod
    public DataInstitucion[] getInstituciones() throws InstitucionDeportivaNoExisteException {
        return ctrlInst.getInstituciones();
    }
    
    @WebMethod
    public WrapperSetString darNombreInstituciones(){
    	WrapperSetString resu=new WrapperSetString();
    	resu.setSet(ctrlInst.darNombreInstituciones());
    	return resu;
    }
    
    @WebMethod
    public void cargarDatosIDeportivas() {
    	ctrlInst.cargarDatosIDeportivas();
    }
    
         
      
}

