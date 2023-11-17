/**
 * https://leetcode.com/problems/jump-game-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int jumps = 1; //Track jumps.
        int currentEnd = nums[0]; //Current furthest position reached with current jumps.
        int farthest = nums[0]; //Furthest position reached with current and next jumps.

        if (nums == null || nums.length <= 1) {
            return 0;
        }

        for (int i = 1; i < nums.length-1; i++)
        {
            farthest = Integer.max(farthest, i + nums[i]);

            if (i == currentEnd)
            {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }
}
