package com.gs;

import java.util.List;

public class TravelerFund {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int requiredAmountAtStart(List<Integer> netSaving) {
        int sum=0;
        for(int i= netSaving.size()-1; i >= 0;i--){
                if( netSaving.get(i) < 0){
                    sum += netSaving.get(i);  
                }else if(sum < 0 && netSaving.get(i) > 0){
                    sum += netSaving.get(i);
                }
        }
        if(sum>=0){
           return 0;
        }else{ 
        return (Math.abs(sum)+1);
        }
    }

}
