/**
 * 
 */
package com.wayfair;

import java.util.*;
/**
 * @author Sachin Garg
 * If two words are anagram or not
 *
 */
public class AnagramProblem {

	/**
	 * @param args
	 */
	
	static String word1 = "LISTEN";
	static String word2 = "SILENT";
	
	public static void main(String[] args) {
		
		System.out.println(isAnagram(word1, word2));
		
		// Driver program  
        String arr[] = { "cat", "dog", "tac", "god", "act" };  
        printAnagrams(arr);  
	}
	private static void printAnagrams(String[] arr) {
		Map<String,List<String>> anagramMap = new HashMap<>();
		
		for(int i=0; i< arr.length; i++){
			String word = arr[i];
			char[] t1 = buildAndSortArr(arr[i]);
			String newWorld = new String(t1);
			if(anagramMap.containsKey(newWorld)){
				anagramMap.get(newWorld).add(word);
			}else{
				List<String> wordList = new ArrayList<>();
				wordList.add(word);
				anagramMap.put(newWorld, wordList);
			}
		}
		
		System.out.println(anagramMap);
		for(String s: anagramMap.keySet()){
			List<String> anagram = anagramMap.get(s);
			if(anagram.size() >=1) {
				System.out.println(anagram);
			}
		}
	}
	/**
	 * 
	 * @param word1
	 * @param word2
	 * @return
	 */
	
	static boolean isAnagram(String word1, String word2) {
		boolean flag = true;
		char[] t1 = buildAndSortArr(word1);
		
		char[] t2 = buildAndSortArr(word2);
		
		if(t1.length == t2.length){
			for(int i=0 ; i < t1.length; i ++){
				if(t1[i] != t2[i]){
					flag = false;
				}
			}	
		}
		return flag;
	}
	
	static char[] buildAndSortArr(String str){
		char[] t1 =str.toCharArray();
		Arrays.sort(t1);
		System.out.println(t1);
		return t1;
	}
}
