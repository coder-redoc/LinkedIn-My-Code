package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.SameEmailOwner;

/*
 * owner 1: 1,2,3,4,5,6
 * owner 2: 7,8
 * owner 3: 9,10,11
 * owner 4	12,12
 */

import org.junit.Test;

public class SameEmailOwnerTester {

	@Test
	public void test() {
		int[][] input={{1,2},{2,1},{2,3},{4,5},{5,6},{6,1},
					   {7,8},{9,10},{11,9},{10,11},{12,12}};
		SameEmailOwner seo=new SameEmailOwner();
		assertTrue(seo.countPeople(input)==4);
	}

}
