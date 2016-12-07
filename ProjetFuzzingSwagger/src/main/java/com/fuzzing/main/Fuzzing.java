package com.fuzzing.main;

import io.swagger.parser.SwaggerParser;

import com.fuzzing.casTest.CasTestURL;
import io.swagger.models.Swagger;
import com.fuzzing.casTest.CasTestParametre;
public class Fuzzing {
	
	public static void main(String[] args) {
		// Lecture du swagger.json
		
		Swagger swagger = new SwaggerParser().read("./src/swagger.json");
		CasTestURL testURL = new CasTestURL(swagger);
		int nbData = 100;
		testURL.startTest(nbData);		
		CasTestParametre t = new CasTestParametre();
		t.VerifParametre();
	}

}
