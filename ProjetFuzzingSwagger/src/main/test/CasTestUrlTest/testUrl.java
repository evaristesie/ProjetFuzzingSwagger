package CasTestUrlTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fuzzing.casTest.CasTestURL;

import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;

public class testUrl {
		
	  @BeforeClass 
	  public static void setUpBeforeClass() throws Exception {
	  
	  }
	  
	  @AfterClass 
	  public static void tearDownAfterClass() throws Exception { }
	  
	  @Before 
	  public void setUp() throws Exception { }
	 
	  @After
	  public void tearDown() throws Exception { }
	 
	
	@Test
	public void testBaseURl() {
		Swagger swagger = new SwaggerParser().read("./src/swagger.json");
		assertTrue("Vérification de l'exisatence du Swagger",swagger != null);
		CasTestURL url = new CasTestURL(swagger);
		String UrlBase = "http://localhost:8080/v1/";
		assertTrue("Vérification de l'URL de base",url.getbaseURL().equals(UrlBase));
	}

}
