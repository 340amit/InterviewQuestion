package com.intuit;
/*package com.intuit;

import java.util.Scanner;

public class SmartanTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int r=sc.nextInt();
		int c=sc.nextInt();
		long[][] grid=new long[r][c];
		long dp[][]=new long[r][c];
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				grid[i][j]=sc.nextInt();
			}
		}
		for(int i=0,j=0;j<r;j++)
		{
			dp[i][j]=grid[i][j];
		}
		for(int i=1,j=0;i<r;i++,j++)
		{
			
				for(int k=0;k<c;k++)
				{
					dp[i][k]=grid[i][k]+dp[j][k];
				}
			
		}
		for(int i=0;i<r;i++)
		{
			
				for(int k=1,j=0;k<c;k++,j++)
				{
					dp[i][k]=dp[i][k]+dp[i][j];
				}
			
		}
		int q=sc.nextInt();
		while(q-->0)
		{
			int x1=sc.nextInt()-1;
			int y1=sc.nextInt()-1;
			int x2=sc.nextInt()-1;
			int y2=sc.nextInt()-1;
		
			
			if(x1==0&&y1==0)
			{
			
				System.out.println(dp[x2][y2]);
	
			}
			
			
			else if(x1>0&y1>0)
 
			{
				System.out.println(dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1]);
			}
			else if(x1>0&&y1==0)
			{
				System.out.println(dp[x2][y2]-dp[x1-1][y2]);
 
			}
			else if(x1==0&&y1>0)
			{
				System.out.println(dp[x2][y2]-dp[x2][y1-1]);
 
			}
				
			  
			
			
		}

	}

}

// 2
2 5
1 2
3 10
1 2 3
*/