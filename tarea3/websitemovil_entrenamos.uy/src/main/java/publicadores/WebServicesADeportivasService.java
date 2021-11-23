
package publicadores;

import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WebServicesADeportivasService", targetNamespace = "http://Publicadores/", wsdlLocation = "http://localhost:9128/CtrlActDeportivas?wsdl")
public class WebServicesADeportivasService
    extends Service
{

    private final static URL WEBSERVICESADEPORTIVASSERVICE_WSDL_LOCATION;
    private final static WebServiceException WEBSERVICESADEPORTIVASSERVICE_EXCEPTION;
    private final static QName WEBSERVICESADEPORTIVASSERVICE_QNAME = new QName("http://Publicadores/", "WebServicesADeportivasService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
        	Properties p = null;
        	String valUrl = "";
        	try {
        		String home = System.getProperty("user.home");
    	    	FileReader reader = new FileReader( home + "/.entrenamosUy/conf.properties");   
    	    	p=new Properties();  
    	    	p.load(reader); 
    	    	valUrl = p.getProperty("urlADeportivasWeb");
        	} catch (Exception ex) {}
            url = new URL(valUrl);
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVICESADEPORTIVASSERVICE_WSDL_LOCATION = url;
        WEBSERVICESADEPORTIVASSERVICE_EXCEPTION = e;
    }

    public WebServicesADeportivasService() {
        super(__getWsdlLocation(), WEBSERVICESADEPORTIVASSERVICE_QNAME);
    }

    public WebServicesADeportivasService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVICESADEPORTIVASSERVICE_QNAME, features);
    }

    public WebServicesADeportivasService(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVICESADEPORTIVASSERVICE_QNAME);
    }

    public WebServicesADeportivasService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVICESADEPORTIVASSERVICE_QNAME, features);
    }

    public WebServicesADeportivasService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServicesADeportivasService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WebServicesADeportivas
     */
    @WebEndpoint(name = "WebServicesADeportivasPort")
    public WebServicesADeportivas getWebServicesADeportivasPort() {
        return super.getPort(new QName("http://Publicadores/", "WebServicesADeportivasPort"), WebServicesADeportivas.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServicesADeportivas
     */
    @WebEndpoint(name = "WebServicesADeportivasPort")
    public WebServicesADeportivas getWebServicesADeportivasPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://Publicadores/", "WebServicesADeportivasPort"), WebServicesADeportivas.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVICESADEPORTIVASSERVICE_EXCEPTION!= null) {
            throw WEBSERVICESADEPORTIVASSERVICE_EXCEPTION;
        }
        return WEBSERVICESADEPORTIVASSERVICE_WSDL_LOCATION;
    }

}
