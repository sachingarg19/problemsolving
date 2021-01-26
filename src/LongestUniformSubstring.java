public class LongestUniformSubstring {

    public static void main(String[] args){
        System.out.println("input");
        longestSubstr("aabbbbccdd");
    }
    
    public static int[] longestSubstr(String input){
        System.out.println(input);
        int left =0;
        int right =1;
        String temp ="";
        String newStr ="";
        int[] output = new int[]{0,0};
        if(input.isBlank()){
            return output;
        }
        while(input.length() > right){
            System.out.println("left -- " + input.charAt(left) + " right -- " + input.charAt(right));
            if(input.charAt(left) == input.charAt(right) || newStr.contains(""+input.charAt(right))){
                newStr = ""+input.charAt(left);
                System.out.println("newStr -- " + newStr);
                if(!temp.contains(newStr)){
                    temp = newStr;
                    System.out.println("temp1 -- " + temp);
                } else if(temp.length() < newStr.length() || temp.contains(""+newStr)){
                    temp += newStr;
                    output = new int[]{temp.indexOf(input.charAt(left)), right};
                    System.out.println("temp2 -- " + temp);
                }
                right ++;
            } else {
                left = right;
                right ++;
            }
        }
        //System.out.println("temp -- " + temp);
        //System.out.println(output);
        return output;
    }
}