package com.visa;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean canConstructLetter(String text, String note) {
		String textArrTemp = text.replace(" ", "");
        char[] textArr=textArrTemp.toCharArray();
        String noteArrTemp = note.replace(" ", "");
        char[] noteArray=noteArrTemp.toCharArray();
        
        Map<Character,Integer> textMap=new HashMap<>();
        
        for(char c:textArr) {
        		if(textMap.containsKey(c)) {
        			textMap.put(c, textMap.get(c)+1);
        		}else if(c !=' '){
        			textMap.put(c, 1);
        		}
        }
        int count=0;
        
		for (char n : noteArray) {
			if (textMap.containsKey(n) && textMap.get(n) != 0) {
				count++;
				textMap.put(n, textMap.get(n) - 1);
			}
		}
		
		if(count==note.length()) {
			return true;
		}
		
		return false;
    }

}
