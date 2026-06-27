package binary_search.binary_search_on_1d_array;

public class P03_UpperBound {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};

        int result = upperBoundOptimal(nums, 2);
        System.out.println(result);
    }

    static int upperBoundBrute(int[] nums, int x) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > x) {
                return i;
            }
        }

        return nums.length;
    }

    static int upperBoundOptimal(int[] nums, int x) {
        int low = 0;
        int high = nums.length - 1;
        int minIndex = nums.length;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] > x) {
                minIndex = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return minIndex;
    }
}