package Stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Integer> stack = new Stack<>();

        for (int i : s.codePoints().toArray())
        {
            if (stack.empty())
            {
                stack.push(Integer.valueOf(i));
            }
            else if (i == '(' || i == '{' || i == '[')
            {
                stack.push(Integer.valueOf(i));
            }

            if (i == ')' || i == '}' || i == ']')
            {
                int last = stack.lastElement();
                StringBuilder sb = new StringBuilder().append(last).append(i);
                String pair = sb.toString();
                if (pair.equals("123125") || pair.equals("4041") || pair.equals("9193"))
                {
                    stack.pop();
                }
                else
                {
                    return false;
                }
            }
        }
        return stack.empty() ? true : false;
    }
}
