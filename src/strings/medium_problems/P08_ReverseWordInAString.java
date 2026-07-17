package strings.medium_problems;

class P08_ReverseWordInAString {
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);

            if (i > 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static String reverseWords(String s) {
        int n = s.length();
        int i = n - 1;
        StringBuilder sb = new StringBuilder();

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

            sb.append(s.substring(i + 1, j + 1)).append(" ");
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }
}
