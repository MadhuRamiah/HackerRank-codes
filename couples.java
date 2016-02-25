package basics;

public class couples 
{
	public static String swap(int a,int b,String str)
	{
		char temp=str.charAt(a);
		//System.out.println(temp+ " "+str.charAt(b));
		//System.out.println("1st substring is"+str.substring(0,a));
		//System.out.println("2nd substring is"+str.substring(a+1,b+1));
		str=str.substring(0,a)+str.charAt(b)+str.substring(a+1,b)+temp+str.substring(b+1,str.length());
		return str;
	}
	public static void main(String args[])
	{
		String str="CABBADDCEETK";
		int count=0;
		for(int i=0;i<=str.length()-1;i+=2)
		{
			if(str.charAt(i)!=str.charAt(i+1))
			{
				System.out.println(str.charAt(i));
				for(int j=str.length()-1;j>i;j--)
				{
					if(str.charAt(i)==str.charAt(j))
					{
						str=swap(i+1,j,str);
						count++;
						break;
					}
				}
			}
			System.out.println(str);
		}
		System.out.println(count);
	}
}
