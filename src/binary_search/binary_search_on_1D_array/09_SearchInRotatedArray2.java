package binary_search_on_1D_array;

class SearchInRotatedArray2 {
  public static void main(String[] args) {
    
  }

 
  static boolean searchInRotatedArray2Brute(int[] nums, int target) {
      for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        
        return false;
  }

  static boolean searchInRotatedArray2Optimal(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                return true;
            }
            
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }
            
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                    if (nums[high] >= target && nums[mid] < target) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
              }
        }
        
        return false;
  }
}
