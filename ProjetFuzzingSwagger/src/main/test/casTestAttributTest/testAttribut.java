package casTestAttributTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.fuzzing.casTest.CasTestAttribut;


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
		CasTestAttribut ta = new CasTestAttribut();
		assertTrue("Verification des attributs ", !ta.getAlphabet().equals(null) & 
				!ta.getAlphabet().equals(null) & ta.getRand() != null & ta.getRand2() != null);
	}

}
