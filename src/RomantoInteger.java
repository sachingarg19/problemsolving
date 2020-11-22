/**
13. Roman to Integer
Easy

2678

3781

Add to List

Share
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Example 2:

Input: s = "IV"
Output: 4
Example 3:

Input: s = "IX"
Output: 9
Example 4:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
*/

class Solution {
    Map<String, Integer> romanToIntMap = new HashMap<>();
    public int romanToInt(String s) {
        System.out.println(s);
        romanToIntMap.put("I",1);
        romanToIntMap.put("V",5);
        romanToIntMap.put("X",10);
        romanToIntMap.put("L",50);
        romanToIntMap.put("C",100);
        romanToIntMap.put("D",500);
        romanToIntMap.put("M",1000);
       return parseRomentoInt(s);
    }
    
    // Brute force
    private int processRomtoInt(String s) {
        int count = 0;
        int index =0;
        int len = s.length();
        while(index < len){
            System.out.println(len);
            if(s.contains("IV")) {
                s= s.replace("IV", "");
                count += romanToIntMap.get("V") - romanToIntMap.get("I");;
            }
            if(s.contains("IX")) {
                s= s.replace("IX", "");
                count += romanToIntMap.get("X") - romanToIntMap.get("I");;
            }
            if(s.contains("XL")) {
                s= s.replace("XL", "");
                count += romanToIntMap.get("L") - romanToIntMap.get("X");;
            }
            if(s.contains("XC")) {
                s= s.replace("XC", "");
                count += romanToIntMap.get("C") - romanToIntMap.get("X");;
            }
            if(s.contains("CD")) {
                s= s.replace("CD", "");
                count += romanToIntMap.get("D") - romanToIntMap.get("C");;
            }
            if(s.contains("CM")) {
                s= s.replace("CM", "");
                count += romanToIntMap.get("M") - romanToIntMap.get("C");;
            }
            System.out.println(s.length());
            if(s.length() > 0) {
              System.out.println(s);
              count += romanToIntMap.get(s.charAt(index)+"");
              len = s.length();
            }
                
            ++index;
        }
        
        System.out.println(count);
        
        return count;
    }
    
    // Optimal solution
    private int parseRomentoInt(String s) {
        int len = s.length();
        int result = 0 ;
       int i=0;
        while(i < len) {
            if(s.charAt(i) == 'I' && i+1 < s.length() && s.charAt(i+1) == 'V') {
                result +=  (romanToIntMap.get("V") - romanToIntMap.get("I"));
                i +=2;
            } else if(s.charAt(i) == 'I' && i+1 < s.length() && s.charAt(i+1) == 'X') {
                result +=  (romanToIntMap.get("X") - romanToIntMap.get("I"));
                i +=2;
            } else if(s.charAt(i) == 'X' && i+1 < s.length() && s.charAt(i+1) == 'L') {
                result += (romanToIntMap.get("L") - romanToIntMap.get("X"));
                i +=2;
            } else if(s.charAt(i) == 'X' && i+1 < s.length() && s.charAt(i+1) == 'C') {
                result += (romanToIntMap.get("C") - romanToIntMap.get("X"));
                i +=2;
            } else if(s.charAt(i) == 'C' && i+1 < s.length() && s.charAt(i+1) == 'D') {
                result += (romanToIntMap.get("D") - romanToIntMap.get("C"));
                i +=2;
            }else if(s.charAt(i) == 'C' && i+1 < s.length() && s.charAt(i+1) == 'M') {
                result += (romanToIntMap.get("M") - romanToIntMap.get("C"));
                i +=2;
            } else {
                result = result + romanToIntMap.get(s.charAt(i)+"");
                ++i;
            }
        } 
        
                                                                            
        return result;
    }
}
