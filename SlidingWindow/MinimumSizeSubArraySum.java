package SlidingWindow;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * Old solution seemed to work, however I got TLE (time limit exceeded)
 * error on one of the tests that contains many nums in the array and a large target.
 * 
 * New solution uses the sliding window technique. Using two pointers to indicate the 
 * start and end of a window (i and j), move j until the window is valid (>= target).
 * Condense window by moving i (while checking that it is still valid), until it is no longer valid.
 */
public class MinimumSizeSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int i = 0;
        int j = 0;
        int minSize = Integer.MAX_VALUE;

        if (nums == null || nums.length == 0)
        {
            return 0;
        }

        while (j < nums.length)
        {
            //Sum keeps adding new window elements to expand window.
            sum += nums[j++]; 

            while (sum >= target)
            {
                //Update minSize.
                minSize = Math.min(minSize, j - i);

                //Move start index and keep the window valid by subtracting the value
                //no longer in the window from sum.
                sum -= nums[i++];
            }
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
