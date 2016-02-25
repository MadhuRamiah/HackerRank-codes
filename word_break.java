package basics;

import java.util.Set;
import java.util.TreeSet;

public class word_break 
{
	public static void main(String args[])
	{
		Set<String> dict=new TreeSet<String>();
		dict.add("leet");
		dict.add("hello");
		dict.add("world");
		dict.add("kitty");
		dict.add("code");
		dict.add("copy");
		String str="leetscode";
		String str1="";
		for(String s:dict)
		{
			if(str.contains(s))
			{
				System.out.println(s);
				str1=str1.concat(s);
			}
		}
		System.out.println(str1);
		if(str1.length()==str.length())
			System.out.println("Yes it can be segmented");
		else
			System.out.println("No it can not be segmented");
	}
}
