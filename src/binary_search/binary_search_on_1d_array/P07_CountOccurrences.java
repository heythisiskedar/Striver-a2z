package binary_search.binary_search_on_1d_array;

// Problem Statement: You are given a sorted array containing N integers and a number X, you have to find the occurrences of X in the given array.
public class P07_CountOccurrences {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 2, 2, 3};

        int ans = countOccurencesOptimal(nums, 2);
        System.out.println(ans);
    }

    static int countOccurencesBrute(int[] nums, int target) {
        int count = 0;

        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }

        return count;
    }

    static int countOccurencesOptimal(int[] nums, int target) {
    int[] ans = {-1, -1};

    ans[0] = searchBound(nums, target, true);
    ans[1] = searchBound(nums, target, false);

    return ans[1] - ans[0] + 1;
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