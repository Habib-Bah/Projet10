package com.opendevup;

import java.util.ArrayList;
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
	}

}
