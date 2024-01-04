package Array.String;
/**
 * https://leetcode.com/problems/roman-to-integer/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        int lastIndex = chars.length - 1;

        for (int i = 0; i < chars.length; i++)
        {
            char previousChar = (i != 0) ? chars[i - 1] : '\0';
            char nextChar = (i != lastIndex) ? chars[i + 1] : '\0';

            switch (chars[i]) 
            {
                case 'I':
                    if (i != lastIndex)
                    {
                        if (nextChar == 'V' || nextChar == 'X')
                        {
                            continue;
                        }
                    }
                    sum += 1;
                    break;
                case 'V':
                    if (previousChar == 'I')
                    {
                        sum += 4;
                    }
                    else 
                    {
                        sum += 5;
                    }
                    break;
                case 'X':
                    if (previousChar == 'I')
                    {
                        sum += 9;
                    }
                    else if (nextChar == 'L' || nextChar == 'C')
                    {
                        continue;
                    }
                    else
                    {
                        sum += 10;
                    }
                    break;
                case 'L':
                    if (previousChar == 'X')
                    {
                        sum += 40;
                    }
                    else
                    {
                        sum += 50;
                    }
                    break;
                case 'C':
                    if (previousChar == 'X')
                    {
                        sum += 90;
                    }
                    else if (nextChar == 'D' || nextChar == 'M')
                    {
                        continue;
                    }
                    else 
                    {
                        sum += 100;
                    }
                    break;
                case 'D':
                    if (previousChar == 'C')
                    {
                        sum += 400;
                    }
                    else 
                    {
                        sum += 500;
                    }
                    break;
                case 'M':
                    if (previousChar == 'C')
                    {
                        sum += 900;
                    }
                    else 
                    {
                        sum += 1000;
                    }
                    break;
            }
        }
        return sum;
    }

    /**
     * Much more concise answer. By iterating backwards, 
     * only previous character needs to be tracked and compared.
     * @param s
     * @return
     */
    public int romanToInt2(String s) {
    
        int answer = 0, number = 0, prev = 0;
    
        for (int j = s.length() - 1; j >= 0; j--) {
            switch (s.charAt(j)) {
                case 'M' -> number = 1000;
                case 'D' -> number = 500;
                case 'C' -> number = 100;
                case 'L' -> number = 50;
                case 'X' -> number = 10;
                case 'V' -> number = 5;
                case 'I' -> number = 1;
            }
            if (number < prev) {
                answer -= number;
            }
            else {
                answer += number;
            }
            prev = number;
        }
        return answer;
    }
}

