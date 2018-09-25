package com.sc;

import java.util.*;
public class MovingTotal {
    /**
     * Adds/appends list of integers at the end of internal list.
     */
   Set<Integer> sumSet=new HashSet<>();
   
   int[] data=new int[3];
    
    public void append(int[] list) {
        if(list.length!=0){
           for(int i=0;i<list.length;i++) {
        	   		data[i]=list[i];
           }
           
           int sum=0;
           for(int j=0;j<data.length;j++) {
        	   		sum=sum+data[j];
           }
           sumSet.add(sum);
            
        } else {
            throw new UnsupportedOperationException("Waiting to be implemented.");
        }
        
    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given total.
     */
    public boolean contains(int total) {
        if(!sumSet.isEmpty()){
               if(sumSet.contains(total)) {
            	   	return true;
               }
            	   
        }else{
            throw new UnsupportedOperationException("Waiting to be implemented.");
        }
        return false;
    }

    public static void main(String[] args) {
        MovingTotal movingTotal = new MovingTotal();

        movingTotal.append(new int[] { 1, 2, 3 });

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));

        movingTotal.append(new int[] { 4 ,5,6});

        System.out.println(movingTotal.contains(15));
    }
}
