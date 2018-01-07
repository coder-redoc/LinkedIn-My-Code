package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;
import onsite.CartesianProduct;

public class CartesianProductTester {

	@Test
	public void test() {
		CartesianProduct tester=new CartesianProduct();
		List<Set<Character>> sets=new ArrayList<Set<Character>>();
		Set<Character> s1=new HashSet<Character>();
		s1.add('a');s1.add('b');s1.add('c');
		Set<Character> s2=new HashSet<Character>();
		s2.add('d');
		Set<Character> s3=new HashSet<Character>();
		s3.add('e');s3.add('f');
		sets.add(s1);sets.add(s2);sets.add(s3);
		List<List<Character>> res=tester.iterativeCartesianProduct(sets);
		for(List<Character> list:res){
			System.out.print("{");
			for(char ch:list){
				System.out.print(ch+",");
			}
			System.out.print("},");
		}
	}

}
