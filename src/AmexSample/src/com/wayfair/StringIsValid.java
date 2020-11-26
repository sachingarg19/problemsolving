/**
 * 
 */
package com.wayfair;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sachin Garg
 *
 */
public class StringIsValid {

	/**
	 * @param args
	 */
	static String regex = "[A-Z][a-z]*";
	static String str = "Sachin";
	public static void main(String[] args) {
		validateString(str);
	}
	private static void validateString(String str2) {
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(str2);
		System.out.println(match.matches());
	}

}
