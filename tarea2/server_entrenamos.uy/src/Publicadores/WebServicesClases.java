package Publicadores;


import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import excepciones.ClaseLlenaException;
import excepciones.ClaseRepetidaException;
import excepciones.ClaseYaCompradaException;
import logica.DtClase;
import logica.Fabrica;
import logica.IctrlClases;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class WebServicesClases {
	
	private Fabrica fabrica = Fabrica.getInstance();
	private IctrlClases ctrl= fabrica.getIctrlClases();
	
    private Endpoint endpoint = null;
    //Constructor
    public WebServicesClases(){}

    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9128/CtrlClases", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
   
    @WebMethod
    public void crearClase(String nombre, Date Finicio, String prof, int Smin, int Smax, String url, Date FechaAlta, String nomAct, Integer hor, Integer min, String img) throws ClaseRepetidaException {
    	ctrl.crearClase(nombre, Finicio, prof, Smin, Smax, url, FechaAlta, nomAct, hor, min, img);
    }
    
    @WebMethod
    public DtClase darDtClase(String nomClas) {
    	return ctrl.darDtClase(nomClas);
    }
    
    @WebMethod
    public void registrarSocioAClase(String nick, String actDep, String clas, boolean cuponera, String nomCuponera, Date fechaReg) throws ClaseYaCompradaException, ClaseLlenaException {
    	ctrl.registrarSocioAClase(nick, actDep, clas, cuponera, nomCuponera, fechaReg);
    }
}
