package Matrix;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * 
 * Solution by user dietpepsi in the LeetCode solutions. Uses the first row and first column
 * that contains a 0 to track the other rows, then sets the zeroes for that row. Specifically, 
 * this runs with constant space complexity.
 * 
 * Another solution is similar however using a row array and column array to track the zeroes.
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int k = 0;

        //Check if the first row has a 0.
        while (k < n && matrix[0][k] != 0)
        {
            k++;
        }

        //Use first row/column as marker, scan the matrix.
        for (int i = 1; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (matrix[i][j] == 0)
                {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        //Set the zeroes.
        for (int i = 1; i < m; i++)
        {
            for (int j = n - 1; j >= 0; j--)
            {
                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
        }

        //Set the zeroes for the first row.
        if (k < n)
        {
            Arrays.fill(matrix[0], 0);
        }
    }
}
