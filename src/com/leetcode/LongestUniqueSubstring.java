/**
 * 
 */
package com.leetcode;

import java.util.*;

public class LongestUniqueSubstring {

  public static void main(String[] args) {
    String input = "abcabcdefabcabdabcdepwkerfdtk";
    System.out.println(identifyLongestUniqueSubstring(input));
  }

  public static String identifyLongestUniqueSubstring(String str) {
    List<StringBuilder> output = new ArrayList<>();
    if (str.isEmpty())
      return "";
    if (str.length() == 1)
      return str;

    int right = 1;
    StringBuilder temp = new StringBuilder();
    temp.append(str.charAt(0));

    while (right < str.length()) {
      String rightChar = "" + str.charAt(right);

      if (!temp.toString().contains(rightChar)) {
        temp.append(rightChar);
        right++;
      } else {
        if (output.isEmpty()) {
          output.add(0, temp);
        }
        if (output.get(0).length() < temp.length()) {
          output.remove(0);
          output.add(0, temp);
        }
        temp = new StringBuilder().append("" + str.charAt(right));
        right++;
      }
    }

    System.out.println(output);
    return output.get(0).toString();
  }
}
