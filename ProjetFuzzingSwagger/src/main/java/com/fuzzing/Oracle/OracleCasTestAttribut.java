package com.fuzzing.Oracle;

import org.apache.http.client.methods.CloseableHttpResponse;

public class OracleCasTestAttribut {
public int good=0,bad=0;
	
	public void OracleVerifAttribut(CloseableHttpResponse rep,int codestatut,int a,int nombreAttribGenerer)
	{
		//verifie si le code retourn� par la requette correspond code attendu
		if(rep.getStatusLine().getStatusCode()==codestatut){
	      good++;
			System.out.println("Good Parameter");	
			
	}
		else
		{bad++;
		  System.out.println("Bad Parameter");
			
		}
		
		
		    if(a==nombreAttribGenerer-1)
		     {
		    	a=nombreAttribGenerer;
		    	 System.out.println("Statistique des Donn�es g�ner�es ");
					System.out.println("----------------------------------");
					System.out.println("Sur "+ a +" attribut g�n�r�s de fa�on al�atoire:");
					System.out.println("Good Attribut="+good);
					System.out.println("Bad Attribut="+bad);
		
		     }
}
}

