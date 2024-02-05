package Matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {
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
                    else if (j <= 3 && j < 6)
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
                    else if (j <= 6 && j < 9)
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
}
