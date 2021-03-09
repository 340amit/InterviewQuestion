package com.ing;

public class LongetChain {

	public static void main(String[] args) {
		int arr[] = { 5, 4, 0, 3, 1, 6, 2 };
		System.out.println(soultion(arr));

	}

	static int countBeads(int arr[], int start, int max) {

		int curr_max = 0;

		while (arr[start] != -1) {
			curr_max++;
			int temp = arr[start];
			arr[start] = -1;
			start = temp;
		}

		return Math.max(max, curr_max);
	}

	static int soultion(int[] arr) {

		int maxBeads = 0, currBeads;
		for (int i = 0; i < arr.length; i++) {
			currBeads = countBeads(arr, i, maxBeads);
			maxBeads = Math.max(currBeads, maxBeads);
		}
		return maxBeads;
	}

}
