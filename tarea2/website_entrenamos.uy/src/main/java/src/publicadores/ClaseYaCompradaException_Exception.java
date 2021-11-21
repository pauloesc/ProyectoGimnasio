
package src.publicadores;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ClaseYaCompradaException", targetNamespace = "http://Publicadores.src/")
public class ClaseYaCompradaException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ClaseYaCompradaException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ClaseYaCompradaException_Exception(String message, ClaseYaCompradaException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ClaseYaCompradaException_Exception(String message, ClaseYaCompradaException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: src.publicadores.ClaseYaCompradaException
     */
    public ClaseYaCompradaException getFaultInfo() {
        return faultInfo;
    }

}
