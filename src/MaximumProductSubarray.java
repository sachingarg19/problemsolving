/**
152. Maximum Product Subarray
Medium

5611

191

Add to List

Share
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

class Solution {
    public int maxProduct(int[] nums) {
        int prevMax = nums[0];
        int prevMin = nums[0];
        int max = nums[0];
        
        for(int i=1; i < nums.length; i++){
            int curr = nums[i];
            int temp = prevMax;
            
            prevMax = Math.max(curr, Math.max(prevMax*curr, prevMin*curr));    
            prevMin = Math.min(curr, Math.min(temp*curr, prevMin*curr));
            max = Math.max(max, Math.max(prevMax, prevMin));
        }    
       return max;
    }
}
