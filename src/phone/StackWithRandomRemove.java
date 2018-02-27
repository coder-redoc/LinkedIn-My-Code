package phone;
import java.util.*;
//implement Stack<T> with pop(), push(T) and randomRemove() in O(1) time complexity.
public class StackWithRandomRemove<T> {
	class Node<K>{
		K val;
		Node<K> pre;
		Node<K> next;
		public Node(K val){
			this.val=val;
		}
	}
	Node<T> head;
	Node<T> tail;
	List<Node<T>> list;
	Map<Node<T>,Integer> map;
	public StackWithRandomRemove(){
		this.list=new ArrayList<Node<T>>();
		this.head=new Node<T>(null);
		this.tail=new Node<T>(null);
		this.head.next=this.tail;
		this.tail.pre=this.head;
		this.map=new HashMap<Node<T>,Integer>();
	}
	public void remove(Node<T> curr){
		curr.pre.next=curr.next;
		curr.next.pre=curr.pre;
		int index=this.map.get(curr);
		if(index!=list.size()-1){
			Node<T> last=list.get(list.size()-1);
			list.set(index, last);
			map.put(last,index);
		}
		this.map.remove(curr);
		this.list.remove(list.size()-1);
	}
	
	public T pop(){
		if(this.list.isEmpty()){
			return null;
		}
		Node<T> curr=tail.pre;
		remove(curr);
		return curr.val;
	}
	
	public void randomRemove(){
		int index=(int)(Math.random()*this.list.size());
		remove(this.list.get(index));
	}
	
	public void push(T val){
		Node<T> toadd=new Node<T>(val);
		this.list.add(toadd);
		this.tail.pre.next=toadd;
		toadd.pre=this.tail.pre;
		toadd.next=tail;
		tail.pre=toadd;
		this.map.put(toadd, this.list.size()-1);
	}
	
	public void display(){
		Node<T> curr=head.next;
		while(curr!=tail){
			System.out.print(curr.val+",");
			curr=curr.next;
		}
		System.out.println();
	}
}
