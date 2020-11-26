package com.citibank;

public class CitiBankTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		show("jack");
		
	}

	private static void show(String name) {
		// TODO Auto-generated method stub
		
		name = name+"Nelson";
		Runnable r = () -> {
			
		try{
			Thread.sleep(100);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		//System.out.println("Welcome: " + name);
	};

	new Thread(r).start();
	System.out.println("Your name is:" + name);
}
}
