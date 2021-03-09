package com.tipico;

public class Problem3 {

	public static void main(String[] args) {
		
//		int[] A = {4, -1, 0, 3};
//		int[] B = {-2, 5, 0, 3};
		
//		([2, -2, -3, 3], [0, 0, 4, -4])
		int[] A = {2, -2, -3, 3};
		int[] B = {0, 0, 4, -4};
		System.out.println(solution(A,B));

	}
//	int[] A = {2, -2, -3, 3};
//	int[] B = {0, 0, 4, -4};
	public static int solution(int[] A, int[] B) {
		int sumA = 0;
		int sumB = 0;
		

		for (int i = 0; i < A.length; ++i) {
			sumA += A[i];
			sumB += B[i];
		}
		
		int leftSumA = A[0];
		int leftSumB = B[0];
		
		for (int i = 0; i < A.length; ++i) {
			sumA -= A[i];
			System.out.println("SumA:"+sumA);
			sumB -= B[i];
			System.out.println("SumB:"+sumB);

			if (leftSumA == sumA && leftSumB == sumB && leftSumA == leftSumB && sumA == sumB)
				return i;

			leftSumA += A[i];
			leftSumB += B[i];
		}

		return -1;
	}
	
	
	public int solution2(int[] A, int[] B) {
		
		int leftSum=0,rightSum = 0;
		int finalIndex = -1;
		for(int i =0,j=A.length-1;i<j; ) {
			if(leftSum>rightSum) {
				rightSum += A[j];
				j--;
			}if(leftSum<rightSum) {
				leftSum += A[i];
				i++;
			} else {
				leftSum  += A[i];
				rightSum += A[j];
				i++;
				j--;
			}
			
			
			
		}
		
		return 0;
		
	}
	
//	int[] A = {2, -2, -3, 3};
//	int[] B = {0, 0, 4, -4};
	public int solution1(int[] A, int[] B) {
		int sumA = 0;
		int sumB = 0;
		for (int i = 0; i < A.length; i++) {
			sumA += A[i];
			sumB += B[i];
		}
		int count = 0;
		int tempA = A[0];
		int tempB = B[0];
		for (int i = 1; i < A.length; i++) {
			if (i != 1 && tempA == tempB && 2 * tempA == sumA && 2 * tempB == sumB) {
				count++;
			}
			tempA += A[i];
			tempB += B[i];
		}
		return count;
}

}
