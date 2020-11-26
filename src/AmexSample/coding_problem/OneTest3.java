/**
 * 
 */
package com.capitalone;

import java.util.Scanner;

/**
 * @author Sachin Garg
 *
 */
public class OneTest3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "THE BIG DOG";

		processString();

	}

	private static void processString() {

		String original, reverse = "";
		Scanner in = new Scanner(System.in);

		System.out.println("Enter a string to reverse");
		original = in.nextLine();

		int length = original.length();

		for ( int i = length - 1 ; i >= 0 ; i-- ){
			reverse = reverse + original.charAt(i);
		}

		System.out.println("Reverse of entered string is: "+reverse);
		
		String[] strArr = reverse.split(" ");
		
		for(int j = strArr.length - 1 ; j >= 0; j--){
			System.out.print(strArr[j] +" ");
		}		
		
	}		

	

}
