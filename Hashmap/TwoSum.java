package Hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i = 0; i < nums.length; i++)
        {
            map.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++)
        {
            int difference = target - nums[i];
            if (map.containsKey(difference) && map.get(difference) != i)
            {
                return new int[]{i, map.get(difference)};
            }
        }
        return new int[]{};
    }
}
