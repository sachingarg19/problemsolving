/**
 * 
 */
package com.practise;

/**
 * @author Sachin Garg
 *
 */
public class RomanNumberToInteger {

	/**
	 * @param args
	 */
	
	static int I = 1; //1
	static int V = 5; //5
	static int X = 10; //10
	static int L = 50; //50
	
	static String romanNumber = "LXXIX";//34
	
	public static void main(String[] args) {
		romanNumberToInteger(romanNumber);
	}

	private static void romanNumberToInteger(String romanNumber2) {
		char[] charList = romanNumber2.toCharArray();
		int a = 0;
		for(char char1: charList){
			a = a + romanCharValue(char1);
			
			if(romanNumber2.indexOf('I') == (romanNumber2.indexOf('V') -1)) {
				a = a-I;
			}
			if(romanNumber2.indexOf('X') == (romanNumber2.indexOf('L') -1)) {
				System.out.println("a -- " + a);
				a = a-X;
			}
			if(romanNumber2.indexOf('I') == (romanNumber2.indexOf('X') -1) ) {
				System.out.println("a -- " + a);
				a = a-I;
			}
			//System.out.println(romanNumber2.indexOf(char1));
		}

		System.out.println(a);
	}
	
	private static int romanCharValue(char ch){
		
		if(ch == 'I')
			return 1;
		if(ch == 'V')
			return 5;
		if(ch == 'X')
			return 10;
		if(ch == 'L')
			return 50;
		
		return -1;
	}

}
