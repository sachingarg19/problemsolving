/**
14. Longest Common Prefix
Easy

3282

2023

Add to List

Share
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

0 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.

*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs == null || strs.length == 0) return "";
        
        
        
        // index = 0 => s = flower
        // index = 1 => s1 = flow
        // s[0] = s1[0] => s += s[0]
        // s[1] = s1[1] => s += s[1]
        // s[2] = s1[2] => s += s[2]
        // s[3] = s1[3] => break;
        // s = flo
       
        // return bruteForce(strs);
        
        return optimalSol(strs, 0, strs.length-1);
    }
    
    private String optimalSol(String[] strs, int left, int right) {
     if(left == right) return strs[left];
        
     int mid = (left+right)/2;
     String leftCP = optimalSol(strs, left, mid);
     String rightCP = optimalSol(strs, mid+1, right);
     
     int min = Math.min(leftCP.length(), rightCP.length());
     for(int i=0; i < min; i++) {
         if(leftCP.charAt(i) != rightCP.charAt(i)) {
             return leftCP.substring(0, i);
         }
     }
     return leftCP.substring(0, min);
    }
    
    
    private String bruteForce(String[] strs) {
        String startStr = strs[0];
        for(int i=1; i < strs.length; i++) {
            String preFix = "";
            String str = strs[i];
            for(int j=0; j < startStr.length(); j++) {
                if(j < str.length() && startStr.charAt(j) == str.charAt(j)) {
                    preFix += startStr.charAt(j)+"";
                } else {
                    startStr = preFix;
                    break;
                }
            }
        }
        
    return startStr;
    }
}
