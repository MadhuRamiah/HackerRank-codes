package basics;

class ListNode
{
	ListNode next;
	int num;
	ListNode(int num)
	{
		this.num=num;
	}
}
public class LinkedListCycle 
{
	public static void main(String args[])
	{
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l5.next=l2;
		ListNode slow=l1;
		ListNode fast=l1.next;
		boolean cycleexists=false;
		int loop_length=1;
		while(slow!=null && fast!=null)
		{
			if(slow==fast)
			{
				System.out.println("Yes, cycle exists");
				cycleexists=true;
				break;
			}
			else
			{
				slow=slow.next;
				fast=fast.next.next;
			}
		}
		if(cycleexists==true)
		{
			fast=fast.next;
			while(slow!=fast)
			{
				loop_length+=1;
				fast=fast.next;
			}
		}
		System.out.println("Loop length is "+loop_length);
		slow=l1;
		fast=l1;
		while(loop_length>0)
		{
			fast=fast.next;
			loop_length--;
		}
		while(slow!=fast)
		{
			slow=slow.next;
			fast=fast.next;
		}
		System.out.println("The node is "+slow.num);
	}
}
