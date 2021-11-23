
package publicadores;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para wrapperListaUsuarios complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="wrapperListaUsuarios">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listaUsuarioss" type="{http://Publicadores/}infoBasicaSocio" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wrapperListaUsuarios", propOrder = {
    "listaUsuarioss"
})
public class WrapperListaUsuarios {

    @XmlElement(nillable = true)
    protected List<InfoBasicaSocio> listaUsuarioss;

    /**
     * Gets the value of the listaUsuarioss property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaUsuarioss property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaUsuarioss().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InfoBasicaSocio }
     * 
     * 
     */
    public List<InfoBasicaSocio> getListaUsuarioss() {
        if (listaUsuarioss == null) {
            listaUsuarioss = new ArrayList<InfoBasicaSocio>();
        }
        return this.listaUsuarioss;
    }

}
