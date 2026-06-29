package binary_search.binary_search_on_2d_array;

import java.util.Arrays;

public class P04_FindPeakElementII {
    public static void main(String[] args) {
        int[][] mat = {{1,4},{3,2}};

        int[] brute = findPeakGridBrute(mat);
        System.out.println(Arrays.toString(brute));

        int[] optimal = findPeakGridOptimal(mat);
        System.out.println(Arrays.toString(optimal));
    }

    public static int[] findPeakGridBrute(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int top = (i > 0) ? mat[i - 1][j] : -1;
                int bottom = (i < n - 1) ? mat[i + 1][j] : -1;
                int left = (j > 0) ? mat[i][j - 1] : -1;
                int right = (j < m - 1) ? mat[i][j + 1] : -1;

                int current = mat[i][j];

                if (current > top && current > bottom && current > left && current > right) {
                    return new int[] {i, j};
                }
            }
        }

        return new int[] {};
    }

    public static int[] findPeakGridOptimal(int[][] mat) {
        int m = mat[0].length;

        int low = 0;
        int high = m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int maxRow = FindMaxElement(mat, mid);

            int cur = mat[maxRow][mid];
            int left = mid - 1 >= 0 ? mat[maxRow][mid - 1] : -1;
            int right = mid + 1 < m ? mat[maxRow][mid + 1] : -1;

            if (cur > left && cur > right) {
                return new int[] {maxRow, mid};
            } else if (cur < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[] {};
    }

    private static int FindMaxElement(int[][] mat, int col) {
        int max = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] > max) {
                max = mat[i][col];
                index = i;
            }
        }

        return index;
    }

}
