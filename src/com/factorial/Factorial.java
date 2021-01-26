/**
 * 
 */
package com.factorial;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author Sachin Garg
 *
 */
public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(fact(5));
		Map<String, String> map  = new Hashtable<String, String>();
		map.put(null, "ABc");

		System.out.println(map);

	}


	public static int fact(int n){

		if(n <= 1){
			return 1;
		}
		return n * fact(n-1);

		//		int m = 1;
		//		int x = n;
		//		while(n>1){
		//			m = factCal(x,n);
		//			x = m;
		//			--n;
		//		}
		//		return m;
	}

	public static int factCal(int m , int n){
		m = m*(n-1);
		//System.out.println(m);
		return m;
	}


}
