package binary_search.binary_search_on_2d_array;

public class P01_RowsWithMaximumOnes {
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 0, 0},
            {0, 0, 1},
            {0, 0, 0}
        };

        int ans = rowsWithMaximumOnesOptimal(matrix);
        System.out.println(ans);
    }

    public static int rowsWithMaximumOnesBrute(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxOnes = 0;
        int index = -1;

        for (int i = 0; i < n; i++) {
            int countOnes = 0;

            for (int j = 0; j < m; j++) {
                countOnes += matrix[i][j];
            }

            if (countOnes > maxOnes) {
                maxOnes = countOnes;
                index = i;
            }
        }

        return index;
    }

    public static int rowsWithMaximumOnesOptimal(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxOnes = 0;
        int index = -1;

        for (int i = 0; i < n; i++) {
            int countOnes = m - lowerBound(matrix[i], m);

            if (countOnes > maxOnes) {
                maxOnes = countOnes;
                index = i;
            }
        }

        return index;
    }

    private static int lowerBound(int[] array, int m) {
        int low = 0;
        int high = m - 1;
        int index = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == 1) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return index;
    }
}
