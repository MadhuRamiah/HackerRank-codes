package basics;

public class reverse 
{
	public static void main(String args[])
	{
		String str="My name is madhu";
		String rev=new StringBuilder(str).reverse().toString();
		int start=0;
		int end=0;
		System.out.println("Reversed string is "+rev);
		while(end<rev.length())
		{
			end=rev.indexOf(' ',start);
			if(end==-1)
			{
				end=rev.length();
			}
			System.out.println(end);
			String str1=rev.substring(start,end);
			String str1rev=new StringBuilder(str1).reverse().toString();
			rev=rev.replace(str1, str1rev);
			System.out.println(rev);
			start=end+1;
		}
	}
}
