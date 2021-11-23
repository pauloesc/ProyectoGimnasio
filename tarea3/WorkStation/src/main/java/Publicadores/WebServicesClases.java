package Publicadores;


import java.io.FileReader;
import java.util.Date;
import java.util.Properties;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import src.excepciones.ClaseLlenaException;
import src.excepciones.ClaseNoExisteException;
import src.excepciones.ClaseRepetidaException;
import src.excepciones.ClaseYaCompradaException;
import src.excepciones.PremioSorteadosException;
import src.logica.DtClase;
import src.logica.DtPremio;
import src.logica.Fabrica;
import src.logica.IctrlClases;
import src.logica.WrapperSetString;

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
    	Properties p = null;
    	try {
	    	FileReader reader=new FileReader("/entrenamosUy/conf.properties");  
	    	p=new Properties();  
	    	p.load(reader); 
    	} catch (Exception e) {}
    		
    		String url = p.getProperty("urlClasesWorkStation");
    		endpoint = Endpoint.publish(url, this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
   
    @WebMethod
    public void crearClase(String nombre, Date Finicio, String prof, int Smin, int Smax, String url, String urlVid, Date FechaAlta, String nomAct, Integer hora, Integer minuto, String img, String descPremios, int cantPremios) throws ClaseRepetidaException {
    	ctrl.crearClase(nombre, Finicio, prof, Smin, Smax, url, urlVid, FechaAlta, nomAct, hora, minuto, img, descPremios, cantPremios);
    }
    
    @WebMethod
    public DtClase darDtClase(String nomClas) {
    	return ctrl.darDtClase(nomClas);
    }
    
    @WebMethod
    public void registrarSocioAClase(String nick, String actDep, String clas, boolean cuponera, String nomCuponera, Date fechaReg) throws ClaseYaCompradaException, ClaseLlenaException {
    	ctrl.registrarSocioAClase(nick, actDep, clas, cuponera, nomCuponera, fechaReg);
    }
    
    @WebMethod
    public WrapperSetString mostrarClasesDeActividadDeportiva(String nomAct) throws ClaseNoExisteException {
    	WrapperSetString envoltura = new WrapperSetString();
    	envoltura.setSet( ctrl.mostrarClasesDeActividadDeportiva(nomAct));
    	return envoltura;
    }
    
    @WebMethod
    public void sortearPremios(String clase) throws PremioSorteadosException {
    	ctrl.sortearPremios(clase);
    }
    
    @WebMethod
	public boolean esProfeDeClase(String nomC, String nomP) {
    	return ctrl.esProfeDeClase(nomC, nomP);
    }
    
    @WebMethod
    public DtPremio sinProposito1() {
    	DtPremio s = new DtPremio();
    	return s;
    }
    
    @WebMethod
    public DtClase sinProposito2() {
    	DtClase s = new DtClase();
    	return s;
    }
	
}
