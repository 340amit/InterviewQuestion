package com.tipico;

import java.util.HashMap;
import java.util.Map;

public class Problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solution(String A, String B) {
        Map<Character, Integer> cardSet = new HashMap<>();
        cardSet.put('A', 14);
        cardSet.put('K', 13);
        cardSet.put('Q', 12);
        cardSet.put('J', 11);
        cardSet.put('T', 10);
        cardSet.put('9', 9);
        cardSet.put('8', 8);
        cardSet.put('7', 7);
        cardSet.put('6', 6);
        cardSet.put('5', 5);
        cardSet.put('4', 4);
        cardSet.put('3', 3);
        cardSet.put('2', 2);
        
        int aWin = 0;
        
        for(int i = 0; i < A.length(); i++) {
        		int aVal = cardSet.get(A.charAt(i));
        		int bVal = cardSet.get(B.charAt(i));
        		if(aVal > bVal) aWin ++;
        }
        
        return aWin;
        
    }

}
