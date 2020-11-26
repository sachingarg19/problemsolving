/**
 * 
 */
package com.wayfair;

import java.util.*;

/**
 * @author Sachin Garg
 * how to merge and sort two… 
 *
 */
public class OrderingUnorderList {

	/**
	 * @param args
	 */
	
	static Integer[] list1 = {3,4,1,6,2};
	static Integer[] list2 = {7,5,8,9,0};
	public static void main(String[] args) {
		orderUnorderList(list1, list2);
	}

	static List<Integer> orderUnorderList(Integer[] list1, Integer[] list2){
		List<Integer> orderedList = new ArrayList<Integer>();
		List<Integer> tempList1 = new ArrayList<>(Arrays.asList(list1));
		List<Integer> tempList2 = new ArrayList<>(Arrays.asList(list2));
		tempList1.addAll(tempList2);
		Collections.sort(tempList1);
		System.out.println(tempList1);
		Collections.reverse(tempList1);
		System.out.println(tempList1);
		return orderedList;
	}
}
