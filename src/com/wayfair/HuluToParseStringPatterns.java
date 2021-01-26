package com.wayfair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
 * Given a string, parse it and return a string array. It's like a tokenizer, but the rules are too...

For exmple, string="abc(edf)hij{klmn}opq[rst]uvw"

The delimitors are (), {}, []. They are in pair. So output array:

["abc", "edf", "hij", "klmn", "opq", "rst", "uvw"]

That's the rule 1. The rule 2 is, if any two consecutive "(" means escaping, that is "((" is actually output char "(". 
It's not part of the delimitor.
Similar to ")", "{", "}", "[", "]". abc(e))df) =&gt; ["abc", "e)df"], since the "))" outpus ")".

Rule 3: if "{" is inside a delimitor pair (), then "{" isn't part of the delimitor. Output it as is.

abc(e{df}}g) =&gt; ["abc", "e{df}}g"]

So, parse the given string and assume the given string is always valid and parsable.
 * */
public class HuluToParseStringPatterns {

	static Stack<String> rule1Stack = new Stack<>();
	static String rule1 ="abc(edf)hij{klmn}opq[rst]uvw";
	
	public static void main(String[] args) {
		
		buildListBasedOnRule1(rule1);
	}
	
	static void buildListBasedOnRule1(String rule1) {
		String rule1Symbols = "(){}[]";
		List<String> list = new ArrayList<String>();
		
		for(int i =0; i < rule1.length(); i++) {
			String str = String.valueOf(rule1.charAt(i));
			if(!rule1Symbols.contains(str)){
				rule1Stack.push(str);
			}else{
				buildStr(list);	
			}	
		}
		
		if(rule1Stack.size() > 0) {
			buildStr(list);
		}
		
		System.out.println(list);
		
	}

	private static void buildStr(List<String> list) {
		StringBuilder sb = new StringBuilder();
		Iterator<String> itr = rule1Stack.iterator();
		while(itr.hasNext()){
			sb.append(rule1Stack.pop()).reverse();		
		}
		list.add(sb.toString());
		System.out.println(sb.toString());
	}

}
