package basics;

public class compression 
{
	public static void main(String args[])
	{
		int arr[]={1,10,11,12,25,27,30,31,33};
		int start=arr[0];
		int end=0;
		String comp="";
		boolean last=false;
		for(int i=1;i<=arr.length-1;i++)
		{
			if(arr[i]==(arr[i-1]+1))
			{
				end=arr[i];
				comp=String.valueOf(start)+'-'+String.valueOf(end);
				last=true;
			}
			else
			{
				if(last==true)
					System.out.println(comp+',');
				else
				{
					System.out.println(arr[i-1]+",");
				}
				start=arr[i];
				last=false;
			}
			if(i==arr.length-1)
			{
				if(last==true)
					System.out.println(comp);
				else
					System.out.println(arr[i]);
			}
		}
	}
}
