
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class CommandStackTest extends TestCase{
	CommandStack cs;
	String [] commands = {"wait", "for", "two", "hours"};
	@Before
	public void setUp(){
		 cs = new CommandStack();
		 cs.setCommandStack(commands);
	}
	@Test
	public void testDeleteCommandStackSizeZero() {
		cs.deleteCommandStack();
		assertEquals(cs.getCommStackSize(), 0);
	}
	@Test
	public void testDeleteCommandStackMainCommandIsNull() {
		cs.deleteCommandStack();
		assertEquals(cs.getMainCommand(), null);
	}
	@Test
	public void testDeleteCommandStackArgAsStringIsEmptyString() {
		cs.deleteCommandStack();
		assertEquals(cs.getCommandArgumentsAsString(), "");
	}
	@Test
	public void testDeleteCommandStackArgListIsEmptyArrayList() {
		ArrayList<String> arr = new ArrayList<String>();
		cs.deleteCommandStack();
		assertEquals(cs.getCommandArgumentsList(),arr);
	}
	@Test
	public void testIncreasePointer() {
		cs.increasePointer();
		cs.increasePointer();
		cs.increasePointer();
		cs.increasePointer();
		cs.increasePointer();
		assertEquals(cs.getPointer(),3);
	}

	@Test
	public void testDecreasePointer() {
		cs.increasePointer();
		cs.increasePointer();
		assertEquals(cs.getPointer(), 2);
		cs.decreasePointer();
		cs.decreasePointer();
		assertEquals(cs.getPointer(), 0);
		cs.decreasePointer();
		assertEquals(cs.getPointer(), 0);
		
	}	

	@Test
	public void testGetPointer() {
		cs.increasePointer();
		cs.increasePointer();
		cs.increasePointer();
		cs.increasePointer();
		cs.decreasePointer();
		assertEquals(cs.getPointer(), 2);
	}

	@Test
	public void testSetCommandStack() {
		assertNotNull(cs.commandStack);
		assertEquals(4,cs.commandStack.size());

	}

	@Test
	public void testGetCommands() {
		cs.setCommandStack(commands);
		assertArrayEquals(cs.getCommands(), commands);
	}

	@Test
	public void testGetCommandStackValues() {
		cs.setCommandStack(commands);
		assertEquals(cs.getCommandStackValues(),"0) wait\n1) for\n2) two\n3) hours\n");
	}

	@Test
	public void testGetCommStackSize() {
		assertEquals(4,cs.getCommStackSize());
	}

	@Test
	public void testGetMainCommand() {
		assertEquals(cs.getMainCommand(), "wait");
	}

	@Test
	public void testGetCommandArgumentsAsString() {
		String s = "for two hours";
		assertEquals(cs.getCommandArgumentsAsString(),s);
	}

	@Test
	public void testGetCommandArgumentsList() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("for");arr.add("two");arr.add("hours");
		assertEquals(cs.getCommandArgumentsList(),arr);
	}

}
