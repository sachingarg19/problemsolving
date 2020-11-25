/**
686. Repeated String Match
Medium

912

814

Add to List

Share
Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.

Notice: string "abc" repeated 0 times is "",  repeated 1 time is "abc" and repeated 2 times is "abcabc".

 

Example 1:

Input: a = "abcd", b = "cdabcdab"
Output: 3
Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.
Example 2:

Input: a = "a", b = "aa"
Output: 2
Example 3:

Input: a = "a", b = "a"
Output: 1
Example 4:

Input: a = "abc", b = "wxyz"
Output: -1
 

Constraints:

1 <= a.length <= 104
1 <= b.length <= 104
a and b consist of lower-case English letters.
*/

class Solution {
   public int repeatedStringMatch(String a, String b) {
        if(a.isEmpty() || b.isEmpty()) return 0;
        int lenB = b.length();
        int lenA = a.length();
        if(lenA == lenB && a.contains(b)) return 1;
        
        int count = 1;
        String dup = a;
       
        while(dup.length() <= a.length()*2+b.length()) {
            if(dup.contains(b)) return count;
            dup += a;
            ++count;     
        }
        return -1;
    }
}
