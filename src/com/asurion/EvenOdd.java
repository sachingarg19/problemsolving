/**
 * 
 */
package com.asurion;

import java.util.Arrays;

/**
 * @author Sachin Garg
 *
 */
public class EvenOdd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] iArr = {10,13,4,25,6,7,18,9};
		Arrays.sort(iArr);
		System.out.println(iArr);

		for(int k=0; k < iArr.length; k++){
			System.out.println("---------" +iArr[k]);
		}

		processArr(iArr);
		//sorted(iArr);
		//evenodd(iArr);

		String s1 = new String("JAVA");

		System.out.println(s1);         //Output : JAVA

		s1.concat("J2EE");

		System.out.println(s1);   

	}

	private static void processArr(int[] iArr) {
		int temp;
		for(int i = 0; i< iArr.length; i++){
			if(iArr[i]%2 == 1){//check for Odd number
				//System.out.println(iArr[i]);
				for(int j = i; j < iArr.length; j++){
					if(iArr[j]%2 == 0){
						temp = iArr[i];
						iArr[i] = iArr[j];
						iArr[j] = temp;
					}
				}
			}

			//System.out.println(iArr[i]);
			//i++;
		}

		for(int k=0; k < iArr.length; k++){
			System.out.println("------" +iArr[k]);
		}

	}

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
			//System.out.println(" --- " +integer[i]);
		}
		for(int k=0; k < integer.length; k++){
			System.out.println("------" +integer[k]);
		}
	}

	public static void evenodd(int[] integer) {

		int i = 0, temp = 0;
		int j = integer.length - 1;

		while (j >= i) {
			// swap if found odd even combo at i and j
			if (integer[i] % 2 != 0 && integer[j] % 2 == 0) {
				temp = integer[i];
				integer[i] = integer[j];
				integer[j] = temp;
				i++;
				j--;

			} else {
				if (integer[i] % 2 == 0) {
					i++;
				}
				if (integer[j] % 2 == 1) {
					j--;
				}

			}

		}
		for(int k=0; k < integer.length; k++){
			System.out.println("----" +integer[k]);
		}
	} 


}
