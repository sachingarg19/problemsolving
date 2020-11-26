package com.wayfair;

public class AppianTest {

	
	/*1. Flip the bit in byte array byte[][] 
	input  -- [1001 1100]
	output -- [0110 0011]
	*/
	
	/*2. Preparing Peak and valley like SIN 
	 * input -- {5,3,1,4,2}
	 * output -- {5,1,3,2,4}
	 * */
	/*3. Allocated empty space based on range
	 * 1,2 --> 1,2
	 * 3,4 -- > 3,4
	 * 6,7 --> 6,7
	 * 10, 11 -- > 10 and 11
	 * 
	 * Allocate 5 based on range or size
	 * Allocate 9 based on range or size
	 * 
	 * */
	
	public static void main(String[] args){
		/*1. Flip the bit in byte array byte[][] 
		input  -- [1001 1100]
		output -- [0110 0011]
		*/
		invokeFlipBit();
		
		/*2. Preparing Peak and valley like SIN 
		 * input -- {5,3,1,4,2}
		 * output -- {5,1,3,2,4}
		 * */
		invokeExampleOfPeekValley();
	}
	
	private static void invokeFlipBit() {
		String[] input = {"1001", "1100"};
		for(int i = 0; i < input.length; i++){
			System.out.println(input[i]);
			String flippedValue = flipBytes(input[i]);
			System.out.println(flippedValue);
		}
		System.out.println(input);
	}

	private static String flipBytes(String input) {
		StringBuilder newStr = new StringBuilder();
		for(char i =0 ; i < input.length(); i++) {
			if(input.charAt(i) == '1'){
				newStr.append(0);
			}else{
				newStr.append(1);
			}
		}
		return newStr.toString();
	}

	private static void invokeExampleOfPeekValley() {
		Integer[] intArr = {5,3,1,4,2};
		preparePeekValley(intArr);
		Integer[] intArr1 = {7,8,2,5,3};
		preparePeekValley(intArr1);
		Integer[] intArr2 = {3,5,1,9,3};
		preparePeekValley(intArr2);
		prepareSinsudoal(intArr2);
	}

	static void preparePeekValley(Integer[] intArr){
		Integer[] outputArr = new Integer[intArr.length];
		outputArr[0] = intArr[0];
		for(int i=2 ; i < intArr.length; i++){
			int var =  intArr[i-1];
			int var1 = intArr[i];
			if(var > var1){
				outputArr[i-1] = var1;
				outputArr[i] = var;
			}
		}
		System.out.println(String.valueOf(outputArr));
		for(int x: outputArr){
			System.out.println(x);
		}
		
	}
	
	//Duplicate method of preparePeekValley
	static void prepareSinsudoal(Integer[] intArr){
		Integer[] optArr = new Integer[intArr.length];
		optArr[0] = intArr[0];
		for(int i=2; i < intArr.length; i++){
			int var = intArr[i-1];
			int var1 = intArr[i];
			if(var > var1){
				optArr[i-1] = var1;
				optArr[i] = var;
			}
		}
		for(int x: optArr){
			System.out.println(x);
		}
	}
	
}
