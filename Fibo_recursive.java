package basics;

public class Fibo_recursive 
{
	public static int fibo(int n)
	{
		if(n==1)
			return 0;
		else if(n==2)
			return 1;
		else
		{
			return fibo(n-1)+fibo(n-2);
		}	
	}
	public static void main(String args[])
	{
		for(int i=1;i<=11;i++)
		{
			System.out.println(fibo(i));
		}
	}
}
