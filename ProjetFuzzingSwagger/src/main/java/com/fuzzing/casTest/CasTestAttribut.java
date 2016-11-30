package com.fuzzing.casTest;

import java.util.Random;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fuzzing.Oracle.OracleCasTestAttribut;
import com.fuzzing.Oracle.OracleCasTestParametre;

public class CasTestAttribut {
	public int i=0;
	
	public void verifieAttribut(int nbAttribGenere){
		
		
		try {
			
			//random pour le premier attribut
			
			Random rand = new Random();
			String alphabet = "au2#1b*4c3de5";
			int longueur = alphabet.length();
			
		// Random du deuxième attribut	
			Random rand2 = new Random();
			String alphabet2 = "abcdeg21b4c3fi5";
			int longueur2 = alphabet2.length();
						
			//Cree une instance de mon oracle
			OracleCasTestAttribut oracle = new OracleCasTestAttribut();
			
			//boucle de generation de 100 donnée aléatoire
			
			for(i=0;i<nbAttribGenere;i++){
				//Création d'un client Http
				CloseableHttpClient httpclient = HttpClients.createDefault();
				
				//random d'alpha-numerique pour le premier attribut
				  int k = rand.nextInt(longueur);

					//random d'alpha-numerique pour le deuxième attribut
			       int k2 = rand2.nextInt(longueur2);
				
				  //Execution de la requete http en remplaçant le paramatre par la donnée generée
				HttpGet httpGet = new HttpGet("http://localhost:8080/v1/products?latitud"+alphabet.charAt(k)+"=1&lon"+alphabet2.charAt(k2)+"itude=1");
				System.out.print("latitud"+alphabet.charAt(k)+"=1 and lon"+alphabet2.charAt(k2)+"itude=1");
				CloseableHttpResponse response = httpclient.execute(httpGet);
				//appel de l'oracle 
				oracle.OracleVerifAttribut(response,200,i,nbAttribGenere);
				response.close();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
}

}
