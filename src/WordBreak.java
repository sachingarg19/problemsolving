/**
139. Word Break
Medium

5604

271

Add to List

Share
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

**/

class Solution {
    Map<String, Boolean> map = new HashMap();
    public boolean wordBreak(String s, List<String> wordDict) {
        // Iterate over S from left to Right
        // Concatination each index and check if it's present in wordDict or not
        // return True if all combinations are present otherwise false; 
        
        return workBreakRecur(s, wordDict);
    }
    
    private boolean workBreakRecur(String s, List<String> wordDict) {
        if(wordDict.contains(s)) return true;
        if(map.containsKey(s)) return map.get(s);
        
        for(int i=1; i<s.length(); i++){
            String leftStr = s.substring(0, i);
            if(wordDict.contains(leftStr) && workBreakRecur(s.substring(i, s.length()), wordDict)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
