package Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * 
 * i and j points to the ith row and jth column, as with description picture 
 * go right along the first row, then down the final column, left the last row,
 * and up first column. Then increase the offset such that already recorded columns 
 * and rows are not repeated.
 */
public class SpriralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int totalElements = rows * columns;
        List<Integer> result = new ArrayList<>();
        int offset = 0;
        int i = 0;
        int j = 0;
        int count = 0;

        while (count < totalElements)
        {
            //move right
            while (j < columns - offset && count < totalElements)
            {
                result.add(matrix[i][j]);
                j++;
                count++;
            }
    
            i++;
            j--;
            
            //move down
            while (i < rows - offset && count < totalElements)
            {
                result.add(matrix[i][j]);
                i++;
                count++;
            }
            
            i--;
            j--;

            //move left
            while (j >= offset && count < totalElements)
            {
                result.add(matrix[i][j]);
                j--;
                count++;
            }

            j++;
            i--;

            //move up
            while (i > offset && count < totalElements)
            {
                result.add(matrix[i][j]);
                i--;
                count++;
            }

            offset++;
            i = offset;
            j = offset;
        }

        return result;
    }
}
