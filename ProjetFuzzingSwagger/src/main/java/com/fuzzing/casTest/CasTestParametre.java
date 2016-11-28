package com.fuzzing.casTest;
import java.util.Random;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fuzzing.Oracle.OracleCasTest;
import com.fuzzing.Oracle.OracleCasTestParametre;

import io.swagger.parser.SwaggerParser;

public class CasTestParametre {

	public int i;
	public void VerifParametre()
	{
				try {
								
					Random rand = new Random();
					String alphabet = "au21b4c3de5";
					int longueur = alphabet.length();
					
					//Cree une instance de mon oracle
					OracleCasTestParametre oracle = new OracleCasTestParametre();
					
					//boucle de generation de 100 donnée aléatoire
					
					for(i=0;i<100;i++){
						//Création d'un client Http
						CloseableHttpClient httpclient = HttpClients.createDefault();
						
						//random d'alpha-numerique 
						  int k = rand.nextInt(longueur);
						  System.out.print(alphabet.charAt(k)+" ");
						  //Execution de la requete http en remplaçant le paramatre par la donnée generée
						HttpGet httpGet = new HttpGet("http://localhost:8080/v1/products?latitude=1&longitude="+alphabet.charAt(k));
						CloseableHttpResponse response = httpclient.execute(httpGet);
						//appel de l'oracle 
						oracle.OracleVerifParametre(response,400,i);
						response.close();
					}
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
	}
	
}
