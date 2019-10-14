/*
 * Bulb Moments - Light bulb only if previous bulb is on
 */
package com.zalando;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem1 {

	Set<Integer> input = new HashSet<>();

	public static void main(String[] args) {
		Problem1 p1 = new Problem1();
		// int[] A= {2,1,3,5,4};
		int[] A = { 2, 3, 4, 1, 5 };
		// System.out.println("Moments:"+p1.solution(A));
		// System.out.println("Moments:"+p1.getVal(A));
		System.out.println("Moments:" + p1.getMaxCount(A));
	}

	//Solution 1 Optimized - O(n)
	public int getMaxCount(int[] A) {
		int count = 0;
		int sum = 0;
		int total = 0;
		for (int i = 0; i < A.length; i++) {
			sum = (((i + 1) * (i + 2)) / 2);
			total += A[i];

			if (sum == total)
				count++;
		}
		return count;
	}

	//Solution 2 not optimized - O(n^2) - O(n)
	public int solution(int[] A) {
		int moments = 0;
		for (int i = 0; i < A.length; i++) {
			if (!input.contains(A[i])) {
				input.add(A[i]);
				if (isAllValAvailable(A[i])) {
					moments++;
				}
			}
		}
		return moments;
	}

	boolean isAllValAvailable(int num) {
		for (int i = num - 1; i > 0; i--) {
			if (!input.contains(i)) {
				return false;
			}
		}
		return true;
	}

}
