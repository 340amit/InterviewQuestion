/*
 * Find number of steps to reduce a number to zero. If even divide by 2, if odd subtract by 1
 */
package com.zalando;

public class Problem2 {

	public static void main(String[] args) {
		Problem2 p2=new Problem2();
//		System.out.println("Steps:"+p2.solution("011100"));
//		System.out.println("Steps Optimized:"+p2.getCount("011100"));//28
//		System.out.println("Steps Optimized:"+p2.getCount("00100000"));//32
		System.out.println("Steps Optimized:"+p2.getCount("00001110"));//14
		System.out.println("Steps Optimized2:"+p2.getCount2("00001110"));//14
		System.out.println("Steps Optimized:"+p2.getCount("00000111"));//7
		System.out.println("Steps Optimized2:"+p2.getCount2("00000111"));//7
		System.out.println("Steps Optimized:"+p2.getCount("00000001"));//1
		System.out.println("Steps Optimized2:"+p2.getCount2("00000001"));//1
		System.out.println("Steps Optimized:"+p2.getCount("00000000"));//0
		System.out.println("Steps Optimized2:"+p2.getCount2("00000000"));//0
		System.out.println("Steps Optimized:"+p2.getCount("00000010"));//2
		System.out.println("Steps Optimized2:"+p2.getCount2("00000010"));//2
		System.out.println("Steps Optimized:"+p2.getCount("00000011"));//3
		System.out.println("Steps Optimized2:"+p2.getCount2("00000011"));//3
		System.out.println("Steps Optimized:"+p2.getCount("00000100"));//4
		System.out.println("Steps Optimized2:"+p2.getCount2("00000100"));//4

	}
	//solution 1 - optimized - O(6)
	public int getCount(String s) {
		char[] arr=s.toCharArray();
		int len =arr.length;
		int k=0;
		int temp=0;
		while(k<len) {
			if(arr[k]=='1') {
				temp=len-k;
				k=k+1;
				break;
			}
			k++;
		}
		while(k<len) {
			
			if(arr[k]=='1')
				temp++;
			k++;
		}
		return temp;
	}
	//Solution -2 Optimized - O(6) - One loop
	public int getCount2(String s) {
		char[] arr=s.toCharArray();
		int len =arr.length;
		int temp=0;
		boolean found=false;
		for(int j=0;j<len;j++) {
			if(arr[j]=='1' && !found) {
				temp =len -j;
				found=true;
			}else if (arr[j]=='1'){
				temp++;
			}
		}
		return temp;
	}
	
	
	//Solution 3 not optimized - O(n)
	public int solution(String S) {
		try {
			int num = Integer.parseInt(S);
			
			int dNum = convertBinaryToDecimal(num);
			
			int count = 0;
			while (dNum != 0) {
				count++;
				if (dNum % 2 == 0) {
					dNum = dNum / 2;
				} else {
					dNum=dNum-1;
				}
			}
			return count;
			
		} catch (NumberFormatException e) {
			return 0;
		}
	}
	
	private int convertBinaryToDecimal(int n) {
		int num = n;
		int decimalValue = 0;
		int base = 1;
		int temp = num;
		while (temp > 0) {
			int lastDigit = temp % 10;
			temp = temp / 10;
			decimalValue += lastDigit * base;
			base = base * 2;
		}
		return decimalValue;
	}

}