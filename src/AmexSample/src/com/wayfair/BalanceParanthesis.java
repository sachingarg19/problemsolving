package com.wayfair;
import java.util.*;

public class BalanceParanthesis {

	public static void main (String [] args){
		String str = "{}";
		//System.out.println("Is expression balanced " + validateExpression(str.toCharArray()));
		
		String str1 = "})({{}";
		//System.out.println("Is expression balanced str1 " + validateExpression(str1.toCharArray()));
		
		String str2 = "[[[{}]]]";
		System.out.println("Is expression balanced str2 " + validateExpression(str2.toCharArray()));
		
		String str3 = "{[[][]]}";
		//System.out.println("Is expression balanced " + validateExpression(str3.toCharArray()));
		
		String str4 = "{({)}}";
		//System.out.println("Is expression balanced " + validateExpression(str4.toCharArray()));
	}
	
	private static boolean validateExpression1(char[] inp){
		boolean status = false;
		Stack stack = new Stack();
		for(char c: inp){
			if(c == '{' || c == '(' || c == '['){
				stack.push(c);
			} else if(c == '}' || c == ')' || c == ']'){
				if(stack.isEmpty()){
					status = false;
				} else{
					if(!matchingPattern((Character) stack.pop(),c)){
						status = stack.isEmpty();
					}
					status = true;
				}
			}	
		}
		return status;
	}
	
	private static boolean matchingPattern(char char1, char char2){
		boolean isMatching = false;
		if(char1 == '(' && char2 ==')'){
			isMatching = true;
		}else if(char1 == '{' && char2 =='}'){
			isMatching = true;
		}else if(char1 == '[' && char2 ==']'){
			isMatching = true;
		}
		return isMatching;
	}
	
	private static boolean validateExpression(char[] inp){
		boolean status = false;
		
		Stack openStack = new Stack();
		Stack closeStack = new Stack();
		String openningParantheis =  "{([";
		Map<String, String> openMap = new HashMap<>();
		String closingParanthesis = "})]";
		for(char c: inp) {
			if(openningParantheis.contains(String.valueOf(c))){
				openStack.push(c);
				switch(c) {
				case '{':
					openMap.put("}", String.valueOf(c));
					break;
				case '(':
					openMap.put(")", String.valueOf(c));
					break;
				case '[':
					openMap.put("]", String.valueOf(c));
					break;
				default:
					break;
				}
				
			}
			if(closingParanthesis.contains(String.valueOf(c))){
				closeStack.push(c);
			}
		}
		
		if(openStack.size() == closeStack.size()){
			System.out.println(openStack);
			System.out.println(openMap);
			System.out.println(closeStack);
			Iterator openStackItr = openStack.iterator();
			Iterator closedStackItr = closeStack.iterator();
			while(openStackItr.hasNext()){
				
			}	
		}

		return status;
		
	}
}
