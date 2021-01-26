/**
 * 
 */
package com.topcoder;

import java.util.Stack;

/**
 * @author Sachin Garg
 *
 *‘5’, ‘4’, ‘+’ = 9  
5 + 4 = 9 
‘3’, ‘4’, ‘-’, ‘5’, ‘+’ = 4 
3 - 4 + 5 = 4 
‘12’, ‘5’, ‘4’, ‘+’, ‘-’ = 3 
12 - (5 + 4) = 3 

 */
public class ReversePolishCalculator {

	public static void main(String[] args) {
		String[] token = new String[] { "5", "4", "+"};
		System.out.println(evalReversePolishNotation(token));
		
		String[] token1 = new String[] { "3", "4", "-","5","+"};
		System.out.println(evalReversePolishNotation(token1));
		
		String[] token2 = new String[] { "12", "5", "4","+","-"};
		System.out.println(evalReversePolishNotation(token2));
		
		String[] token3 = new String[] { "40", "5", "4","*","/"};
		System.out.println(evalReversePolishNotation(token3));

	}
	    static public int evalReversePolishNotation(String[] tokens) {
	 
	        int value = 0;
	 
	        String operators = "+-*/";
	 
	        Stack<String> stack = new Stack<String>();
	 
	        for(String t : tokens){
	            if(!operators.contains(t)){
	                stack.push(t);
	            }else{
	                int a = Integer.valueOf(stack.pop());
	                int b = Integer.valueOf(stack.pop());
	                int index = operators.indexOf(t);
	                switch(index){
	                    case 0:
	                        stack.push(String.valueOf(a+b));
	                        break;
	                    case 1:
	                        stack.push(String.valueOf(b-a));
	                        break;
	                    case 2:
	                        stack.push(String.valueOf(a*b));
	                        break;
	                    case 3:
	                        stack.push(String.valueOf(b/a));
	                        break;
	                }
	            }
	        }
	 
	        value = Integer.valueOf(stack.pop());
	 
	        return value;
	 
	    }

}
