package onsite;
import java.util.*;

/*
 * find email ID with same owner, every pair in array is defined to be have same owner
 */
public class SameEmailOwner {
	class Node{
		public int emailID;
		public Node parent;
		public int depth;
		public Node(int id){
			this.emailID=id;
			this.depth=0;
		}
	}
	public int countPeople(int[][] array){
		int count=0;
		if(array==null||array.length==0||array[0].length==0){
			return count;
		}
		HashMap<Integer,Node> map=new HashMap<Integer,Node>();
		for(int i=0;i<array.length;i++){
			Node n1=map.get(array[i][0]);
			if(n1==null){
				n1=new Node(array[i][0]);
				map.put(array[i][0], n1);
			}
			Node n2=map.get(array[i][1]);
			if(n2==null){
				n2=new Node(array[i][1]);
				map.put(array[i][1], n2);
			}
			Node p1=findParent(n1);
			Node p2=findParent(n2);
			if(p1==p2){
				continue;
			}
			if(p1.depth==p2.depth){
				p1.depth++;
				p2.parent=p1;
			}
			else if(p1.depth<p2.depth){
				p1.parent=p2;
			}
			else{
				p2.parent=p1;
			}
		}
		for(int key:map.keySet()){
			if(map.get(key).parent==null){
				count++;
			}
		}
		return count;
	}
	public Node findParent(Node n){
		while(n.parent!=null){
			n=n.parent;
		}
		return n;
	}
}
