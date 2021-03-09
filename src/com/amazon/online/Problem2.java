package com.amazon.online;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

	public static void main(String[] args) {
		Problem2 p = new Problem2();
		List<List<String>> codeList = new ArrayList<List<String>>();
		List<String> code = new ArrayList<String>();
		code.add("apple");
		code.add("apple");
		codeList.add(code);
		code = new ArrayList<String>();
		code.add("anything");
		code.add("banana");
		code.add("orange");
		codeList.add(code);

		List<String> shoppingCart = new ArrayList<String>();
		shoppingCart.add("orange");
		shoppingCart.add("apple");
		shoppingCart.add("apple");
		shoppingCart.add("orange");
		shoppingCart.add("banana");
		shoppingCart.add("orange");

		System.out.println(p.check(codeList, shoppingCart));

	}

	public static int checkWinner(List<List<String>> codeList, List<String> shopingCart) {
		int cartLen = shopingCart.size();
		int index = 0;
		int count = 0;
		int currentIndex = 0;
		for (List<String> codes : codeList) {
			index = currentIndex;
			count = 0;
			while (count != codes.size()) {
				if (currentIndex == cartLen) {
					return 0;
				}
				currentIndex++;
				for (String code : codes) {
					if (index < cartLen
							&& (code.equalsIgnoreCase(shopingCart.get(index)) || code.equalsIgnoreCase("Anything"))) {
						index++;
						count++;
					} else {
						count = 0;
						index = currentIndex;
						break;
					}
				}
				if (count == codes.size()) {
					codes.stream().forEach(i -> {
						System.out.print(i + " ");
					});
					currentIndex = index;
				}
			}
		}
		return 1;
	}

	public int check(List<List<String>> codeList, List<String> shoppingCart) {
		// covert codeList to arraylist
		List<String> xmList = new ArrayList<String>();
		for (List<String> eh : codeList) {
			for (String st : eh) {
				xmList.add(st);
			}
		}
		System.out.println(xmList);
		System.out.println(shoppingCart);
		if (xmList.size() > shoppingCart.size())
			return 0;
		int j = 0;
		for (int i = 0; i <= shoppingCart.size() - xmList.size(); i++) {
			while (j < xmList.size()
					&& (xmList.get(j).equals(shoppingCart.get(i + j)) || xmList.get(j).equals("anything"))) {
				j++;
			}
			if (j == xmList.size()) {
				return 1;
			}
			j = 0;
		}

		return 0;
	}

}
