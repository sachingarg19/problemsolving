/**
215. Kth Largest Element in an Array
Medium

4591

300

Add to List

Share
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1) return nums[0];
        List<Integer> sList = new ArrayList<>(nums.length+1);
        
        for(int i=0; i< nums.length; i++) {
            sList.add(nums[i]);
        }
        Collections.sort(sList);
        
        return sList.get(sList.size()-k);
    }
}
