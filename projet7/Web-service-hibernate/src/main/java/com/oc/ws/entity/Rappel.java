package com.oc.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name="rappel")
public class Rappel {

	private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column
    private String email;
    @Column
    private String titrelivre;
    @Column
    private String daterappel;
    
	public Rappel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rappel(String email, String titrelivre, String daterappel) {
		super();
		this.email = email;
		this.titrelivre = titrelivre;
		this.daterappel = daterappel;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitrelivre() {
		return titrelivre;
	}
	public void setTitrelivre(String titrelivre) {
		this.titrelivre = titrelivre;
	}
	public String getDaterappel() {
		return daterappel;
	}
	public void setDaterappel(String daterappel) {
		this.daterappel = daterappel;
	}
    
}
