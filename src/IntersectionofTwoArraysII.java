/**
350. Intersection of Two Arrays II
Easy

1766

470

Add to List

Share
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
         return lessMemory(nums1, nums2);
        //return fastWay(nums1, nums2);
    }

    
    private int[] fastWay(int[] nums1, int[] nums2) {
        Map<Integer, Integer> num1Map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i: nums1) {
            num1Map.put(i,num1Map.getOrDefault(i,0)+1);
        }
        
        for(int j: nums2) {
            if(num1Map.containsKey(j)) {
                list.add(j);
                num1Map.put(j, num1Map.get(j)-1);
                if(num1Map.get(j) == 0)
                    num1Map.remove(j);
            }
        }
        
       // System.out.println(list + " " + num1Map);
        
        int[] result = new int[list.size()];
        for(int k=0; k < list.size(); k++) {
            result[k] = list.get(k);
        }
        
        return result;
    }
   
    
    
    private int[] lessMemory(int[] nums1, int[] nums2) {
        int i =0;
        int j =0;
        int k=0;
        // check len start with min
       while(i <  nums1.length) {
           k = j;
            while(k < nums2.length) {
                if(nums2[k] == nums1[i]) {
                    int temp = nums2[k];
                    nums2[k] = nums2[j];
                    nums2[j] = temp;
                    ++j;
                    break;
                }
                ++k;
            }
           ++i;
        }
        
        System.out.println(j);
        int[] result = new int[j];
        for(int m=0; m<j; m++) {
            result[m] = nums2[m];
        }
        return result;
    }
}
