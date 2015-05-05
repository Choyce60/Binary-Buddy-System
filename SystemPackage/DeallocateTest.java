package SystemPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeallocateTest {

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
	public void testDeallocate() {
		BinaryBuddySystemTree bbst = new BinaryBuddySystemTree();
		bbst.addProcess(32,"A");
		int expValue = 1;
		
		assertEquals(expValue,bbst.deallocate("A"));
	}

}
