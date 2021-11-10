/**
 * 
 */
package publicadores;

/**
 * @author mbarrera
 *
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import excepciones.ActividadDeportivaNoExisteException;
import excepciones.ActividadDeportivaRepetidaException;
import logica.Fabrica;
import logica.IctrlADeportivas;
import logica.DataActividad;
import logica.EstadoActi;

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
         endpoint = Endpoint.publish("http://localhost:9128/CtrlActDeportivas", this);
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
    	return ctrladep.darNombresActividadesDeportivas(inst).toArray(new String[ctrladep.darNombresActividadesDeportivas(inst).size()]);
    }
    
    @WebMethod
    public String[] getActividadesCategoria(String cat) {
    	return ctrladep.getActividadesCategoria(cat).toArray(new String[ctrladep.getActividadesCategoria(cat).size()]);
    }
    
    @WebMethod
    public String[] mostrarClasesVigentesDeActividadDeportiva(String nomAct) {
    	return ctrladep.mostrarClasesVigentesDeActividadDeportiva(nomAct).toArray(new String[ctrladep.mostrarClasesVigentesDeActividadDeportiva(nomAct).size()]);
    }
    
    @WebMethod
    public void cambiarEstado(String nom, EstadoActi est) {
    	ctrladep.cambiarEstado(nom, est);
    }

    @WebMethod
    public String[] getActividadesIngresadas() throws ActividadDeportivaNoExisteException {
    	return ctrladep.getActividadesIngresadas().toArray(new String[ctrladep.getActividadesIngresadas().size()]);
    }
    
    @WebMethod
    public DataActividad[] buscarActividades(String query) {
    	return ctrladep.buscarActividades(query).toArray(new DataActividad[ctrladep.buscarActividades(query).size()]);
    }
   
    @WebMethod
    public DataActividad[] getDataActividadesIngresadas() throws ActividadDeportivaNoExisteException {
    	return ctrladep.getDataActividadesIngresadas().toArray(new DataActividad[ctrladep.getDataActividadesIngresadas().size()]); 	
    }
      
}

