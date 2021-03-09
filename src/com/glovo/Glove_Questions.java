package com.glovo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Glove_Questions {

	public static void main(String args[]) {
		int a[] = { 1, 0, 0, 1, 1, 1 };
//		getCeiling(a);
		toNegativeBase(-11,-2);
	}

	public static int[] getCeiling(int[] A) {

		Double sum = 1 * A[0] * 1.0;
		for (int i = 1; i < A.length; i++) {
			sum = sum + Math.pow(-2, i) * A[i];

		}
		int result =  (int)Math.ceil(sum / 2);
		
		System.out.println("Result:"+ result);

		/*
		 * for(int i=0;i<A.length;i++) { if(i%2==0) { sum = sum+A[i]*2^i; } else { sum =
		 * sum+A[i]*2^i; } } sum = (int)Math.ceil(sum/2);
		 * 
		 * String binaray = Integer.toBinaryString(sum); int result = 0; for(int
		 * i=0;i<binaray.length();i++) {
		 * 
		 * result = result-Integer.valueOf(binaray.charAt(i))*(-2)^i;
		 * 
		 * }
		 */
		System.out.println(" " + sum);

//		List<Integer> l = toNegativeBase(result, -2);

//		System.out.println("List:" + l);

//		return l.stream().mapToInt(i -> i).toArray();
		
//		String converted = toNegativeBase(result, -2);
		
//		return convert(converted);
		int[] out = toNegativeBase(result, -2);
		for(int i =0; i< out.length; i++) {
			System.out.print(out[i]+" ");
		}
		return toNegativeBase(result, -2);

	}
	
	static int[] toNegativeBase(int n, int negBase) 
	{ 
		List<Integer> al = new ArrayList<>();
		// If n is zero then in any base 
		// it will be 0 only 
//		if (n == 0) 
//			return 0; 
		String converted = ""; 
		while (n != 0) 
		{ 
			// Get remainder by negative base, 
			// it can be negative also 
			int remainder = n % negBase; 
			n /= negBase; 

			// if remainder is negative, 
			// add Math.abs(base) to it 
			// and add 1 to n 
			if (remainder < 0) 
			{ 
				remainder += (-negBase); 
				n += 1; 
			} 

			// convert remainder to String add into the result 
			converted = String.valueOf(remainder) + converted; 
//			al.add(remainder);
			

		} 
		/*int len = converted.length();
		int[] x = new int [len];
		for(int i = 0; i < len; i++) {
			x[0] = Integer.valueOf(converted.charAt(i));
		}*/
//		System.out.println("converted:"+converted);
		/*int[] res = new int[st.size()];
		int i =0;
		while(!st.isEmpty()) {
			res[i] = st.pop();
			System.out.print(res[i] +" ");
			i++;
		}*/
		
//		System.out.println("List:"+al);
		
		System.out.println("Converted:"+converted);
		
		return al.stream().mapToInt(i -> i).toArray();
	} 
	
	static List<Integer> convert(String converted) {
		int len = converted.length();
//		int[] x = new int [len];
		List<Integer> x = new ArrayList<>();
		for(int i = 0; i<len; i++) {
			x.add(Integer.valueOf(converted.charAt(len-1 -i)-'0'));
		}
		
		System.out.println(x);
		 return x;
	}

	static List<Integer> convert_base(int n, int b) {
		List<Integer> output = new ArrayList<>();
//		Stack<Integer> stk = new Stack<>();
		while (n != 0) {
			int x = Math.abs(n % b);
			System.out.println("X:"+x);
			output.add(x);
			n /= b;
			System.out.println("N:"+n);
		}
		/*while (!stk.empty()) {
			output.add(Math.abs(stk.peek()));
			stk.pop();
		}*/
		return output;
	}

}