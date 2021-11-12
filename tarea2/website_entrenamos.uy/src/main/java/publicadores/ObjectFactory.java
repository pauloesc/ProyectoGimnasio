
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

    private final static QName _CategoriaExistenteException_QNAME = new QName("http://Publicadores/", "CategoriaExistenteException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: publicadores
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CategoriaExistenteException }
     * 
     */
    public CategoriaExistenteException createCategoriaExistenteException() {
        return new CategoriaExistenteException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoriaExistenteException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Publicadores/", name = "CategoriaExistenteException")
    public JAXBElement<CategoriaExistenteException> createCategoriaExistenteException(CategoriaExistenteException value) {
        return new JAXBElement<CategoriaExistenteException>(_CategoriaExistenteException_QNAME, CategoriaExistenteException.class, null, value);
    }

}
