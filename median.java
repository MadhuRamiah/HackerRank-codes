package basics;

public class median 
{
	/*A=[1,4,7,8,10]
	 *B=[2,3,11,14,18]
	 */
	public static float median(int a[],int b[],int alen,int blen,int astart,int aend,int bstart,int bend)
	{
		if(alen==0)
		{
			if(blen%2!=0)
				return b[bstart+bend/2];
			else
				return (b[bstart+bend/2]+b[bstart+bend/2+1])/2;
		}
		else if(blen==0)
		{
			if(alen%2!=0)
				return a[(astart+aend)/2];
			else
				return (a[(astart+aend)/2]+a[(astart+aend)/2+1])/2;
		}
		else if(alen==0 && blen==0)
			return 0;
		else
		{
			int amid=(astart+aend)/2;
			int bmid=(bstart+bend)/2;
			if(a[amid]<b[bmid])
			{
				return median(a,b,alen/2+1,blen/2,amid,aend,bstart,bmid);
			}
			else if(a[amid]>b[bmid])
			{
				return median(a,b,alen/2+1,blen/2+1,astart,amid,bmid,bend);
			}
			else
				return a[amid];
		}
	}
	
	public static void main(String args[])
	{
		int A[]={1,4,7,8,10,12};
		int B[]={2,3,11,14,18};
		int alen=A.length;
		int blen=B.length;
		float median=0;
		median=median(A,B,alen,blen,0,alen,0,blen);
		System.out.println(median);
	}
}


/*  A,B,5,5,0,5,0,5
 * A,B,3,3,2,5,0,2
 * A,B,2,2,2,3,1,2
 */