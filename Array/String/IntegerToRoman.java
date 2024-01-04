package Array.String;
public class IntegerToRoman {
    /**
     * https://leetcode.com/problems/integer-to-roman/
     * 
     * After a long attempt involving unwieldy switch statements and a while loop,
     * used the following far more concise and working solution.
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

    /**
     * Another solution with better time complexity, perhaps from fewer array accesses.
     */
    public String intToRoman2(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX","V", "IV", "I"};
        StringBuilder solution = new StringBuilder();

        int idx = 0;
        int tmp = num;
        while(tmp > 0) {
            // tmp matches a value
            if(tmp >= values[idx]) {
                solution.append(symbols[idx]);
                tmp -= values[idx];
            } else {
                idx++;
            }
        }

        return solution.toString();
    }
}
