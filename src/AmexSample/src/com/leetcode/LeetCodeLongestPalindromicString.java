/**
 * 
 */
package com.leetcode;

/**
 * @author Sachin Garg
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 *
 */

import java.util.*;

public class LeetCodeLongestPalindromicString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(longestPalindrome1("babad"));
		System.out.println(longestPalindrome1("cbbd"));
	}

	public static String longestPalindrome1(String s) {
		System.out.println(s);
		if (s.isEmpty()) return "";
		int start = 0, end =0;
		for(int i = 0; i < s.length(); i++){
			int len1 = stringLength(s, i, i);
			int len2 = stringLength(s, i, i+1);
			int longestWordLen = Math.max(len1, len2);
			if(longestWordLen > end-start){
				start = i-(longestWordLen-1)/2;
				end = i + longestWordLen/2;
			}
		}

		return s.substring(start, end+1);
	}
	
	private static int stringLength(String s, int left, int right){
		while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
			left--;
			right++;
		}
		return right-left-1;
	}
	
	public static String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        int start= 0;
        int end = 0;
        for (int i=0; i<s.length(); i++){ //cbbd
            int len1 = longest(s, i, i); //cbbd,0,0 len1 = 0; cbbd,1,1 len1 = 1; 2,2 len1=1; 3,3 len1= 1
            int len2 = longest(s, i, i+1); //cbbd,0,1 len2 =0; cbbd,1,2 len2 = 2; 2, 3 len2= 0; 3, 4 len2 = 0
            int longestWord = Math.max(len1, len2); //= 0 ; 2 ; 1; 1
            if(longestWord > end-start){ //0> 0 2 > 0 1 > 2-1
                start = i-(longestWord-1)/2; //1-(2-1)/2 = 1 - 1/2 = 0
                end = i+longestWord/2; // 1+2/2 = 2
                System.out.println("i - " + i  + " len1 - " + len1 + " len2 - " + len2 + " Start - " + start + " end - " + end);
            }
        }
        return s.substring(start, end+1);
    }
    
    public static int longest(String s, int left, int right){
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right) ){ //c==c c!=b; 2- b==b  b == b; b==b b!=d; d==d
            left--; // 0 0 0 1 2
            right++; //1 2 3 3 4
        }
        return right-left-1; //1-0-1 =0 1-0-1 =0 2 - 0 -1 = 1 3-0-1 = 2 3-1-1 = 1 3-2-1 = 0 4 - 2-1= 1 4 - 3 -1 =0
    }

}
