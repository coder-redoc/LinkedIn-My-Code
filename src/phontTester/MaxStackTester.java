package phontTester;

import static org.junit.Assert.*;

import org.junit.Test;

import phone.MaxStack;
//{7,2,5,2,//8,2,54,7,5,7,9,10}
public class MaxStackTester {

	@Test
	public void test() {
		MaxStack tester=new MaxStack();
		tester.push(7);tester.push(2);tester.push(5);tester.push(2);
		assertTrue(tester.peekMax()==7);
		assertTrue(tester.popMax()==7);
		assertTrue(tester.popMax()==5);
		assertTrue(tester.peekMax()==2);
		assertTrue(tester.popMax()==2);
		assertTrue(tester.popMax()==2);
		tester.push(8);tester.push(7);tester.push(2);tester.push(7);tester.push(54);
		tester.push(7);tester.push(5);tester.push(7);tester.push(9);
		assertTrue(tester.peekMax()==54);
		assertTrue(tester.peek()==9);
		tester.push(10);
		assertTrue(tester.pop()==10);
		assertTrue(tester.pop()==9);
		assertTrue(tester.pop()==7);
		assertTrue(tester.pop()==5);
		assertTrue(tester.pop()==7);
		assertTrue(tester.pop()==54);
		assertTrue(tester.peekMax()==8);
		assertTrue(tester.popMax()==8);
		assertTrue(tester.popMax()==7);
		assertTrue(tester.peekMax()==7);
		assertTrue(tester.pop()==2);
		assertTrue(tester.pop()==7);
		assertTrue(tester.pop()==null);
		assertTrue(tester.popMax()==null);
	}

}
