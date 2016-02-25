import java.util.ArrayList;


class Queue<T>{

    private int total;

    public Node first, last;

    public class Node {
        public T data;
        public T arrivalTime;
        public T finishTime;
        public Node next;
    }

    public Queue() { }

    public void enqueue(T data,T arrivalTime,T finishTime)
    {
        Node current = last;
        last = new Node();
        last.data = data;
        last.arrivalTime=arrivalTime;
        last.finishTime=finishTime;

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
    
    public Node peek()
    {
    	if(first==null) throw new java.util.NoSuchElementException();
    	return first;
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

public class LoadBalancingWithStack {
	public static void main(String args[]){
		
		//initializing the arrival time, execution time, and arraylist to access all servers(queues)
		int servers=5;
		int requests=20;
		int arrivalTime[]={2,1,0,3,4,5,6,4,9,8,0,9,13,14,2,7,8,10,20,9};
		int executionTime[]={2,3,1,4,2,5,3,2,1,5,20,9,11,23,45,12,1,5,10,19};
		ArrayList<Queue<Integer>> QueueArrayList=new ArrayList<Queue<Integer>>();
		int IP[]=new int[requests];
		int finishTime[]=new int[requests];
		
		//initializing IP
		for(int i=0;i<requests;i++){
			IP[i]=i;
		}
		
		//creating queues and adding it to the ArrayList
		for(int i=0;i<servers;i++){
			QueueArrayList.add(new Queue<Integer>());
		}
		
		//sort execution time, IP numbers, according to arrival times
		for(int i=0;i<requests;i++){
			for(int j=i+1;j<requests;j++){
				if(arrivalTime[j]<arrivalTime[i]){
					int temp=arrivalTime[j];
					arrivalTime[j]=arrivalTime[i];
					arrivalTime[i]=temp;
					
					temp=IP[j];
					IP[j]=IP[i];
					IP[i]=temp;
					
					temp=executionTime[j];
					executionTime[j]=executionTime[i];
					executionTime[i]=temp;
				}
			}
		}
		
		//calculating Finish times and printing them
		System.out.println("IP"+"\t"+"Arrival Time"+"\t"+"Execution Time"+"\t"+"Finish Time");
		for(int i=0;i<requests;i++){
			finishTime[i]=executionTime[i]+arrivalTime[i];
			System.out.println(IP[i]+"\t"+ arrivalTime[i]+"\t\t"+executionTime[i]+"\t\t"+finishTime[i]);
			
		}
		
		System.out.println("\n"+"The job schedule is as below"+"\n");
		
		//For every request, the process to enqueue
		for(int i=0;i<requests;i++){
			boolean isEnqueue=false;
			for(int j=0;j<5;j++){
				//if queue is empty, immediately enqueue to that particular queue
				if(QueueArrayList.get(j).isEmpty()){
					QueueArrayList.get(j).enqueue(IP[i],arrivalTime[i],finishTime[i]);
					isEnqueue=true;
					System.out.println("The job "+IP[i]+" is enqued to the server "+j);
					break;
				}
			}
			
			//if none of the queues are empty
			int min=Integer.MAX_VALUE;
			int server=0;
			if(isEnqueue==false){
				//find the queue which has minimum load
				for(int j=0;j<5;j++){
					if(QueueArrayList.get(j).peek().finishTime<min){
						min=QueueArrayList.get(j).peek().finishTime;
						server=j;
					}
				}
				
				//enqueue the request into that queue, and dequeue any request which has finished before this job arrived
				QueueArrayList.get(server).enqueue(IP[i], arrivalTime[i], finishTime[i]);
				if(QueueArrayList.get(server).peek().finishTime<arrivalTime[i]){
					System.out.println("The job "+QueueArrayList.get(server).peek().data+" is dequeued from the server "+server);
					QueueArrayList.get(server).dequeue();
				}
				System.out.println("The job "+IP[i]+" is enqued to the server "+server);
			}
		}
	}
}
