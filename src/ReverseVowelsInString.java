/**
345. Reverse Vowels of a String
Easy

Add to List

Share
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".

*/
class Solution {
    public String reverseVowels(String s) {
        String vowels = "aAeEiIoOuU";
        int left = 0;
        int right = s.length() -1;
        
        // needs to change string to char array and switch between vowels
        char[] charArray = s.toCharArray();
        while(left < right) {
            if(vowels.contains((""+charArray[left]))) {
                char c = charArray[left];
                if(vowels.contains((""+charArray[right]))) {
                    char c1 = charArray[right];
                    charArray[left] = charArray[right];
                    charArray[right] = c;
                    --right;
                    ++left;
                } else {
                    --right;
                }
            } else {
                ++left;
            }
        }
  
        return new String(charArray);
    }
}
