/*
 * Task
Usually when you buy something, you're asked whether your credit card number, phone number or answer to your most secret question is still correct.
However, since someone could look over your shoulder, you don't want that shown on your screen. Instead, we mask it.

Your task is to write a function maskify, which will:

Mask all digits (0-9) with #, unless they are first or last four characters.
Never mask credit cards with less than 6 characters.
Never mask non-digit characters.
Examples
Input	Output	Comments
"4556364607935616"	"4###########5616"	
"4556-3646-0793-5616"	"4###-####-####-5616"	
"64607935616"	"6######5616"	
ABCD-EFGH-IJKLM-NOPQ	ABCD-EFGH-IJKLM-NOPQ	
A1234567BCDEFG89HI	A#######BCDEFG89HI	
"12345"	"12345"	No #s if less than 6 characters
""	""	Make sure to handle empty strings
"Skippy"	"Skippy"
 */
package com.klarna;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class CreditCardMasking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String maskify(String creditCardNumber) {
	      if(creditCardNumber == null ) return null;
	      int len = creditCardNumber.length();
	      if(len < 6) return creditCardNumber;
	      
	      char[] cr = creditCardNumber.toCharArray();
	       
	      for(int i =1; i< len - 4; i++){
	        if(isDigit(cr[i])){
	          cr[i] = '#';  
	        }  
	      }  
	      return new String(cr);
	    }
	  
	  static boolean isDigit(char c){
	   return (c >= '0' && c <= '9');
	  }
	
	public double evaluate(String expr) {
	    String[] tokens = expr.split(" ");
	    Map<String, BiFunction<Double, Double, Double>> op = new HashMap<>();
	        op.put("+", (b, a) -> a + b);
	        op.put("-", (b, a) -> a - b);
	        op.put("*", (b, a) -> a * b);
	        op.put("/", (b, a) -> a / b);
	   Stack<Double> stack = new Stack<>();
	   for(String token : tokens)
	            switch(token) {
	                case "+": case "-": case "*": case "/":
	                    stack.push(op.get(token).apply(stack.pop(), stack.pop())); break;
	                default:
	                    stack.push(Double.parseDouble(token));
	            }
	       return stack.peek();
	  }
	
	public static String numberToOrdinal(Integer number) {

		StringBuilder sb = new StringBuilder();
		sb.append(number);

		if (number == 0)
			return sb.toString();

		if (number % 100 <= 13 && number % 100 >= 11) {
			return sb.append("th").toString();
		} else if (number % 10 == 1) {
			return sb.append("st").toString();
		} else if (number % 10 == 2) {
			return sb.append("nd").toString();
		} else if (number % 10 == 3) {
			return sb.append("rd").toString();
		} else {
			return sb.append("th").toString();
		}

	}

}
