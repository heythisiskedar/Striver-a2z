package binary_search.binary_search_on_1d_array;

public class P05_FloorAndCeiling {
    public static void main(String[] args) {
        int[] nums = {3, 4, 4, 7, 8, 10};
        foorAndCeiling(nums,5);
    }

    // floor - The floor of x is the largest element in the array which is smaller than or equal to x
    // ceil - The ceiling of x is the smallest element in the array greater than or equal to x
    static void foorAndCeiling(int[] nums, int x) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        int floor = -1;
        int ceil = -1;


        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] <= x) {
                floor = nums[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        low = 0;
        high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] >= x) {
                ceil = nums[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(floor + " " + ceil);
    } 
}
