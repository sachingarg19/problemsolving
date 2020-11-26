/**
 * 
 */
package com.primenumber;

/**
 * @author Sachin Garg
 *
 */
public class PrimeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		primeNumber(5, 1000);
	}
	
	
	static void primeNumber(int start, int end){
		
		for(int i = start; i < end; i++){
			if(primeNumberTest(i)){
				System.out.println("Prime number " + i);
			}
		}
	}
	
	static boolean primeNumberTest(int n){
		boolean flag = true;
		for(int j = 2; j < n/2 ; j++ ){
			if(n%j == 0){
				return false;				
			}
		}
		return flag;
	}

}
