/**
 * 
 */
package Publicadores;

/**
 * @author agaletta
 *
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
import src.excepciones.CuponeraCompradaException;
import src.excepciones.CuponeraNoExisteException;
import src.logica.Fabrica;
import src.logica.IctrlCuponeras;
import src.logica.WrapperSetDataCuponera;
import src.logica.WrapperSetString;
import src.logica.DataCuponera;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class WebServicesCuponeras {
	
	private Fabrica fabrica = Fabrica.getInstance();
	private IctrlCuponeras ctrlcup = fabrica.getIctrlCuponeras();
	
    private Endpoint endpoint = null;
    //Constructor
    public WebServicesCuponeras(){}

    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar(){
    	Properties p = null;
    	try {
    		String home = System.getProperty("user.name");
    		FileReader reader = new FileReader( "/home/"+home+"/.entrenamosUy/conf.properties");
  
	    	p=new Properties();  
	    	p.load(reader); 
    	} catch (Exception e) {}
    		
    		String url = p.getProperty("urlCuponerasWorkStation");
    		endpoint = Endpoint.publish(url, this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
   
       
    @WebMethod
    public WrapperSetString listarCuponeras() throws CuponeraNoExisteException {
    	WrapperSetString resu=new WrapperSetString();
    	resu.setSet(ctrlcup.listarCuponeras());
    	return resu;
    }
    
   
       
    @WebMethod
    public DataCuponera mostrarCuponera(String nomCup)throws CuponeraNoExisteException {
    	return ctrlcup.mostrarCuponera(nomCup);
    }
    
    @WebMethod
    public WrapperSetString getCuponerasActividad(String nac) throws CuponeraNoExisteException {
    	WrapperSetString resu=new WrapperSetString();
    	resu.setSet(ctrlcup.getCuponerasActividad(nac));
    	return resu;
    }
    
    
    @WebMethod
    public WrapperSetString listarcuponeraslibres() throws CuponeraNoExisteException {
    	WrapperSetString resu=new WrapperSetString();
    	resu.setSet(ctrlcup.listarcuponeraslibres());
    	return resu;
    }
    
    @WebMethod
    public void comprarCuponera(Date fecha, String cuponera, String nomsocio) throws CuponeraCompradaException {
    	ctrlcup.comprarCuponera(fecha, cuponera, nomsocio);
    }
   
    @WebMethod
    public WrapperSetString getCuponerasCategoria(String cat) {
    	WrapperSetString resu=new WrapperSetString();
    	resu.setSet(ctrlcup.getCuponerasCategoria(cat));
    	return resu;
    }
    
    @WebMethod
    public WrapperSetString getCuponerasInstitucion(String inst) {
    	WrapperSetString resu=new WrapperSetString();
    	resu.setSet(ctrlcup.getCuponerasInstitucion(inst));
    	return resu;
    }
    
    @WebMethod
    public WrapperSetString getCuponerasAD(String act){
    	WrapperSetString resu=new WrapperSetString();
    	resu.setSet(ctrlcup.getCuponerasAD(act));
    	return resu;
    }
    @WebMethod
    public WrapperSetDataCuponera buscarCuponeras(String consulta)throws CuponeraNoExisteException{
    	WrapperSetDataCuponera resu=new WrapperSetDataCuponera();
    	resu.setLista(ctrlcup.buscarCuponeras(consulta));
    	
    	return resu;
    }
    
    @WebMethod
    public byte[] getFile(@WebParam(name = "fileName") String name)
                    throws  IOException {
        byte[] byteArray = null;
        try {
                File f = new File(".files/" + name);
                FileInputStream streamer = new FileInputStream(f);
                byteArray = new byte[streamer.available()];
                streamer.read(byteArray);
        } catch (IOException e) {
                throw e;
        }
        return byteArray;
    }
    
}

