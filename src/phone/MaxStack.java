package phone;

/*
 * 让你设计一个MaxStack，要求实现以下功能。
class MaxStack {
    int Pop(); // Pop the value on top of the stack;
    void Push(int); // Push a new value into the stack;
    int Peek(); // Return the value on top of the stack;

    int PopMax(); // Pop the max value in the stack;
    int PeekMax(); // Return the max value in the stack;
}
 */
// method 1, use pq to store all nodes, pop max will be logN
// method 2(my way), use separate pointer to point to the next smaller value, O(1) popMax, but O(N) on insert value
public class MaxStack {
	public class ListNode{
		ListNode next;
		ListNode pre;
		ListNode smaller;
		ListNode larger;
		int val;
		public ListNode(int val){
			this.val=val;
		}
	}
	ListNode maxNode;
	ListNode head;
	ListNode tail;
	public MaxStack(){
		this.head=new ListNode(Integer.MIN_VALUE);
		this.tail=new ListNode(Integer.MAX_VALUE);
		head.next=tail;
		tail.pre=head;
		this.maxNode=null;
	}
	public void push(int val){
		ListNode newNode=new ListNode(val);
		newNode.pre=tail.pre;
		tail.pre.next=newNode;
		newNode.next=tail;
		tail.pre=newNode;
		if(maxNode==null){
			maxNode=newNode;
		}
		else if(newNode.val>=maxNode.val){
			newNode.smaller=maxNode;
			maxNode.larger=newNode;
			maxNode=newNode;
		}
		else{
			ListNode curr=maxNode;
			while(curr!=null){
				if(curr.smaller==null||newNode.val>=curr.smaller.val){
					newNode.smaller=curr.smaller;
					if(curr.smaller!=null){
						curr.smaller.larger=newNode;
					}
					curr.smaller=newNode;
					newNode.larger=curr;
					break;
				}
				curr=curr.smaller;
			}
		}
	}
	public Integer pop(){
		ListNode curr=tail.pre;
		if(curr==head){
			return null;
		}
		if(maxNode==curr){
			maxNode=maxNode.smaller;
			if(maxNode!=null){
				maxNode.larger=null;
			}
		}
		else{
			if(curr.smaller!=null){
				curr.smaller.larger=curr.larger;
			}
			if(curr.larger!=null){
				curr.larger.smaller=curr.smaller;
			}
		}
		curr.pre.next=curr.next;
		curr.next.pre=curr.pre;
		return curr.val;
	}
	public Integer peek(){
		ListNode curr=tail.pre;
		if(curr==head){
			return null;
		}
		return curr.val;
	}
	public Integer popMax(){
		if(maxNode==null){
			return null;
		}
		ListNode curr=maxNode;
		curr.pre.next=curr.next;
		curr.next.pre=curr.pre;
		maxNode=curr.smaller;
		if(maxNode!=null){
			maxNode.larger=null;
		}
		return curr.val;
	}
	public Integer peekMax(){
		if(maxNode==null){
			return null;
		}
		return maxNode.val;
	}
	public boolean isEmpty(){
		return this.maxNode==null;
	}
}
