/**
 * 
 */
package com.wayfair;

import java.util.*;

/**
 * @author Sachin Garg
 *
 */
public class MergeSort {

	/**
	 * @param args
	 */
	static int[] unsortedList = {4,6,2,7,3,9,5,1};

	static private int numCompares = 0;
	public static void main(String[] args) {
		//Arrays.sort(unsortedList);
		//Arrays.parallelSort(unsortedList);
		//List<int[]> list = Arrays.asList(unsortedList);
		/*for(int i: unsortedList){
		System.out.println(i);
		}*/
		List<Integer> list = new ArrayList<>();
		for(int i: unsortedList) {
			list.add(i);
		}

		System.out.println(splitList(list));
		System.out.println(numCompares);
	}

	static List<Integer> splitList(List<Integer> list){
		List<Integer> subList1 = new ArrayList<>();
		List<Integer> subList2 = new ArrayList<>();


		if(list.size() <= 1) return list;

		subList1 = splitList(list.subList(0, list.size()/2));
		//System.out.println(subList1);
		subList2 = splitList(list.subList(list.size()/2, list.size()));
		//System.out.println(subList2);
		return merge(subList1,subList2);
		//return list;
	}

	static List<Integer> merge(List<Integer> b, List<Integer> c){
		List<Integer> a = new ArrayList<>(b.size() + c.size());
		List<Integer> subList1 = new ArrayList<>();
		subList1.addAll(b);
		List<Integer> subList2 = new ArrayList<>();
		subList2.addAll(c);

		while(!subList1.isEmpty() && !subList2.isEmpty()){	
			numCompares++;
			if(subList1.get(0) < subList2.get(0)) {
				a.add(subList1.remove(0));
			} else if(subList1.get(0) > subList2.get(0)){
				a.add(subList2.remove(0));
			} else {
				a.add(subList1.remove(0));
				a.add(subList2.remove(0));
			}
		}

		if(!subList1.isEmpty()) {
			a.addAll(subList1);
		}
		if(!subList2.isEmpty()) {
			a.addAll(subList2);
		}
		return a;
	}

}
