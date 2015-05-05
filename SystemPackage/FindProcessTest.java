package SystemPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FindProcessTest {

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
	public void testFindProcess() {
		BinaryBuddySystemTree bbst = new BinaryBuddySystemTree();
		bbst.addProcess(32, "A");
		bbst.addProcess(16, "B");
		bbst.addProcess(8, "C");
		Memory testSubject = new Memory(16);
		testSubject.setID("B");
		assert(testSubject.equals(bbst.findProcess("B")));
	}

}
