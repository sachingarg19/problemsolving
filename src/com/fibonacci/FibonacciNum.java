package com.fibonacci;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sachin Garg
 *
 */
public class FibonacciNum {

	/**
	 * @param args
	 * 
	 * 0 1 1 2 3 5 8 13 21 34 ....
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fibNum(20);
		//fib(5);
		System.out.println(fib(8));
	}

	public static void  fibNum(int n){
		int[] fibList = new int[n];
		int fibValue = 0;

		fibList[0] = 0;
		fibList[1] = 1;
		for(int i = 2; i < n; i++){
			fibList[i] = fibList[i-1] + fibList[i-2];
		}
		
		//System.out.println(fibValue);

		for(int j : fibList){
			System.out.println(j);
		}
	}
	
	public static int fib(int n){
		//System.out.println(n);
		if(n <= 1) return 1;
		return fib(n-1) + fib(n-2);
	}

}
