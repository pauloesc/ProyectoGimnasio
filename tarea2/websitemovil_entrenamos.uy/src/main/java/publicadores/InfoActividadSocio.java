
package publicadores;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para infoActividadSocio complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="infoActividadSocio">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Publicadores/}informacionActividad">
 *       &lt;sequence>
 *         &lt;element name="clases" type="{http://Publicadores/}dtClase" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "infoActividadSocio", propOrder = {
    "clases"
})
public class InfoActividadSocio
    extends InformacionActividad
{

    @XmlElement(nillable = true)
    protected List<DtClase> clases;

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

}
