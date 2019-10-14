package com.bizongo;

import java.util.Arrays;

public class Test1 {
	
	/*5
	19 123 12 24 85
	4
	5 1
	6 1
	73 3
	23 5*/

	public static void main(String[] args) {
		/*
		int[] a= {19,123,12,24,85};
		int q=4;
		int[] x= {5,6,73,23};
		int[] k= {1,1,3,5};
		
		int[] result=findMax(a,q,x,k);
		System.out.println("Result:"+result[0]);
		System.out.println("Result:"+result[1]);
		System.out.println("Result:"+result[2]);
		System.out.println("Result:"+result[3]);
		*/
		String s1="archit";
		String s2="ar";
		String temp="X";
//		String k=s1.replace(s2,);
		System.out.println("Result:"+s1.replace(s2, temp));
		
		//findMinOps(s1,s2);
	}
			
	static int findMinOps(String s1,String s2) {
		if(s1.contains(s2)) {
			s1.replace(s2, "X");
			System.out.println("S1:"+s1);
		}
		
		return 1;
	}
	
	static int findMinInsertionsDP(char str[], int n) {
		// Create a table of size n*n. table[i][j]
		// will store minumum number of insertions
		// needed to convert str[i..j] to a palindrome.
		int table[][] = new int[n][n];
		int l, h, gap;

		// Fill the table
		for (gap = 1; gap < n; ++gap)
			for (l = 0, h = gap; h < n; ++l, ++h)
				table[l][h] = (str[l] == str[h]) ? table[l + 1][h - 1]
						: (Integer.min(table[l][h - 1], table[l + 1][h]) + 1);

		// Return minimum number of insertions
		// for str[0..n-1]
		return table[0][n - 1];
	}
	
	static int[] findMax(int[]a,int q,int[] x,int[] k) {
		int len=a.length;
		int[] output=new int[q];
		for(int m=0;m<q;m++) {
			output[m]=getMax(a,k[m],x[m],len);
		}
		return output;
	}
	
	static int getMax(int[] a,int k,int t,int len) {
		int b[]=new int[len];
		for(int j=0;j<a.length;j++) {
			b[j]=a[j]^t;
		}
		Arrays.sort(b);
		return b[len-k];
	}
}
