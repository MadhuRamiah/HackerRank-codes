package basics;
import java.lang.Math.*;
public class arrays 
{
	public static void main(String args[])
	{
		int a[]={5,9,9,9};
		int b[]=new int[4];
		int num=1000*a[0]+100*a[1]+10*a[2]+a[3]+1;
		System.out.println(num);
		double j=3;
		for(int i=0;i<4;i++)
		{
			b[i]=(int) (num/Math.pow(10.0,j));
			num=(int) (num%(Math.pow(10.0,j)));
			j--;
			System.out.println(b[i]);
		}
	}
}
