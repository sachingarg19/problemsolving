/*Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/
class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> nList = new ArrayList<>();
        for(int n: nums) {
            nList.add(n);
        }
        Collections.sort(nList);
        return nList.get(nList.size() -k);
    }
}
