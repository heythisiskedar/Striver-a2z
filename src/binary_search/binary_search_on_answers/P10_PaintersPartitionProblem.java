package binary_search.binary_search_on_answers;

public class P10_PaintersPartitionProblem {
  public int findLargestMinDistanceBrute(int[] boards, int k) {
        int low = 0;
        int high = 0;

        for (int board : boards) {
            low = Math.max(board, low);
            high += board;
        }

        for (int i = low; i <= high; i++) {
            if (checkPainters(boards, i, k)) {
                return i;
            }
        }

        return low;
  }

  static int findLargestMinDistanceOptimal(int[] boards, int k) {
        int low = 0;
        int high = 0;

        for (int board : boards) {
            low = Math.max(board, low);
            high += board;
        }

        int ans = low;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (checkPainters(boards, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
  }

  private static boolean checkPainters(int[] boards, int maxTime, int k) {
        int painters = 1;
        int currentTime = 0;

        for (int board : boards) {
            if (currentTime + board > maxTime) {
                painters++;
                currentTime = board;
            } else {
                currentTime += board;
            }
        }

        return painters <= k;
  }
}
