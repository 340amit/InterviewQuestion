 package com.delivery.hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem1 {

	public static void main(String[] args) {
		
		String p = "a,0 b,0 a,10 a,20 b,20 b,40 b,50 b,60 a,60";
		String d = "a";
		int s = 10;
		
		Problem1 prob = new Problem1();
//		int count = prob.solution(p, d, s);
		
//		System.out.println("Count:"+ count);
		
		System.out.println("Count:"+ prob.solution1(p, d, s));

	}
	
	public int solution(String p, String d, int s) {
		String[] data = p.split(" ");
		List<Integer> list = new ArrayList<>();
		for(String m: data) {
			String[] elements = m.split(",");
			if(d.equals(elements[0])) {
				list.add(Integer.parseInt(elements[1]));
			}
		}
		int prev = list.get(0);
		int count = 0;
		for(int i=1; i<list.size(); i++) {
			int current = list.get(i);
			if(current - (prev + s) != 0) count++;
			prev = current;
		}
		
		return count;
	}
	
	public long solution1(String p, String d, int s) {
		
		return Arrays.stream(p.split(" ")).map(x -> x.split(",")).filter(it -> d.equals(it)).count();
		
	}

}

//a,0 b,0 a,10 a,20 b,20 b,40 b,50 b,60

