package com.gs;

import java.util.HashSet;
import java.util.Set;

public class NonRepeating {

	public static void main(String[] args) {
		System.out.println("finalcount:"+nonRepeatingDigitProductCount(2,10,15));

	}
	
	static int nonRepeatingDigitProductCount(int x, int y, int z) {
        Set<Character> inValidSet=createInValidDigit(y,z);
        int count=0;
        for(int i=y;i<=z;i++){
            long prod=new Long(x)* new Long(i);
            System.out.println("prod:"+prod);
            if(isValid(prod,inValidSet)){
                count++;
                System.out.println("count:"+count);
            }
        }
        return count;
    }
        
static boolean isValid(long prod,Set<Character> inValidSet){
    char[] prodArr=String.valueOf(prod).toCharArray();
    for(int i=0;i<prodArr.length;i++){
    	System.out.println(prodArr[i]);
        if(inValidSet.contains(prodArr[i])){
            return false;
        }
    }
    return true;       
}               
static Set<Character> createInValidDigit(int y,int z){
    Set<Character> hs=new HashSet<>();
    for(int i=y;i<=z;i++){
        hs.addAll(convertHashSet(i));
    }
    System.out.println("createInValidDigit:"+hs);
    return hs;
}
static Set<Character> convertHashSet(int h){
    Set<Character> hs=new HashSet<>();
    char[] hArr=String.valueOf(h).toCharArray();
    for(int i=0;i<hArr.length;i++){
        hs.add(hArr[i]);
    }
    return hs;
}               
}
