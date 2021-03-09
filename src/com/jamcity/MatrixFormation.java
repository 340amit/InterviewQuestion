/*package com.jamcity;

public class MatrixFormation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String solution(int U, int L, int[] C) {

		StringBuilder str1 = new StringBuilder();
		StringBuilder str2 = new StringBuilder();

		for (int i = 0; i < C.length; i++) {
			if (C[i] == 0) {

				str1.append("0");
				str2.append("0");

			} else if (C[i] == 2) {
				if (U > 0 && L > 0) {

					str1.append("1");
					str2.append("1");
					U -= 1;
					L -= 1;
				} else
					return "IMPOSSIBLE";

			} else if (C[i] == 1) {
				if (U > 0) {

					str1.append("1");
					str2.append("0");
					U -= 1;
				} else if (L > 0) {
					str1.append("0");
					str2.append("1");
					L -= 1;
				} else
					return "IMPOSSIBLE";
			}

		}

		return str1.append(",").append(str2).toString();
	}
	 
	 
	 public int[] solution(int N) {
	        Random _random = new Random();
	        int[] arr = new int[N];
	        for(int i = 0; i<N; i++){
	            arr[i] = _random.Next(1, 1000);
	        }
	        return arr;
	    }
	 
	 public int solution(int[] A) {
	        if(A.Length == 1) return 1;
	        if(A.Length == 2 && A[0] != A[1]) return 1;
	        
	        int max =0;
	        int count =0;
	        for(int i=0; i<A.Length-2;i++){
	            if((A[i] > A[i+1] && A[i+1]< A[i+2]) || 
	            (A[i] < A[i+1] && A[i+1] > A[i+2])){
	                count++;
	            }else count =0;
	            
	            if(count > max) max = count;
	        }
	        Console.WriteLine("Max:"+(max+2));
	        return max +2;
	    }
}*/
