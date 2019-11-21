package com.opendevup;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import client.BibliotequeVilleWS;
import client.BibliothequeService;
import client.IOException_Exception;
import client.Livre;
import client.Utilisateur;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientBibliotheque1ApplicationTests {

	BibliothequeService livreS = new BibliothequeService();
	BibliotequeVilleWS bib = livreS.getBibliotequeVilleWSPort();
	
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testGetListLivre() throws IOException_Exception {
		
		List<Livre> listeLivre = bib.listedeslivres();
		int taille = listeLivre.size();
		int res = 60;
		
		assertEquals(res, taille);
	}
	
	@Test
	public void testGetListUser() throws IOException_Exception {
		
		List<Utilisateur> listeuser = bib.listUser();
		int taille = listeuser.size();
		int res = 3;
		assertEquals(res, taille);
	}

}
