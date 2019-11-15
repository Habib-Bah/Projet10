package com.oc.ws.wsService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.oc.ws.config.Configuration;
import com.oc.ws.entity.Livre;
import com.oc.ws.entity.Prolongation;
import com.oc.ws.entity.Reservation;
import com.oc.ws.entity.Reservations;
import com.oc.ws.entity.Utilisateur;

@WebService(name = "BibliotequeVilleWS")
public class Bibliotheque {

	
	List<Utilisateur> utilisateurs = new ArrayList<>();
	List<Reservation> listreservation = new ArrayList<>();
	

	Connection connection;
	Statement statement;
	ResultSet result;

	// AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//	LivreService livreService = context.getBean(LivreService.class);
	// ReservationService reservationService =
	// context.getBean(ReservationService.class);
//	UtilisateurService utilisateurService = context.getBean(UtilisateurService.class);
	// PretService pretService = context.getBean(PretService.class);

	/*
	  
	  @WebMethod(operationName = "inscription") public void
	  inscription(@WebParam(name = "nom") String nom, @WebParam(name = "prenom")
	  String prenom,
	  
	  @WebParam(name = "email") String email, @WebParam(name = "motdepasse") String
	  motdepasse) throws IOException {
	  
	  try {
	  
	  Utilisateur utilisateur = new Utilisateur(nom, prenom, motdepasse, email);
	  
	  utilisateurService.add(utilisateur);
	  
	  } catch (Exception e) { e.printStackTrace(); }
	  
	  }
	  
	  
	  @WebMethod(operationName = "connexionEquipe") public boolean
	  connexionEquipe(@WebParam(name = "email") String email,
	  
	  @WebParam(name = "motdepasse") String motdepasse) throws IOException {
	  
	  boolean res = true;
	  
	  try {
	  
	  Utilisateur utilisateur = utilisateurService.connexion(email, motdepasse);
	  
	  if (utilisateurs != null) {
	  
	  return "admin".equalsIgnoreCase(utilisateur.getRole()); }
	  
	  } catch (Exception e) { e.printStackTrace(); } return res; }
	  
	 
*/
	
	@WebMethod(operationName = "inscription") 
	public void  inscription(@WebParam(name = "nom") String nom, @WebParam(name = "prenom")
	  String prenom, @WebParam(name = "email") String email, @WebParam(name = "motdepasse") String
	  motdepasse, @WebParam(name = "role") String role, @WebParam(name = "code") String code) throws IOException {
	  
		Configuration conf = new Configuration();

		try {

			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(conf.getMotDepasse());
			statement = connection.createStatement();
			String sql = "insert into utilisateur (nom, prenom, motdepasse, email, role, code) values ( '"
					+ nom + "', '" + prenom + "' ,'" + motdepasse + "', '" + email + "', '" + role +"', '" + code + "')";
			statement.executeQuery(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	
	@WebMethod(operationName = "connexionEquipe")
	public boolean connexionEquipe(@WebParam(name = "email") String email, @WebParam(name = "motdepasse") String motdepasse)
			throws IOException {

		boolean res = false;
		Configuration conf = new Configuration();

		try {

			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(conf.getMotDepasse());

			statement = connection.createStatement();
			String sql = "select * from utilisateur";
			result = statement.executeQuery(sql);

			while (result.next()) {

				if ((result.getString(1).equalsIgnoreCase(email))
						&& (result.getString(3).equalsIgnoreCase(motdepasse))) {
					res = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;

	}
	
	@WebMethod(operationName = "Listedeslivres")
	public List<Livre> getLivre() throws IOException {

		Configuration conf = new Configuration();
		List<Livre> livres = new ArrayList<>();

		try {

			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(conf.getMotDepasse());

			statement = connection.createStatement();
			result = statement.executeQuery("select * from livre");

			while (result.next()) {

				String auteur = result.getString(2);
				String titre = result.getString(3);
				int nombredepages = result.getInt(4);
				int nombreexemplaire = result.getInt(5);
				String categorie = result.getString(6);

				Livre l = new Livre();
				l.setAuteur(auteur);
				l.setTitre(titre);
				l.setNombredepages(nombredepages);
				l.setNombreexemplaire(nombreexemplaire);
				l.setCategorie(categorie);
				livres.add(l);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return livres;
	}

	@WebMethod(operationName = "reserver")
	public void pret(@WebParam(name = "Nomutilisateur") String nomutilisateur, @WebParam(name = "prenom") String prenom,
			@WebParam(name = "titrelivre") String titrelivre, @WebParam(name = "datedebut") String datedebut,
			@WebParam(name = "datefin") String datefin, @WebParam(name = "email") String email, @WebParam(name = "code") String code) throws IOException {

		Configuration conf = new Configuration();

		try {

			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(conf.getMotDepasse());
			statement = connection.createStatement();
			String sql = "insert into reservation (nomutilisateur, prenom, titrelivre, datedebut, datefin, email, code) values ( '"
					+ nomutilisateur + "', '" + prenom + "' ,'" + titrelivre + "', '" + datedebut + "', '" + datefin
					+ "', '" + email +"', '" + code + "')";
			statement.executeQuery(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@WebMethod(operationName = "USerReservation")
	public List USerReservation(@WebParam(name = "code") String code) throws IOException {

		// List<Reservation> listreservation = new ArrayList<>();
		Configuration conf = new Configuration();

		try {

			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(conf.getMotDepasse());
			statement = connection.createStatement();
			String sql = "(select * from reservation where code = '" + code + "')";
			result = statement.executeQuery(sql);

			while (result.next()) {
				if (result.getString(8).equalsIgnoreCase(code)) {
					Reservation r = new Reservation();
					r.setNomutilisateur(result.getString(2));
					r.setPrenom(result.getString(3));
					r.setTitrelivre(result.getString(4));
					r.setDatedebut(result.getString(5));
					r.setDatefin(result.getString(6));
					r.setEmail(result.getString(7));
					r.setCode(code);

					listreservation.add(r);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listreservation;
	}

	@WebMethod(operationName = "connexion")
	public boolean connexion(@WebParam(name = "email") String email, @WebParam(name = "motdepasse") String motdepasse)
			throws IOException {

		boolean res = false;
		Configuration conf = new Configuration();

		try {

			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(conf.getMotDepasse());

			statement = connection.createStatement();
			String sql = "select * from utilisateur";
			result = statement.executeQuery(sql);

			while (result.next()) {

				if ((result.getString(1).equalsIgnoreCase(email))
						&& (result.getString(3).equalsIgnoreCase(motdepasse))) {
					res = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;

	}

	@WebMethod(operationName = "prolongerpret")
	public void prolongerPret(@WebParam(name = "nom") String nomutilisateur, @WebParam(name = "prenom") String prenom,
			@WebParam(name = "titrelivre") String titrelivre, @WebParam(name = "datedebut") String datedebut,
			@WebParam(name = "datefin") String datefin, @WebParam(name = "email") String email,
			@WebParam(name = "code") String code) throws IOException {

		List<Reservation> listreservation = new ArrayList<>();
		Reservation reservation = new Reservation(nomutilisateur, prenom, titrelivre, datedebut, datefin, email, code);
		listreservation.add(reservation);

		Configuration conf = new Configuration();
		try {

			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(conf.getMotDepasse());
			statement = connection.createStatement();

			String sql1 = "delete from reservation where email like '" + email + "' and titrelivre like '" + titrelivre
					+ "'";
			statement.executeQuery(sql1);

			String sql = "insert into reservation (nomutilisateur, prenom, titrelivre, datedebut, datefin, email, code) values ( '"
					+ nomutilisateur + "', '" + prenom + "' '" + titrelivre + "', '" + datedebut + "', '" + datefin
					+ "', '" + email + "',  '" + code + "')";
			statement.executeQuery(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@WebMethod(operationName = "trouverlivre")
	public Livre trouverlivre(@WebParam(name = "titrelivre") String titrelivre) throws IOException {

		Livre l = new Livre();
		Configuration conf = new Configuration();

		try {

			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(conf.getMotDepasse());
			statement = connection.createStatement();
			String sql = "select * from livre";
			result = statement.executeQuery(sql);

			while (result.next()) {
				if (result.getString(3).equalsIgnoreCase(titrelivre)) {
					l.setTitre(titrelivre);
					l.setNombreexemplaire(result.getInt(5));
					l.setNombredepages(result.getInt(4));
					l.setAuteur(result.getString(2));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return l;
	}

	@WebMethod(operationName = "listUser")
	public List<Utilisateur> listUser() throws IOException {
		List<Utilisateur> listUser = new ArrayList<>();
		Configuration conf = new Configuration();

		try {

			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(conf.getMotDepasse());
			statement = connection.createStatement();
			String sql = "select * from utilisateur";
			result = statement.executeQuery(sql);

			while (result.next()) {
				Utilisateur u = new Utilisateur();
				u.setNom(result.getString(4));
				u.setPrenom(result.getString(5));
				u.setEmail(result.getString(1));
				u.setMotdepasse(result.getString(3));
				u.setRole(result.getString(6));
				u.setCode(result.getString(7));
				listUser.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}

	@WebMethod(operationName = "ListPret")
	public List<Reservation> ListPret() throws IOException {
		List<Reservation> prets = new ArrayList();
		Configuration conf = new Configuration();

		try {

			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(conf.getMotDepasse());

			statement = connection.createStatement();
			String sql = "select * from reservation";
			result = statement.executeQuery(sql);

			while (result.next()) {
				Reservation p = new Reservation();
				p.setNomutilisateur(result.getString(2));
				p.setPrenom(result.getString(3));
				p.setTitrelivre(result.getString(4));
				p.setDatedebut(result.getString(5));
				p.setDatefin(result.getString(6));
				p.setEmail(result.getString(7));
				p.setCode(result.getString(8));
				prets.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return prets;
	}

	@WebMethod(operationName = "Retour")
	public void Retour(@WebParam(name = "email") String email, @WebParam(name = "titrelivre") String titrelivre)
			throws IOException {

		Configuration conf = new Configuration();
		try {

			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(conf.getMotDepasse());

			statement = connection.createStatement();

			String sql = "delete from reservation where titrelivre like '" + titrelivre + "' and email like '" + email
					+ "'";
			statement.executeQuery(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@WebMethod(operationName = "reserverEnAvance")
	public void reserverEnAvance(@WebParam(name = "Nomutilisateur") String nomutilisateur,
			@WebParam(name = "prenom") String prenom, @WebParam(name = "titrelivre") String titrelivre,
			@WebParam(name = "email") String email, @WebParam(name = "code") String code,
			@WebParam(name = "numero") int numero) throws IOException {

		Configuration conf = new Configuration();

		try {

			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(conf.getMotDepasse());
			statement = connection.createStatement();
			String sql = "insert into reservations (nomutilisateur, prenom, titrelivre, code, email, numero) values ( '"
					+ nomutilisateur + "', '" + prenom + "' ,'" + titrelivre + "', '" + code + "', '" + email + "', '" + numero + "')";
			statement.executeQuery(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@WebMethod(operationName = "ListAttente")
	public List<Reservations> ListAttente() throws IOException {
		
		Configuration conf = new Configuration();
		List<Reservations> attente = new ArrayList();

		try {

			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(conf.getMotDepasse());

			statement = connection.createStatement();
			String sql = "select * from reservations";
			result = statement.executeQuery(sql);

			while (result.next()) {
				Reservations r = new Reservations();
				r.setNomutilisateur(result.getString(1));
				r.setPrenom(result.getString(2));
				r.setTitrelivre(result.getString(3));
				r.setCode(result.getString(4));
				r.setEmail(result.getString(5));
				r.setNumero(result.getInt(6));

				attente.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return attente;
	}
	
	
	@WebMethod(operationName = "SupprimerReservations")
	public void SupprimerReservations(@WebParam(name = "email") String email,
			@WebParam(name = "titrelivre") String titrelivre) throws IOException {
		
		Configuration conf = new Configuration();

		try {

			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(conf.getMotDepasse());

			statement = connection.createStatement();
			String sql = "delete from reservations where titrelivre like '" + titrelivre + "' and email like '" + email
					+ "'";
			statement.executeQuery(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@WebMethod(operationName = "ajouterLivre")
	public void ajouterLivre(@WebParam(name = "titre") String titre,
			@WebParam(name = "nombredepages") int nombredepages, @WebParam(name = "categorie") String categorie,
			@WebParam(name = "auteur") String auteur, @WebParam(name = "nombreexemplaire") int nombreexemplaire) throws IOException {
		
		Configuration conf = new Configuration();

		try {

			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(conf.getMotDepasse());

			statement = connection.createStatement();
			String sql = "insert into livre (auteur, titre, nombredepages, nombreexemplaire, categorie) values ( '"
					+ auteur + "', '" + titre + "' ,'" + nombredepages + "', '" + nombreexemplaire + "', '" + categorie + "')";
			result = statement.executeQuery(sql);

			while (result.next()) {
				Livre l = new Livre();
				l.setAuteur(result.getString(2));
				l.setTitre(result.getString(3));
				l.setNombredepages(result.getInt(4));
				l.setNombreexemplaire(result.getInt(5));
				l.setCategorie(result.getString(6));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@WebMethod(operationName = "supprimerLivre")
	public void supprimerLivre(@WebParam(name = "titre") String titre) throws IOException {

		Configuration conf = new Configuration();
		try {

			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(conf.getMotDepasse());

			statement = connection.createStatement();

			String sql = "delete from livre where titre like '" + titre + "'";
			statement.executeQuery(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@WebMethod(operationName = "prolongations")
	public void prolongations(@WebParam(name = "email") String email,
			@WebParam(name = "titrelivre") String titrelivre, @WebParam(name = "nombre") int nombre) throws IOException {
		
		Configuration conf = new Configuration();

		try {

			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(conf.getMotDepasse());

			statement = connection.createStatement();
			String sql = "insert into prolongation (email, titrelivre, nombre) values ( '" + email + "', '" + titrelivre + "', '" + nombre + "')";
			result = statement.executeQuery(sql);

			while (result.next()) {
				Prolongation pr = new Prolongation();
				pr.setEmail(result.getString(1));
				pr.setTitrelivre(result.getString(2));
				pr.setNombre(result.getInt(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@WebMethod(operationName = "listeprolongations")
	public List<Prolongation> listeprolongations() throws IOException {
		List<Prolongation> listePr = new ArrayList<>();
		Configuration conf = new Configuration();

		try {

			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(conf.getMotDepasse());

			statement = connection.createStatement();
			String sql = "select * from prolongation";
			result = statement.executeQuery(sql);

			while (result.next()) {
				Prolongation pr = new Prolongation();
				pr.setEmail(result.getString(1));
				pr.setTitrelivre(result.getString(2));
				pr.setNombre(result.getInt(3));
				listePr.add(pr);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listePr;
	}

	@WebMethod(operationName = "Supprimerprolongation")
	public void Supprimerprolongation(@WebParam(name = "email") String email,
			@WebParam(name = "titrelivre") String titrelivre) throws IOException {
		
		Configuration conf = new Configuration();

		try {

			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(conf.getMotDepasse());

			statement = connection.createStatement();
			String sql = "delete from prolongation where titrelivre like '" + titrelivre + "' and email like '" + email
					+ "'";
			statement.executeQuery(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
