package basics;

public class subsetsum 
{
	public static boolean subset(int arr[],int n,int sum)
	{
		if(sum==0)
			return true;
		if(sum>0 && n==0)
			return false;
		if(arr[n-1]>sum)
			return subset(arr,n-1,sum);
		return subset(arr,n-1,sum) || subset(arr,n-1,sum-arr[n-1]);
	}
	public static void main(String args[])
	{
		int arr[]={3,34,4,12,5,2};
		int sum=0;
		for(int i=0;i<arr.length;i++)
			sum+=arr[i];
		sum=sum/2;
		boolean found=subset(arr,arr.length,sum);
		if(found)
			System.out.println("Subset with given sum is found");
		else
			System.out.println("Subset with given sum is not found");
	}
}
