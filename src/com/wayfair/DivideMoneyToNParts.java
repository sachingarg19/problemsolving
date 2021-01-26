/**
 * 
 */
package com.wayfair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sachin Garg
 *
 */
public class DivideMoneyToNParts {

	/**
	 * @param args
	 */
	
	private static int money = 121;
	private static int numberOfDivision = 6;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		splitMoney(money, numberOfDivision);
	}
	
	public static void splitMoney(int value, int partition) {
		List<Integer> partitionList = new ArrayList<>();
		while(partition > 0) {
			int temp1 = value / partition;
			value -= temp1;
			partitionList.add(temp1);
			-- partition; 
		}
		System.out.println(partitionList);
	}
}
