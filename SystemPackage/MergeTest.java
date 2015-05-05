package SystemPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MergeTest {

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
	public void testMergeBasic() {
		BinaryBuddySystemTree bbst = new BinaryBuddySystemTree();
		bbst.addProcess(32, "A");
		int listSize = 1;
		bbst.deallocate("A");
		assertEquals(listSize, bbst.getCurrentList().size());
	}
	
	@Test
	public void testMergeIntense() {
		BinaryBuddySystemTree bbst = new BinaryBuddySystemTree();
		bbst.addProcess(32, "A");
		bbst.addProcess(16, "B");
		bbst.addProcess(8, "C");
		int listSize = 3;
		bbst.deallocate("C");
		assertEquals(listSize, bbst.getCurrentList().size());
	}

}
