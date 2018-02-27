package phontTester;

import org.junit.Test;

import phone.StackWithRandomRemove;

public class StackWithRandomRemoveTester {

	@Test
	public void test1() {
		StackWithRandomRemove<Integer> tester=new StackWithRandomRemove<Integer>();
		tester.push(1);tester.push(2);tester.push(3);tester.push(4);tester.push(5);
		tester.randomRemove();tester.randomRemove();
		tester.display();
	}
	@Test
	public void test2() {
		StackWithRandomRemove<Integer> tester=new StackWithRandomRemove<Integer>();
		tester.push(1);tester.push(2);tester.push(3);tester.push(4);tester.push(5);
		tester.push(6);
		tester.display();
		tester.pop();
		tester.randomRemove();tester.randomRemove();
		tester.display();
		tester.pop();
		tester.display();
	}

}
