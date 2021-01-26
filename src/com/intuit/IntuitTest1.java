/**
 * 
 */
package com.intuit;

/**
 * @author Sachin Garg
 *
 */
public class IntuitTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fuzzBuzz(1,3);
		//fuzzBuzz(1,15);
		//fuzzBuzz(4,30);
	}

	static void fuzzBuzz(int start, int stop){
		for(int i = start ; i<= stop; ++i){
			if(i%3 == 0 && i%5 == 0){
				System.out.println("FizzBuzz");
			}else if(i%3 == 0){
				System.out.println("Fizz");
			}else if(i%5 == 0){
				System.out.println("Buzz");
			}else{
				System.out.println(i);
			}		    		
		}
	}

}
