package basics;

public class spiralmatrix 
{
	public static void main(String args[])
	{
		int[][] matrix={{1,2,3,10,17},{4,5,6,11,18},{7,8,9,12,19},{13,14,15,16,20},{21,22,23,24,25}};
		int row_start=0;
		int row_end=matrix.length-1;
		int column_start=0;
		int column_end=matrix[0].length-1;
		int iterations=row_end-1;
		System.out.println(row_start+ " "+ row_end + " " +column_start + " "+ column_end);
		while(iterations>=0)
		{
			int j=row_start;
			for(int i=column_start;i<=column_end;i++)
			{
				System.out.println(matrix[j][i]);
			} 
			int i=column_end;
			if(iterations!=0)
			{
				for(int k=row_start+1;k<=row_end;k++)
				{
					System.out.println(matrix[k][i]);
				}
				i=row_end;
				for(int k=column_end-1;k>=column_start;k--)
				{
					System.out.println(matrix[i][k]);
				}
				i=column_start;
				for(int k=row_end-1;k>row_start;k--)
				{
					System.out.println(matrix[k][i]);
				}
			}
			iterations--;
			column_start+=1;
			column_end-=1;
			row_start+=1;
			row_end-=1;
		}
	}
}
/*
 * 
 * 1 2 3 10 17
 * 4 5 6 11 18
 * 7 8 9 12 19
 * 13 14 15 16 20
 * 21 22 23 24 25
*/