package com.prudential;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Problem3 {

	public static void main(String[] args) {
		List<String> strToEvaluate = new ArrayList<>();
		strToEvaluate.add("abc");
		System.out.println("Result:" + scatterPalindrome(strToEvaluate));

	}

	public static List<Integer> scatterPalindrome(List<String> strToEvaluate) {
		List<Integer> list = new ArrayList<>();
		if (strToEvaluate == null || strToEvaluate.size() == 0)
			return list;

		String str = strToEvaluate.get(0);

		TreeMap<String, Integer> palindromes = new TreeMap<>();
		int len = str.length();

		int[][] row = new int[2][len + 1];

		str = "@" + str + "#";

		for (int j = 0; j <= 1; j++) {
			int radius = 0;
			row[j][0] = 0;

			int i = 1;
			while (i <= len) {

				while (str.charAt(i - radius - 1) == str.charAt(i + j + radius))
					radius++;
				row[j][i] = radius;
				int k = 1;
				while ((row[j][i - k] != radius - k) && (k < radius)) {
					row[j][i + k] = Math.min(row[j][i - k], radius - k);
					k++;
				}
				radius = Math.max(radius - k, 0);
				i += k;
			}
		}

		str = str.substring(1, str.length() - 1);

		palindromes.put(str.substring(0, 1), 1);
		for (int i = 1; i < len; i++) {
			for (int j = 0; j <= 1; j++)
				for (int rp = row[j][i]; rp > 0; rp--)
					palindromes.put(str.substring(i - rp - 1, i - rp - 1 + 2 * rp + j), 1);
			palindromes.put(str.substring(i, i + 1), 1);
		}

		list.add(palindromes.size());

		return list;

	}

	private int distinctMove(String s, int n, int x, int y) {
		Set<String> result = new HashSet<String>();
		rec_move(s, n, x, y, 0, new StringBuilder(), result);
		return result.size();
	}

	private void rec_move(String input, int length, int x, int y, int currentIndex, StringBuilder path,
			Set<String> resultlist) {
		if (x == y) {
			resultlist.add(path.toString());
		}

		if (currentIndex < 0 || currentIndex >= length)
			return;

		char c = input.charAt(currentIndex);
		rec_move(input, length, x, y, currentIndex + 1, path, resultlist);
		if (c == 'r') {
			rec_move(input, length, x + 1, y, currentIndex + 1, path.append("r"), resultlist);
			path.deleteCharAt(path.length() - 1);
		} else {
			rec_move(input, length, x - 1, y, currentIndex + 1, path.append("l"), resultlist);
			path.deleteCharAt(path.length() - 1);
		}
	}

}
