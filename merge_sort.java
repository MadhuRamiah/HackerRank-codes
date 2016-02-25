package basics;

import java.util.Arrays;

public class merge_sort 
{
	public static int[] Sort(int A[],int B[])
	{
		int m=A.length;
		int n=B.length;
		int i=0,j=0;
		int count=0;
		int C[]=new int[m+n];
		while(i<m && j<n)
		{
			if(A[i]>B[j])
			{
				C[count]=B[j];
				count++;
				j++;
			}
			if(A[i]<B[j])
			{
				C[count]=A[i];
				count++;
				i++;
			}
		}
//		System.out.println(C);
		return C;
	}
	public static int[] merge(int start,int end,int n,int A[])
	{
		int[] sortedarray;
		if(n==1)
			return A;
		else
		{
			int [] Arr1=merge(0,n/2,n/2,A);
			int [] Arr2=merge(n/2+1,n,n/2,A);
			System.out.println(Arrays.toString(Arr1));
			System.out.println(Arrays.toString(Arr2));
			sortedarray=Sort(Arr1,Arr2);
			return sortedarray;
		}
	}
	public static void main(String args[])
	{
		int[] A={1,5,7,2,6,3};
	//	System.out.println(Arrays.toString(A));
		merge(0,A.length,A.length,A);
	}
}
