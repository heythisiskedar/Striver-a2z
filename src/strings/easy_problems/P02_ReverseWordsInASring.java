package strings.easy_problems;

public class P02_ReverseWordsInASring {
    public static void main(String[] args) {
        String  s = " hello world";

        String a1 = reverseWordsApproach1(s);
        System.out.println(a1);

        String a2 = reverseWordsApproach2(s);
        System.out.println(a2);
    }

    public static String reverseWordsApproach1(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            ans.append(words[i]);

            if (i > 0) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }

    public static String reverseWordsApproach2(String s) {
        StringBuilder ans = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if (i < 0) {
                break;
            }

            int j = i;

            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            String word = s.substring(i + 1, j + 1);

            if (ans.length() > 0) {
                ans.append(" ");
            }

            ans.append(word);
        }

        return ans.toString();
    }
}