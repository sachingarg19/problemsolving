/**
 * 
 */
package com.appian;

/**
 * @author Sachin Garg
 *
 */
public class Palindrome {

	/**
	 * @param args
	 */
	
	static int[] intArr = {121, 343, 345, 57911975};
	public static void main(String[] args) {
		
		System.out.println(isPalidrome("Nitin"));
		System.out.println(isPalidrome("Sachin"));
		System.out.println(isPalidrome("121"));
		for(int i: intArr) {
			System.out.println(i + " -- " + isPalidrome(String.valueOf(i)));
		}
		
		StringBuilder sb1 = new StringBuilder("1344312");
		System.out.println("value -- " +  sb1.reverse().toString());
	}
	
	static boolean isPalidrome(String str) {
		boolean status = false;
		StringBuilder sb = new StringBuilder(str);
		
		if(str.equalsIgnoreCase(sb.reverse().toString())) {
			status = true;
			//System.out.println(str);
		}
		return status;
	}

}
