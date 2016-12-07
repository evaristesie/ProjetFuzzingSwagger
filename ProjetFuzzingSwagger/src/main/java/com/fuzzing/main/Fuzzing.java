package com.fuzzing.main;

import io.swagger.parser.SwaggerParser;
import com.fuzzing.casTest.CasTestURL;
import com.fuzzing.casTest.CasTestURL;
import io.swagger.models.Swagger;
import com.fuzzing.casTest.CasTestAttribut;
import com.fuzzing.casTest.CasTestParametre;

public class Fuzzing {

	public static void main(String[] args) {
	
		Swagger swagger = new SwaggerParser().read("./src/swagger.json");
		CasTestURL testURL = new CasTestURL(swagger);
		int nbData = 100;
		testURL.startTest(nbData);		
		CasTestParametre t = new CasTestParametre();
		t.VerifParametre(nbData);
		
		 // appel du cas de test paramettre
		// CasTestParametre t = new CasTestParametre();
		// t.VerifParametre(200);
		 

		/*
		 * appel du cas de test url CasTestURL testURL = new
		 * CasTestURL(swagger); 
		 * int nbData = 100; //genère 100 URL de façon aleatoire
		 * testURL.startTest(nbData);
		 */

		CasTestAttribut attribut = new CasTestAttribut();
		attribut.verifieAttribut(400); //400 pour dit genère 400 attribut aléatoire
	}

}
