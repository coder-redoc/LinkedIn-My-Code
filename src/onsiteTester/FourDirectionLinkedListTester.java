package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.FourDirectionLinkedList;
import onsite.FourDirectionLinkedList.Node;

/*
visualized structure
				1								

5				2								

6				3		4				19		20

7		8		9		10		11		12		13

		14				18						

		15		16		17						

						21		
						
*/
public class FourDirectionLinkedListTester {

	@Test
	public void test1() {
		FourDirectionLinkedList fdll=new FourDirectionLinkedList();
		Node n1=fdll.new Node(1);
		Node n2=fdll.new Node(2);
		Node n3=fdll.new Node(3);
		Node n4=fdll.new Node(4);
		Node n5=fdll.new Node(5);
		Node n6=fdll.new Node(6);
		Node n7=fdll.new Node(7);
		Node n8=fdll.new Node(8);
		Node n9=fdll.new Node(9);
		Node n10=fdll.new Node(10);
		Node n11=fdll.new Node(11);
		Node n12=fdll.new Node(12);
		Node n13=fdll.new Node(13);
		Node n14=fdll.new Node(14);
		Node n15=fdll.new Node(15);
		Node n16=fdll.new Node(16);
		Node n17=fdll.new Node(17);
		Node n18=fdll.new Node(18);
		Node n19=fdll.new Node(19);
		Node n20=fdll.new Node(20);
		Node n21=fdll.new Node(21);
		n1.down=n2;
		n2.up=n1; n2.down=n3;
		n3.up=n2; n3.right=n4; n3.down=n9;
		n4.left=n3; n4.down=n10;
		n5.down=n6;
		n6.up=n5;n6.down=n7;
		n7.up=n6;n7.right=n8;
		n8.right=n9;n8.left=n7;n8.down=n14;
		n9.left=n8;n9.up=n3;n9.right=n10;
		n10.left=n9;n10.up=n4;n10.right=n11;n10.down=n18;
		n11.left=n10;n11.right=n12;
		n12.left=n11;n12.up=n19;n12.right=n13;
		n13.left=n12;n13.up=n20;
		n14.up=n8;n14.down=n15;
		n15.up=n14;n15.right=n16;
		n16.left=n15;n16.right=n17;
		n17.left=n16;n17.up=n18;n17.down=n21;
		n18.up=n10;n18.down=n17;
		n19.right=n20;n19.down=n12;
		n20.left=n19;n20.down=n13;
		n21.up=n17;
		
		fdll.head=fdll.flattern(n15);
		Node curr=fdll.head;
		while(curr!=null){
			System.out.println(curr.val);
			curr=curr.right;
		}
		System.out.println();
	}
}
