package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MediumProblems {
    public static void main(String[] args) {

        int[] nums = {2, 3, 4, 5, 1};
        System.out.println(Arrays.toString(nums));

        int profit = maxProfitBrute(nums);
        System.out.println(profit);
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
        int count0 = 0, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
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
        int n = prices.length;
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
}