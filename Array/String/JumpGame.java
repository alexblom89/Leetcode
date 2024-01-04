package Array.String;
/**
 * https://leetcode.com/problems/jump-game/description/
 */
public class JumpGame {
    /**
     * Iterate through array, keeping track of the furthest reachable index.
     * For an index to be reachable, all previous indices must be also.
     * Hence, we iterate through array, if an index is not reachable we return false, 
     * else we iterate through the whole array. If the loop finishes we return true.
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if(i > reachable)
            {
                return false;
            }
            reachable = Integer.max(reachable, i + nums[i]);
        }
        return true;
    }
}
