package com.tomtom;

import java.util.Arrays;

public class Problem1 {

	public static void main(String[] args) {
		int a[]= {1,4,7,3,3,5};
		System.out.println(solution(a));

	}
	
	 public static int solution(int[] A) {
		 int[] valueDistances = new int[A.length];
	        int[] distances = new int[A.length];
	        int minDistance = 0;
	        Arrays.fill(valueDistances, Integer.MAX_VALUE);

	        for (int i = 0; i < A.length; i++) {
	            for (int j = i + 1; j < A.length; j++) {
	                int valueDistance = Math.abs(A[i] - A[j]);
	                if (valueDistances[i] >= valueDistance) {
	                    valueDistances[i] = valueDistance;
	                    distances[i] = Math.abs(i - j);
	                    if (distances[i] > minDistance) {
	                    	minDistance = distances[i];
	                    }
	                }
	                if (valueDistances[j] > valueDistance)
	                    valueDistances[j] = valueDistance;
	            }
	        }
	        return minDistance > 0 ? minDistance : -1;
	    
	    }

}
