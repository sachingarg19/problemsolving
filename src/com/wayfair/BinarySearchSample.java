/**
 * 
 */
package com.wayfair;

import java.util.*;

/**
 * @author Sachin Garg
 *
 */
public class BinarySearchSample {

	/**
	 * @param args
	 */
	static boolean isSearchSuccess = false;
	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 7, 8, 9, 10, 11, 12, 14, 30, 31, 33, 35, 39, 40, 41 };
		int arr1[] = { 2 }; 
		int srchItem = 31;

		System.out.println(binarySearch(arr, srchItem));
		System.out.println(binarySearch(arr1, srchItem));

	}

	static boolean binarySearch(int[] arr, int srchItem) {
		int[] leftList = Arrays.copyOf(arr, arr.length/2);
		/*for(int i: leftList){
			System.out.println("left arr size -- " + leftList.length + " left -- " + i);
		}*/
		int[] rightList = Arrays.copyOfRange(arr, arr.length/2, arr.length);
		//System.out.println("right arr size -- "+rightList.length);
		/*for(int i: rightList){
			System.out.println("right arr size -- "+rightList.length + " right -- " + i);
		}*/

		//System.out.println("Last element of array left -- " + leftList[leftList.length -1]);
		//System.out.println("first element of array right -- " + rightList[0]);

		if(leftList.length >= 1 && rightList.length >=1) {
			return isItemExist(srchItem, leftList, rightList);
		}else{
			System.out.println("Item not in array");
			isSearchSuccess = false;
		}
		return isSearchSuccess;
	}

	/**
	 * @param srchItem
	 * @param leftList
	 * @param rightList
	 */
	private static boolean isItemExist(int srchItem, int[] leftList, int[] rightList) {
		if(srchItem == leftList[leftList.length-1]){
			System.out.println("Item found left -- " + leftList[leftList.length -1]);
			//
			isSearchSuccess = true;
		}else if(srchItem == rightList[0]){
			System.out.println("Item found right -- " + rightList[0]);
			isSearchSuccess = true;
		}else if(srchItem < leftList[leftList.length -1]){
			//TODO go to left array
			//System.out.println("Inside left array -- " + leftList[leftList.length -1]);
			binarySearch(leftList, srchItem);
		}else if(srchItem > rightList[0]){
			//TODO go to right array
			//System.out.println("Inside right array -- " + rightList[rightList.length -1]);
			binarySearch(rightList, srchItem);
		}
		return isSearchSuccess;
	}
}
