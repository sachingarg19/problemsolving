package com.betsol;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Reverse {
	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        StringBuffer buffer = new StringBuffer();
	        buffer.append(line);
	        String reverse = buffer.reverse().toString();
	        while(reverse.startsWith("0")) {
	      	  reverse = reverse.substring(0+1);
	        }
	        System.out.println(reverse);
	}

}
