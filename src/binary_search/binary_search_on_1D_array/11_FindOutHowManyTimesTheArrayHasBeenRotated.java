package binary_search_on_1D_array;

class Solution {
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
