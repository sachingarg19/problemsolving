/**
 * 
 */
package com.wayfair;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Sachin Garg
 *
 */
public class DFSConnectedGraph {

	/**
	 * @param args
	 */

	static LinkedList<Integer>[] linkedList;
	static int num = 7;
	public static void main(String[] args) {
		/*ArrayList<ArrayList<Integer>> links = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(3);
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(2);
		list3.add(4);
		ArrayList<Integer> list4 = new ArrayList<>();
		list4.add(3);
		list4.add(4);
		ArrayList<Integer> list5 = new ArrayList<>();
		list5.add(3);
		list5.add(6);
		ArrayList<Integer> list6 = new ArrayList<>();
		list6.add(6);
		list6.add(7);
		ArrayList<Integer> list7 = new ArrayList<>();
		list7.add(4);
		list7.add(5);

		links.add(list1);
		links.add(list2);
		links.add(list3);
		links.add(list4);
		links.add(list5);
		links.add(list6);
		links.add(list7);*/


		populateEmptyList();

		populateListApproach1(1,2);
		populateListApproach1(1,3);
		populateListApproach1(2,4);
		populateListApproach1(3,4);
		populateListApproach1(3,6);
		populateListApproach1(6,7);
		populateListApproach1(4,5);

		/*populateListApproach1(1,0);
		populateListApproach1(2,3);
		populateListApproach1(3,4);*/
		
		for(LinkedList<?> list: linkedList){
			System.out.println(list);
		}
		getConnectedNodes();
	}

	/**
	 * 
	 */
	private static void populateEmptyList() {
		linkedList = new LinkedList[num+1];	
		for(int i=0; i < num+1; ++i){
			linkedList[i] = new LinkedList<>();
		}
	}

	/*
	 * Method is add y at x index and x at y index in linkedList
	 * */
	static void populateListApproach1(int x, int y){
		if(null == linkedList[x]){
			linkedList[x] = new LinkedList<>();
		}
		if(null == linkedList[y]){
			linkedList[y] = new LinkedList<>();
		}
		linkedList[x].add(y);
		linkedList[y].add(x);
	}

	static void getConnectedNodes(){
		boolean[] visited = new boolean[num+1];
		for(int i=0; i < num; ++i){
			if(!visited[i])
				applyDFS(i, visited);
		}
	}

	static void applyDFS(int v, boolean[] visited){
		visited[v] = true;
		if(null != linkedList[v] && !linkedList[v].isEmpty()){
			System.out.println(v + " ");
			for(int x : linkedList[v]) {
				if(!visited[x]){
					applyDFS(x, visited);
					System.out.println();
				}
			}
		}
	}

}
