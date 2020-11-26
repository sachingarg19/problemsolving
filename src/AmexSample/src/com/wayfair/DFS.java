/**
 * 
 */
package com.wayfair;

import java.util.*;
import java.util.Map.Entry;


/**
 * @author Sachin Garg
 * 
 * simple Graph
 *
 */
public class DFS {

	/**
	 * @param args
	 * 
	 * 
	 */
	static List<Integer>[] linkedList;
	static int num = 7;
	static Map<Integer, List<Integer>> mapOfArray = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> links = new ArrayList<>();
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
		links.add(list7);


		linkedList = new LinkedList[num+1];
		for(int i=0; i < num; ++i){
			linkedList[i] = new LinkedList<>();
		}

		populateListApproach1(1,2);
		populateListApproach1(1,3);
		populateListApproach1(2,4);
		populateListApproach1(3,4);
		populateListApproach1(3,6);
		populateListApproach1(6,7);
		populateListApproach1(4,5);

		//findDFSApproach2(7, links);

		dfs1Approach1(linkedList);
		/*populateList(0, 1); 
        populateList(0, 2); 
        populateList(1, 2); 
        populateList(2, 0); 
        populateList(2, 3); 
        populateList(3, 3); */
		dfsApproach1(3);

	}


	/*public static void findDFSApproach2(int num, ArrayList<ArrayList<Integer>> links){
		
		for(List<Integer> linkList : links){
			System.out.println(linkList);
			List<Integer> tempList = new ArrayList<>();
			if(!mapOfArray.containsKey(linkList.get(0))){
				tempList.add(linkList.get(1));
				mapOfArray.put(linkList.get(0),tempList);
			}else{
				mapOfArray.get(linkList.get(0)).add(linkList.get(1));
			}
		}

		System.out.println(mapOfArray);
		boolean visited = true;
		boolean[] visitedArr = new boolean[num+1];
		for(Entry<?, ?> key: mapOfArray.entrySet()){
		dfsUtilApproach2(visitedArr, (Integer) key.getKey());
		}
		
	}
	
	static List<Integer> list = new ArrayList<>();
	static Set<Entry<Integer, List<Integer>>> mapSet = mapOfArray.entrySet();
	private static void dfsUtilApproach2(boolean[] visitedArr, Integer key){
		visitedArr[key] = true;
		list.add(key);
		System.out.println(key);
		if(null != mapOfArray.get(key)){
			for(int value: mapOfArray.get(key)){
				if(!visitedArr[value]){
					dfsUtilApproach2(visitedArr, value);
				}
			}
		}
		System.out.println(visitedArr);
		System.out.println(list);
	}*/

	static void populateListApproach1(int i, int next){
		linkedList[i].add(next);
	}

	public static void dfs1Approach1(List<Integer>[] linkedList){
		for(List<Integer> list: linkedList){
			System.out.println(list);
		}
	}

	static void dfsApproach1(int v){
		boolean[] visited = new boolean[num+1];
		dfsUtilApproach1(v, visited);
	}


	private static void dfsUtilApproach1(int v, boolean[] visited) {
		visited[v] = true;

		System.out.print(v+" ");

		if(null != linkedList[v]){
			Iterator<?> itr = linkedList[v].listIterator();

			while(itr.hasNext()){
				int n = (int) itr.next();
				if(!visited[n]){
					dfsUtilApproach1(n, visited);
				}
			}
		}

	}

}
