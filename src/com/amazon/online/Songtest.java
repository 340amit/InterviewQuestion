package com.amazon.online;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Songtest {

	public static void main(String[] args) {
		ArrayList<Integer> arr=new ArrayList<>();
		arr.add(1);
		
	}

	ArrayList<Integer> IDsOfSongs(int rideDuration, ArrayList<Integer> songDurations) {
		ArrayList<Integer> result = new ArrayList<>();
		int timeRequired = rideDuration - 30;
		HashSet<Integer> data = new HashSet<>();
		int p1=-1;
		int p2Val=-1;
		int p2=-1;
		for (int i = 0; i < songDurations.size(); i++) {
			int temp = timeRequired - songDurations.get(i);
			if (data.contains(temp)) {
				p1=i;
				p2Val=temp;
			} else {
				data.add(songDurations.get(i));
			}
		}
		
		for(int j=0;j<songDurations.size(); j++) {
			if(songDurations.get(j)==p2Val) {
				p2=j;
			}
		}
		result.add(p1);
		result.add(p2);
		return result;
	}

}
