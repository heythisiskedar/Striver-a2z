package binary_search.binary_search_on_2d_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P05_MatrixMedian {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 4, 9}, 
            {2, 5, 6}, 
            {3, 7, 8}
        };

        int brute = findMedianBrute(matrix);
        System.out.println(brute);
    }

    public static int findMedianBrute(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                list.add(matrix[i][j]);
            }
        }

        Collections.sort(list);

        return list.get(n * m / 2);
    }
}
