/*
7. Reverse Integer
Easy

3252

5132

Add to List

Share
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. 
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

*/

class ReverseInteger {
    String sbr="";
    public int reverse(int x) {
        System.out.println(x);
        String sb = new String(x+"");
        long result =0;
        for(int i=sb.length()-1; i >= 0; i --){
            if(sb.charAt(i) == '-')
               break;
            result = reverseInt(sb.charAt(i));
            if(x < 0 ){
                result = result * -1;
            }
        }
        if(result > Math.pow(2, 31) -1 || result < Math.pow(-2,31)){
            return 0;
        }
        System.out.println("res -- " + result);
        return (int)result;
    }
    
    private long reverseInt(char ch){
        sbr += ch+""; 
        System.out.println(sbr);
        long value = Long.parseLong(sbr);
        //System.out.println("value " + value);
        return value;    
    }
}
