package com.oc.ws;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.ws.Endpoint;

import com.oc.ws.config.Configuration;
import com.oc.ws.entity.Livre;
import com.oc.ws.wsService.Bibliotheque;

public class MainApp {
	public static void main(String[] args) throws IOException {
		Configuration conf = new Configuration();

		String url = conf.getUrl();
		Endpoint.publish(url, new Bibliotheque());
		System.out.println(url);

	/*
		
		Connection connection;
		Statement statement;
		ResultSet result;
		
		
		
		String auteur = "Hans Christian Andersen";
		String titre = "La reine des neiges";
		
		int nombredepages = 250;
		int nombreexemplaire = 1;
		String categorie = "Roman";
		
		
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
		
		*/
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = "07/06/2013";

        try {

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
	}

}
