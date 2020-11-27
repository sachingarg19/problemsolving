import java.util.Arrays;

/**
 * Remove the duplicate from string
 */
public class RemoveDuplicateFromString {

  public static void main(String[] args) {
    System.out.println(removeDuplicate("aabbbccc"));
    System.out.println(removeDuplicate("bbaabbbcccdd"));
    System.out.println(removeDuplicate("efsbbaasbbsbccscdd"));
  }

  public static String removeDuplicate(String s) {
    if (s.length() == 0)
      return "";
    if (s.length() == 1)
      return s;
    char[] tempArray = s.toCharArray();
    Arrays.sort(tempArray);
    s = new String(tempArray);
    String result = s;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i - 1)) { // index 1, a == inde 0, a / index
        String c = s.charAt(i) + "" + s.charAt(i - 1);
        String c1 = "" + s.charAt(i);
        result = result.replace(c, c1);
        // System.out.println("result: " + result);
      }
    }

    return result;
  }

}
