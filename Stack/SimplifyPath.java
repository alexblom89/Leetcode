package Stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/simplify-path/
 */
public class SimplifyPath {
    /**
     * For this problem, I split the input string by "/". Then iterate over the resultant 
     * array. Skip instances of '.', and for '..' pop the stack. If neither, add the string
     * to the stack.
     * 
     * After, I use the stack method 'copyInto' to copy the stack's values into an array 
     * to iterate over them and build the simplified path.
     * @param path
     * @return Simplified Path
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] stringArray = path.split("/");
        
        for (int i = 0; i < stringArray.length; i++)
        {
            String currentString = stringArray[i];
            if (!currentString.isEmpty())
            {
                if (currentString.equals("."))
                {
                    continue;
                }
                else if (currentString.equals("..")) 
                {
                    if (!stack.isEmpty())
                    {
                        stack.pop();
                    }
                    
                }
                else
                {
                    stack.push(currentString);
                }   
            }
        }

        //Build  simplified path.
        String[] stackArray = new String[stack.size()];
        stack.copyInto(stackArray);
        StringBuilder sb = new StringBuilder();
        sb.append("/");

        for (String s : stackArray)
        {
            sb.append(s);
            stack.pop();
            if (!stack.isEmpty())
            {
                sb.append("/");
            }
        }

        return sb.toString();
    }
}
