package SystemPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RoundSizeTest {

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
	public void testRoundSizeNonPower() {
		BinaryBuddySystemTree bbst = new BinaryBuddySystemTree();
		int three = 3;
		assertEquals(4,bbst.roundSize(three));
	}
	
	@Test
	public void testRoundSizePower(){
		BinaryBuddySystemTree bbst = new BinaryBuddySystemTree();
		int sixteen = 16;
		assertEquals(16,bbst.roundSize(sixteen));
	}

}
