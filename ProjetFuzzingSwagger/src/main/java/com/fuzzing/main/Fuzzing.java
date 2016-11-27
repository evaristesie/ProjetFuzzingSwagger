package com.fuzzing.main;

import io.swagger.parser.SwaggerParser;

import java.io.Closeable;
import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import io.swagger.models.Swagger;

public class Fuzzing {
	
	public static void main(String[] args) {
		// Lecture du swagger.json
		Swagger swagger = new SwaggerParser().read("./src/swagger.json");
		
		//System.out.println("Resultat : "+swagger.getPath("/products"));
		/*
		 * Manipulation HttpClient
		try {
			int i;
			for(i=0;i<1000000000;i++){
				//Création d'un client Http
				CloseableHttpClient httpclient = HttpClients.createDefault();
				HttpGet httpGet = new HttpGet("http://localhost:8080/v1/swagger-ui.html");
				CloseableHttpResponse response = httpclient.execute(httpGet);
				System.out.println( (i+1) +":"+response.getStatusLine());
				response.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		*/
		
		
	}

}
