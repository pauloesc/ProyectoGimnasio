
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

    private final static QName _UsuarioInexistenteException_QNAME = new QName("http://Publicadores/", "UsuarioInexistenteException");
    private final static QName _UsuarioDisponibilidadException_QNAME = new QName("http://Publicadores/", "UsuarioDisponibilidadException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: publicadores
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UsuarioDisponibilidadException }
     * 
     */
    public UsuarioDisponibilidadException createUsuarioDisponibilidadException() {
        return new UsuarioDisponibilidadException();
    }

    /**
     * Create an instance of {@link UsuarioInexistenteException }
     * 
     */
    public UsuarioInexistenteException createUsuarioInexistenteException() {
        return new UsuarioInexistenteException();
    }

    /**
     * Create an instance of {@link DtPremio }
     * 
     */
    public DtPremio createDtPremio() {
        return new DtPremio();
    }

    /**
     * Create an instance of {@link ParActividad }
     * 
     */
    public ParActividad createParActividad() {
        return new ParActividad();
    }

    /**
     * Create an instance of {@link InfoActividadProfe }
     * 
     */
    public InfoActividadProfe createInfoActividadProfe() {
        return new InfoActividadProfe();
    }

    /**
     * Create an instance of {@link WrapperListDtPremio }
     * 
     */
    public WrapperListDtPremio createWrapperListDtPremio() {
        return new WrapperListDtPremio();
    }

    /**
     * Create an instance of {@link WrapperDataCuponera }
     * 
     */
    public WrapperDataCuponera createWrapperDataCuponera() {
        return new WrapperDataCuponera();
    }

    /**
     * Create an instance of {@link WrapperListString }
     * 
     */
    public WrapperListString createWrapperListString() {
        return new WrapperListString();
    }

    /**
     * Create an instance of {@link WrapperStringNull }
     * 
     */
    public WrapperStringNull createWrapperStringNull() {
        return new WrapperStringNull();
    }

    /**
     * Create an instance of {@link InformacionActividad }
     * 
     */
    public InformacionActividad createInformacionActividad() {
        return new InformacionActividad();
    }

    /**
     * Create an instance of {@link InfoBasicaSocio }
     * 
     */
    public InfoBasicaSocio createInfoBasicaSocio() {
        return new InfoBasicaSocio();
    }

    /**
     * Create an instance of {@link DataCuponera }
     * 
     */
    public DataCuponera createDataCuponera() {
        return new DataCuponera();
    }

    /**
     * Create an instance of {@link DtActividadesDeportivas }
     * 
     */
    public DtActividadesDeportivas createDtActividadesDeportivas() {
        return new DtActividadesDeportivas();
    }

    /**
     * Create an instance of {@link InfoBasicaProfesor }
     * 
     */
    public InfoBasicaProfesor createInfoBasicaProfesor() {
        return new InfoBasicaProfesor();
    }

    /**
     * Create an instance of {@link WrapperSetString }
     * 
     */
    public WrapperSetString createWrapperSetString() {
        return new WrapperSetString();
    }

    /**
     * Create an instance of {@link WrapperListaUsuarios }
     * 
     */
    public WrapperListaUsuarios createWrapperListaUsuarios() {
        return new WrapperListaUsuarios();
    }

    /**
     * Create an instance of {@link InfoActividadSocio }
     * 
     */
    public InfoActividadSocio createInfoActividadSocio() {
        return new InfoActividadSocio();
    }

    /**
     * Create an instance of {@link DtClase }
     * 
     */
    public DtClase createDtClase() {
        return new DtClase();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsuarioInexistenteException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Publicadores/", name = "UsuarioInexistenteException")
    public JAXBElement<UsuarioInexistenteException> createUsuarioInexistenteException(UsuarioInexistenteException value) {
        return new JAXBElement<UsuarioInexistenteException>(_UsuarioInexistenteException_QNAME, UsuarioInexistenteException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsuarioDisponibilidadException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Publicadores/", name = "UsuarioDisponibilidadException")
    public JAXBElement<UsuarioDisponibilidadException> createUsuarioDisponibilidadException(UsuarioDisponibilidadException value) {
        return new JAXBElement<UsuarioDisponibilidadException>(_UsuarioDisponibilidadException_QNAME, UsuarioDisponibilidadException.class, null, value);
    }

}
