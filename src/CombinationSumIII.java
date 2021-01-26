/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
*/
class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        System.out.println(k + " -- " + n);
       List<List<Integer>> result = new ArrayList<List<Integer>>();
       List<Integer> lInt = new ArrayList<Integer>();
        trackData(result, lInt, k, n, 1);
        return result;
    }
    
    public void trackData(List<List<Integer>> result, List<Integer> lInt, int k, int n, int start) {
       // System.out.println(k + " -- " + n + " -- " + " -- " + lInt + " -- " +lInt.size());
        if(n < 0) {
            return;
        }
        if(n == 0 && lInt.size() == k){
            result.add(new ArrayList<>(lInt));
            return;
        }   
        
       // System.out.println(result);
        for(int i = start; i <= 9; i ++){
            lInt.add(i);
           // System.out.println(lInt);
            trackData(result, lInt, k, n-i, i+1);
            lInt.remove(lInt.size() -1);
        }
    }
}
