package basics;

public class heapsort 
{
	static int arr[]={4,3,1,7,10,3,8,9};
	public static void maxheap(int arr[])
	{
		int N=arr.length-1;
		for(int i=N/2;i>=0;i--)
			heapify(arr,i);
	}
	
	public static void heapify(int arr[],int i)
	{
		int max=i;
		int left=2*i;
		int right=2*i+1;
		if(left<=arr.length && arr[left]>arr[i])
			max=left;
		if(right<=arr.length && arr[right]>arr[i])
			max=right;
		if(max!=i)
		{
			int temp=arr[i];
			arr[i]=arr[max];
			arr[max]=temp;
			heapify(arr,max);
		}
	}
	
	public static void main(String args[])
	{
		int length=arr.length-1;
		maxheap(arr);
		for(int i=length;i>=0;i--)
		{
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			length=length-1;
			heapify(arr,0);
		}
		for(int i=0;i<=length;i++)
			System.out.println(arr[i]);
	}
}
