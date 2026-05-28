public class EasyProblems {
    public static void main(String[] args) {


    }

    static void largestElement(int[] nums) {
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        System.out.println("Largest: " + max);
    }

    static void secondLargestElementBrute(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max && nums[i] != max) secondMax = nums[i];
            if (nums[i] < max && nums[i] != min) secondMin = nums[i];
        }

        System.out.println("Second smallest element: " + secondMin);
        System.out.println("Second largest element: " + secondMax);
    }

    static void secondLargestElementBetter(int[] nums) {
        if (nums.length <= 1) System.out.println(-1 + " " + -1);;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int secondMin = Integer.MAX_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for (int num : nums) {
            if (num < secondMin && num != min) secondMin = num;

            if (num > secondMax && num != max) secondMax = num;
        }

        System.out.println("Second small: " + secondMin);
        System.out.println("Second large: " + secondMax);
    }

    static void secondLargestElementOptimal(int[] nums) {
        if (nums.length <= 1) System.out.println(-1 + " " + -1);

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < min) {
                secondMin = min;
                min = num;
            } else if (num < secondMin && num != min) {
                secondMin = num;
            }

            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }

        System.out.println("Second small: " + secondMin);
        System.out.println("Second large: " + secondMax);
    }

    static boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) return false;
        }

        return true;
    }

    static List<Integer> removeDuplicatesBrute(int[] nums) {
        List<Integer> arr = new ArrayList<>();

        for (int num : nums) {
            if (!arr.contains(num)) {
                arr.add(num);
            }
        }

        return arr;
    }

    static int removeDuplicatesOptimal(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;

                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    static void leftRotateArrayByOne(int[] nums) {
        int temp = nums[0];

        for (int i = 1; i < nums.length; i++)  {
            nums[i - 1] = nums[i];
        }

        nums[nums.length - 1] = temp;
    }

    static void rightRotateByK(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1); // reverse whole array
        reverse(nums, 0, k - 1); // reverse from 0 to k - 1 (sorts 0 to k - 1 in ascending order)
        reverse(nums, k, n - 1); // reverse from k to n - 1 (sorts k to n - 1 in ascending order)
    }

    static void reverse(int[] nums, int low, int high) {
        while (low < high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;

            low++;
            high--;
        }
    }

    static void moveZerosToEndBrute(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                temp[index++] = num;
            }
        }

        System.arraycopy(temp, 0, nums, 0, n);
    }

    static void moveZerosToEndOptimal(int[] nums) {
        int n = nums.length;
        int j = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        if (j == -1) return;

        for (int i = j  + 1; i < n; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
            }
        }
    }

    static int linearSearch(int[] nums, int key) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                return i;
            }
        }

        return -1;
    }

    static void unionOfTwoSortedArraysOptimal(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int n = nums1.length;
        int m = nums2.length;
        List<Integer> union = new ArrayList<>();

        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                if (union.isEmpty() || union.getLast() != nums1[i]) {
                    union.add(nums1[i]);
                }
                i++;

            } else if (nums2[j] < nums1[i]) {
                if (union.isEmpty() || union.getLast() != nums2[j]) {
                    union.add(nums2[j]);
                }
                j++;

            } else {
                if (union.isEmpty() || union.getLast() != nums1[i]) {
                    union.add(nums1[i]);
                }
                i++;
                j++;
            }
        }

        while (i < n) {
            if (union.isEmpty() || union.getLast() != nums1[i]) {
                union.add(nums1[i]);
            }
            i++;
        }

        while (j < m) {
            if (union.isEmpty() || union.getLast() != nums2[j]) {
                union.add(nums2[j]);
            }
            j++;
        }

        System.out.println(union);
    }

    static int missingNumberBrute(int[] nums) {
        int n = nums.length;

        // iterate through every number from 0 to n
        for (int i = 1; i <= n; i++) {
            boolean found = false;

            // check if 'i' exists in the array
            for (int j : nums) {
                if (j == i) {
                    found = true;
                    break;
                }
            }

            if (!found) return i;
        }

        return -1;
    }

    static int missingNumberOptimal(int[] nums) {
        int sum = 0;
        int max = 0;

        return 0;
    }

    static void consecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                if (count > max) max = count;
            }

            else count = 0;
        }

        System.out.println(max);
    }

    static void singleNumber(int[] nums) {
        int uniqueElement = 0;

        for (int num : nums) {
            uniqueElement ^= num;
        }

        System.out.println(uniqueElement);
    }

    static void longestSubarrayBrute(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;

        for (int startIndex = 0; startIndex < n; startIndex++) {
            for (int endIndex = startIndex; endIndex < n; endIndex++) {
                int currentSum = 0;

                for (int i = startIndex; i <= endIndex; i++) {
                    currentSum += nums[i];
                }

                if (currentSum == k) {
                    maxLength = Math.max(maxLength, endIndex - startIndex + 1);
                }
            }
        }

        System.out.println(maxLength);
    }

    static void longestSubarrayOptimal(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;
        int left = 0, right = 0;
        int sum = nums[0];

        while (right < n) {
            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }

            right++;
            if (right < n) {
                sum += nums[right];
            }
        }

        System.out.println(maxLength);
    }
}