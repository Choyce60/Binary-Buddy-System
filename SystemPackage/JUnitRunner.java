package SystemPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitRunner {

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
	
	@Test
	public void testAddProcess() {
		BinaryBuddySystemTree bbst = new BinaryBuddySystemTree();
		//Testing that method actually adds an element to the currentState arraylist
		assert(bbst.addProcess(32,"A"));
		boolean expValue = false;
		assertEquals(expValue,bbst.addProcess(128, "A"));	
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
	
	@Test
	public void testDeallocate() {
		BinaryBuddySystemTree bbst = new BinaryBuddySystemTree();
		bbst.addProcess(32,"A");
		int expValue = 1;
		
		assertEquals(expValue,bbst.deallocate("A"));
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
	
	@Test
	public void testSplit() {
		BinaryBuddySystemTree bbst = new BinaryBuddySystemTree();
		
		bbst.addProcess(16,"B");
		bbst.addProcess(16,"C");
		bbst.displayInfo();
		assertEquals(bbst.findProcess("B").getParent(),bbst.findProcess("C").getParent());
	}
	
	@Test
	public void testSystemSize() 
	{	
		BinaryBuddySystemTree bbst = new BinaryBuddySystemTree();
		int expectedSize = 64;
		assertEquals(expectedSize,bbst.setSystemSize(64));
	}
}
