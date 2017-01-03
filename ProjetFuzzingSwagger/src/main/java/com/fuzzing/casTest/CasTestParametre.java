package com.fuzzing.casTest;

import java.awt.Color;
import java.util.Random;

import javax.swing.JTextPane;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fuzzing.Oracle.OracleCasTestParametre;
import com.fuzzing.main.TextAreaStyle;

public class CasTestParametre {

	private int i;
	private Random rand ;
	private String alphabet;
	private int longueur;
	
	
	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}

	public String getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(String alphabet) {
		this.alphabet = alphabet;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public CasTestParametre() {
		rand = new Random();
		alphabet = "au21b4c3de5";
		longueur = alphabet.length();
	}

	public void VerifParametre(int nbParametre, JTextPane tp, JTextPane tpStat) {
		try {

			
			// Cree une instance de mon oracle
			OracleCasTestParametre oracle = new OracleCasTestParametre();
			// boucle de generation de 100 donnée aléatoire
			for (i = 0; i < nbParametre; i++) {
				// Création d'un client Http
				CloseableHttpClient httpclient = HttpClients.createDefault();
				// random d'alpha-numerique
				int k = rand.nextInt(longueur);
				String msg;
				msg = alphabet.charAt(k) + " ";
				TextAreaStyle.writeTextArea(tp, msg, Color.BLUE);
				// Execution de la requete http en remplaçant le paramatre par
				// la donnée generée
				HttpGet httpGet = new HttpGet(
						"http://localhost:8080/v1/products?latitude=1&longitude=" + alphabet.charAt(k));
				msg = "latitude=1 and longitude=" + alphabet.charAt(k);
				TextAreaStyle.writeTextArea(tp, msg, Color.BLACK);
				CloseableHttpResponse response = httpclient.execute(httpGet);
				oracle.OracleVerifParametre(response, 400, i, nbParametre, tp, tpStat);
				response.close();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
