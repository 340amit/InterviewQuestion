package com.ing;

public class ConsequtiveProduct {

	public static void main(String[] args) {
		System.out.println("Result:"+solution(6, 20));

	}
	
	public static int solution(int A, int B) {
		int l = (int) Math.sqrt(A);
		int r = (int) Math.sqrt(B);

		int i = l * (l + 1);
		int j = r * (r + 1);

		int start = i >= A && i <= B ? 1 : 0;
		int end = j >= A && j <= B ? 1 : 0;

		int count = r - l - 1 + start + end;

		return count >= 0 ? count : 0;
		}

}
