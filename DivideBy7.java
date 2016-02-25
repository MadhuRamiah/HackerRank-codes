package basics;
import java.util.Scanner;

public class DivideBy7 
{
	public static void main(String args[]){
		System.out.println("Enter any integer");
		Scanner inputReader=new Scanner(System.in);
		int num=inputReader.nextInt();
		while(num>7){
			int last=num%10;
			num=num/10;
			last*=2;
			num-=last;
		}
		if(num==7 || num==0 || num==-7){
			System.out.println("The number is divisible by 7");
		}
		else{
			System.out.println("The number is not divisible by 7");
		}
	}
}
