package casTestAttributTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fuzzing.casTest.CasTestAttribut;
import com.fuzzing.casTest.CasTestURL;

import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;

public class testAttribut {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		//verifie que le random n'est pas null
		CasTestAttribut attribut = new CasTestAttribut();
		assertNull("Le random n'est pas null", attribut);
	}

}
