
package publicadores;

import java.net.MalformedURLException;
import java.net.URL;
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
@WebServiceClient(name = "WebServicesCategoriasService", targetNamespace = "http://publicadores/", wsdlLocation = "http://172.16.0.160:9128/ctrlCategorias?wsdl")
public class WebServicesCategoriasService
    extends Service
{

    private final static URL WEBSERVICESCATEGORIASSERVICE_WSDL_LOCATION;
    private final static WebServiceException WEBSERVICESCATEGORIASSERVICE_EXCEPTION;
    private final static QName WEBSERVICESCATEGORIASSERVICE_QNAME = new QName("http://publicadores/", "WebServicesCategoriasService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://172.16.0.160:9128/ctrlCategorias?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVICESCATEGORIASSERVICE_WSDL_LOCATION = url;
        WEBSERVICESCATEGORIASSERVICE_EXCEPTION = e;
    }

    public WebServicesCategoriasService() {
        super(__getWsdlLocation(), WEBSERVICESCATEGORIASSERVICE_QNAME);
    }

    public WebServicesCategoriasService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVICESCATEGORIASSERVICE_QNAME, features);
    }

    public WebServicesCategoriasService(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVICESCATEGORIASSERVICE_QNAME);
    }

    public WebServicesCategoriasService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVICESCATEGORIASSERVICE_QNAME, features);
    }

    public WebServicesCategoriasService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServicesCategoriasService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WebServicesCategorias
     */
    @WebEndpoint(name = "WebServicesCategoriasPort")
    public WebServicesCategorias getWebServicesCategoriasPort() {
        return super.getPort(new QName("http://publicadores/", "WebServicesCategoriasPort"), WebServicesCategorias.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServicesCategorias
     */
    @WebEndpoint(name = "WebServicesCategoriasPort")
    public WebServicesCategorias getWebServicesCategoriasPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://publicadores/", "WebServicesCategoriasPort"), WebServicesCategorias.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVICESCATEGORIASSERVICE_EXCEPTION!= null) {
            throw WEBSERVICESCATEGORIASSERVICE_EXCEPTION;
        }
        return WEBSERVICESCATEGORIASSERVICE_WSDL_LOCATION;
    }

}
