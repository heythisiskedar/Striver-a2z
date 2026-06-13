package binary_search.binary_search_on_1D_array;

class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        int ans = searchInRotatedArrayOptimal(nums, 0);
        System.out.println(ans);
    }

    static int searchInRotatedArrayBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }

    static int searchInRotatedArrayOptimal(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target <= nums[high] && nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
