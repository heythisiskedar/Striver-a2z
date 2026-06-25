package binary_search_on_answers;

class Solution {
  public double findMedianSortedArraysBrute(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];
        
        int i = 0, j = 0, k = 0;
        
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        
        while (i < m) {
            merged[k++] = nums1[i++];
        }
      
        while (j < n) {
            merged[k++] = nums2[j++];
        }
        
        int totalLen = m + n;
        if (totalLen % 2 == 1) {
            return (double) merged[totalLen / 2];
        } else {
            return ((double) merged[totalLen / 2 - 1] + (double) merged[totalLen / 2]) / 2.0;
        }
  }    

  public double findMedianSortedArraysOptimal(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int n = nums1.length;
        int m = nums2.length;
        
        int low = 0;
        int high = n;
        
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (n + m + 1) / 2 - cut1;
            
            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            
            int right1 = (cut1 == n) ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = (cut2 == m) ? Integer.MAX_VALUE : nums2[cut2];
            
            if (left1 <= right2 && left2 <= right1) {
                if ((n + m) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        
        return 0.0;
  }
}
