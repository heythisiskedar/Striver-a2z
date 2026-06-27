package binary_search.binary_search_on_1d_array;

public class P04_SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int ans = searchInsertPositionOptimal(nums, 2);

        System.out.println(ans);
    }

    static int searchInsertPositionOptimal(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int index = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] >= target) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return index;
    }
}
