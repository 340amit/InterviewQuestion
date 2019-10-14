package com.amazon.online;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimalDeviceUsage {

	public static void main(String[] args) {
		// deviceCapacity=7
		//foregroundAppList=[[1,3],[2,5],[3,7],[4,10]]
		//backgroundAppList=[[1,2],[2,3],[3,4],[4,5]]
	/*
	 *  int deviceCapacity=10;
		List<List<Integer>> foregroundAppList=new ArrayList<>();
		List<Integer> f1=new ArrayList<>();
		f1.add(1);
		f1.add(3);
		foregroundAppList.add(f1);
		List<Integer> f2=new ArrayList<>();
		f2.add(2);
		f2.add(5);
		foregroundAppList.add(f2);
		List<Integer> f3=new ArrayList<>();
		f3.add(3);
		f3.add(7);
		foregroundAppList.add(f3);
		List<Integer> f4=new ArrayList<>();
		f4.add(4);
		f4.add(10);
		foregroundAppList.add(f4);
		
		List<List<Integer>> backgroundAppList=new ArrayList<>();
		List<Integer> b1=new ArrayList<>();
		b1.add(1);
		b1.add(2);
		backgroundAppList.add(b1);
		List<Integer> b2=new ArrayList<>();
		b2.add(2);
		b2.add(3);
		backgroundAppList.add(b2);
		List<Integer> b3=new ArrayList<>();
		b3.add(3);
		b3.add(4);
		backgroundAppList.add(b3);
		List<Integer> b4=new ArrayList<>();
		b4.add(4);
		b4.add(5);
		backgroundAppList.add(b4);
		*/
		int deviceCapacity=7;
		List<List<Integer>> foregroundAppList=new ArrayList<>();
		List<Integer> f1=new ArrayList<>();
		f1.add(1);
		f1.add(2);
		foregroundAppList.add(f1);
		List<Integer> f2=new ArrayList<>();
		f2.add(2);
		f2.add(4);
		foregroundAppList.add(f2);
		List<Integer> f3=new ArrayList<>();
		f3.add(3);
		f3.add(6);
		foregroundAppList.add(f3);
		
		List<List<Integer>> backgroundAppList=new ArrayList<>();
		List<Integer> b1=new ArrayList<>();
		b1.add(1);
		b1.add(2);
		backgroundAppList.add(b1);
		
		OptimalDeviceUsage od=new OptimalDeviceUsage();
		od.optimalUtilization(deviceCapacity, foregroundAppList, backgroundAppList);

	}
	
	List<List<Integer>> optimalUtilization(int deviceCapacity,List<List<Integer>> foregroundAppList,List<List<Integer>> backgroundAppList){
		List<List<Integer>> result=new ArrayList<>();
		int rows=foregroundAppList.size()+1;
		int cols=backgroundAppList.size()+1;
		int[][] data=new int[rows][cols];
		int lenSum=rows*cols;
		int[] sumData=new int[lenSum];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				data[i][j]=0;
			}
		}
		
		int s=0;
		for(int k=1;k<rows;k++) {
			for(int l=1;l<cols;l++) {
				int sum=foregroundAppList.get(k-1).get(1)+backgroundAppList.get(l-1).get(1);
				System.out.println("Sum:"+sum);
				data[k][l]=sum;
				sumData[s]=sum;
				s++;
				if(sum==deviceCapacity) {
					List<Integer> temp=new ArrayList<>();
					temp.add(k);
					temp.add(l);
					result.add(temp);
					System.out.println("Temp Result:"+temp+"-- sum:"+sum);
				}
				
			}
		}
		System.out.println(Arrays.asList(data));
		
		int newDeviceCapacity=0;
		
		if(result.isEmpty()) {
			System.out.println("Result Empty .. calculate newDeviceCapacity");
			Arrays.sort(sumData);
			for(int n=lenSum-1;n>=0;n--) {
				if(sumData[n]<deviceCapacity) {
					newDeviceCapacity=sumData[n];
					System.out.println("newDeviceCapacity:"+newDeviceCapacity);
					n=-1;
				}
			}

			for(int i=1;i<rows;i++) {
				for(int j=1;j<cols;j++) {
					int sum=data[i][j];
					if(sum==newDeviceCapacity) {
						List<Integer> temp=new ArrayList<>();
						temp.add(i);
						temp.add(j);
						result.add(temp);
					}
				}
			}
		}
		
		System.out.println("Final Result:"+result);
		
		return result;
	}

}
