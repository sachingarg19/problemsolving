/**
 * 
 */
package com.intuit;

import java.util.Arrays;

/**
 * @author Sachin Garg
 *
 */
public class IntuitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] iArr = {1,5,3,4,2};
		int k = 4;
		System.out.println(pairs(iArr, k));
	}

	static int pairs(int[] a,int k) {
		/* Complete this function */
		int iTemp;
		int iLen=a.length;
		int count=0;
		Arrays.sort(a);
		for(int i=0;i<iLen;i++){
			iTemp=a[i];
			for(int j=i+1;j<iLen;j++){
				if(iTemp-a[j]==-k){
					count++;
					break;
				}
			}
		}
		return count;
	}


}
