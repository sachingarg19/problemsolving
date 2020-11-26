/**
 * 
 */
package com.wayfair;

/**
 * @author Sachin Garg
 *
 *	The question was rather easy, I was asked to implement a function that given an integer number num, it returns the a string representation of the number, comma separated.
	i.e. f(1234) = “1,234”
 *
 */
public class NumberNumToCommaSeparated {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(formatNumToString(1000000, 3));
		
		System.out.println(formatNumToString(12312300, 2));
	}
	
	static String formatNumToString(int num, int formatPattern){
		int total_process = 0;
		StringBuilder returnString = new StringBuilder("");
		while(num > 0) {
			if(total_process != 0 && total_process%3 == 0){
				returnString.append(",");
			}
			returnString.append((char)(num%10 + '0'));
			total_process ++;
			num /= 10;
		}
		return returnString.reverse().toString();
	}

}
