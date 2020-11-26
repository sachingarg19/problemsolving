/**
 * 
 */
package com.leetcode;

import java.util.*;

/**
 * @author Sachin Garg
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
public class LeetCodeLongestsubstringWithoutReplacingChar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring(" "));
		System.out.println(lengthOfLongestSubstring("au"));
		System.out.println(lengthOfLongestSubstring("cdd"));
	}

	
	public static int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int len = s.length();
		String output = "";
		for(int start=0, end=0; end < len; end++){
			char c = s.charAt(end);
			if(map.containsKey(c)){
				start = Math.max(map.get(c)+1, end);
			}
			if(output.length() < end - start + 1){
				output = s.substring(start, end+1);
			}
			map.put(c, end);
		}
		System.out.println(output);
		System.out.println(map);
		return output.length();
	}
}
