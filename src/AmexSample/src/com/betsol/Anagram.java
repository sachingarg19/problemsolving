package com.betsol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Anagram {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int inputSize = Integer.parseInt(line);
		String[] anagramGroup = new String[inputSize];
		if (inputSize >= 1 && inputSize <= 100000) {
			for (int i = 0; i < inputSize; i++) {
				line = br.readLine();
				anagramGroup[i] = line;
			}
		}
		HashMap<Integer, ArrayList<String>> hm = new HashMap<Integer, ArrayList<String>>();
		groupAnagrams(anagramGroup, hm);
		Set<Entry<Integer, ArrayList<String>>> entry = hm.entrySet();
		int size = Integer.MIN_VALUE;
		for (Entry<Integer, ArrayList<String>> ent : entry) {
			if (size < ent.getValue().size()) {
				size = ent.getValue().size();
			}
		}
		System.out.println(size);
	}

	public static void groupAnagrams(String[] list, HashMap<Integer, ArrayList<String>> hm) {

		for (int x = 0; x < list.length; x++) {
			if (list[x] == null) {
				continue;
			}

			String curX = list[x];
			int hashX = primeHash(curX);

			hm.put(hashX, new ArrayList<String>(Arrays.asList(curX)));

			for (int y = x + 1; y < list.length; y++) {

				String curY = list[y];
				int hashY = 0;
				if(null != curY){
					hashY = primeHash(curY);
				}

				if (curY == null || curY.length() != curX.length())
					continue;

				if (hashX == hashY) {
					//if(null != hm.get(hashX) && !hm.get(hashX).contains(curY)){
						hm.get(hashX).add(curY);
					//}

					list[y] = null;
				}
			}
		}
	}

	public static int primeHash(String word) {
		int productOfPrimes = 1;
		int prime[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };

		for (char ch : word.toCharArray()) {
			productOfPrimes *= prime[(int) ch - (int) 'a'];
		}
		return productOfPrimes;
	}
}