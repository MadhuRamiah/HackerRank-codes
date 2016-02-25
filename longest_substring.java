package basics;

public class longest_substring 
{
	public static boolean IsPalindrome(String str,int begin,int end)
	{
		while(begin>=0 && end<=str.length()-1 && str.charAt(begin)==str.charAt(end))
		{
			begin++;
			end--;
		}
		return true;
	}
	public static void main(String args[])
	{
		String str="aaaabcbaa";
		int start=0;
		boolean pal=false;
	}
}
