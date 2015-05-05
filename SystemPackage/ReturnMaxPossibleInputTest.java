package SystemPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReturnMaxPossibleInputTest 
{
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
	public void testReturnMaxPossibleInputHigh() {
		BinaryBuddySystemTree bbst = new BinaryBuddySystemTree();
		int expectedMaxPossible = 64;
		assertEquals(expectedMaxPossible, bbst.returnMaxPossibleInput());
	}
	
	@Test
	public void testReturnMaxPossibleInputLow() {
		BinaryBuddySystemTree bbst = new BinaryBuddySystemTree();
		bbst.addProcess(32, "A");
		bbst.addProcess(16, "B");
		bbst.addProcess(8, "C");
		bbst.addProcess(4, "D");
		bbst.addProcess(2, "E");
		int expectedMaxPossible = 2;
		assertEquals(expectedMaxPossible, bbst.returnMaxPossibleInput());
	}

}
