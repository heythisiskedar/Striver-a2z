package binary_search.binary_search_on_1d_array;

import java.util.Arrays;

public class P06_FirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] ans = searchRangeOptimal(nums, 8);
        System.out.println(Arrays.toString(ans));
    }

    static int[] searchRangeIntrutive(int[] nums, int target) {
        int[] ans = {-1, -1};
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans[0] = mid;
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        low = 0;
        high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans[1] = mid;
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    static int[] searchRangeOptimal(int[] nums, int target) {
        int[] ans = {-1, -1};

        ans[0] = searchBound(nums, target, true);
        ans[1] = searchBound(nums, target, false);

        return ans;
    }

    private static int searchBound(int[] nums, int target, boolean isFirst) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                index = mid;

                if (isFirst) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return index;
    }
}