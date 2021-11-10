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
import excepciones.CuponeraCompradaException;
import excepciones.CuponeraNoExisteException;
import excepciones.CuponeraRepetidaException;
import logica.Fabrica;
import logica.IctrlCuponeras;
import logica.WrapperSetString;
import logica.DataActividad;
import logica.DataCuponera;


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
         endpoint = Endpoint.publish("http://localhost:9128/CtrlCuponeras", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
   
    @WebMethod
    public void registrarCuponera (String nombre, String descrip, Date fecha_ini, Date fecha_fin, Float descuento, Date fecha_alta, String imagen) throws CuponeraRepetidaException {
           	ctrlcup.registrarCuponera (nombre, descrip, fecha_ini, fecha_fin, descuento, fecha_alta, imagen);
    }
    
    @WebMethod
    public WrapperSetString listarCuponeras() throws CuponeraNoExisteException {
    	WrapperSetString resu=new WrapperSetString();
    	resu.setSet(ctrlcup.listarCuponeras());
    	return resu;
    }
    
    @WebMethod
    public  WrapperSetString listarActividadesfaltantes(String nomcup, String nominst)throws ActividadDeportivaNoExisteException {
    	WrapperSetString resu=new WrapperSetString();
    	resu.setSet(ctrlcup.listarActividadesfaltantes(nomcup, nominst));
    	return resu;
    }
    
    @WebMethod
    public void agregarActividad(String nomcup, String act, int numclase) throws ActividadDeportivaRepetidaException  {
    	ctrlcup.agregarActividad(nomcup, act, numclase);
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
    public void cargarDatosCuponeras() {
    	ctrlcup.cargarDatosCuponeras();
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
    public DataActividad[] getDataActividadesIngresadas() throws ActividadDeportivaNoExisteException {
    	return ctrladep.getDataActividadesIngresadas().toArray(new DataActividad[ctrladep.getDataActividadesIngresadas().size()]); 	
    }
      
}

