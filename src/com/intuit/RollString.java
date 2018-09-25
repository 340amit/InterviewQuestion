package com.intuit;

import java.util.stream.IntStream;

public class RollString {

	public static void main(String[] args) {
		/*char a1=97;
		System.out.println(a1);
		char a2=122;
		System.out.println(a2);
		int c1=a2+1;
		char a3=(char) c1;
		System.out.println(a3);
		char[] alphabet=new char[26];
		for (char i = 'a'; i <= 'z'; i++) {
		    alphabet[i - 'a'] = i;
		}
		
		for(int i=0;i<alphabet.length;i++) {
			System.out.print(alphabet[i]+" ");
		}*/
	String s="abz";
	int roll[]= {3,2,1};
		System.out.println(rollTheString(s,roll));


	}

	public static String rollTheString(String s, int roll[]) {

		int len = s.length();
		
		int count[] = new int[len];

		/*Arrays.stream(roll).forEach(rollCount -> count[rollCount - 1]++);
		for (int i = len - 2; i >= 0; i--) {
			count[i] += count[i + 1];
		}*/

		char result[] = s.toCharArray();
		
		IntStream.range(0, len).forEach(index -> {
			result[index] = (char) ('a' + (roll[index] % 26 + result[index] - 'a') % 26);
//			result[index] = (char) ('a' + (roll[index] % 26));
		});

		return String.valueOf(result);

	}

}
