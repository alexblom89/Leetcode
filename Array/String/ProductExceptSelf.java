package Array.String;
import java.util.Arrays;

public class ProductExceptSelf {
    /**
     * Brute force - O(n^2)
     */
    public int[] productExceptSelf(int[] nums) {
        int[] answerArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++)
        {
            int product = 1;
            for (int j = 0; j < nums.length; j++)
            {
                if (j != i)
                {
                    product *= nums[j];
                }
                answerArray[i] = product;
            }
        }
        return answerArray;
    }

    /**
     * O(n) solution with O(1) space complexity, loop through array from 0
     * to i-1, then from i+1 to last element, multiplying each element with the 
     * answerArray[i] and then with nums[i], thus multiplying everything but i together.
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int answerArray[] = new int[n];
        Arrays.fill(answerArray, 1);
        int current = 1;
        for(int i = 0; i < n; i++) {
            answerArray[i] *= current;
            current *= nums[i];
        }
        current = 1;
        for(int i = n - 1; i >= 0; i--) {
            answerArray[i] *= current;
            current *= nums[i];
        }
        return answerArray;
    }
}
