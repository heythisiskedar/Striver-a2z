package binary_search.binary_search_on_answers;

public class P09_SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for (int num : nums) {            
            low = Math.max(num, low);
            high += num;
        }
        
        int ans = low;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (subarrayCount(nums, mid) <= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private int subarrayCount(int[] nums, int maxSum) {
        int subarrays = 1;
        int currentSum = 0;
        for (int num : nums) {
            if (currentSum + num > maxSum) {
                subarrays++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }

        return subarrays;
    }
}
