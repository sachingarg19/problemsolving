/*
3. Longest Substring Without Repeating Characters
Medium

8790

529

Add to List

Share
Given a string, find the length of the longest substring without repeating characters.

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

*/

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        return findLongeestSubstring(s);
    }
    
    public int findLongeestSubstring(String s){
        Set set = new HashSet();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while(right < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, set.size());
                right++;
            }else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        
        return maxLen;
    }
}
