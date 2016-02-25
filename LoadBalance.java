package basics;
import java.util.ArrayList;

class Queue<T>{

    private int total;

    private Node first, last;

    private class Node {
        private T data;
        private Node next;
    }

    public Queue() { }

    public void enqueue(T data)
    {
        Node current = last;
        last = new Node();
        last.data = data;

        if (total++ == 0) first = last;
        else current.next = last;
    }

    public T dequeue()
    {
        if (total == 0) throw new java.util.NoSuchElementException();
        T ele = first.data;
        first = first.next;
        if (--total == 0) last = null;
        return ele;
    }
    
    public Object peek()
    {
    	if(first==null) throw new java.util.NoSuchElementException();
    	return first.data;
    }
    
    public boolean isEmpty()
    {
    	if(first==null){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
}

public class LoadBalance {
	public static void main(String args[]){
		int servers=5;
		int requests=100;
		ArrayList<Queue<Integer>> QueueArrayList=new ArrayList<Queue<Integer>>();
		for(int i=0;i<servers;i++){
			QueueArrayList.add(new Queue<Integer>());
		}
		for(int i=0;i<requests;i+=5){
			for(int j=0;j<5;j++){
				QueueArrayList.get(j).enqueue(i+j);
			}
		}
		System.out.println(QueueArrayList.get(0).dequeue());
		System.out.println(QueueArrayList.get(2).dequeue());
		System.out.println(QueueArrayList.get(4).dequeue());
		System.out.println(QueueArrayList.get(0).dequeue());
		System.out.println(QueueArrayList.get(2).dequeue());
		System.out.println(QueueArrayList.get(4).dequeue());
	}

}
