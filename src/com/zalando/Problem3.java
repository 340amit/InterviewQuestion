/*
 * Count identical pairs
 */
package com.zalando;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem3 {

	public static void main(String[] args) {
		int[] A= {3,5,6,3,3,5};
		System.out.println("Pairs:"+countPairs(A));
		System.out.println("Pairs2:"+countPairs2(A));

	}
// Solution 1
	public static int countPairs(int[] A) {
		Map<Integer,Integer> temp = new HashMap<>();
		int len=A.length;
		if(len==1) return 0;
		int ip = 0;
		Arrays.stream(A).forEach((d)->{
					if (!temp.containsKey(d)) {
						temp.put(d, 1);
					}else {
						temp.put(d, temp.get(d)+1);
					}
		});
		/*for (int i=0;i<len;i++) {
			if (!temp.containsKey(A[i])) {
				temp.put(A[i], 1);
			}else {
				temp.put(A[i], temp.get(A[i])+1);
			}
		}*/
		
		for (Map.Entry<Integer,Integer> m:temp.entrySet()) {
			int tc = m.getValue();
			ip =ip+ ((tc * (tc - 1))/2);
		}
		
		
		
		return ip>1000000000?1000000000:ip;
	}
	//Solution Trial
	public static int countPairs2(int[] A) {
		Map<Integer, Integer> temp = new HashMap<>();
		int len = A.length;
		
		if (len == 1 || len==0)
			return 0;
		long ip = 0L;
		int maxVal = 1000000000;
		Arrays.stream(A).forEach((d) -> {
			if (!temp.containsKey(d)) {
				temp.put(d, 1);
			} else {
				int t=temp.get(d)+1;
				
				temp.put(d, temp.get(d) + 1);
			}
		});
		/*
		 * for (int i=0;i<len;i++) { if (!temp.containsKey(A[i])) { temp.put(A[i], 1);
		 * }else { temp.put(A[i], temp.get(A[i])+1); } }
		 */
		ip=Integer.MAX_VALUE-1;
		for (Map.Entry<Integer, Integer> m : temp.entrySet()) {
			int tc = m.getValue();
			if (Integer.MAX_VALUE < ip) {
				return maxVal;
			}
			ip = ip + ((tc * (tc - 1)) / 2);
		}
		if (ip > Integer.valueOf(maxVal)) {
			return maxVal;
		} else {
			return Math.toIntExact(ip);
		}
	}


}
