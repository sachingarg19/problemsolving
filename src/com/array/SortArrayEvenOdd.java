/**
 * 
 */
package com.array;

/**
 * @author Sachin Garg
 *
 */
public class SortArrayEvenOdd {

	public static void sorted(int [] integer) {

		int i, j , temp;
		
		for (i = 0;  i < integer.length;  i++) {

			if (integer[i] % 2 == 1) {
				for (j = i;  j < integer.length;  j++) {
					if (integer[j] % 2 == 0) {
						temp = integer[i];
						integer[i] = integer[j];
						integer[j] = temp;
					}
				}
			}
			System.out.println(integer[i]);
		}
		
		//System.out.println(integer.length);
	}

	public static void main(String args[]) {

		sorted(new int[]{1, 2,7, 9, 4}); 



	}

}
