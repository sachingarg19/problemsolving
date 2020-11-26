/**
 * 
 */
package com.wayfair;

import java.util.*;

/**
 * @author Sachin Garg
 *	7 coins that are the same weight and one that is heavier - and finding that one with one balance.
 */
public class FindHeaviestCoin {

	/**
	 * @param args
	 */
	static Integer[] weightList = {4,4,4,4,4,4,4,8,4};
	static List<Integer> temp1;
	static List<Integer> temp2;
	static int temp1V;
	static int temp2V;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrays.sort(weightList);
		identifyIndexOfHeaviestCoin(new ArrayList<>(Arrays.asList((weightList))));
	}
	
	static void identifyIndexOfHeaviestCoin(List<Integer> tempList){
		if(tempList.size() == 1) {
			System.out.println(tempList.get(0));
		}else {
		temp1 = selectingSublist(tempList, 0, tempList.size()/2);
		System.out.println(temp1);
		temp2 = selectingSublist(tempList,tempList.size()/2,tempList.size());
		System.out.println(temp2);
		temp1V = sumArrayIndex(temp1);
		//System.out.println(temp1V);
		temp2V = sumArrayIndex(temp2);
		//System.out.println(temp2V);
		validatingWeight(tempList);
		}
	}

	/**
	 * @param tempList
	 */
	private static void validatingWeight(List<Integer> tempList) {
		if(temp1V == temp2V){
			System.out.println(tempList.get(tempList.size()-1));
		}else if (temp1V < temp2V) {
			//System.out.println(temp2V);
			identifyIndexOfHeaviestCoin(temp2);
		}else if (temp1V > temp2V) {
			identifyIndexOfHeaviestCoin(temp1);
		}
	}

	/**
	 * @param tempList
	 * @return
	 */
	private static List<Integer> selectingSublist(List<Integer> tempList, int startIndex, int endIndex) {
		return tempList.subList(startIndex, endIndex);
	}
	
	static int sumArrayIndex(List<Integer> list){
		int sum = 0;
		for(Integer weight: list){
			sum = sum + weight;
		}
		//System.out.println(sum);
		return sum;
	}

}
