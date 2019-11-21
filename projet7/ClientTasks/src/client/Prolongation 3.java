
package client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour prolongation complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="prolongation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="titrelivre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prolongation", propOrder = {
    "email",
    "nombre",
    "titrelivre"
})
public class Prolongation {

    protected String email;
    protected int nombre;
    protected String titrelivre;

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

}
