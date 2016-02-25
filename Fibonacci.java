package basics;

public class Fibonacci 
{
	public static void main(String args[])
	{
		int a=0;
		int b=1;
		int c=0;
		for(int j=0;j<=11;j++)
		{
			System.out.println(a);
			c=a+b;
			a=b;
			b=c;
		}
	}
}
