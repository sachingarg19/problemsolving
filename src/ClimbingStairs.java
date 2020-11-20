/**
LeetCode
70. Climbing Stairs is based on fibonaci series

5313

170

Add to List

Share
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45
**/


class Solution {
    public int climbStairs(int n) {
       //return climb(n, 0);
        return optimalSolution(n);
    }
    
    // brute force
    int climb(int n, int i) {
        if(n < i) return 0;
        if(n == i) return 1;
        return climb(n, i+1) + climb(n, i+2);
    }
    
    //Optimal solution think about fibonaci series
    int optimalSolution(int n){
        if(n == 1)  return 1;
        int[] mem = new int[n+1];
        mem[1] =1;
        mem[2] =2;
        
        for(int i=3; i <= n; i++) {
           mem[i] = mem[i-1] + mem[i -2]; 
        }
        
        return mem[n];
    }
}
