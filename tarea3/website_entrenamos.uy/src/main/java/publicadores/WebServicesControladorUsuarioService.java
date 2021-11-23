
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
@WebServiceClient(name = "WebServicesControladorUsuarioService", targetNamespace = "http://Publicadores/", wsdlLocation = "")
public class WebServicesControladorUsuarioService
    extends Service
{

    private final static URL WEBSERVICESCONTROLADORUSUARIOSERVICE_WSDL_LOCATION;
    private final static WebServiceException WEBSERVICESCONTROLADORUSUARIOSERVICE_EXCEPTION;
    private final static QName WEBSERVICESCONTROLADORUSUARIOSERVICE_QNAME = new QName("http://Publicadores/", "WebServicesControladorUsuarioService");

    static {
    	URL url = null;
        WebServiceException e = null;
        try {
        	Properties p = null;
        	String valUrl = "";
        	try {
        		String home = System.getProperty("user.home");
        		FileReader reader = new FileReader( "/home/"+home+"/.entrenamosUy/conf.properties");
  
    	    	p=new Properties();  
    	    	p.load(reader); 
    	    	valUrl = p.getProperty("urlUsuario");
        	} catch (Exception ex) {}
            url = new URL(valUrl);
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVICESCONTROLADORUSUARIOSERVICE_WSDL_LOCATION = url;
        WEBSERVICESCONTROLADORUSUARIOSERVICE_EXCEPTION = e;
    }

    public WebServicesControladorUsuarioService() {
        super(__getWsdlLocation(), WEBSERVICESCONTROLADORUSUARIOSERVICE_QNAME);
    }

    public WebServicesControladorUsuarioService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVICESCONTROLADORUSUARIOSERVICE_QNAME, features);
    }

    public WebServicesControladorUsuarioService(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVICESCONTROLADORUSUARIOSERVICE_QNAME);
    }

    public WebServicesControladorUsuarioService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVICESCONTROLADORUSUARIOSERVICE_QNAME, features);
    }

    public WebServicesControladorUsuarioService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServicesControladorUsuarioService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WebServicesControladorUsuario
     */
    @WebEndpoint(name = "WebServicesControladorUsuarioPort")
    public WebServicesControladorUsuario getWebServicesControladorUsuarioPort() {
        return super.getPort(new QName("http://Publicadores/", "WebServicesControladorUsuarioPort"), WebServicesControladorUsuario.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServicesControladorUsuario
     */
    @WebEndpoint(name = "WebServicesControladorUsuarioPort")
    public WebServicesControladorUsuario getWebServicesControladorUsuarioPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://Publicadores/", "WebServicesControladorUsuarioPort"), WebServicesControladorUsuario.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVICESCONTROLADORUSUARIOSERVICE_EXCEPTION!= null) {
            throw WEBSERVICESCONTROLADORUSUARIOSERVICE_EXCEPTION;
        }
        return WEBSERVICESCONTROLADORUSUARIOSERVICE_WSDL_LOCATION;
    }

}
