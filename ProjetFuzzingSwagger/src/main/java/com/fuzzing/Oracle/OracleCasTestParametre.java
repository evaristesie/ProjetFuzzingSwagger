package com.fuzzing.Oracle;

import org.apache.http.client.methods.CloseableHttpResponse;

import com.fuzzing.casTest.CasTestParametre;

public class OracleCasTestParametre {
	
	public int good=0,bad=0;
	
	public void OracleVerifParametre(CloseableHttpResponse rep,int codestatut,int a)
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
		
		
		    if(a==99)
		     {
		    	 System.out.println("Statistique des Données génerées ");
					System.out.println("----------------------------------");
					System.out.println("Sur 100 paramètres générés de façon aléatoire:");
					System.out.println("Good parameter="+good);
					System.out.println("Bad parameter="+bad);
		
		     }
}
}

