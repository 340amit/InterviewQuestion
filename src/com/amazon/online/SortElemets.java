package com.amazon.online;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortElemets {

	public static void main(String[] args) {
		//Expected Result : Sort element when the second element is char but let number entry be in it's order
		//r1 box ape bit
		//br8 eat nim did
		//w1 has uni gry
		//b4 xi me nu
		//t2 13 121 98
		//f3 52 54 31
		
		List<String> data=new ArrayList<>();
		data.add("w1 has uni gry");
		data.add("t2 13 121 98");
		data.add("r1 box ape bit");
		data.add("f3 52 54 31");
		data.add("br8 eat nim did");
		data.add("b4 xi me nu");
		
		orderJunctionBoxes(data.size(),data);

	}
	
	public static List<String> orderJunctionBoxes(int numberOfBoxes,List<String> boxList){
		List<String> l1=new ArrayList<>();
		List<String> l2=new ArrayList<>();
		Map<String,String> t=new TreeMap<>();
		for(String s:boxList) {
			String[] boxSplit=s.split(" ",2);
			String box1=boxSplit[0];
			String box2=boxSplit[1];
			if(box2.matches("^[a-zA-Z\\s]*$")) {
				t.put(box2, box1+" "+box2);
			}else {
				l1.add(s);
			}
		}
		
		System.out.println("PrintList L1");
		printList(l1);
		
		for(Map.Entry<String,String> m:t.entrySet()) {
			l2.add(m.getValue());
		}
		
		System.out.println("PrintList L2");
		printList(l2);
		
		
		
		l2.addAll(l1);
		
		System.out.println("PrintList Sorted");
		printList(l2);
		
		return l2;
	}
	
	static void printList(List<String> l){
		for(String s:l) {
			System.out.println(s);
		}
	}

}
