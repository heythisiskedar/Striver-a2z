package binary_search.binary_search_on_answers;

public class P08_AllocateMinimumNumberOfPages {
  public int findPagesBrute(int[] nums, int m) {
        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(num, low);
            high += num;
        }

        int ans = low;

        for (int i = low; i <= high; i++) {
            if (countStudents(nums, i, m)) {
                return i;
            }
        }

        return ans;
  }

  static int findPagesOptimal(int[] nums, int m) {
        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(num, low);
            high += num;
        }

        int ans = low;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (countStudents(nums, mid, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
  }

  private static boolean countStudents(int[] nums, int maxPages, int m) {
        int stu = 1;
        int curPages = 0;

        for (int num : nums) {
            if (curPages + num > maxPages) {
                stu++;
                curPages = num;
            } else {
                curPages += num;
            }
        }

        return stu <= m;
  }
}
