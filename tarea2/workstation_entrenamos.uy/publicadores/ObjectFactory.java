
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

    private final static QName _InstitucionDeportivaNoExisteException_QNAME = new QName("http://Publicadores/", "InstitucionDeportivaNoExisteException");
    private final static QName _InstitucionDeportivaRepetidaException_QNAME = new QName("http://Publicadores/", "InstitucionDeportivaRepetidaException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: publicadores
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InstitucionDeportivaRepetidaException }
     * 
     */
    public InstitucionDeportivaRepetidaException createInstitucionDeportivaRepetidaException() {
        return new InstitucionDeportivaRepetidaException();
    }

    /**
     * Create an instance of {@link InstitucionDeportivaNoExisteException }
     * 
     */
    public InstitucionDeportivaNoExisteException createInstitucionDeportivaNoExisteException() {
        return new InstitucionDeportivaNoExisteException();
    }

    /**
     * Create an instance of {@link DataInstitucion }
     * 
     */
    public DataInstitucion createDataInstitucion() {
        return new DataInstitucion();
    }

    /**
     * Create an instance of {@link DataInstitucionArray }
     * 
     */
    public DataInstitucionArray createDataInstitucionArray() {
        return new DataInstitucionArray();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InstitucionDeportivaNoExisteException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Publicadores/", name = "InstitucionDeportivaNoExisteException")
    public JAXBElement<InstitucionDeportivaNoExisteException> createInstitucionDeportivaNoExisteException(InstitucionDeportivaNoExisteException value) {
        return new JAXBElement<InstitucionDeportivaNoExisteException>(_InstitucionDeportivaNoExisteException_QNAME, InstitucionDeportivaNoExisteException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InstitucionDeportivaRepetidaException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Publicadores/", name = "InstitucionDeportivaRepetidaException")
    public JAXBElement<InstitucionDeportivaRepetidaException> createInstitucionDeportivaRepetidaException(InstitucionDeportivaRepetidaException value) {
        return new JAXBElement<InstitucionDeportivaRepetidaException>(_InstitucionDeportivaRepetidaException_QNAME, InstitucionDeportivaRepetidaException.class, null, value);
    }

}
