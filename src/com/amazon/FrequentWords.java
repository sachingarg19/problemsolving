/**
 * 
 */
package com.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sachin Garg
 *
 */
public class FrequentWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		
		FrequentWords f = new FrequentWords();
		List<String> abc = new ArrayList<String>();
		abc.add("art");
		abc.add("thou");
		System.out.println(f.retreiveFreqUsedWords("bcd romeo romeo wherefore art ijk thou romeo abc efg", abc));
	}
	
	List<String> retreiveFreqUsedWords(String literatureText, List<String> wordsToExclude){
		List<String>retreiveFreqUsedWords = new ArrayList<String>();
		System.out.println("literatureText - " + literatureText);
		System.out.println("wordsToExclude - " + wordsToExclude);
		List<String> tempList = (List)Arrays.asList(literatureText.split(" "));
		//tempList.sort(String.CASE_INSENSITIVE_ORDER);
		Collections.sort(tempList);
		System.out.println(tempList);
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		for(String s : tempList){
			if(!wordsToExclude.contains(s)){
				retreiveFreqUsedWords.add(s);
			}
		}
		System.out.println(retreiveFreqUsedWords);
		
		
		
		
		//tempList.
		
		return retreiveFreqUsedWords;
		
	}

}
