package com.opendevup.controller;

import java.text.DateFormat;
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
import client.Reservation;
import client.Reservations;
import client.Retour;
import client.Utilisateur;;

@Controller
public class EmployeController {

	@RequestMapping(value = "/Utilisateurs")
	public String Utilisateurs(Model model) throws IOException_Exception {

		BibliothequeService livreS = new BibliothequeService();
		BibliotequeVilleWS bib = livreS.getBibliotequeVilleWSPort();

		java.util.List<Utilisateur> user;
		user = bib.listUser();

		model.addAttribute("listusers", user);

		return "listUsers";
	}

	@RequestMapping(value = "/ConnexionEmploye", method = RequestMethod.GET)
	public String ConnexionEmploye(Model model) {

		model.addAttribute("appuser", new AppUser());
		return "connexionEmploye";
	}

	@RequestMapping(value = "/ConnexionE", method = RequestMethod.GET)
	public String ConnexionE(Model model) {

		model.addAttribute("appuser", new AppUser());
		return "connexionE";
	}

	@RequestMapping(value = "/loginEmploye", method = RequestMethod.POST)
	public String loginEmploye(Model model, AppUser u) throws IOException_Exception {

		BibliothequeService livreS = new BibliothequeService();
		BibliotequeVilleWS bib = livreS.getBibliotequeVilleWSPort();

		java.util.List<Utilisateur> user;
		user = bib.listUser();

		boolean res = bib.connexion(u.getEmail(), u.getEncrytedPassword());

		if (res == true) {

			for (Utilisateur us : user) {
				if (us.getEmail().equalsIgnoreCase(u.getEmail())) {
					if (us.getRole().equalsIgnoreCase("admin")) {
						return "pageEmploye";
					}

					else {
						return "ErreurCEE";
					}
				}
			}
		}

		return "ErreurCE";
	}

	@RequestMapping(value = "/PretEmployee")
	public String PretEmployee(Model model) throws IOException_Exception {

		BibliothequeService livreS = new BibliothequeService();
		BibliotequeVilleWS bib = livreS.getBibliotequeVilleWSPort();

		java.util.List<Reservation> pret = new ArrayList<>();
		pret = bib.listPret();

		model.addAttribute("listprets", pret);

		return "PretEmployee";
	}

	@RequestMapping(value = "/RetourE", method = RequestMethod.GET)
	public String RetourE(Model model) {

		model.addAttribute("retour", new Retour());
		return "retourE";
	}

	@RequestMapping(value = "/SaveRetourE", method = RequestMethod.POST)
	public String SaveRetourE(Model model, Retour r) throws IOException_Exception {

		client.BibliothequeService livreS = new client.BibliothequeService();
		client.BibliotequeVilleWS bib = livreS.getBibliotequeVilleWSPort();

		java.util.List<Reservation> pret = new ArrayList<>();
		pret = bib.listPret();

		for (Reservation p : pret) {

			if (p.getEmail().equalsIgnoreCase(r.getEmail()) && p.getTitrelivre().equalsIgnoreCase(r.getTitrelivre())) {
				bib.retour(r.getEmail(), r.getTitrelivre());
				List<Livre> listeL = bib.listedeslivres();

				for (Livre li : listeL) {
					if (li.getTitre().equalsIgnoreCase(r.getTitrelivre())) {

						Livre livre = new Livre();
						livre.setAuteur(li.getAuteur());
						livre.setCategorie(li.getCategorie());
						livre.setTitre(li.getTitre());
						livre.setNombredepages(li.getNombredepages());
						livre.setNombreexemplaire(li.getNombreexemplaire() + 1);
						bib.supprimerLivre(r.getTitrelivre());
						bib.ajouterLivre(livre.getTitre(), livre.getNombredepages(), livre.getCategorie(),
								livre.getAuteur(), livre.getNombreexemplaire());
					}
				}

				return "SaveRetourE";
			}
		}

		return "erreurRetourE";

	}

	@RequestMapping(value = "/DeconnectionEmploye")
	public String DeconnectionEmploye(Model model) {

		return "deconnection";
	}

	@RequestMapping(value = "/ReservationEmploye")
	public String reservationEmploye(Model model) {

		model.addAttribute("reservation", new Reservation());
		return "reservationEmploye";
	}

	@RequestMapping(value = "/SaveRE")
	public String SaveRE(Model model, Reservation r) throws IOException_Exception {

		client.BibliothequeService livreS = new client.BibliothequeService();
		client.BibliotequeVilleWS bib = livreS.getBibliotequeVilleWSPort();

		List<Reservation> prets = new ArrayList<>();
		List<Utilisateur> users = new ArrayList<>();
		List<Livre> listeL = new ArrayList<>();
		List<Reservations> listeAtt = new ArrayList<>();

		prets = bib.listPret();
		users = bib.listUser();

		for (Reservation p : prets) {

			if (p.getEmail().equalsIgnoreCase(r.getEmail()) && p.getTitrelivre().equalsIgnoreCase(r.getTitrelivre())) {

				return "LivreDejaReserve";
			}
		}

		for (Utilisateur u : users) {

			if (u.getEmail().equalsIgnoreCase(r.getEmail()) && u.getCode().equals(r.getCode())) {
				String pattern = "dd/MM/yyyy";
				DateFormat df = new SimpleDateFormat(pattern);
				Date today = Calendar.getInstance().getTime();
				String datedebut = df.format(today);
				today.setMonth(today.getMonth() + 1);
				String datefin = df.format(today);
				listeL = bib.listedeslivres();
				listeAtt = bib.listAttente();

				for (Livre l : listeL) {

					if (l.getTitre().equalsIgnoreCase(r.getTitrelivre())) {
						if (l.getNombreexemplaire() == 0) {

							if (listeAtt.isEmpty()) {
								bib.reserverEnAvance(r.getNomutilisateur(), r.getPrenom(), r.getTitrelivre(),
										r.getEmail(), r.getCode(), 1);

							} else {
								Reservations res = (Reservations) listeAtt.get(listeAtt.size() - 1);
								bib.reserverEnAvance(r.getNomutilisateur(), r.getPrenom(), r.getTitrelivre(),
										r.getEmail(), r.getCode(), res.getNumero() + 1);
							}

							return "pasdexemplaire";
						}

						else {
							Livre livre = new Livre();
							livre.setAuteur(l.getAuteur());
							livre.setCategorie(l.getCategorie());
							livre.setTitre(l.getTitre());
							livre.setNombredepages(l.getNombredepages());
							livre.setNombreexemplaire(l.getNombreexemplaire() - 1);

							bib.supprimerLivre(r.getTitrelivre());
							bib.ajouterLivre(livre.getTitre(), livre.getNombredepages(), livre.getCategorie(),
									livre.getAuteur(), l.getNombreexemplaire() - 1);
							bib.reserver(r.getNomutilisateur(), r.getPrenom(), r.getTitrelivre(), datedebut, datefin,
									r.getEmail(), r.getCode());
							listeL = bib.listedeslivres();
							return "confirmRE";

						}
					}

				}

			}
		}

		return "noEmail";

	}

	@RequestMapping(value = "/PolongerPourClient", method = RequestMethod.GET)
	public String polongerPourClient(Model model) {

		model.addAttribute("reservation", new Reservation());
		return "polongerPourClient";
	}

	@RequestMapping(value = "/EProlonger", method = RequestMethod.POST)
	public String EProlonger(Model model, Reservation r) throws IOException_Exception {

		client.BibliothequeService livreS = new client.BibliothequeService();
		client.BibliotequeVilleWS bib = livreS.getBibliotequeVilleWSPort();

		List<Reservation> Res = new ArrayList();
		List<Utilisateur> users = new ArrayList();
		List<Livre> listeL = new ArrayList<>();

		Res = bib.listPret();
		users = bib.listUser();

		for (Reservation p : Res) {

			String pattern = "dd/MM/yyyy";
			DateFormat df = new SimpleDateFormat(pattern);
			Date today = Calendar.getInstance().getTime();
			String datedebut = df.format(today);
			today.setMonth(today.getMonth() + 1);
			String datefin = df.format(today);

			if (p.getEmail().equalsIgnoreCase(r.getEmail()) && p.getTitrelivre().equalsIgnoreCase(r.getTitrelivre())) {

				if (p.getDatefin().compareTo(datedebut) < 0) {

					return "datefinpasarrivee";
				}
				if (p.getDatefin().compareTo(datedebut) == 0 || p.getDatefin().compareTo(datedebut) > 0) {

					listeL = bib.listedeslivres();
					Livre livre = new Livre();

					for (Livre l : listeL) {

						if (l.getTitre().equalsIgnoreCase(p.getTitrelivre())) {

							livre.setAuteur(l.getAuteur());
							livre.setCategorie(l.getCategorie());
							livre.setTitre(l.getTitre());
							livre.setNombredepages(l.getNombredepages());
							livre.setNombreexemplaire(l.getNombreexemplaire() - 1);

						}

					}

					bib.retour(r.getEmail(), r.getTitrelivre());
					bib.supprimerLivre(r.getTitrelivre());
					bib.ajouterLivre(livre.getTitre(), livre.getNombredepages(), livre.getCategorie(),
							livre.getAuteur(), livre.getNombreexemplaire());
					bib.reserver(r.getNomutilisateur(), r.getPrenom(), r.getTitrelivre(), datedebut, datefin,
							r.getEmail(), r.getCode());

					return "confirmationPE";
				}
			}

		}

		return "mauvaisEMailE";

	}

	@RequestMapping(value = "/Horaires")
	public String Horaires(Model model) {

		return "Horaires";
	}

	@RequestMapping(value = "/PageEmploye")
	public String PageEmploye(Model model) {

		return "pageEmploye";
	}

}
