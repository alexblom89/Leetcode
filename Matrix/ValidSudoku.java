package Matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {

    /**
     * The problem is to validate that no numbers in the given matrix are repeated in a row, column,
     * or 3x3 square (of which there are 9).
     * My approach is to iterate through each row column by column, if a dupe is not encountered the rowSet
     * can be cleared to begin a new row. 
     * Columns are handled similarly, though each column has its own HashSet as a value in a HashMap, thus saving
     * the values. The values must be saved since we won't know if there are any duplicates until the final row has 
     * been iterated. 
     * The squares are handled similarly to the columns, except that there are only three HashMap entries, with
     * "left", "middle" and "right" keys. Their values are cleared with every third row, to make room for the following
     * three squares. 
     * At any point in any of these sets, if a duplicate value is encountered the function returns false.
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = new HashSet<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<String, Set<Character>> squareMap = new HashMap<>();        

        //Initialize squareMap.
        squareMap.put("left", new HashSet<Character>());
        squareMap.put("middle", new HashSet<Character>());
        squareMap.put("right", new HashSet<Character>());

        for (int i = 0; i < 9; i++)
        {
            if (i % 3 == 0)
            {
                squareMap.get("left").clear();
                squareMap.get("middle").clear();
                squareMap.get("right").clear();
            }

            rowSet.clear();

            for (int j = 0; j < 9; j++)
            {
                Character c = Character.valueOf(board[i][j]);

                if (c != '.')
                {
                    if (!colMap.containsKey(j))
                    {
                        colMap.put(j, new HashSet<Character>());
                    }

                    Set<Character> colSet = colMap.get(j);
                    
                    if (colSet.contains(c))
                    {
                        return false;
                    }
                    else
                    {
                        colSet.add(c);
                    }

                    if (rowSet.contains(c))
                    {
                        return false;
                    }
                    else
                    {
                        rowSet.add(c);
                    }

                    if (j >= 0 && j < 3)
                    {
                        Set<Character> left = squareMap.get("left");
                        if (left.contains(c))
                        {
                            return false;
                        }
                        else
                        {
                            left.add(c);
                        }
                    }
                    else if (j >= 3 && j < 6)
                    {
                        Set<Character> middle = squareMap.get("middle");
                        if (middle.contains(c))
                        {
                            return false;
                        }
                        else
                        {
                            middle.add(c);
                        }
                    }
                    else if (j >= 6 && j < 9)
                    {
                        Set<Character> right = squareMap.get("right");
                        if (right.contains(c))
                        {
                            return false;
                        }
                        else
                        {
                            right.add(c);
                        }
                    }
                }
            }
        }

        return true;
    }

    /**
     * Much more concise solution via the user schwetaa_'s solution on LeetCode.
     */
    public boolean isValidSudoku2(char[][] board) {
        HashSet<String> seen = new HashSet<>();
       
         for (int i=0; i<9; i++)
         {
              for (int j=0; j<9; j++)
              {
               if (board[i][j] != '.')
               { 
                   char currentVal = board[i][j];

                   //set.add returns false if value is already in set.
                    if (!(seen.add(currentVal + "found in row "+ i)) ||
                        !(seen.add(currentVal + "found in column "+ j) ) ||
                        !(seen.add(currentVal + "found in sub box "+ i/3 + "-"+ j/3)))
                    {
                        return false;
                    }
               }
           
            } 
         
         }

         return true;
     }
}
