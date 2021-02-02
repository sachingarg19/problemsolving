/**
 * 
 */
package com.leetcode;

import java.util.*;

/**
 * Find out unique characters from string
 */
public class UniqueCharactersFromString {

  public static final Map<Character, Integer> map = new HashMap<>();
  public static final List<Character> list = new ArrayList<>();

  public static void main(String[] args) {
    String input = "Sachina";

    findUniqueChar(input);
  }

  public static void findUniqueChar(String input) {
    if (!input.isEmpty()) {
      for (int i = 0; i < input.length(); i++) {
        char ch = input.charAt(i);
        usingList(ch);
        usingMap(ch);
      }
      System.out.println("map -- " + map);
      System.out.println("list -- " + list);
    }
  }

  private static Map<Character, Integer> usingMap(Character ch) {
    if (!map.containsKey(ch)) {
      map.put(ch, 1);
    } else {
      map.remove(ch);
    }
    return map;
  }

  private static List<Character> usingList(Character ch) {
    if (!list.contains(ch)) {
      list.add(ch);
    } else {
      list.remove((Character) ch);
    }
    return list;
  }
}
