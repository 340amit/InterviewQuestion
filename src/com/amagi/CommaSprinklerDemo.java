package com.amagi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

@SuppressWarnings({ "unchecked"})
public class CommaSprinklerDemo {
	int n;
	String[] tokens;
	Map<String, Integer> dataMap;
	boolean[] haveComma;
	boolean[] havePeriod;
	List<Integer>[] before;
	List<Integer>[] after;
	int[] ids;

	int id = 0;

	public static void main(String[] args) {
		CommaSprinklerDemo csd = new CommaSprinklerDemo();
		String input = "please sit spot. sit spot, sit. spot here now here.";
		csd.formDataSets(input);
		csd.processDataSets();
		System.out.println(csd.getCommaSprinkler());
	}


//		Generate final output after recursively marking the graph
	String getCommaSprinkler() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n - 1; i++) {
			sb.append(tokens[i]);
			if (haveComma[i])
				sb.append(",");
			if (havePeriod[i])
				sb.append(".");
			sb.append(" ");
		}
		sb.append(tokens[n - 1] + ".");

		return sb.toString();
	}

//	filter out words,comma and periods
	void formDataSets(String s) {
		dataMap = new HashMap<>();

		StringTokenizer token = new StringTokenizer(s);
		n = token.countTokens();

		tokens = new String[n];
		haveComma = new boolean[n];
		havePeriod = new boolean[n];

		ids = new int[n];

		int i = 0;

		while (token.hasMoreTokens()) {
			String tmp = token.nextToken();
			int len = tmp.length();
			if (tmp.charAt(len - 1) == '.') {
				havePeriod[i] = true;
				tokens[i] = tmp.substring(0, len - 1);
			} else if (tmp.charAt(len - 1) == ',') {
				haveComma[i] = true;
				tokens[i] = tmp.substring(0, len - 1);
			} else
				tokens[i] = tmp;

			if (!dataMap.containsKey(tokens[i])) {
				dataMap.put(tokens[i], id++);
			}

			ids[i] = dataMap.get(tokens[i]);
			i++;
		}
	}

//	form graph with visited comma and period
	void processDataSets() {
		before = new ArrayList[id];
		for (int i = 0; i < id; i++)
			before[i] = new ArrayList<>();
		after = new ArrayList[id];
		for (int i = 0; i < id; i++)
			after[i] = new ArrayList<>();

		for (int i = 0; i < n - 1; i++) {
			if (havePeriod[i])
				continue;
			after[ids[i]].add(ids[i + 1]);
			before[ids[i + 1]].add(ids[i]);
		}

		boolean[] visited1 = new boolean[id];
		boolean[] visited2 = new boolean[id];

		for (int i = 0; i < n; i++) {
			if (haveComma[i]) {
				dfsTraverse(visited1, visited2, ids[i], true);
				dfsTraverse(visited1, visited2, ids[i + 1], false);
			}
		}
		for (int i = 0; i < n; i++) {
			if (haveComma[i] || havePeriod[i])
				continue;
			if (visited1[ids[i]])
				haveComma[i] = true;
			if (i < n - 1 && visited2[ids[i + 1]])
				haveComma[i] = true;
		}
	}

//	traverse graph recursively
	void dfsTraverse(boolean[] visited1, boolean[] visited2, int v, boolean dir) {
		if (dir) {
			visited1[v] = true;
		} else {
			visited2[v] = true;
		}
		List<Integer> next = dir ? after[v] : before[v];
		boolean[] visited = dir ? visited2 : visited1;
		for (Integer i : next) {
			if (!visited[i]) {
				dfsTraverse(visited1, visited2, i, !dir);
			}
		}
	}

}
