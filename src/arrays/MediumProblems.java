package arrays;

import java.util.*;

public class MediumProblems {
    public static void main(String[] args) {

        int[][] matrix = new int[][] {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        
        setZerosBrute(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int complement = 0;
        boolean found = false;

        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];

            if (map.containsKey(complement)) {
                found = true;
                System.out.println(map.get(complement) + " " + i);
                break;
            }

            map.put(nums[i], i);
        }

        if (!found) System.out.println("Not found");
    }

    static void sortArrayOf012(int[] nums) {
        int count0 = 0, count1 = 0;

        for (int num : nums) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
        }

        for (int i = 0; i < count0; i++) {
            nums[i] = 0;
        }

        for (int i = count0; i < count0 + count1; i++) {
            nums[i] = 1;
        }

        for (int i = count0 + count1; i < nums.length; i++) {
            nums[i] = 2;
        }

        System.out.println(Arrays.toString(nums));
    }

    static void sortArrayOf012Optimal(int[] nums) {
        int low = 0, mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;

                low++;
                mid++;

            } else if (nums[mid] == 1) {
                mid++;

            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > (nums.length / 2)) {
                return num;
            }
        }

        return -1;
    }

    static int majorityElementOptimal(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count++;

            } else if (num == candidate) {
                count++;

            } else {
                count--;
            }
        }

        return candidate;
    }

    static int maxSubarray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;


        for (int num : nums) {
            sum += num;

            if (sum < 0) {
                sum = 0;
            }

            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        return maxSum;
    }

    static int maxSubarrayPrintSubarray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        int start = 0; // Start index of current subarray
        int ansStart = -1, ansEnd = -1; // Indices of maximum subarray

        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                start = i;
            }

            sum += nums[i];

            if (sum > maxSum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(nums[i] + " ");
        }

        return maxSum;
    }

    static int maxProfitBrute(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int profit = prices[j] - prices[i];

                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    static int maxProfitOptimal(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;

            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }

    static int[] rearrangeArrayBrute(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int num : nums) {
            if (num > 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }

        for (int i = 0; i < nums.length / 2; i++) {
            nums[i * 2] = pos.get(i);
            nums[i * 2 + 1] = neg.get(i);
        }

        return nums;
    }

    static int[] rearrangeArrayOptimal(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int posIndex = 0, negIndex = 1;

        for (int num : nums) {
            if (num > 0) {
                result[posIndex] = num;
                posIndex += 2;
            } else {
                result[negIndex] = num;
                negIndex += 2;
            }
        }

        return result;
    }

    static int longestConsecutiveBrute (int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int longest = 1;

        for (int num : nums) {
            int cur = num;
            int count = 1;

            while (linearSearch(nums, cur + 1) == true) {
                cur++;
                count++;
            }

            if (count > longest) {
                longest = count;
            }
        }

        return longest;
    }

    private static boolean linearSearch(int[] nums, int target) {
        for (int num : nums) {
            if (target == num) {
                return true;
            }
        }

        return false;
    }

    static int longestConsecutiveOptimal(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        int longest = 1;

        for (int num : nums) {
            set.add(num);
        }

        for (int i : set) {
            if (!set.contains(i - 1)) {
                int count = 1;
                int cur = i;

                while (set.contains(cur + 1)) {
                    count++;
                    cur++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    static void setZerosBrute(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    for (int col = 0; col < n; col++) {
                        if (matrix[i][col] != 0) {
                            matrix[i][col] = -1;
                        } 
                    }

                    for (int row = 0; row < m; row++) {
                        if (matrix[row][j] != 0) {
                            matrix[row][j] = 0-1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
