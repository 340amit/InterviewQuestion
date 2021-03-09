package com.prudential;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

	public static void main(String[] args) {
		System.out.println(getPalindSubstring("abc"));
		// a, aa, aca, c
		List<String> strToEvaluate = new ArrayList<>();
		strToEvaluate.add("abc");
		System.out.println("Result:" + scatterPalindrome(strToEvaluate));
	}

	public static List<Integer> scatterPalindrome(List<String> strToEvaluate) {
		List<Integer> list = new ArrayList<>();
		if (strToEvaluate == null || strToEvaluate.size() == 0)
			return list;

		String str = strToEvaluate.get(0);

		List<String> pList = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		getPalindrome(str, pList, 0, sb);

		list.add(pList.size());

		return list;
	}

	private static void getPalindrome(String str, List<String> pList, int current, StringBuilder sb) {
		if (isValid(sb.toString()) && sb.length() > 0) {
			pList.add(sb.toString());
		}
		for (int i = current; i < str.length(); i++) {
			if (i > current && str.charAt(i) == str.charAt(i - 1))
				continue;

			sb.append(str.charAt(i));
			getPalindrome(str, pList, i + 1, sb);

			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private static boolean isValid(String str) {
		int[] data = new int[26];
		for (char c : str.toCharArray()) {
			data[c - 'a']++;
		}
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] % 2 == 1)
				count++;
		}
		return count < 2;
	}

	private static List<Integer> getPalindSubstring(String s) {
		List<String> res = new ArrayList<>();
		dfs(s, res, 0, new StringBuilder());
		List<Integer> list = new ArrayList<>();
		list.add(res.size());
		return list;
	}

	private static void dfs(String s, List<String> res, int cur, StringBuilder sb) {
		if (isValid(sb.toString()) && sb.length() > 0) {
			res.add(sb.toString());
		}
		for (int i = cur; i < s.length(); i++) {
			if (i > cur && s.charAt(i) == s.charAt(i - 1))
				continue;
			sb.append(s.charAt(i));
			dfs(s, res, i + 1, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private static boolean isValid1(String s) {
		int[] cnt = new int[26];
		for (char c : s.toCharArray()) {
			cnt[c - 'a']++;
		}
		int count = 0;
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] % 2 == 1)
				count++;
		}
		return count < 2;
	}

}
