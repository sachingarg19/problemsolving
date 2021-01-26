package com.citibank;

public class CitiBankTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = Integer.MAX_VALUE;
		int a1 = Integer.MAX_VALUE;
		
		try{
			int c = Math.addExact(a, a1);
			System.out.println(c);
		}catch(ArithmeticException e){
			e.printStackTrace();
		}
		
	}
	
	

}
