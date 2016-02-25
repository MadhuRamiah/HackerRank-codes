package basics;

import java.util.ArrayList;

class stack{
	int data;
	stack next;
	stack top;
	int length;
	int min;
	int threshold=5;
	stack(int x){
		data=x;
	}
	
	public void push(int data,ArrayList<stack> lst){
		if(lst.isEmpty()){
			stack s=new stack(data);
			s.top=s;
			s.next=null;
			lst.add(s);
			s.length=1;
		}
		else{
			int size=lst.size()-1;
			if(lst.get(size).length<threshold){
				stack t=lst.get(size).top;
				stack n=new stack(data);
				n.next=t;
				lst.get(size).top=n;
				lst.get(size).length++;
				System.out.println("Stack is "+size+" data is "+data);
			}
			else{
				stack s=new stack(data);
				s.length=1;
				s.top=s;
				s.next=null;
				lst.add(s);
				System.out.println("Stack is "+(lst.size()-1)+" data is "+data);
			}
		}
	}
	
	public int pop(ArrayList<stack> lst){
		int size=lst.size()-1;
		int value=lst.get(size).top.data;
		if(lst.get(size).length>1){
			lst.get(size).top=lst.get(size).top.next;
			lst.get(size).length--;
		}
		else{
			lst.remove(size);
		}
		return value;
	}
	
	public boolean isEmpty(ArrayList<stack> lst){
		if(lst.size()==0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int peek(ArrayList<stack> lst){
		int size=lst.size()-1;
		return lst.get(size).top.data;
	}
}

public class SetOfStacks {
	public static void main(String args[]){
		stack s=new stack(1);
		ArrayList<stack> lst=new ArrayList<stack>();
		System.out.println(s.isEmpty(lst));
		s.push(1, lst);
		s.push(2, lst);
		s.push(3, lst);
		s.push(4, lst);
		System.out.println(s.isEmpty(lst));
		s.push(5, lst);
		s.push(6, lst);
		System.out.println("The top element is "+s.peek(lst));
		s.push(7, lst);
		int value=s.pop(lst);
		System.out.println("Value is "+ value);
		value=s.pop(lst);
		System.out.println("Value is "+ value);
		value=s.pop(lst);
		System.out.println("Value is "+ value);
		s.push(7, lst);
		s.push(8, lst);
		
		System.out.println(s.isEmpty(lst));
		System.out.println("The top element is "+s.peek(lst));
	}
}
