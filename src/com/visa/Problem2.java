package com.visa;

public class Problem2 {

	public static void main(String[] args) {
		Problem2 p2=new Problem2();
		int n = 74;
		p2.getFirstPrimePair(n);

	}
	
	void printMatrix(int[][] matrix) {
		
		int i, j, t;
		int M=matrix.length;
		int N=matrix[0].length;
        for( t = 0; t<M+N; ++t) {
        		for( i=t, j=0; i>=0 ; --i, ++j) {
        			 if( (i<M) && (j<N) ) {
        				 System.out.print(matrix[i][j]+" ");
        			 }      
        		}
        		System.out.println();
        }
             
	}

	boolean SieveEratosthenes(int n, boolean data[]) {
		data[0] = false;
		data[1] = false;
		for (int i = 2; i <= n; i++)
			data[i] = true;

		for (int j = 2; j * j <= n; j++) {
			if (data[j] == true) {
				for (int k = j*j; k <= n; k += j)
					data[k] = false;
			}
		}
		return false;
	}

	 void getFirstPrimePair(int n) {
		boolean data[] = new boolean[n + 1];
		SieveEratosthenes(n, data);

		for (int i = 0; i < n; i++) {
			if (data[i] && data[n - i]) {
				System.out.print(i + " " + (n - i));
				break;
			}
		}
	}

}
