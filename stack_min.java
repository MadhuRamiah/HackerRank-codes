package basics;

import java.util.Stack;

class Node{
	int data;
	Node next;
	Node top;
	int min;
	Node(int x){
		data=x;
	}
	
	public void push(int data){
		if(top==null){
			Node n=new Node(data);
			top=n;
			top.next=null;
			top.min=data;
		}
		else{
			Node n=new Node(data);
			if(data<top.min){
				n.min=data;
			}
			else{
				n.min=top.min;
			}
			n.next=top;
			top=n;	
		}
	}
	
	public Node pop(){
		if(top==null){
			return null;
		}
		else{
			Node n=top;
			top=top.next;
			return n;
		}
	}
	
	public int min(){
		if(top==null){
			return -1;
		}
		else{
			return top.min;
		}
	}
}
public class stack_min{	
	public static void main(String args[]){
		Node n = new Node(1);
		n.push(4);
		n.push(2);
		n.push(3);
		System.out.println("The minimum is "+n.min());
		System.out.println(n.pop().data);
		System.out.println("The minimum is "+n.min());
		System.out.println(n.pop().data);
		System.out.println("The minimum is "+n.min());
		System.out.println(n.pop().data);
	}
}
