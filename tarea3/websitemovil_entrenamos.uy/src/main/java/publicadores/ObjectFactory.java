
package publicadores;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the publicadores package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ActividadDeportivaNoExisteException_QNAME = new QName("http://Publicadores/", "ActividadDeportivaNoExisteException");
    private final static QName _IOException_QNAME = new QName("http://Publicadores/", "IOException");
    private final static QName _ActividadDeportivaRepetidaException_QNAME = new QName("http://Publicadores/", "ActividadDeportivaRepetidaException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: publicadores
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ActividadDeportivaRepetidaException }
     * 
     */
    public ActividadDeportivaRepetidaException createActividadDeportivaRepetidaException() {
        return new ActividadDeportivaRepetidaException();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link ActividadDeportivaNoExisteException }
     * 
     */
    public ActividadDeportivaNoExisteException createActividadDeportivaNoExisteException() {
        return new ActividadDeportivaNoExisteException();
    }

    /**
     * Create an instance of {@link WrapperSetDtClase }
     * 
     */
    public WrapperSetDtClase createWrapperSetDtClase() {
        return new WrapperSetDtClase();
    }

    /**
     * Create an instance of {@link DataActividad }
     * 
     */
    public DataActividad createDataActividad() {
        return new DataActividad();
    }

    /**
     * Create an instance of {@link DtClase }
     * 
     */
    public DtClase createDtClase() {
        return new DtClase();
    }

    /**
     * Create an instance of {@link DataActividadArray }
     * 
     */
    public DataActividadArray createDataActividadArray() {
        return new DataActividadArray();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActividadDeportivaNoExisteException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Publicadores/", name = "ActividadDeportivaNoExisteException")
    public JAXBElement<ActividadDeportivaNoExisteException> createActividadDeportivaNoExisteException(ActividadDeportivaNoExisteException value) {
        return new JAXBElement<ActividadDeportivaNoExisteException>(_ActividadDeportivaNoExisteException_QNAME, ActividadDeportivaNoExisteException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Publicadores/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActividadDeportivaRepetidaException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Publicadores/", name = "ActividadDeportivaRepetidaException")
    public JAXBElement<ActividadDeportivaRepetidaException> createActividadDeportivaRepetidaException(ActividadDeportivaRepetidaException value) {
        return new JAXBElement<ActividadDeportivaRepetidaException>(_ActividadDeportivaRepetidaException_QNAME, ActividadDeportivaRepetidaException.class, null, value);
    }

}
