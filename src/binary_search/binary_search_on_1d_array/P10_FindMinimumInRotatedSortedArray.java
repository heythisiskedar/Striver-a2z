package binary_search.binary_search_on_1d_array;

public class P10_FindMinimumInRotatedSortedArray {
  static int findMin(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            if (nums[low] <= nums[high]) {
                minNum = Math.min(nums[low], minNum);
                break;
            }
            int mid = low + (high - low) / 2;
            
            minNum = Math.min(nums[mid], minNum);
            
            if (nums[high] < nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return minNum;
  }
}
