/**
 * 
 */
package com.wayfair;

import java.util.*;

/**
 * @author Sachin Garg
 *
 */
public class OpeningClosingTracking {

	/**
	 * @param args
	 */
	static String value = "1+(2+3)";
	static String value1 = ")1(1+(2+3)";
	static String value2 = "(1)+((2+3))";
	static String value3 = "(1)+(2+3)+)3+9(";
	static int open = 0;
	static int close = 0;
	public static void main(String[] args) {
		//System.out.println(isStringValid(value.toCharArray()));
		//System.out.println(isStringValid(value1.toCharArray()));
		//System.out.println(isStringValid(value2.toCharArray()));
		//System.out.println(isStringValid(value3.toCharArray()));
		
		System.out.println(identifyBalancedBrackets(value));
		System.out.println(identifyBalancedBrackets(value1));
		System.out.println(identifyBalancedBrackets(value2));
		System.out.println(identifyBalancedBrackets(value3));
		
		//System.out.println(balancedParenthensies("{(a,b)}"));
        //System.out.println(balancedParenthensies("{(a},b)"));
        //System.out.println(balancedParenthensies("{)(a,b}"));
        System.out.println(balancedParenthensies(value));
      	System.out.println(balancedParenthensies(value1));
      	System.out.println(balancedParenthensies(value2));
      	System.out.println(balancedParenthensies(value3));
	}
	
	static boolean isStringValid(char[] charList){
		boolean flag = false;
		int openingBraces = 0;
		int closingBraces = 0;
		
		for(int i=0; i < charList.length; i++){
			
			if(charList[i] == '('){
				++openingBraces;
				open = i;
			}
			
			if(charList[i] ==  ')'){
				++closingBraces;
				close = i;
			}
		}
		
		System.out.println(openingBraces + " " +  closingBraces);
		
		if(open < close && openingBraces == closingBraces){
			flag = true;
		}
		
		return flag;
	}
	
	static boolean identifyBalancedBrackets(String value){
		Stack<String> stack = new Stack<>();
		for(int i = 0 ; i < value.length(); i ++ ){
			String ch = String.valueOf(value.charAt(i));	
			if(ch.equals("(")){
				stack.push(ch);
			}else if(")".equals(ch)){
				if(stack.isEmpty() || !"(".equals(stack.pop())){
					return false;
				}
			}
		}
		
		return stack.isEmpty();
	}
	
	public static boolean balancedParenthensies(String s) {
        Stack<Character> stack  = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {     
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }           
            } else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
