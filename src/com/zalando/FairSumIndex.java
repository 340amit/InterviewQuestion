package com.zalando;

public class FairSumIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solution(int[] A, int[] B) {
		int sumA = 0;
        int sumB = 0;
        for(int i=0; i<A.length; i++){
            sumA+=A[i];
            sumB+=B[i];
        }
        int count = 0;
        int tempA = A[0];
        int tempB = B[0];
        for(int i = 1; i<A.length;i++){
            if(i!=1 && tempA == tempB && 2*tempA == sumA  && 2*tempB == sumB){
                count++;
            }
            tempA+=A[i];
            tempB+=B[i];
        }
        return count;
    }
	
	public int solution(int N) {
        int sum = getSum(N);
        
        int result = N;
        
        while(sum != getSum(result = result + 9));
        
    return result;

    }
    
    int getSum(int n) 
    {     
        int sum = 0; 

        while (n != 0) 
        { 
            sum = sum + n % 10; 
            n = n/10; 
        } 
      
    return sum; 
    } 

}
