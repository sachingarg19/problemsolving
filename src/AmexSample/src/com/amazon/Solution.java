/**
 * 
 */
package com.amazon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static class LinkedListNode{
		String val;
		LinkedListNode next;

		LinkedListNode(String node_value) {
			val = node_value;
			next = null;
		}
	};

	public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, String val){
		if(head == null) {
			head = new LinkedListNode(val);
		}
		else {
			LinkedListNode end = head;
			while (end.next != null) {
				end = end.next;
			}
			LinkedListNode node = new LinkedListNode(val);
			end.next = node;
		}
		return head;
	}

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		// BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		LinkedListNode res;

		int _initialRoute_size = 0;
		_initialRoute_size = Integer.parseInt(in.nextLine());
		int _initialRoute_i;
		String _initialRoute_item;
		LinkedListNode _initialRoute = null;
		for(_initialRoute_i = 0; _initialRoute_i < _initialRoute_size; _initialRoute_i++) { 
			try {
				_initialRoute_item = in.nextLine();
			} catch (Exception e) {
				_initialRoute_item = null;
			}
			_initialRoute = _insert_node_into_singlylinkedlist(_initialRoute, _initialRoute_item);
		}


		int _citiesToSkip_size = 0;
		_citiesToSkip_size = Integer.parseInt(in.nextLine());
		String[] _citiesToSkip = new String[_citiesToSkip_size];
		String _citiesToSkip_item;
		for(int _citiesToSkip_i = 0; _citiesToSkip_i < _citiesToSkip_size; _citiesToSkip_i++) {
			try {
				_citiesToSkip_item = in.nextLine();
			} catch (Exception e) {
				_citiesToSkip_item = null;
			}
			_citiesToSkip[_citiesToSkip_i] = _citiesToSkip_item;
		}

		res = updateRoute(_initialRoute, _citiesToSkip);
		while (res != null) {
			// bw.write(res.val);
			// bw.newLine();
			System.out.println(res.val);
			res = res.next;
			
			
		}
		
		

		//bw.close();

		//		LinkedListNode head = null;
		//		LinkedListNode initialRoute = null;
		//		List<String> cities = new ArrayList<>();
		//		cities.add("S");
		//		cities.add("T");
		//		cities.add("G");
		//		cities.add("A");
		//		cities.add("B");
		//		String[] citiesToSkip = {"T","A"};
		//		LinkedList<String> finalRoute = new LinkedList<>();
		//		for(String val : cities){
		//			initialRoute = _insert_node_into_singlylinkedlist(head, val);
		//			initialRoute = updateRoute(initialRoute, citiesToSkip);
		////			if(null != initialRoute)
		////				new LinkedListNode(initialRoute.val);
		//		}
		//		System.out.println("list :: " + initialRoute.val);
		//updatedRoute(list, "T");
	}



	static LinkedListNode updateRoute(LinkedListNode initialRoute, String[] citiesToSkip) {
		//		for(String  city : citiesToSkip){
		//			if(initialRoute.val == city){
		//				return null;
		//			}
		//		}
		LinkedListNode updatedRoute=new  LinkedListNode("");
		while (null != initialRoute && initialRoute.next != null) {

			for (int i = 0; i < citiesToSkip.length; i++) {
				// LinkedListNode deleteNode=new
				// LinkedListNode(citiesToSkip[i]);
				if (initialRoute.val != null && initialRoute.val.equalsIgnoreCase(citiesToSkip[i])){
					deleteNode(initialRoute);
				}else{
					updatedRoute=new  LinkedListNode(initialRoute.val);
					updatedRoute.next=initialRoute;
				}}
			initialRoute = initialRoute.next;
		}
		return updatedRoute;

		//return initialRoute;
	}

	public static void deleteNode(LinkedListNode node) {
		if(node.next != null){
			node.val = node.next.val;
			node.next = node.next.next;
		}
	}


}
