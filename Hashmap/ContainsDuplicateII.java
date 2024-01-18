package Hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            int element = nums[i];

            if (map.containsKey(element))
            {
                if (i - map.get(element) <= k)
                {
                    return true;
                }
            }

            map.put(element, i);
        }
        
        return false;
    }
}
