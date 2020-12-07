/**
140. Word Break II
Hard

2677

426

Add to List

Share
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]

Ref: https://www.youtube.com/watch?v=jQJyWcRPEpE&ab_channel=NareshGupta

*/

class Solution {
    Map<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        // It's DFS approach
        // Check if dict contains s then store in result;
        // iterate over the string index by index
        // concate each index and check if present in dict or not
        // if present then get the sublist by making recursive calls
        // loop over the sublist and add left and right strings
        // take out subdict and perform the same
        List<String> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();
        
        if(wordDict.contains(s)) wordSet.add(s);
        if(map.containsKey(s)) return map.get(s);
        
        int len = s.length();
        for(int i = 1; i<= len; i++) {
            String leftS = s.substring(0, i); // taking substring
            
            if(wordDict.contains(leftS)) {
                List<String> subList = wordBreak(s.substring(i, len), wordDict);
                for(String sen: subList) {
                    wordSet.add(leftS + " " + sen);
                }
            }
        }
        result.addAll(wordSet);
        map.put(s, result);
        return result;
    }
}
