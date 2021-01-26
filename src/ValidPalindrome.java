import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPalindrome {

  public static void main(String[] args) {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
  }

  public static boolean isPalindrome(String s) {

    String regex = "[^a-zA-Z0-9]";
    System.out.println(Calendar.getInstance().getTime());
    String str = s.replaceAll(regex, "");
    System.out.println(Calendar.getInstance().getTime());

    Pattern pattern = 
    // System.out.println(str);
    StringBuilder sb = new StringBuilder(str);
    // System.out.println(sb.reverse());
    if (str.equalsIgnoreCase(sb.reverse().toString())) {
      return true;
    }
    return false;
  }
}
