
package publicadores;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for estadoActi.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="estadoActi">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACEPTADA"/>
 *     &lt;enumeration value="RECHAZADA"/>
 *     &lt;enumeration value="INGRESADA"/>
 *     &lt;enumeration value="FINALIZADA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "estadoActi")
@XmlEnum
public enum EstadoActi {

    ACEPTADA,
    RECHAZADA,
    INGRESADA,
    FINALIZADA;

    public String value() {
        return name();
    }

    public static EstadoActi fromValue(String v) {
        return valueOf(v);
    }

}
