package com.fuzzing.Oracle;

import org.apache.http.client.methods.CloseableHttpResponse;

public class OracleCasTestURL {
	int good;
	int bad;
	public OracleCasTestURL() {
		good = 0;
		bad = 0;
	}
	
	public void executeOracle(CloseableHttpResponse rep, int codeRep, int nb){
		System.out.print("Reponse : "+rep.getStatusLine());
		if( rep.getStatusLine().getStatusCode() == codeRep){
			System.out.println(" Bad URL ");
			bad++;
		}else{
			System.out.println(" Good URL ");
			good++;
		}
		System.out.println();
		if( (bad + good) == nb ){
			System.out.println();
			System.out.println("=====================================");
			System.out.println(" Bilan sur "+nb+" Requests executées");
			System.out.println(" Good URL : " + good);
			System.out.println(" Bad URL : " + bad);
		}
	}
}
