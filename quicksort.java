package basics;

public class quicksort 
{
	static int arr[]={5,7,2,3,8,10,12,15};
	public static void quick(int lower,int higher)
	{
		int i=lower;
		int j=higher;
		int pivot=arr[lower+(higher-lower)/2];
		System.out.println("pivot is"+pivot);
		while(i<=j)
		{
			while(arr[i]<pivot)
				i++;
			while(arr[j]>pivot)
				j--;
			if(i<=j)
			{
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i++;
				j--;
			}
		}
		for(int m=0;m<arr.length;m++)
			System.out.println(arr[m]);
		if(lower<j)
			quick(lower,j);
		if(i<higher)
			quick(i,higher);
	}
	public static void main(String args[])
	{
		quick(0,arr.length-1);
	}
}
