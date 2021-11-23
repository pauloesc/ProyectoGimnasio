
package publicadores;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for dtClase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dtClase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actualSocios" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cantPremios" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="descPremios" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estadoActividad" type="{http://Publicadores/}estadoActi" minOccurs="0"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaReg" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="hora" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="imagen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maxSocios" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minSocios" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minuto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nomAct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomProfesor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sorteados" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtClase", propOrder = {
    "actualSocios",
    "cantPremios",
    "descPremios",
    "estadoActividad",
    "fecha",
    "fechaReg",
    "hora",
    "imagen",
    "maxSocios",
    "minSocios",
    "minuto",
    "nomAct",
    "nomProfesor",
    "nombre",
    "sorteados",
    "url"
})
public class DtClase {

    protected int actualSocios;
    protected int cantPremios;
    protected String descPremios;
    @XmlSchemaType(name = "string")
    protected EstadoActi estadoActividad;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaReg;
    protected int hora;
    protected String imagen;
    protected int maxSocios;
    protected int minSocios;
    protected int minuto;
    protected String nomAct;
    protected String nomProfesor;
    protected String nombre;
    protected boolean sorteados;
    protected String url;

    /**
     * Gets the value of the actualSocios property.
     * 
     */
    public int getActualSocios() {
        return actualSocios;
    }

    /**
     * Sets the value of the actualSocios property.
     * 
     */
    public void setActualSocios(int value) {
        this.actualSocios = value;
    }

    /**
     * Gets the value of the cantPremios property.
     * 
     */
    public int getCantPremios() {
        return cantPremios;
    }

    /**
     * Sets the value of the cantPremios property.
     * 
     */
    public void setCantPremios(int value) {
        this.cantPremios = value;
    }

    /**
     * Gets the value of the descPremios property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescPremios() {
        return descPremios;
    }

    /**
     * Sets the value of the descPremios property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescPremios(String value) {
        this.descPremios = value;
    }

    /**
     * Gets the value of the estadoActividad property.
     * 
     * @return
     *     possible object is
     *     {@link EstadoActi }
     *     
     */
    public EstadoActi getEstadoActividad() {
        return estadoActividad;
    }

    /**
     * Sets the value of the estadoActividad property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoActi }
     *     
     */
    public void setEstadoActividad(EstadoActi value) {
        this.estadoActividad = value;
    }

    /**
     * Gets the value of the fecha property.
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
     * Sets the value of the fecha property.
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
     * Gets the value of the fechaReg property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaReg() {
        return fechaReg;
    }

    /**
     * Sets the value of the fechaReg property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaReg(XMLGregorianCalendar value) {
        this.fechaReg = value;
    }

    /**
     * Gets the value of the hora property.
     * 
     */
    public int getHora() {
        return hora;
    }

    /**
     * Sets the value of the hora property.
     * 
     */
    public void setHora(int value) {
        this.hora = value;
    }

    /**
     * Gets the value of the imagen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Sets the value of the imagen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImagen(String value) {
        this.imagen = value;
    }

    /**
     * Gets the value of the maxSocios property.
     * 
     */
    public int getMaxSocios() {
        return maxSocios;
    }

    /**
     * Sets the value of the maxSocios property.
     * 
     */
    public void setMaxSocios(int value) {
        this.maxSocios = value;
    }

    /**
     * Gets the value of the minSocios property.
     * 
     */
    public int getMinSocios() {
        return minSocios;
    }

    /**
     * Sets the value of the minSocios property.
     * 
     */
    public void setMinSocios(int value) {
        this.minSocios = value;
    }

    /**
     * Gets the value of the minuto property.
     * 
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * Sets the value of the minuto property.
     * 
     */
    public void setMinuto(int value) {
        this.minuto = value;
    }

    /**
     * Gets the value of the nomAct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomAct() {
        return nomAct;
    }

    /**
     * Sets the value of the nomAct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomAct(String value) {
        this.nomAct = value;
    }

    /**
     * Gets the value of the nomProfesor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomProfesor() {
        return nomProfesor;
    }

    /**
     * Sets the value of the nomProfesor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomProfesor(String value) {
        this.nomProfesor = value;
    }

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the sorteados property.
     * 
     */
    public boolean isSorteados() {
        return sorteados;
    }

    /**
     * Sets the value of the sorteados property.
     * 
     */
    public void setSorteados(boolean value) {
        this.sorteados = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

}
