package binary_search_on_1D_array;

class FindMinimumInRotatedSortedArray {
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
