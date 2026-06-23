package binary_search_on_answers;

class Solution {
  public int agressiveCowsBrute(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int maxDist = stalls[n - 1] - stalls[0];

        for (int dist = 1; dist <= maxDist; dist++) {
            if (!checkIfValid(stalls, cows, dist)) {
                return dist - 1;
            }
        }

        return maxDist;
    }

  public int agressiveCowsOptimal(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int n = stalls.length;

        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        int ans = 1:

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (checkIfValid(stalls, cows, mid)) {
            	ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
  }

  private boolean checkIfValid(int[] stalls, int cows, int dist) {
        int cowsPlaced = 1;
        int lastPlacedPos = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlacedPos >= dist) {
                cowsPlaced++;
                lastPlacedPos = stalls[i];
            }

            if (cowsPlaced >= cows) {
                return true;
            }
        }

        return false;
  }
}
