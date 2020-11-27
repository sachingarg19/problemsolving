import java.util.*;

/**
 * Count char repetition in string
 */

public class CountStringVariableRepetition {

  public static void main(String[] args) {
    System.out.println(countCharInString("aaabbcccdee"));
    System.out.println(countCharInString("aaaddbbeeffbbcccdee"));
  }

  public static Map<Character, Integer> countCharInString(String s) {
    if (s.length() == 0)
      return null;

    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      int count = 1;
      char c = s.charAt(i);
      if (!map.containsKey(c)) {
        map.put(c, count);
      } else {
        count += map.get(c);
        map.put(c, count);
      }
    }
    return map;
  }

}
