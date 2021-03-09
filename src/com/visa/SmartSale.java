package com.visa;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class SmartSale {

	public static void main(String[] args) {
//		int coins[] = {1, 1, 0 , 1};
		int coins[] = {1, 0, 0 , 1, 0};
		playSegments(coins);

	}
	
	static int playSegments(int[] coins) {
		// 1 1 0 1
		// 0 1 2 1 2
		// 1 0 0 1 0
		// 0 1 0 -1 0 -1
		int n = coins.length;
		int score[] = new int[n+1];
		int k = 1;
		for(int i = 0; i< n; i++) {
			for(int j = 0; j<= i; j++) {
				if(coins[j] == 0) {
					score[k] -= 1;
				}else {
					score[k] += 1; 
				}
			}
			k++;
		}
		
		System.out.println(Arrays.toString(score));
		int max = Integer.MIN_VALUE;
		int maxIndex = 0;
		for(int i = 0; i < n; i++) {
			if(score[i]>max) {
				max = score[i];
				maxIndex = i;
			} 
		}
		
		System.out.println("MaxIndex:"+maxIndex);
		
		return maxIndex;
	}

}
