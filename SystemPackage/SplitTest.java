package SystemPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SplitTest {

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
	public void testSplit() {
		BinaryBuddySystemTree bbst = new BinaryBuddySystemTree();
		
		bbst.addProcess(16,"B");
		bbst.addProcess(16,"C");
		bbst.displayInfo();
		assertEquals(bbst.findProcess("B").getParent(),bbst.findProcess("C").getParent());
	}

}
