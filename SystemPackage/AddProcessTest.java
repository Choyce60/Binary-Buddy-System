package SystemPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AddProcessTest {

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
	public void testAddProcess() {
		BinaryBuddySystemTree bbst = new BinaryBuddySystemTree();
		//Testing that method actually adds an element to the currentState arraylist
		assert(bbst.addProcess(32,"A"));
		boolean expValue = false;
		assertEquals(expValue,bbst.addProcess(128, "A"));	
	}

}
