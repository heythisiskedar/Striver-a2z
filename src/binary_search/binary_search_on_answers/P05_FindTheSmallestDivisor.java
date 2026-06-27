package binary_search.binary_search_on_answers;

public class P05_FindTheSmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        for (int num : nums) {
            high = Math.max(num, high);
        }
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (checkDivisor(nums, mid, threshold)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean checkDivisor(int[] nums, int divisor, int threshold) {
        long sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor;
            if (sum > threshold) {
                return false;
            }
        }

        return true;
    }
}
