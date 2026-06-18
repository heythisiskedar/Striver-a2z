package binary_search;

class Solution {
  static int floorSqrt(int num) {
        if (num == 0 || num == 1) {
            return num;
        }

        int low = 1;
        int high = num / 2;
        int ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (mid * mid <= num) {
                ans = (int) mid;
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }

        return ans;
  }
}
