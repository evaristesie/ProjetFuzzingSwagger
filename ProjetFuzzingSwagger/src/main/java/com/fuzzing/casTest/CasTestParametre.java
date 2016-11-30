package com.fuzzing.casTest;
import java.util.Random;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fuzzing.Oracle.OracleCasTestParametre;

public class CasTestParametre {

	public int i;
	public void VerifParametre(int nbParametre)
	{
				try {
								
					Random rand = new Random();
					String alphabet = "au21b4c3de5";
					int longueur = alphabet.length();
					
					//Cree une instance de mon oracle
					OracleCasTestParametre oracle = new OracleCasTestParametre();
					
					//boucle de generation de 100 donnée aléatoire
					
					for(i=0;i<nbParametre;i++){
						//Création d'un client Http
						CloseableHttpClient httpclient = HttpClients.createDefault();
						
						//random d'alpha-numerique 
						  int k = rand.nextInt(longueur);
						  System.out.print(alphabet.charAt(k)+" ");
						  //Execution de la requete http en remplaçant le paramatre par la donnée generée
						HttpGet httpGet = new HttpGet("http://localhost:8080/v1/products?latitude=1&longitude="+alphabet.charAt(k));
						 System.out.print("latitude=1 and longitude="+alphabet.charAt(k));
						CloseableHttpResponse response = httpclient.execute(httpGet);
						//appel de l'oracle 
						oracle.OracleVerifParametre(response,400,i,nbParametre);
						response.close();
					}
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
	}
	
}
