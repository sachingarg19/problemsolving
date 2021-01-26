/**
 * 
 */
package com.wayfair;

import java.util.*;

/**
 * @author Sachin Garg
 *
 */
/*
02 TopCoder
0 Single Round Match 1
0 Division 1
0 Level 2
0 Points 00
0 Description http//community.topcoder.com/stat?c=problem_statement&pm=
0  */

public class MessageMess {

	public static void main(String[] args) {
		String[] dictionary = {"H", "I", "HIT1", "HIT", "MAN", "HIT1 MAN1", "HIT MAN2"};
		String[] dict1 = {"HI", "YOU", "SAY"};
		String message = "HIYOUSAYHI";
		
		String[] dict2 = {"ABC", "BCD", "CD", "ABCB"};
		String message1 = "ABCBCD";


		System.out.println(restore2(dictionary, "HIT1"));
		System.out.println(restore2(dict1, message));
		System.out.println(restore2(dict2, message1));
	}

	/*static public String restore(String[] dictionary, String message) {

		List<String> dictList = new ArrayList<>();
		for(String dict : dictionary){
			if(message.equals(dict)){		
				dictList.add(dict);
			}
			if(dictList.size() >= 2){
				return "AMBIGUOUS!";
			}
		}
		if(dictList.size() == 0){
			return "IMPOSSIBLE!";
		}
		return dictList.get(0);
		
	}*/
	
	static public String restore2(String[] dictionary, String message){
		int[] numberOfSolutions = new int[message.length() + 1];
		numberOfSolutions[0] = 1;
		
		String[] solutions = new String[message.length() + 1];
		solutions[0] = "";
		
		for(int i=1; i < solutions.length; i++){
			solutions[i] = "IMPOSSIBLE!";
		}
		for(int position = 0 ; position < message.length(); position ++){
			for(String word: dictionary){
				if(numberOfSolutions[position] == 1){
					int newSize = position + word.length();
					if(newSize <= message.length() && 
							word.equals(message.substring(position, newSize))){
						if(numberOfSolutions[newSize] == 0){
							numberOfSolutions[newSize] = 1;
							solutions[newSize] = solutions[position] + " " + word;
						} else {
							numberOfSolutions[newSize] = 2;
							solutions[newSize] = "AMBIGUOUS!";
						} 
					}
				}
				
			}
		}
		return solutions[solutions.length -1].trim();
	}
	
	static public String restore1(String[] dictionary, String message) {
		
		/*
		 * Holds the number of ways the message can be recreated up to a given
		 * point.  numOfSolutions[0] = 1, represents the one starting state.
		 * numOfSolutions[x] is the number of ways the substring beginning
		 * with the first x characters of the message can be reached.
		 */
		int[] numOfSolutions = new int[message.length() + 1];
		numOfSolutions[0] = 1;

		
		/*  Holds the restored string from the message recreated up to a
		 *  given point.
		 *  If no solutions exists to get to that character x,
		 *  then solutions[x] holds IMPOSSIBLE!.
		 *  If two or more solutions are found that lead to character x,
		 *  then solutions[x] holds "AMBIGUOUS!".
		 */
		String[] solutions = new String[message.length() + 1];

		// Initialize the array.
		solutions[0] = "";
		for (int i = 1; i < solutions.length; i++) {
			solutions[i] = "IMPOSSIBLE!";
		}
		
		System.out.println(solutions.length);

		// Loop through each position in the message.
		for (int position = 0; position < message.length(); position++) {

			// Only process if positon can be reached once unambiguously.
			if (numOfSolutions[position] == 1) {

				for (String word:  dictionary) {

					// The size the message would be if word were tacked on.
					int newSize = position + word.length();

					/*
					 * If adding this dictionary word to our current
					 * position would take us beyond the length of the
					 * message; or, the dictionary word does not match the
					 * next sequence in the message, then skip it.
					 */
					 
					if ((newSize <= message.length()) &&
							(word.equals(message.substring(position,
									newSize)))) {

						
						 /* Set the number of ways to reach the new size to
						 * either 1 or 2 - depending on if it was 0 or 1
						 * before.  If it's now 2, mark it as ambiguous.
						 */
						 

						if (numOfSolutions[newSize] == 0) {
							numOfSolutions[newSize] = 1;
							solutions[newSize] = solutions[position] + " " +
									word;
						} else {
							numOfSolutions[newSize] = 2;
							solutions[newSize] = "AMBIGUOUS!";
						}
					}
				}
			}
		}

		return solutions[solutions.length - 1].trim();
	}
}