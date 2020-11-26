/**
 * 
 */
package com.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @author Sachin Garg
 * 
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 */
public class LeetCodeAdd2Numbers {

	/**
	 * @param args
	 */
	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for(int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	public static ListNode stringToListNode(String input) {
		// Generate array from the input
		int[] nodeValues = stringToIntegerArray(input);

		// Now convert that list into linked list
		ListNode dummyRoot = new ListNode(0);
		ListNode ptr = dummyRoot;
		for(int item : nodeValues) {
			ptr.next = new ListNode(item);
			ptr = ptr.next;
		}
		return dummyRoot.next;
	}

	public static String listNodeToString(ListNode node) {
		if (node == null) {
			return "[]";
		}

		String result = "";
		while (node != null) {
			result += Integer.toString(node.val) + ", ";
			node = node.next;
		}
		return "[" + result.substring(0, result.length() - 2) + "]";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			ListNode l1 = stringToListNode(line);
			System.out.println("L1 -- " +  l1);
			line = in.readLine();
			ListNode l2 = stringToListNode(line);

			ListNode ret = addTwoNumbers(l1, l2);

			String out = listNodeToString(ret);

			System.out.print(out);
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		System.out.println(l1 + " -- " + l2);
		
		BigInteger valB = new BigInteger(process(l1).toString());
		BigInteger valB1 = new BigInteger(process(l2).toString());
		BigInteger sumB = valB.add(valB1);
		System.out.println(sumB);
		StringBuilder s3 = new StringBuilder();
		s3.append(sumB).reverse();
		System.out.println(s3);
		char[] charArr = s3.toString().toCharArray();
	
		int[] intArr = new int[charArr.length];
		for(int i=0; i < charArr.length; i++){
			intArr[i] = Integer.parseInt(String.valueOf(charArr[i]));
		}
		System.out.println(intArr);
		return buildListNode(intArr);
	}

	private static ListNode buildListNode(int[] input){
		ListNode node = new ListNode(0);
		ListNode dummyNode = node;
		for(int num: input){
			dummyNode.next = new ListNode(num);
			dummyNode = dummyNode.next;
		}
		return node.next;
	}

	private static StringBuilder process(ListNode listNode){
		StringBuilder s1 = new StringBuilder();
		s1.append(listNode.val);
		while(listNode.next != null){
			listNode = listNode.next;
			s1.append(listNode.val);
		}
		return s1.reverse();
	}

}


/**
 * Definition for singly-linked list.
 */ class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
 }
