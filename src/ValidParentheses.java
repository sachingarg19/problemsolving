/**
LeetCode
20. Valid Parentheses


6081

249

Add to List

Share
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.






**/


class Solution {
    Stack<Character> strStack = new Stack<>();
        
    public boolean isValid(String s) {
        boolean result = false;
        
        if(s.length() < 1) return result;
        
        String openBrackets = "({[";
        for(int i=0 ; i < s.length(); i++) {
            if(openBrackets.contains(s.charAt(i)+"")) {
                strStack.push(s.charAt(i));
            } else if(s.charAt(i) == ')') {
                result = evaluateBraces('(');
                if(!result) break;
            } else if(s.charAt(i) == '}') {
                result = evaluateBraces('{');
                 if(!result) break;
            } else if(s.charAt(i) == ']') {
                result = evaluateBraces('[');
                 if(!result) break;
            }
            
        }
      return result && strStack.empty()? true: false;
    }
    
    private boolean evaluateBraces(Character c) {
        return !strStack.empty() && strStack.pop() == c ? true : false;
    }
}
