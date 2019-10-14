package com.gs;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Question {

	public static void main(String[] args) {
		int[] numberArray = {56789};
		
		if(numberArray != null && numberArray.length <= 0) {}
            //return "";
        Set<Integer> sortedOutput = new TreeSet<>();
        for(int i =0 ; i < numberArray.length; i++){
            String inp = Integer.toString(numberArray[i]);
            if(inp.contains("1") && inp.contains("2") && inp.contains("3")){
                sortedOutput.add(numberArray[i]);
            }

        }
        if(sortedOutput.size() > 0) {
        Iterator<Integer> it = sortedOutput.iterator();
        String outPut = "";
        while(it.hasNext()){
            outPut = outPut + it.next().toString() + ",";
        }
        System.out.println("output : " + outPut.substring(0,outPut.length()-1));
        //return outPut.substring(0,outPut.length()-1);
        }
	}
}
