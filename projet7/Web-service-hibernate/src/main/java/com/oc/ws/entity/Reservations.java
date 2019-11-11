package com.oc.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name="reservations")
public class Reservations {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String datedebut;
    @Column
    private String datefin;
    @Column
    private String nomutilisateur;
    @Column
    private String prenom;
    @Column
    private String titrelivre;
    @Column
    private String email;
    @Column
    private String code;
    @Column
    private int numero;


    public Reservations() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Reservations(String nomUtilisateur, String prenom, String titrelivre, String dateDeDebutDePret,
                       String dateDeFinDePret, String email) {
        super();
        this.datedebut = dateDeDebutDePret;
        this.prenom = prenom;
        this.datefin = dateDeFinDePret;
        nomutilisateur = nomUtilisateur;
        this.titrelivre = titrelivre;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomutilisateur() {
        return nomutilisateur;
    }

    public void setNomutilisateur(String nomutilisateur) {
        this.nomutilisateur = nomutilisateur;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public String getTitrelivre() {
        return titrelivre;
    }

    public void setTitrelivre(String titrelivre) {
        this.titrelivre = titrelivre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public  int getNumero() {
		return numero;
	}

	public  void setNumero(int numero) {
		this.numero = numero;
	}
    
    
}
