
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
@WebServiceClient(name = "WebServicesClasesService", targetNamespace = "http://Publicadores/", wsdlLocation = "")
public class WebServicesClasesService
    extends Service
{

    private final static URL WEBSERVICESCLASESSERVICE_WSDL_LOCATION;
    private final static WebServiceException WEBSERVICESCLASESSERVICE_EXCEPTION;
    private final static QName WEBSERVICESCLASESSERVICE_QNAME = new QName("http://Publicadores/", "WebServicesClasesService");

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
    	    	valUrl = p.getProperty("urlClases");
        	} catch (Exception ex) {}
            url = new URL(valUrl);
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVICESCLASESSERVICE_WSDL_LOCATION = url;
        WEBSERVICESCLASESSERVICE_EXCEPTION = e;
    }

    public WebServicesClasesService() {
        super(__getWsdlLocation(), WEBSERVICESCLASESSERVICE_QNAME);
    }

    public WebServicesClasesService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVICESCLASESSERVICE_QNAME, features);
    }

    public WebServicesClasesService(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVICESCLASESSERVICE_QNAME);
    }

    public WebServicesClasesService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVICESCLASESSERVICE_QNAME, features);
    }

    public WebServicesClasesService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServicesClasesService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WebServicesClases
     */
    @WebEndpoint(name = "WebServicesClasesPort")
    public WebServicesClases getWebServicesClasesPort() {
        return super.getPort(new QName("http://Publicadores/", "WebServicesClasesPort"), WebServicesClases.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServicesClases
     */
    @WebEndpoint(name = "WebServicesClasesPort")
    public WebServicesClases getWebServicesClasesPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://Publicadores/", "WebServicesClasesPort"), WebServicesClases.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVICESCLASESSERVICE_EXCEPTION!= null) {
            throw WEBSERVICESCLASESSERVICE_EXCEPTION;
        }
        return WEBSERVICESCLASESSERVICE_WSDL_LOCATION;
    }

}
