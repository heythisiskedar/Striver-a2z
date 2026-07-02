package strings.easy_problems;

public class P03_LargestOddNumberInString {
    public static void main(String[] args) {
        String string = "35427";

        String ans = largestOddNumber(string);
        System.out.println(ans);
    }

    public static String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';

            if (digit % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }

        return "";
    }
}
