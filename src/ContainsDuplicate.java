import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * 
 * Your function should return true if any value appears at least twice in the
 * array, and it should return false if every element is distinct.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,1] Output: true Example 2:
 * 
 * Input: [1,2,3,4] Output: false Example 3:
 * 
 * Input: [1,1,1,3,3,4,3,2,4,2] Output: true
 **/

class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };

        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> nSet = new HashSet<>();
        for(int n: nums) {
            nSet.add(n);
        }
        boolean flag = true;
        if(nums.length == nSet.size()) {
            flag = false;
        }
        return flag;
        
    }
}
