package com.zalando;

public class FindNth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int findNth(int n) 
	{ 
//		int count = 0; 

		for (int curr = 29;; curr += 8) { 

			// Find sum of digits in current no. 
			int sum = 0; 
			for (int x = curr; x > 0; x = x / 10) 
				sum = sum + x % 10; 

			// If sum is 10, we increment count 
			if (sum == 10) 
				return curr;

			// If count becomes n, we return current 
			// number. 
			//if (count == n) 
				//return curr; 
		} 
	} 


}
