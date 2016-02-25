package basics;

import java.util.Stack;

public class postfix_expressions 
{
	public static void main(String args[])
	{
		String[] exp=new String[]{"5","3","+","6","*"};
		String operations=new String("+-*/");
		Stack<String> stack=new Stack<String>();
		int result=0;
		for(int i=0;i<exp.length;i++)
		{
			if(!operations.contains(exp[i]))
			{
				stack.push(exp[i]);
			}
			else
			{
				int num1=Integer.valueOf(stack.pop());
				int num2=Integer.valueOf(stack.pop());
				if(exp[i].equals("+"))
				{
					result=num1+num2;
				}
				else if(exp[i].equals("-"))
				{
					result=num2-num1;
				}
				else if(exp[i].equals("*"))
				{
					result=num2*num1;
				}
				else
				{
					result=num2/num1;
				}
				String r=String.valueOf(result);
				stack.push(r);
			}
		}
		System.out.println("The result is"+Integer.valueOf(result));
	}
}
