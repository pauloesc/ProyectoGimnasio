
package publicadores;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para dtClase complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
 *         &lt;element name="urlVideo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "url",
    "urlVideo"
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
    protected String urlVideo;

    /**
     * Obtiene el valor de la propiedad actualSocios.
     * 
     */
    public int getActualSocios() {
        return actualSocios;
    }

    /**
     * Define el valor de la propiedad actualSocios.
     * 
     */
    public void setActualSocios(int value) {
        this.actualSocios = value;
    }

    /**
     * Obtiene el valor de la propiedad cantPremios.
     * 
     */
    public int getCantPremios() {
        return cantPremios;
    }

    /**
     * Define el valor de la propiedad cantPremios.
     * 
     */
    public void setCantPremios(int value) {
        this.cantPremios = value;
    }

    /**
     * Obtiene el valor de la propiedad descPremios.
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
     * Define el valor de la propiedad descPremios.
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
     * Obtiene el valor de la propiedad estadoActividad.
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
     * Define el valor de la propiedad estadoActividad.
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
     * Obtiene el valor de la propiedad fechaReg.
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
     * Define el valor de la propiedad fechaReg.
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
     * Obtiene el valor de la propiedad hora.
     * 
     */
    public int getHora() {
        return hora;
    }

    /**
     * Define el valor de la propiedad hora.
     * 
     */
    public void setHora(int value) {
        this.hora = value;
    }

    /**
     * Obtiene el valor de la propiedad imagen.
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
     * Define el valor de la propiedad imagen.
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
     * Obtiene el valor de la propiedad maxSocios.
     * 
     */
    public int getMaxSocios() {
        return maxSocios;
    }

    /**
     * Define el valor de la propiedad maxSocios.
     * 
     */
    public void setMaxSocios(int value) {
        this.maxSocios = value;
    }

    /**
     * Obtiene el valor de la propiedad minSocios.
     * 
     */
    public int getMinSocios() {
        return minSocios;
    }

    /**
     * Define el valor de la propiedad minSocios.
     * 
     */
    public void setMinSocios(int value) {
        this.minSocios = value;
    }

    /**
     * Obtiene el valor de la propiedad minuto.
     * 
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * Define el valor de la propiedad minuto.
     * 
     */
    public void setMinuto(int value) {
        this.minuto = value;
    }

    /**
     * Obtiene el valor de la propiedad nomAct.
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
     * Define el valor de la propiedad nomAct.
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
     * Obtiene el valor de la propiedad nomProfesor.
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
     * Define el valor de la propiedad nomProfesor.
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
     * Obtiene el valor de la propiedad nombre.
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
     * Define el valor de la propiedad nombre.
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
     * Obtiene el valor de la propiedad sorteados.
     * 
     */
    public boolean isSorteados() {
        return sorteados;
    }

    /**
     * Define el valor de la propiedad sorteados.
     * 
     */
    public void setSorteados(boolean value) {
        this.sorteados = value;
    }

    /**
     * Obtiene el valor de la propiedad url.
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
     * Define el valor de la propiedad url.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Obtiene el valor de la propiedad urlVideo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlVideo() {
        return urlVideo;
    }

    /**
     * Define el valor de la propiedad urlVideo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlVideo(String value) {
        this.urlVideo = value;
    }

}
