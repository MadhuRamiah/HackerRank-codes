package basics;

public class island 
{
	public static void main(String args[])
	{
		int arr[][]={{1,1,1,0,1,0,0,0,0,0}, 
				{0,0,1,1,0,0,0,0,0,0}, 
				{0,0,0,0,0,0,0,0,0,0}, 
				{0,0,0,0,1,0,1,0,0,0},
				{0,0,0,1,1,1,0,0,0,0}, 
				{0,0,0,0,0,0,1,0,0,0}, 
				{0,0,0,0,0,0,0,0,0,0}, 
				{1,0,0,0,0,1,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{1,0,0,0,0,0,0,0,0,1}};
		int count=0;
		for (int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				if(arr[i][j]==1)
				{	
					boolean neighbor=false;
					if(i>0)
					{
						if(arr[i-1][j]==1)
							neighbor=true;
					}
					if(j>0)
					{
						if(arr[i][j-1]==1)
							neighbor=true;
					}
					
					while(++j<arr.length)
					{
						if(arr[i][j]==1)
						{
							if(i>0)
							{
								if(arr[i-1][j]==1)
									neighbor=true;
							}
						}
						else
							break;
					}
					
					if(!neighbor)
						count++;
				}
			}
		}
		
		System.out.println(count);
	}
}
