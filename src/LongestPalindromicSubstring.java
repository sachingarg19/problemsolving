/*
5. Longest Palindromic Substring
Medium

6415

513

Add to List

Share
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

*/

class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		System.out.println(s);
		if (s.isEmpty())
			return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = stringLength(s, i, i);
			int len2 = stringLength(s, i, i + 1);
			int longestWordLen = Math.max(len1, len2);
			if (longestWordLen > end - start) {
				start = i - (longestWordLen - 1) / 2;
				end = i + longestWordLen / 2;
			}
		}

		return s.substring(start, end + 1);
	}

	private static int stringLength(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}
}
