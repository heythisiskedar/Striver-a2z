package strings.easy_problems;

public class P01_RemoveOutermostParentheses {
    public static void main(String[] args) {
        String s = "(()())(())";

        String ans = removeOuterParentheses(s);
        System.out.println(ans);
    }

    public static String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int level = 0;

        for (char ch : s.toCharArray()) {
            if  (ch == '(') {
                if (level > 0) {
                    ans.append('(');
                }

                level++;
            } else if (ch == ')') {
                level --;

                if (level > 0) {
                    ans.append(')');
                }
            }
        }

        return ans.toString();
    }
}