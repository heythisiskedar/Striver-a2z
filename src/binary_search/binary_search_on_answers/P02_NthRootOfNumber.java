package binary_search.binary_search_on_answers;

public class P02_NthRootOfNumber {
  static int nThRootOfNumberBrute(int n, int m) {
        long root = -1;

        for (int i = 1; i <= m; i++) {
            if ((long) Math.pow(i, n) == m) {
                root = i;
                break;
            }
        }

        return (int) root;
  }

  static int nThRootOfNumberOptimal(int n, int m) {
        int low = 1;
        int high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midState = checkPowerState(mid, n, m);

            if (midState == 1) {
                return mid;
            } else if (midState == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private static int checkPowerState(int mid, int n, int m) {
        long ans = 1;

        for (int i = 1; i <= n; i++) {
            ans *= mid;

            if (ans > m) {
                return 2;
            }
        }

        if (ans == m) {
            return 1;
        }

        return 0;
    }
}
