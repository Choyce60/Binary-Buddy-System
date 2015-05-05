package SystemPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CreateProcessTest {

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
	public void testCreateProcess() {
		BinaryBuddySystemTree bbst = new BinaryBuddySystemTree();
		Memory expValue = new Memory(2);
		expValue.setID("");
		assertEquals(expValue,bbst.createProcess(2,""));
		
		expValue = new Memory(128);
		expValue.setID("A");
		assertEquals(expValue,bbst.createProcess(128, "A"));
	}

}
