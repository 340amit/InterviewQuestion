package com.amazon.online;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem1 {

	public static void main(String[] args) {
		Problem1 p = new Problem1();
		System.out.println(p.subStringsLessKDist("democracycracy", 5));

	}

	/*
	 * public List<String> subStringsLessKDist(String inputString, int num) {
	 * List<String> result = new ArrayList<>(); for (int i = 0; i <=
	 * inputString.length() - num; i++) { String temp = inputString.substring(i, i +
	 * num); if (isValid(temp)) { result.add(temp); } } return result; }
	 * 
	 * public boolean isValid(String str) { Map<Character, Integer> hm = new
	 * HashMap<>(); for (int i = 0; i < str.length(); i++) { char temp =
	 * str.charAt(i); if (!hm.containsKey(temp)) { hm.put(temp, 1); } else {
	 * hm.put(temp, hm.get(temp) + 1); } } int count = 0; for (Map.Entry<Character,
	 * Integer> it : hm.entrySet()) { if (it.getValue() == 2) count++; }
	 * 
	 * return count == 1 ? true : false; }
	 */

	public static List<String> subStringsLessKDist(String inputString, int num) {
		List<String> result = new ArrayList<>();

		if (inputString == null || inputString.isEmpty())
			return result;

		int len = inputString.length();
		if (len < num)
			return result;

//		Set<String> ocurrences = new HashSet<>();
		List<String> ocurrences = new ArrayList<>();
		int[] letters = new int[26];

		int count = 0;

		int i = 0;
		for (i = 0; i < len; i++) {
			if (i >= num) {
				if (count == num - 1) {
					ocurrences.add(inputString.substring(i - num, i));
				}

				if (--letters[inputString.charAt(i - num) - 'a'] == 0) {
					count--;
				}

			}

			if (letters[inputString.charAt(i) - 'a']++ == 0) {
				count++;
			}
		}

		if (count == num - 1)
			ocurrences.add(inputString.substring(i - num, i));

		return new ArrayList<String>(ocurrences);
	}
}
