/*
 * Count identical pairs
 */
package com.zalando;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem3 {

	public static void main(String[] args) {
		int[] A= {3,5,6,3,3,5,6};
		System.out.println("Pairs:"+countPairs(A));
//		System.out.println("Pairs2:"+countPairs2(A));
		System.out.println("Pairs3:"+countPairs3(A));
		
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
			if(ip>1000000000) return 1000000000;
		}
		
		return ip;
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
	
	public static int countPairs3(int[] A) {
		
		Map<Integer, Long> occurrences =
			    IntStream.of(A).boxed().collect(
			        Collectors.groupingBy(Function.identity(), Collectors.counting()));
			
		System.out.println("occurrences:"+occurrences);

		long count =
			    occurrences.values().stream()
			        .mapToLong(e -> e * (e - 1) / 2)
			        .sum();
			
			return Math.toIntExact(count);
	}
	
	public static long getLimit(long i) {
		return i>4?4:i;
	}

}
