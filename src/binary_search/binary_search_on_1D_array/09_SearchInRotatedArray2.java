package binary_search_on_1D_array;

class SearchInSortedArray2 {
  public static void main(String[] args) {
    
  }

 
  static boolean search(int[] nums, int target) {
      for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        
        return false;
  }
}
