/**
 * 
 */
package com.leetcode;

/**
 * @author Sachin Garg
 *
 */
public class LeetCodeMaximum69numberLeet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maximum69Number(9669);
	}

	public static int maximum69Number (int num) {
		System.out.println(num);
		char[] number = String.valueOf(num).toCharArray();
		String empty = "";
		
		
		for(int i=0; i< number.length; i++) {
			if(number[i] == '9') {
				number[i] = '6';      
			}else if(number[i] == '6') {
				number[i] = '9'; 
			}
			System.out.println(number);
		}
		return num;
	}
}
