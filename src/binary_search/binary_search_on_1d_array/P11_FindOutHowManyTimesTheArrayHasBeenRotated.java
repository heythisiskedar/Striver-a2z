package binary_search.binary_search_on_1d_array;

public class P11_FindOutHowManyTimesTheArrayHasBeenRotated {
	public int findRotations(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[high] < nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
	}
}
