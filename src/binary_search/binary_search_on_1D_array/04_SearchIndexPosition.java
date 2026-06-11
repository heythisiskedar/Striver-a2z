package binary_search.binary_search_on_1D_array;

class SearchIndexPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int ans = searchIndexPositionOptimal(nums, 2);

        System.out.println(ans);
    }

    static int searchIndexPositionOptimal(int[] nums, int target) {
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
