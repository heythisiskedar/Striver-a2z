package binary_search_on_1D_array;

class FindPeakElement {
  public int findPeakElementBrute(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            boolean left = (i == 0) || (nums[i] > nums[i - 1]);

            boolean right = (i == n - 1) || (nums[i] > nums[i + 1]);

            if (left && right) {
                return i;
            }
        }

        return -1;
  }
  
  public int findPeakElementOptimal(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
  }
}
