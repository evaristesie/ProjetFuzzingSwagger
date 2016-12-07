package com.fuzzing.Oracle;

import org.apache.http.client.methods.CloseableHttpResponse;


public class OracleCasTestParametre {
	
	public int good=0,bad=0;
	
	public void OracleVerifParametre(CloseableHttpResponse rep,int codestatut,int a,int nbParamGenerer)
	{
		if(rep.getStatusLine().getStatusCode()==codestatut){
			bad++;
		  System.out.println("Bad Parameter");
	}
		else
		{
			good++;
			System.out.println("Good Parameter");
		}
		
		
		    if(a==nbParamGenerer-1)
		     {
		    	a=nbParamGenerer;
		    	 System.out.println("Statistique des Données génerées ");
					System.out.println("----------------------------------");
					System.out.println("Sur "+a+" paramètres générés de façon aléatoire:");
					System.out.println("Good parameter="+good);
					System.out.println("Bad parameter="+bad);
		
		     }
}
}

