package binary_search.binary_search_on_1d_array;

public class P12_SingleElementInSortedArray {

    public int singleNonDuplicateBrute(int[] nums) {
      int ans = 0;

      for (int num : nums) {
        ans ^= num;
      }

      return ans;
    }
  
    public int singleNonDuplicateOptimal(int[] nums) {
        int n = nums.length;
        
        if (n == 1) {
            return nums[0];
        }
        
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }
        
        int low = 1;
        int high = n - 2;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            
            if (mid % 2 == 0 && nums[mid] == nums[mid + 1] || mid % 2 == 1 && nums[mid] == nums[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return -1;
    }
}
