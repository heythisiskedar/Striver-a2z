package binary_search.binary_search_on_1D_array;

class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        int ans = searchInRotatedArrayBrute(nums, 0);
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
}
