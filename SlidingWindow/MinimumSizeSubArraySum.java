package SlidingWindow;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * This solution currently seems to work, however I get TLE (time limit exceeded)
 * error on one of the tests that contains many nums in the array and a large target.
 * 
 */
public class MinimumSizeSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int sum;
        int count;
        int minSize = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++)
        {
            int j = i + 1;
            sum = nums[i];
            count = 1;

            while (sum < target && j < nums.length)
            {
                sum += nums[j];
                count++;
                j++;
            }
            
            if (sum >= target)
            {
                minSize = Math.min(minSize, count);
            }
            
            if (i == 0 && j == nums.length && sum < target)
            {
                return 0;
            }
        }

        return minSize;
    }
}
