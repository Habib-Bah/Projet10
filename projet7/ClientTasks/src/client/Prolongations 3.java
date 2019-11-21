
package client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour prolongations complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="prolongations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="titrelivre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prolongations", propOrder = {
    "email",
    "titrelivre",
    "nombre"
})
public class Prolongations {

    protected String email;
    protected String titrelivre;
    protected int nombre;

    /**
     * Obtient la valeur de la propriété email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Définit la valeur de la propriété email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Obtient la valeur de la propriété titrelivre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitrelivre() {
        return titrelivre;
    }

    /**
     * Définit la valeur de la propriété titrelivre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitrelivre(String value) {
        this.titrelivre = value;
    }

    /**
     * Obtient la valeur de la propriété nombre.
     * 
     */
    public int getNombre() {
        return nombre;
    }

    /**
     * Définit la valeur de la propriété nombre.
     * 
     */
    public void setNombre(int value) {
        this.nombre = value;
    }

}
