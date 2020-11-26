/**
 * 
 */
package com.walmart;

/**
 * @author sachi
 *
 */
public class SumArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Integer[] intArray = {1,3,5,7,9,10};
		int[] intArray = {5, 5, 10, 100, 10, 5};

		sum(intArray);

	}

	private static void sum(int[] intArray) {
		int x = 0;
		int y = 0;
		
		Integer[] even = new Integer[intArray.length - (intArray.length/2)];
		Integer[] odd = new Integer[intArray.length/2];
		for(int i = 0; i < intArray.length ; i++){
			//System.out.println(i);
			if(i%2 == 0){
				even[y++] = intArray[i];
			}else{
				odd[x++] = intArray[i];
			}

		}
		int valueOdd = 0;
		for(Integer j : odd){
			System.out.println("j :: " + j.intValue());
			valueOdd += j;
		}
		int valueEven = 0;
		for (Integer k: even){
			System.out.println("k :: " + k.intValue());
			valueEven += k;
		}
		if(valueEven < valueOdd){
			System.out.println(valueOdd);
		}else{
			System.out.println(valueEven);
		}
	}

}
