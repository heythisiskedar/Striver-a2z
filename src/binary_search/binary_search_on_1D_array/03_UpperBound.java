package binary_search.binary_search_on_1D_array;

class Upperbound {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};

        int result = upperBoundBrute(nums, 2);
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
}