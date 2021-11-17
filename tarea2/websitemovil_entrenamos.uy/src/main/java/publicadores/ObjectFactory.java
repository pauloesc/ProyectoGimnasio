
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

    private final static QName _PremioSorteadosException_QNAME = new QName("http://Publicadores/", "PremioSorteadosException");
    private final static QName _ClaseLlenaException_QNAME = new QName("http://Publicadores/", "ClaseLlenaException");
    private final static QName _ClaseRepetidaException_QNAME = new QName("http://Publicadores/", "ClaseRepetidaException");
    private final static QName _ClaseNoExisteException_QNAME = new QName("http://Publicadores/", "ClaseNoExisteException");
    private final static QName _ClaseYaCompradaException_QNAME = new QName("http://Publicadores/", "ClaseYaCompradaException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: publicadores
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClaseNoExisteException }
     * 
     */
    public ClaseNoExisteException createClaseNoExisteException() {
        return new ClaseNoExisteException();
    }

    /**
     * Create an instance of {@link ClaseYaCompradaException }
     * 
     */
    public ClaseYaCompradaException createClaseYaCompradaException() {
        return new ClaseYaCompradaException();
    }

    /**
     * Create an instance of {@link ClaseLlenaException }
     * 
     */
    public ClaseLlenaException createClaseLlenaException() {
        return new ClaseLlenaException();
    }

    /**
     * Create an instance of {@link ClaseRepetidaException }
     * 
     */
    public ClaseRepetidaException createClaseRepetidaException() {
        return new ClaseRepetidaException();
    }

    /**
     * Create an instance of {@link PremioSorteadosException }
     * 
     */
    public PremioSorteadosException createPremioSorteadosException() {
        return new PremioSorteadosException();
    }

    /**
     * Create an instance of {@link WrapperSetString }
     * 
     */
    public WrapperSetString createWrapperSetString() {
        return new WrapperSetString();
    }

    /**
     * Create an instance of {@link DtClase }
     * 
     */
    public DtClase createDtClase() {
        return new DtClase();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PremioSorteadosException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Publicadores/", name = "PremioSorteadosException")
    public JAXBElement<PremioSorteadosException> createPremioSorteadosException(PremioSorteadosException value) {
        return new JAXBElement<PremioSorteadosException>(_PremioSorteadosException_QNAME, PremioSorteadosException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClaseLlenaException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Publicadores/", name = "ClaseLlenaException")
    public JAXBElement<ClaseLlenaException> createClaseLlenaException(ClaseLlenaException value) {
        return new JAXBElement<ClaseLlenaException>(_ClaseLlenaException_QNAME, ClaseLlenaException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClaseRepetidaException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Publicadores/", name = "ClaseRepetidaException")
    public JAXBElement<ClaseRepetidaException> createClaseRepetidaException(ClaseRepetidaException value) {
        return new JAXBElement<ClaseRepetidaException>(_ClaseRepetidaException_QNAME, ClaseRepetidaException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClaseNoExisteException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Publicadores/", name = "ClaseNoExisteException")
    public JAXBElement<ClaseNoExisteException> createClaseNoExisteException(ClaseNoExisteException value) {
        return new JAXBElement<ClaseNoExisteException>(_ClaseNoExisteException_QNAME, ClaseNoExisteException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClaseYaCompradaException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Publicadores/", name = "ClaseYaCompradaException")
    public JAXBElement<ClaseYaCompradaException> createClaseYaCompradaException(ClaseYaCompradaException value) {
        return new JAXBElement<ClaseYaCompradaException>(_ClaseYaCompradaException_QNAME, ClaseYaCompradaException.class, null, value);
    }

}
