package binary_search.binary_search_on_1D_array;

class BinarySearchToSearchTarget {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 10, 11, 14};
        int result = binarySearch(nums, 5);
        System.out.println(result);
    }

    static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
