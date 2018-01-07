/*
 * flatten 4-direction doubly linked list.
就是有上下左右四个方向的子node，每个子node也可以有上下左右四个方向的子node，
要求把这玩意儿转换成正常的doubly linkedlist，O(1) space，所以不能recursive，因为有stack space。
 */
package onsite;

import java.util.HashSet;

public class FourDirectionLinkedList {
	public class Node{
		public Node up;
		public Node down;
		public Node left;
		public Node right;
		public int val;
		public Node(int val){
			this.val=val;
		}
	}
	public Node head;
	public Node flattern(Node node){
		node=findTopLeft(node);
		Node head=new Node(0);
		Node parent=head;
		Node start=node;
		Node curr=node;
		
		while(curr!=null){
			// add entire row when available, we don't care about up and down here.
			// up and down will be handled when those nodes became start.
			while(curr!=null){
				parent.right=curr;
				curr.left=parent;
				parent=curr;
				curr=curr.right;
			}
			// find next node which have up and down node.
			while(start!=null){
				if(!haveUporDown(start)){
					start=start.right;
				}
				else{
					curr=findUpOrDown(start);
					curr=findTopLeft(curr);
					if(curr!=head){
						break;
					}
					else{
						curr=findUpOrDown(start);
						curr=findTopLeft(curr);
						if(curr!=head&&curr!=null){
							break;
						}
					}
					start=start.right;
				}
			}
		}
		return head;
	}
	public boolean checked(Node target){
		Node curr=target;
		while(curr.left!=null){
			curr=curr.left;
		}
		return head==curr;
	}
	public boolean haveUporDown(Node node){
		return node.up!=null||node.down!=null;
	}
	public Node findUpOrDown(Node node){
		if(node==null){
			return null;
		}
		if(node.up!=null){
			Node result=node.up;
			node.up=null;
			result.down=null;
			return result;
		}
		if(node.down!=null){
			Node result=node.down;
			node.down=null;
			result.up=null;
			return result;
		}
		return null;
	}
	
	public Node findTopLeft(Node node){
		if(node==null){
			return null;
		}
		while(node.left!=null||node.up!=null){
			if(node.left!=null){
				node=node.left;
			}
			else{
				node=node.up;
			}
		}
		return node;
	}
}
