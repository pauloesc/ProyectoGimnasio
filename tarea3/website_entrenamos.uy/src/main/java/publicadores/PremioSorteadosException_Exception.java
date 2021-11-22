
package publicadores;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "PremioSorteadosException", targetNamespace = "http://Publicadores/")
public class PremioSorteadosException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private PremioSorteadosException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public PremioSorteadosException_Exception(String message, PremioSorteadosException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public PremioSorteadosException_Exception(String message, PremioSorteadosException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: publicadores.PremioSorteadosException
     */
    public PremioSorteadosException getFaultInfo() {
        return faultInfo;
    }

}
