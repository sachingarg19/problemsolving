/**
1002. Find Common Characters
Easy

1160

129

Add to List

Share
Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.

 

Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]
 

Note:

1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] is a lowercase letter
*/

class Solution {
    public List<String> commonChars(String[] A) {
        return parseArrayToListApproach(A);
    }
    
    private List<String> parseArrayToListApproach(String[] A){
        Map<Character, Integer> map = null;
        List<String> list = new ArrayList<>();
       
        for(String s: A){
            char[] arr = s.toCharArray();
            Map<Character,Integer> tempMap = new HashMap();
            for(char c: arr) {
                if(map == null) {
                    tempMap.put(c, tempMap.containsKey(c) ? tempMap.get(c)+1:1);
                } else {
                    if(map.containsKey(c)) {
                        if(map.get(c) > 1) {
                            map.put(c, map.get(c)-1);
                        }
                        else {
                            map.remove(c);
                        }
                        tempMap.put(c, tempMap.containsKey(c) ? tempMap.get(c)+1:1);
                    } 
                }
            }
            map = tempMap;
        }
        
        
        for(Map.Entry<Character, Integer> v: map.entrySet()){
            int count1= v.getValue();
            while( count1 > 0 ) {
                list.add(v.getKey()+"");
                --count1;
            }
        }
        
        return list;
    }
}
