package com.fuzzing.casTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fuzzing.Oracle.OracleCasTestURL;

import io.swagger.models.Swagger;

//Tester avec de mauvaises url
public class CasTestURL {
	
	private String baseURL;
	
	public CasTestURL(Swagger s){
		baseURL = "http://localhost:8080"+s.getBasePath()+"/";
		System.out.println("URL de base : " + baseURL);
	}
	
	private String generateURL(){
		String listurl = new String();
		List<String> goodUrl = new ArrayList<String>(){
			{
				add(baseURL);
				add("http://localhost:8080/v1/swagger-ui.html");
			}
		};
		Random r = new Random();
		int indexgoodUrl;
		int indexmodif;
		indexgoodUrl = r.nextInt(2); // un entier aléatoire compris entre 0 inclus et l'entier passé en paramètre exclus
		indexmodif = r.nextInt(50); //entre 0 - 49
		if( indexmodif <= baseURL.length() ){
			listurl = goodUrl.get(indexgoodUrl);
		}else{
			listurl = goodUrl.get(indexgoodUrl) + generateString();
		}
		
		return listurl;
	}
	
	private String generateString(){
		String str = new String();
		Random rand = new Random();
		char c;
		for(int i = 0;i<5;i++){
			c = (char)(rand.nextInt(26)+ 97); // de a - Z
			str+=c;
		}
		return str;
	}
	
	public void startTest( int nbData){
		try {
			int i;
			String urlAletoire;
			OracleCasTestURL oracle = new OracleCasTestURL();
			for(i=0;i<nbData;i++){
				//Création d'un client Http
				CloseableHttpClient httpclient = HttpClients.createDefault();
				urlAletoire = generateURL();
				HttpGet httpGet = new HttpGet(urlAletoire);
				CloseableHttpResponse response = httpclient.execute(httpGet);
				System.out.print( (i+1) + " - " );
				System.out.println("URL generée : "+urlAletoire);
				oracle.executeOracle(response,404,nbData);
				response.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
