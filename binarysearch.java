package basics;

public class binarysearch 
{
	public static int search(int[] arr,int start,int end,int num)
	{
		int mid=(start+end)/2;
		if(num==arr[mid])
			return mid;
		else
		{
			if(num<arr[mid])
			{
				return search(arr,0,mid-1,num);
			}
			else if(num>arr[mid])
			{
				return search(arr,mid+1,arr.length,num);
			}
			else
				return mid;
		}
	}
	public static void main(String args[])
	{
		int arr[]={1,2,3,4,5,5,5,6,7,7};
		int num=8;
		int position=search(arr,0,arr.length,num);
		System.out.println("The position is"+position);
	}
}
