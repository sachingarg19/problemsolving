/**
88. Merge Sorted Array
Easy

2888

4636

Add to List

Share
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 

Constraints:

-10^9 <= nums1[i], nums2[i] <= 10^9
nums1.length == m + n
nums2.length == n
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.out.println(nums1.length + " " + nums2.length);
        //System.out.println(nums1[2]);
        
       bruteForce(nums1, m, nums2, 1);
    }

    private void bruteForce(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        List<Integer> list = new ArrayList<>(m+n);
        while(i < nums2.length) {
            nums1[m] = nums2[i];
            i++;
            m++;
        }
        
        for(int j : nums1) {
            list.add(j);
        }
        
        Collections.sort(list);
        for(int k=0; k < list.size(); k++){
           nums1[k] = list.get(k); 
        }
    }
}
