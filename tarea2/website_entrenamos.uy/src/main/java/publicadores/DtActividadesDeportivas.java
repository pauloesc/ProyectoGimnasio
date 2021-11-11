
package publicadores;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtActividadesDeportivas complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtActividadesDeportivas">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clases" type="{http://Publicadores/}dtClase" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://Publicadores/}estadoActi" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtActividadesDeportivas", propOrder = {
    "clases",
    "estado"
})
public class DtActividadesDeportivas {

    @XmlElement(nillable = true)
    protected List<DtClase> clases;
    @XmlSchemaType(name = "string")
    protected EstadoActi estado;

    /**
     * Gets the value of the clases property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clases property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClases().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtClase }
     * 
     * 
     */
    public List<DtClase> getClases() {
        if (clases == null) {
            clases = new ArrayList<DtClase>();
        }
        return this.clases;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link EstadoActi }
     *     
     */
    public EstadoActi getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoActi }
     *     
     */
    public void setEstado(EstadoActi value) {
        this.estado = value;
    }

}
