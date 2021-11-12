
package publicadores;

import java.io.IOException;

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

    private final static QName _CuponeraNoExisteException_QNAME = new QName("http://Publicadores/", "CuponeraNoExisteException");
    private final static QName _IOException_QNAME = new QName("http://Publicadores/", "IOException");
    private final static QName _CuponeraCompradaException_QNAME = new QName("http://Publicadores/", "CuponeraCompradaException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: publicadores
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CuponeraCompradaException }
     * 
     */
    public CuponeraCompradaException createCuponeraCompradaException() {
        return new CuponeraCompradaException();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link CuponeraNoExisteException }
     * 
     */
    public CuponeraNoExisteException createCuponeraNoExisteException() {
        return new CuponeraNoExisteException();
    }

    /**
     * Create an instance of {@link ParActividad }
     * 
     */
    public ParActividad createParActividad() {
        return new ParActividad();
    }

    /**
     * Create an instance of {@link DataCuponera }
     * 
     */
    public DataCuponera createDataCuponera() {
        return new DataCuponera();
    }

    /**
     * Create an instance of {@link WrapperSetDataCuponera }
     * 
     */
    public WrapperSetDataCuponera createWrapperSetDataCuponera() {
        return new WrapperSetDataCuponera();
    }

    /**
     * Create an instance of {@link WrapperSetString }
     * 
     */
    public WrapperSetString createWrapperSetString() {
        return new WrapperSetString();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CuponeraNoExisteException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Publicadores/", name = "CuponeraNoExisteException")
    public JAXBElement<CuponeraNoExisteException> createCuponeraNoExisteException(CuponeraNoExisteException value) {
        return new JAXBElement<CuponeraNoExisteException>(_CuponeraNoExisteException_QNAME, CuponeraNoExisteException.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CuponeraCompradaException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Publicadores/", name = "CuponeraCompradaException")
    public JAXBElement<CuponeraCompradaException> createCuponeraCompradaException(CuponeraCompradaException value) {
        return new JAXBElement<CuponeraCompradaException>(_CuponeraCompradaException_QNAME, CuponeraCompradaException.class, null, value);
    }

}
