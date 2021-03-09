/*
 * Your job is to create a calculator which evaluates expressions in Reverse Polish notation.

For example expression 5 1 2 + 4 * + 3 - (which is equivalent to 5 + ((1 + 2) * 4) - 3 in normal notation) should evaluate to 14.

Note that for simplicity you may assume that there are always spaces between numbers and operations, e.g. 1 3 + expression is valid, but 1 3+ isn't.

Empty expression should evaluate to 0.

Valid operations are +, -, *, /.

You may assume that there won't be exceptional situations (like stack underflow or division by zero).
 */

package com.klarna;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class ReversePolishExpr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public double evaluate(String expr) {
	    if(expr == "") return 0;
		String[] tokens = expr.split(" ");
		Map<String, BiFunction<Double, Double, Double>> op = new HashMap<>();
		op.put("+", (b, a) -> a + b);
		op.put("-", (b, a) -> a - b);
		op.put("*", (b, a) -> a * b);
		op.put("/", (b, a) -> a / b);
		
	    Stack<Double> stack = new Stack<>();
		for(String token : tokens){
	      switch(token) {
		    case "+": 
	        case "-": 
	        case "*": 
	        case "/":
		      stack.push(op.get(token).apply(stack.pop(), stack.pop())); 
	          break;
		    default:
		      stack.push(Double.parseDouble(token));
		   }
	    }
	    return stack.peek();
		  
	  }

}
