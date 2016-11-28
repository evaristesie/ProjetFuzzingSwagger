package com.fuzzing.main;

import io.swagger.parser.SwaggerParser;

import java.io.Closeable;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import io.swagger.models.Swagger;
import com.fuzzing.casTest.CasTestParametre;
public class Fuzzing {
	
	public static void main(String[] args) {
		// Lecture du swagger.json
		
		Swagger swagger = new SwaggerParser().read("./src/swagger.json");
		CasTestParametre t = new CasTestParametre();
		t.VerifParametre();
		
	}

}
