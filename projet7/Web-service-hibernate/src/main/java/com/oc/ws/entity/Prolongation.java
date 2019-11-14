package com.oc.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name="prolongation")
public class Prolongation {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column
    private String email;
    @Column
    private String titrelivre;
    @Column
    private int nombre;


    public Prolongation() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Prolongation(String email, String titrelivre, int nombre) {
        super();
        this.email = email;
        this.titrelivre = titrelivre;
        this.nombre = nombre;
       
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
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

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

    
    
}
