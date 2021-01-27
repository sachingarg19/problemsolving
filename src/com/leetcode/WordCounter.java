/**
 * 
 */
package com.leetcode;

import java.io.*;
import java.util.Scanner;
import java.util.*;

/**
 * Counting number of words repeated in a file
 * 
 */

public class WordCounter {

  public static Scanner scan = null;
  static Map<String, Integer> wordCountMap = new HashMap<>();

  public static void main(String[] args) {
    try (FileReader inputFile = new FileReader("problemsolving/src/com/leetcode/wordcount.txt");
        Scanner scan = new Scanner(inputFile)) {
      while (scan.hasNextLine()) {
        String word = scan.next();
        wordCount(word);
      }
    } catch (FileNotFoundException f) {
      f.printStackTrace();
    } catch (IOException i) {
      i.printStackTrace();
    }
  }

  public static void wordCount(String word) {
    int wordCount = 1;
    if (wordCountMap.containsKey(word)) {
      wordCountMap.put(word, wordCountMap.get(word) + 1);
    } else {
      wordCountMap.put(word, wordCount);
    }
    System.out.println(wordCountMap);
  }

}
