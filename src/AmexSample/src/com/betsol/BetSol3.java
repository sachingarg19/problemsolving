/**
 * 
 */
package com.betsol;

/**
 * @author Sachin Garg
 *
 */
public class BetSol3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BetSol3 b = new BetSol3();
		b.start();
		b.show();
		
		  int num = 100;
	        if (num < 1000) {
	            System.out.println("Output = "+ num);
	        }
	}

	void show(){
		try 
		{ 
			System.out.print("Hello world ");
		} 
		finally 
		{
			System.out.println("Finally executing ");
		}
	}

	void start1() 
	{
		boolean b1 = false;
		boolean b2 = fix(b1);
		System.out.println(b1 + " " + b2);
	}

	boolean fix(boolean b1) 
	{
		b1 = true;
		return b1;
	}

	void start() 
	{
		String s1 = "slip";
		String s2 = fix(s1);
		System.out.println(s1 + " " + s2);
	}

	String fix(String s1) 
	{
		s1 = s1 + "stream";
		System.out.print(s1 + " ");
		return "stream";
	}
}
