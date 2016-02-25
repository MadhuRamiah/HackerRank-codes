package basics;

class LinkedList
{
	LinkedList next;
	int num;
	LinkedList(int num)
	{
		this.num=num;
	}
}
public class LinkedList_reverse 
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
		l5.next=null;
		ListNode head;
		ListNode next;
		ListNode p;
		head=p=l1;
		next=l1.next;
		head.next=null;
		while(next!=null)
		{
			p=next;
			next=next.next;
			p.next=head;
			head=p;
		}
		
		while(p!=null)
		{
			System.out.println(" "+p.num);
			p=p.next;
		}
	}
}
