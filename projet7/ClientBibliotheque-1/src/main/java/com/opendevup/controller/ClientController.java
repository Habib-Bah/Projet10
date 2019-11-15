package com.opendevup.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.opendevup.model.AppUser;

import client.BibliotequeVilleWS;
import client.BibliothequeService;
import client.IOException_Exception;
import client.Livre;
import client.Pret;
import client.Prolongation;
import client.Reservation;
import client.Reservations;
import client.Retour;
import client.Utilisateur;


@Controller
public class ClientController {

	@RequestMapping(value = "/Inscription", method = RequestMethod.GET)
	public String formUser(Model model) {

		model.addAttribute("appuser", new AppUser());
		return "inscriptionform";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Model model, AppUser u) throws IOException_Exception {

		BibliothequeService livreS = new BibliothequeService();
		BibliotequeVilleWS bib = livreS.getBibliotequeVilleWSPort();
		
		List<Utilisateur> listeU= bib.listUser();
		
		for(Utilisateur ut : listeU) {
			
			if(ut.getCode().equals(u.getCode())) {
				return "mauvaisCode";
			}
			if(ut.getEmail().equals(u.getEmail())) {
				return "mauvaisE";
			
		}
			
	 }
		
		

		bib.inscription(u.getUserName(), u.getPrenom(), u.getEmail(), u.getEncrytedPassword(), "user", u.getCode());

		return "resultatInscription";
	}
	
	@RequestMapping(value = "/Connexion", method = RequestMethod.GET)
	public String Connexion(Model model) {

		model.addAttribute("appuser", new AppUser());
		return "connexion";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, AppUser u) throws IOException_Exception {

		BibliothequeService livreS = new BibliothequeService();
		BibliotequeVilleWS bib = livreS.getBibliotequeVilleWSPort();

		boolean res = bib.connexion(u.getEmail(), u.getEncrytedPassword());

		if (res == true) {
			List <Livre> listelivre = new ArrayList();
			listelivre = bib.listedeslivres();
			model.addAttribute("listelivre", listelivre);
			
			return "listeL";
		}

		else {
			return "erreurC";
		}

	}
	
	
	@RequestMapping(value = "/ListeL", method = RequestMethod.GET)
	public String ListeL(Model model) throws IOException_Exception {
		
		BibliothequeService livreS = new BibliothequeService();
		BibliotequeVilleWS bib = livreS.getBibliotequeVilleWSPort();
		
		List <Livre> listelivre = new ArrayList();
		listelivre = bib.listedeslivres();
		model.addAttribute("listelivre", listelivre);
		
		return "listeL";
	}
	
	@RequestMapping(value = "/reserV", method = RequestMethod.POST)
	public String reserV(Model model, AppUser u) {

		BibliothequeService livreS = new BibliothequeService();
		BibliotequeVilleWS bib = livreS.getBibliotequeVilleWSPort();

		return "resultatReservation";
	}
	
	@RequestMapping(value = "/Livre")
	public String ListLivre(Model model) {

		return "livre";
	}
	
	@RequestMapping(value = "/Deconnection")
	public String Deconnection(Model model) {

		return "deconnection";
	}
	
	@RequestMapping(value = "/Reservation", method = RequestMethod.GET)
	public String Reservation(Model model) {
		
		
		model.addAttribute("reservation", new Reservation());
		
		return "reservations";
	}
	
	@RequestMapping(value = "/findReservation", method = RequestMethod.POST)
	public String findReservation(Model model, Reservation r) throws IOException_Exception {

		client.BibliothequeService livreS = new client.BibliothequeService();
		client.BibliotequeVilleWS bib = livreS.getBibliotequeVilleWSPort();
	
		
		
		java.util.List<Reservation> pret = new ArrayList<>();
		pret = bib.listPret();
		java.util.List<Pret>  prets = new ArrayList<>();
		
		for(Reservation p : pret) {
			if(p.getCode().equalsIgnoreCase(r.getCode())) {
				Pret pr = new Pret();
				pr.setNomutilisateur(p.getNomutilisateur());
				pr.setPrenom(r.getPrenom());
				pr.setEmail(p.getEmail());
				pr.setTitrelivre(p.getTitrelivre());
				pr.setDatedebut(pr.getDatedebut());
				pr.setDatefin(p.getDatefin());
				pr.setCode(p.getCode());
				prets.add(pr);
				
				
			}
		}
		
		model.addAttribute("prets", prets);
		
		return "resultReservation";
		
		
	}
	
	
	@RequestMapping(value = "/Retour", method = RequestMethod.GET)
	public String touverpret(Model model) {
		
		model.addAttribute("retour", new Retour());
		
		return "RetourDePret";
	}
	
	@RequestMapping(value = "/SaveRetour", method = RequestMethod.POST)
	public String SaveRetour(Model model, Retour r) throws IOException_Exception {

		
		client.BibliothequeService livreS = new client.BibliothequeService();
		client.BibliotequeVilleWS bib = livreS.getBibliotequeVilleWSPort();
		
		java.util.List<Reservation> pret = new ArrayList<>();
		pret = bib.listPret();
		
		for(Reservation p : pret) {
			
			
			if(p.getEmail().equalsIgnoreCase(r.getEmail()) && p.getTitrelivre().equalsIgnoreCase(r.getTitrelivre())) {
				bib.retour(r.getEmail(), r.getTitrelivre());
				List<Livre> listeL = bib.listedeslivres();
				
				for(Livre li : listeL) {
					if(li.getTitre().equalsIgnoreCase(r.getTitrelivre())) {
						
						
						Livre livre = new Livre();
						livre.setAuteur(li.getAuteur());
						livre.setCategorie(li.getCategorie());
						livre.setTitre(li.getTitre());
						livre.setNombredepages(li.getNombredepages());
						livre.setNombreexemplaire(li.getNombreexemplaire() + 1);
						bib.supprimerLivre(r.getTitrelivre());
						bib.ajouterLivre(livre.getTitre(), livre.getNombredepages(), livre.getCategorie(), livre.getAuteur(), livre.getNombreexemplaire());
						bib.supprimerprolongation(r.getEmail(), r.getTitrelivre());
					}
				}
				
				return "confirmRetour";
			}
		}
		
		
		
		return "erreurRetour";
		
		
	}
	
	
	@RequestMapping(value = "/Sport")
	public String Sport(Model model) {

		return "sport";
	}
	
	@RequestMapping(value = "/Musique")
	public String Musique(Model model) {

		return "musique";
	}
	
	
	@RequestMapping(value = "/index")
	public String listeL(Model model) {

		return "index";
	}
	
	@RequestMapping(value = "/acceuil")
	public String acceuil(Model model) {

		return "listeL";
	}
	
	@RequestMapping(value = "/RetourDePret", method = RequestMethod.GET)
	public String RetourDePret(Model model, String titrelivre) {

		model.addAttribute("retour", new Retour());
		Livre l = new Livre();
		l.setTitre(titrelivre);
		model.addAttribute("titrelivre", l.getTitre());
		return "RetourDePret";
	}
	
	@RequestMapping(value = "/ConfirmRetourDePret", method = RequestMethod.POST)
	public String ConfirmRetourDePret(Model model, Retour r) throws IOException_Exception {
		
		client.BibliothequeService livreS = new client.BibliothequeService();
		client.BibliotequeVilleWS bib = livreS.getBibliotequeVilleWSPort();
		
		bib.retour(r.getEmail(), r.getTitrelivre());
		bib.supprimerprolongation(r.getEmail(), r.getTitrelivre());
		
		
		return "ConfirmRetourDePret";
		
	}
	
	@RequestMapping(value = "/reserver", method = RequestMethod.GET)
	public String reserver(Model model) throws IOException_Exception {
		
		BibliothequeService livreS = new BibliothequeService();
		BibliotequeVilleWS bib = livreS.getBibliotequeVilleWSPort();
		
		List <Livre> listelivre = new ArrayList();
		listelivre = bib.listedeslivres();
		model.addAttribute("listelivre", listelivre);
		model.addAttribute("reservation", new Reservation()); 

		return "reserver";
	}
	
	@RequestMapping(value = "/CReserver", method = RequestMethod.POST)
	public String CReserver(Model model, Reservation r) throws IOException_Exception {
		
		client.BibliothequeService livreS = new client.BibliothequeService();
		client.BibliotequeVilleWS bib = livreS.getBibliotequeVilleWSPort();
		
		
		
		List <Reservation> prets = new ArrayList<>();
		List <Utilisateur> users = new ArrayList<>();
		List <Livre> listeL = new ArrayList<>();
		List<Reservations> listeAtt= new ArrayList<>();
		
		prets = bib.listPret();
		users = bib.listUser();
		
		
		for(Reservation p : prets) {
			
			if(p.getEmail().equalsIgnoreCase(r.getEmail()) && p.getTitrelivre().equalsIgnoreCase(r.getTitrelivre())) {
				
				return "LivreDejaReserve";
			}
		}
		
	
		
		for(Utilisateur u : users) {
			
			
			
			if(u.getEmail().equalsIgnoreCase(r.getEmail()) && u.getCode().equals(r.getCode())) {
				String pattern = "dd/MM/yyyy";
				DateFormat df = new SimpleDateFormat(pattern);
				Date today = Calendar.getInstance().getTime();
				String datedebut = df.format(today);
				today.setMonth(today.getMonth() + 1);
				String datefin = df.format(today);
				listeL = bib.listedeslivres();
				listeAtt = bib.listAttente();
				
				for(Livre l : listeL) {
					
					if(l.getTitre().equalsIgnoreCase(r.getTitrelivre())) {
						if(l.getNombreexemplaire() == 0) {
							
						
							if(listeAtt.isEmpty()) {
								bib.reserverEnAvance(r.getNomutilisateur(), r.getPrenom(), r.getTitrelivre(), r.getEmail(), r.getCode(), 1);
								
							}
							else {
								Reservations res = (Reservations) listeAtt.get(listeAtt.size() - 1);
								bib.reserverEnAvance(r.getNomutilisateur(), r.getPrenom(), r.getTitrelivre(), r.getEmail(), r.getCode(), res.getNumero() + 1);
							}
													
							return "pasdexemplaire";
						}
						
						if(!l.getTitre().equalsIgnoreCase(r.getTitrelivre())) {
							
							if(l.getNombreexemplaire() == 0) {
								
								
								if(listeAtt.isEmpty()) {
									bib.reserverEnAvance(r.getNomutilisateur(), r.getPrenom(), r.getTitrelivre(), r.getEmail(), r.getCode(), 1);
									
								}
								else {
									Reservations res = (Reservations) listeAtt.get(listeAtt.size() - 1);
									bib.reserverEnAvance(r.getNomutilisateur(), r.getPrenom(), r.getTitrelivre(), r.getEmail(), r.getCode(), res.getNumero() + 1);
								}
														
								return "pasdexemplaire";
							}
						}
						
					}
							Livre livre = new Livre();
							livre.setAuteur(l.getAuteur());
							livre.setCategorie(l.getCategorie());
							livre.setTitre(l.getTitre());
							livre.setNombredepages(l.getNombredepages());
							livre.setNombreexemplaire(l.getNombreexemplaire() - 1);
							
							bib.supprimerLivre(r.getTitrelivre());
							bib.ajouterLivre(livre.getTitre(), livre.getNombredepages(), livre.getCategorie(), livre.getAuteur(), l.getNombreexemplaire() - 1);
							bib.reserver(r.getNomutilisateur(), r.getPrenom(), r.getTitrelivre(), datedebut , datefin, r.getEmail(), r.getCode());
							listeL = bib.listedeslivres();
							return "ConfReser";

					
				}	
				
			}
		}
		
		
		return"noEmail";
		
	}
	
	
	@RequestMapping(value = "/Prolonger", method = RequestMethod.GET)
	public String Prolonger(Model model) {

		model.addAttribute("reservation", new Reservation());
		return "prolonger";
	}
	
	@RequestMapping(value = "/CProlonger", method = RequestMethod.POST)
	public String CProlonger(Model model, Reservation r) throws IOException_Exception, ParseException {
		
		client.BibliothequeService livreS = new client.BibliothequeService();
		client.BibliotequeVilleWS bib = livreS.getBibliotequeVilleWSPort();
		
		
		List <Reservation> Res = new ArrayList();
		List <Utilisateur> users = new ArrayList();
		List <Livre> listeL = new ArrayList<>();
		
		Res = bib.listPret();
		users = bib.listUser();
		
			
		for(Reservation p : Res) {
		
		
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        String dateInString = p.getDatefin();

	        

	            Date today = formatter.parse(dateInString);
	            String datedebut = formatter.format(today);
				today.setMonth(today.getMonth() + 1);
				String datefin = formatter.format(today);
	           
	     	
			if(p.getEmail().equalsIgnoreCase(r.getEmail()) && p.getTitrelivre().equalsIgnoreCase(r.getTitrelivre())) {
				
				
				if(p.getDatefin().compareTo(datedebut) < 0) {
					
					return "datefinpasarrivee"; 
				}
				 if(p.getDatefin().compareTo(datedebut) == 0 || p.getDatefin().compareTo(datedebut) > 0) {
					
					 /*******************/
					 List<Prolongation> listePr = bib.listeprolongations();
					 
					 if(listePr.isEmpty()) {
						 listeL = bib.listedeslivres();
						    Livre livre = new Livre();
						   
						    for(Livre l : listeL) {
						    	
						    	if(l.getTitre().equalsIgnoreCase(p.getTitrelivre())) {
						    		
						    		
									livre.setAuteur(l.getAuteur());
									livre.setCategorie(l.getCategorie());
									livre.setTitre(l.getTitre());
									livre.setNombredepages(l.getNombredepages());
									livre.setNombreexemplaire(l.getNombreexemplaire() - 1);
									
						    	}
						    	
						    }
						
							bib.retour(r.getEmail(), r.getTitrelivre());
							bib.reserver(r.getNomutilisateur(), r.getPrenom(), r.getTitrelivre(), datedebut, datefin, r.getEmail(), r.getCode());
							bib.prolongations(r.getEmail(), r.getTitrelivre(), 1);
							
							
						return "confirmationP";
					 }
					 
					 
					 if(!listePr.isEmpty()) {
						 
						 for(Prolongation prolon : listePr) {
							 if(prolon.getEmail().equalsIgnoreCase(p.getEmail()) && prolon.getTitrelivre().equalsIgnoreCase(p.getTitrelivre())) {
								 
								 if(prolon.getNombre() > 4) {
									 return"nombredeProlongationAtteint";
								 }
								 
								 if(prolon.getNombre() <= 4) {
									 
									 listeL = bib.listedeslivres();
									   
										bib.retour(r.getEmail(), r.getTitrelivre());
										bib.reserver(r.getNomutilisateur(), r.getPrenom(), r.getTitrelivre(), datedebut, datefin, r.getEmail(), r.getCode());
										
										int nbre = prolon.getNombre();
										bib.supprimerprolongation(r.getEmail(), r.getTitrelivre());
										bib.prolongations(r.getEmail(), r.getTitrelivre(), nbre + 1);
										
									return "confirmationP";
								 }
								 
							 }
							 
							 if(prolon.getEmail().equalsIgnoreCase(p.getEmail()) && !prolon.getTitrelivre().equalsIgnoreCase(p.getTitrelivre())) {
							
								 	bib.retour(r.getEmail(), r.getTitrelivre());
									bib.reserver(r.getNomutilisateur(), r.getPrenom(), r.getTitrelivre(), datedebut, datefin, r.getEmail(), r.getCode());
									bib.prolongations(r.getEmail(), r.getTitrelivre(), 1);
									
							 }
						 }
						 
					}
				}
			
			}
					 
		}
					 
		
		return "mauvaisEMail";
	}
}
