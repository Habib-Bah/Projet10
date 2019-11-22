package com.opendevup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimerTask;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import client.BibliotequeVilleWS;
import client.BibliothequeService;
import client.IOException_Exception;
import client.Livre;
import client.Rappel;
import client.Reservation;
import client.Reservations;
import client.Utilisateur;

public class SchedulerMain extends TimerTask {

	Date current;
	int cnt = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub

		BibliothequeService livreS = new BibliothequeService();
		BibliotequeVilleWS bib = livreS.getBibliotequeVilleWSPort();

		List<Reservation> prets = new ArrayList<>();
		List<Reservations> reservations = new ArrayList<>();
		try {
			prets = bib.listPret();
		} catch (IOException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reservations = bib.listAttente();
		} catch (IOException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Utilisateur> users = new ArrayList<>();
		try {
			users = bib.listUser();
		} catch (IOException_Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		List<Rappel> listeRappel = new ArrayList<>();
		try {
			listeRappel = bib.listerappel();
		} catch (IOException_Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		List<Livre> listeLivre = new ArrayList<>();
		try {
			listeLivre = bib.listedeslivres();
		} catch (IOException_Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (Reservation p : prets) {

			for (Utilisateur u : users) {

				if (p.getEmail().equalsIgnoreCase(u.getEmail())) {

					final String username = "habibelmundo@gmail.com";
					final String password = "aeoneflux14";

					Properties props = new Properties();
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.port", "587");
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.starttls.enable", "true");

					Session session = Session.getInstance(props, new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					});

					try {

						Message message = new MimeMessage(session);
						message.setFrom(new InternetAddress("habibelmundo@gmail.com"));
						message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(u.getEmail()));
						message.setSubject("Retour de pret");
						message.setText("Bonjour " + p.getPrenom() + ", votre pret pour le livre " + p.getTitrelivre()
								+ " prend fin le " + p.getDatefin()
								+ ". N'oubliez pas de retourner votre pret avant cette date. Bien cordialement");

						Transport.send(message);

						System.out.println("Envoyé avec succès");

					} catch (MessagingException e) {
						e.printStackTrace();
					}
				}
			}
		}

		for (Reservations p : reservations) {

			for (Utilisateur u : users) {

				if (p.getEmail().equalsIgnoreCase(u.getEmail())) {

					final String username = "habibelmundo@gmail.com";
					final String password = "aeoneflux14";

					Properties props = new Properties();
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.port", "587");
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.starttls.enable", "true");

					Session session = Session.getInstance(props, new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					});

					try {

						Message message = new MimeMessage(session);
						message.setFrom(new InternetAddress("habibelmundo@gmail.com"));
						message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(u.getEmail()));
						message.setSubject("Disponibilité de pret");
						message.setText("Bonjour " + p.getPrenom() + ", vous êtes en position numero " + p.getNumero()
								+ " pour la reservation du livre " + p.getTitrelivre()
								+ ". Nous vous enverrons des mails quotidiennement pour vous prevenir si le livre est disponible. Bien cordialement");

						Transport.send(message);

						System.out.println("Envoyé avec succès");

					} catch (MessagingException e) {
						e.printStackTrace();
					}
				}
			}
		}

		for (Reservations res : reservations) {

			String pattern = "dd/MM/yyyy";
			DateFormat df = new SimpleDateFormat(pattern);
			Date today = Calendar.getInstance().getTime();
			String daterappel = df.format(today);
			today.setDate(today.getDate() + 1);
			String datefin = df.format(today);
			
			for (Livre l : listeLivre) {
				if(l.getNombreexemplaire() >= 1 && l.getTitre().equalsIgnoreCase(res.getTitrelivre()) && res.getNumero() == 1) {
						
					
					try {
						bib.envoyerRappel(res.getEmail(), res.getTitrelivre(), daterappel);
					} catch (IOException_Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					final String username = "habibelmundo@gmail.com";
					final String password = "aeoneflux14";

					Properties props = new Properties();
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.port", "587");
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.starttls.enable", "true");

					Session session = Session.getInstance(props, new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					});

					try {

						Message message = new MimeMessage(session);
						message.setFrom(new InternetAddress("habibelmundo@gmail.com"));
						message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(res.getEmail()));
						message.setSubject("Disponibilité de pret");
						message.setText("Bonjour " + res.getPrenom() + ", le livre " + res.getTitrelivre()  + "que vous avez reservé est disponible."
								+ " vous avez 48h pour venir le chercher. Passé ce delais, vous ne serez plus prioritaire sur ce livre. Bien cordialement.");

						Transport.send(message);

						System.out.println("Envoyé avec succès");

					} catch (MessagingException e) {
						e.printStackTrace();
					}
				}
					
			}
		}


		for(Rappel rap : listeRappel) {
			
			String pattern = "dd/MM/yyyy";
			DateFormat df = new SimpleDateFormat(pattern);
			Date today = Calendar.getInstance().getTime();
			String daterappel = df.format(today);
			today.setDate(today.getDate() + 2);
			String datefin = df.format(today);
			List<Reservations> listr = new ArrayList<>();
			
			if(rap.getDaterappel().compareTo(datefin) == 0) {
				
				try {
					
					listr = bib.listAttente();
					
					for(Reservations reser1 : listr) {
						Reservations finale = new Reservations();
						finale.setEmail(reser1.getEmail());
						finale.setNomutilisateur(reser1.getNomutilisateur());
						finale.setPrenom(reser1.getPrenom());
						finale.setTitrelivre(reser1.getTitrelivre());
						finale.setNumero(reser1.getNumero());
						finale.setCode(reser1.getCode());
						if (finale.getNumero() == 1) {

							bib.supprimerRappel(rap.getEmail(), rap.getTitrelivre());
						} else {
							bib.supprimerReservations(finale.getEmail(), finale.getTitrelivre());
							bib.reserverEnAvance(finale.getNomutilisateur(), finale.getPrenom(),
									finale.getTitrelivre(), finale.getEmail(), finale.getCode(),
									finale.getNumero() - 1);
						}
					}
					
				} catch (IOException_Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
