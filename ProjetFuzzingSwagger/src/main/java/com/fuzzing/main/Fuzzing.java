package com.fuzzing.main;

import io.swagger.parser.SwaggerParser;
import io.swagger.models.Swagger;

public class Fuzzing {

	public static void main(String[] args) {
		// Lecture du swagger.json
		Swagger swagger = new SwaggerParser().read("./src/swagger.json");
		System.out.println("Le Base Path est : "+swagger.getBasePath());
	}

}
