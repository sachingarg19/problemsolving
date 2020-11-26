/**
 * 
 */
package com.topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sachin Garg
 * https://community.topcoder.com/stat?c=problem_statement&pm=1669
 */
public class PaternityTest {

	/**
	 * @param args
	 */
	
	static String[] fathers1 = { "SBTD", "QRCD" };
	public static void main(String[] args) {
		System.out.println(possibleFathers("ABCD", "AXCY", fathers1));

	}

	
	public static int[] possibleFathers(String child, String mother, String[] menArr){
		int[] results = {};
		List<String> tempChild = new ArrayList<>();
		char[] childArr = convertToCharArr(child);
		System.out.println(childArr);
		System.out.println(convertToCharArr(mother));
		String temp = "";
		for(int c = 0; c < childArr.length; c++){
			if (!mother.contains(String.valueOf(childArr[c]))){
				temp += String.valueOf(childArr[c]);
			}
		}
		System.out.println(temp);
		char[] tempChildArr = temp.toCharArray();
		for(int men = 0; men < menArr.length; men++) {
			System.out.println(menArr[men]);
			for(char c : tempChildArr){
				if(menArr[men].contains(String.valueOf(c))){
					System.out.println(men);
					results[men] = men;
				}
			}
			//System.out.println(convertToCharArr(men));
		}
		
		return results;
	}
	
	private static char[] convertToCharArr(Object obj){
		char[] charArr = obj.toString().toCharArray();
		Arrays.sort(charArr);
		return charArr;
	}
}
