package basics;

class Link
{
	Link next;
	int num;
	Link(int num)
	{
		this.num=num;
	}
}
public class add_numbers 
{
	public static void main(String args[])
	{
		Link l1=new Link(7);
		Link l2=new Link(0);
		Link l3=new Link(8);
		Link l4=new Link(3);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=null;
		
		Link l5=new Link(4);
		Link l6=new Link(2);
		Link l7=new Link(3);
		Link l8=new Link(2);
		l5.next=l6;
		l6.next=l7;
		l7.next=l8;
		l8.next=null;
		
		Link node=l1;
		Link node1=l5;
		int count=1;
		Link r=new Link(0);
		Link head1=r;
		int carry=0;
		while(node.next!=null)
		{
			int result=node.num+node1.num+carry;
			if(result/10>0)
			{
				carry=result/10;
			}
			else
			{
				carry=0;
			}
			r.next=new Link(result%10);
			r=r.next;
			node=node.next;
			node1=node1.next;
		}
		r.next=null;
		while(head1!=null)
		{
			System.out.println(" "+head1.num);
			head1=head1.next;
		}
	}
}
