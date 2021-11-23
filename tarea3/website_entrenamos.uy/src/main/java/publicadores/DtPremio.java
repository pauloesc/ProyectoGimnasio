
package publicadores;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para dtPremio complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtPremio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="descrPremio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaClase" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="nomA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtPremio", propOrder = {
    "descrPremio",
    "fecha",
    "fechaClase",
    "nomA",
    "nomC"
})
public class DtPremio {

    protected String descrPremio;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaClase;
    protected String nomA;
    protected String nomC;

    /**
     * Obtiene el valor de la propiedad descrPremio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrPremio() {
        return descrPremio;
    }

    /**
     * Define el valor de la propiedad descrPremio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrPremio(String value) {
        this.descrPremio = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaClase.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaClase() {
        return fechaClase;
    }

    /**
     * Define el valor de la propiedad fechaClase.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaClase(XMLGregorianCalendar value) {
        this.fechaClase = value;
    }

    /**
     * Obtiene el valor de la propiedad nomA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomA() {
        return nomA;
    }

    /**
     * Define el valor de la propiedad nomA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomA(String value) {
        this.nomA = value;
    }

    /**
     * Obtiene el valor de la propiedad nomC.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomC() {
        return nomC;
    }

    /**
     * Define el valor de la propiedad nomC.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomC(String value) {
        this.nomC = value;
    }

}
