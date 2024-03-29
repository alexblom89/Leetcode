import java.util.ArrayList;
import java.util.List;

import Matrix.SpriralMatrix;
import Matrix.ValidSudoku;

public class Main {
    public static void main(String[] args) {
        // int[] array = {0,0,1,1,1,2,2,3,3,4};
        // RemoveDuplicates.removeDuplicates(array);
        // ReverseWords.reverseWords("a good  example");
        // IsomorphicStrings.isIsomorphic("32767", "65535");
        // char[][] board = 
        // {
        //     {'5','3','.','.','7','.','.','.','.'},
        //     {'6','.','.','1','9','5','.','.','.'},
        //     {'.','9','8','.','.','.','.','6','.'},
        //     {'8','.','.','.','6','.','.','.','3'},
        //     {'4','.','.','8','.','3','.','.','1'},
        //     {'7','.','.','.','2','.','.','.','6'},
        //     {'.','6','.','.','.','.','2','8','.'},
        //     {'.','.','.','4','1','9','.','.','5'},
        //     {'.','.','.','.','8','.','.','7','9'}
        // };

        // char[][] board2 = 
        // {
        //     {'.','.','5','.','.','.','.','.','6'},
        //     {'.','.','.','.','1','4','.','.','.'},
        //     {'.','.','.','.','.','.','.','.','.'},
        //     {'.','.','.','.','.','9','2','.','.'},
        //     {'5','.','.','.','.','2','.','.','.'},
        //     {'.','.','.','.','.','.','.','3','.'},
        //     {'.','.','.','5','4','.','.','.','.'},
        //     {'3','.','.','.','.','.','4','2','.'},
        //     {'.','.','.','2','7','.','6','.','.'}
        // };
        // ValidSudoku.isValidSudoku(board2);

        int[][] matrix = 
        {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
        };
        
        List<Integer> list = new ArrayList<>();
        list = SpriralMatrix.spiralOrder(matrix);
        for (Integer i : list)
        {
            System.out.printf("%d", i);
        }
    }
}
 