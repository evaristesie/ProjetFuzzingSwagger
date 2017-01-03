package casTestParametre;

import static org.junit.Assert.*;

import javax.swing.JTextPane;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fuzzing.casTest.CasTestParametre;

public class testParametre {

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

	
	// verifie que le paramettre n'est pas null
	@Test
	public void test() {
		CasTestParametre testParam = new CasTestParametre();
		assertTrue(" Verifier que les attributs ne sont pas nuls ", testParam.getRand() != null & 
							!testParam.getAlphabet().equals(null) & testParam.getLongueur() != 0);
	}

}
