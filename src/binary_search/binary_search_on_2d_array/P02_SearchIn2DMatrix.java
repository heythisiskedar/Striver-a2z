package binary_search.binary_search_on_2d_array;

public class P02_SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60}
        };
        int target = 3;

        boolean brute = searchMatrixBrute(matrix, target);
        System.out.println(brute);
        boolean optimal = searchMatrixOptimal(matrix, target);
        System.out.println(optimal);
        boolean strivers = searchMatrixStriversOptimal(matrix, target);
        System.out.println(strivers);
    }

    public static boolean searchMatrixBrute(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean searchMatrixOptimal(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (matrix[mid][m - 1] < target) {
                low = mid + 1;
            } else {
                if (binarySearch(matrix[mid], target)) {
                    return true;
                }
                high = mid - 1;
            }
        }

        return false;
    }

    private static boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static boolean searchMatrixStriversOptimal(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = n * m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = mid / m;
            int col = mid % m;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
