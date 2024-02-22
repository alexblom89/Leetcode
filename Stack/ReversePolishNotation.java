package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 
 */
public class ReversePolishNotation {
    public int evalRPN(String[] tokens) 
    {
        Stack<Integer> stack = new Stack<>();
        int a, b;

        for (String token : tokens)
        {
            switch (token)
            {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
