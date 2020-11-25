/**
459. Repeated Substring Pattern
Easy

2080

207

Add to List

Share
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 

Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
*/
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        boolean result = false; 
        if(s.length() < 2) return result;
        return tryingDifferentSolution(s);
    }
    
    /*Working solution*/
    private boolean tryingDifferentSolution(String s) {   
        for (int i = 1; i <= (s.length() >>> 1); ++i) {
            if (s.equals(s.substring(i) + s.substring(0, i))) return true;
        }
        return false;
    }
    
    private boolean parsingString(String s) {
        Set<Character> set = new LinkedHashSet<>();
        List<Character> list = new ArrayList<>();
        
        int len = s.length();
        for(int i=0; i < len; i++) {
            if(!list.contains(s.charAt(i))){
                list.add(s.charAt(i));
            }
        }
        
        System.out.println(list);
        String str = "";
        for(Character c: list) {
            str = str + c;
        }
        
        int diff = s.length() / str.length();
        System.out.println(s.length() / str.length());
        String s1 = "";
        for(int i =0 ; i < diff; i++) {
            s1 +=str;
        }
        System.out.println(s1);
        return s1.equals(s) ? true: false;
    }
}
