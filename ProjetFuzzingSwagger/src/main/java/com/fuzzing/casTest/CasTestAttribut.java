package com.fuzzing.casTest;

import java.awt.Color;
import java.util.Random;

import javax.swing.JTextPane;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fuzzing.Oracle.OracleCasTestAttribut;
import com.fuzzing.main.TextAreaStyle;

public class CasTestAttribut {
	public int i;
	Random rand;
	Random rand2;
	String alphabet;
	String alphabet2;

	public CasTestAttribut() {
		rand = new Random();
		rand2 = new Random();
		i = 0;
		alphabet = "au2#1b*4c3de5";
		alphabet2 = "abcdeg21b4c3fi5";
	}

	public void verifieAttribut(int nbAttribGenere, JTextPane tp, JTextPane tpStat) {

		try {

			int longueur = alphabet.length();
			int longueur2 = alphabet2.length();
			// Cree une instance de mon oracle
			OracleCasTestAttribut oracle = new OracleCasTestAttribut();
			// boucle de generation de 100 donn�e al�atoire
			for (i = 0; i < nbAttribGenere; i++) {
				// Cr�ation d'un client Http
				CloseableHttpClient httpclient = HttpClients.createDefault();
				// random d'alpha-numerique pour le premier attribut
				int k = rand.nextInt(longueur);
				// random d'alpha-numerique pour le deuxi�me attribut
				int k2 = rand2.nextInt(longueur2);
				// Execution de la requete http en rempla�ant le paramatre par
				// la donn�e gener�e
				HttpGet httpGet = new HttpGet("http://localhost:8080/v1/products?latitud" + alphabet.charAt(k)
						+ "=1&lon" + alphabet2.charAt(k2) + "itude=1");
				String msg = "latitud" + alphabet.charAt(k) + "=1 and lon" + alphabet2.charAt(k2) + "itude=1 \t";
				TextAreaStyle.writeTextArea(tp, msg, Color.BLACK);
				CloseableHttpResponse response = httpclient.execute(httpGet);
				// appel de l'oracle
				oracle.OracleVerifAttribut(response, 200, i, nbAttribGenere,tp,tpStat);
				response.close();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
