
package client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour envoyerRappel complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="envoyerRappel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="titrelivre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="daterappel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "envoyerRappel", propOrder = {
    "email",
    "titrelivre",
    "daterappel"
})
public class EnvoyerRappel {

    protected String email;
    protected String titrelivre;
    protected String daterappel;

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
     * Obtient la valeur de la propriété daterappel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDaterappel() {
        return daterappel;
    }

    /**
     * Définit la valeur de la propriété daterappel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDaterappel(String value) {
        this.daterappel = value;
    }

}
