/**
 * 
 */
package Publicadores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author mbarrera
 *
 */

import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import src.excepciones.ActividadDeportivaNoExisteException;
import src.excepciones.ActividadDeportivaRepetidaException;
import src.logica.Fabrica;
import src.logica.IctrlADeportivas;
import src.logica.WrapperSetDtClase;
import src.logica.DataActividad;
import src.logica.DtClase;
import src.logica.EstadoActi;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class WebServicesADeportivas {
	
	private Fabrica fabrica = Fabrica.getInstance();
	private IctrlADeportivas ctrladep = fabrica.getIctrlADeportivas();
	
    private Endpoint endpoint = null;
    //Constructor
    public WebServicesADeportivas(){}

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
    		
    		String url = p.getProperty("urlADeportivasWorkStation");
    		endpoint = Endpoint.publish(url, this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
   
    @WebMethod
    public void altaActividadDeportiva(String nid, String pid, String nom, String des, Float dur, Float cos, Date fal, String[] cats, String img) throws ActividadDeportivaRepetidaException {
        Set<String> catset = new HashSet<String>();
        for(int i=0; i < cats.length; i++) {
        	catset.add(cats[i]);
        }
    	ctrladep.altaActividadDeportiva(nid, pid, nom, des, dur, cos, fal, catset, img);
    }
    
    @WebMethod
    public DataActividad[] getActividades(String nid) throws ActividadDeportivaNoExisteException {
    	return ctrladep.getActividades(nid);
    }
    
    @WebMethod
    public DataActividad getDataActividad(String nom) throws ActividadDeportivaNoExisteException {
        return ctrladep.getDataActividad(nom);
    }
    
    @WebMethod
    public String[] darNombresActividadesDeportivas(String inst) {
    	return ctrladep.darNombresActividadesDeportivas(inst).toArray(new String[0]);
    }
    
    @WebMethod
    public String[] getActividadesCategoria(String cat) {
    	return ctrladep.getActividadesCategoria(cat).toArray(new String[0]);
    }
    
    @WebMethod
    public String[] mostrarClasesVigentesDeActividadDeportiva(String nomAct) {
    	return ctrladep.mostrarClasesVigentesDeActividadDeportiva(nomAct).toArray(new String[0]);
    }
    
    @WebMethod
    public void cambiarEstado(String nom, EstadoActi est) {
    	ctrladep.cambiarEstado(nom, est);
    }

    @WebMethod
    public String[] getActividadesIngresadas() throws ActividadDeportivaNoExisteException {
    	return ctrladep.getActividadesIngresadas().toArray(new String[0]);
    }
    
    @WebMethod
    public DataActividad[] buscarActividades(String query) {
    	return ctrladep.buscarActividades(query).toArray(new DataActividad[0]);
    }
   
    @WebMethod
    public DataActividad[] getDataActividadesIngresadas() throws ActividadDeportivaNoExisteException {
    	return ctrladep.getDataActividadesIngresadas().toArray(new DataActividad[0]); 	
    }
    
    @WebMethod
    public DataActividad newDataActividad() {
    	return new DataActividad();
    }
    
    @WebMethod
    public WrapperSetDtClase getTodasLasClases() {
    	WrapperSetDtClase c = new WrapperSetDtClase();
    	c.setList(ctrladep.getTodasLasClases());
    	return c;
    	
    }
    
    @WebMethod
    public boolean saveFile(byte[] fileContent, String fileName)
                    throws  IOException {
       OutputStream outputStream = null;
       try {
    	   File file = new File(".files" + File.separator + fileName);
    	   outputStream = new FileOutputStream(file);
    	   outputStream.write(fileContent);
    	   return true;
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		if (outputStream != null) {
    		try {
    			outputStream.close();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	}
    	return false;
    }
}

