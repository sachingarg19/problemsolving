package com.betsol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class TestClass {
	public static String largestNumber(int[] nums) {
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(strs, new Comparator<String>() {
			public int compare(String s1, String s2) {
				String leftRight = s1 + s2;
				String rightLeft = s2 + s1;
				return -leftRight.compareTo(rightLeft);

			}
		});

		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			sb.append(s);
		}

		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}

	public static void main(String args[]) throws Exception {
		int[] inps = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String size = br.readLine();
		int n = Integer.valueOf(size);
		if (n >= 1 && n <= 100) {
			inps = new int[n];
			int index = 0;
			String input = br.readLine();
			String[] inputSplit = input.split("\\s+");
			for (int i = 0; i < inputSplit.length; i++) {
				int number = Integer.valueOf(inputSplit[i]);
				if (number >= 1 && number <= 1000000) {
					inps[index] = number;
					index++;
				}
			}
		}
		String out = largestNumber(inps);
		System.out.println("abc " +out);
	}
}