package com.gs;

public class TruckerProfit {

	public static void main(String[] args) {
		int[][] cargoList=new int[][] {{58,330,500},{21,280,1800},{13,120,1500}};
		int maxWeight=300;
		System.out.println(maxProfit(cargoList,maxWeight));
	}
	
	static int maxProfit(int[][] cargoList,int maxWeight) {
		int row = cargoList.length;
		int mP=0;
		int mW=maxWeight;
		for(int i=0;i<row;i++) {
			int cW=cargoList[i][1];
			int cP=cargoList[i][2];
			for(int j=i+1;j<row;j++) {
				cW=cW+cargoList[j][1];
				cP=cP+cargoList[j][2];
				if(cW<=mW) {
					mP=Math.max(mP, cP);
					System.out.println("mp:"+mP);
				}else {
					cW=cW-cargoList[j][1];
					cP=cP-cargoList[j][2];
				}
			}
		}
		return mP;
	}

}
