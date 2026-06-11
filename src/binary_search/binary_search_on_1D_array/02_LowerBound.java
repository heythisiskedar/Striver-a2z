package binary_search.binary_search_on_1D_array;

class LowerBound {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};

        int result = lowerBoundBrute(nums, 2);
        System.out.println(result);
    }

    static int lowerBoundBrute(int[] nums, int x) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= x) {
                return i;
            }
        }

        return nums.length;
    }
}