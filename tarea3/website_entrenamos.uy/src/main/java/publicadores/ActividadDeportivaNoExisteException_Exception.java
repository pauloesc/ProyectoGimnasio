
package publicadores;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ActividadDeportivaNoExisteException", targetNamespace = "http://publicadores/")
public class ActividadDeportivaNoExisteException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ActividadDeportivaNoExisteException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ActividadDeportivaNoExisteException_Exception(String message, ActividadDeportivaNoExisteException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ActividadDeportivaNoExisteException_Exception(String message, ActividadDeportivaNoExisteException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: publicadores.ActividadDeportivaNoExisteException
     */
    public ActividadDeportivaNoExisteException getFaultInfo() {
        return faultInfo;
    }

}
