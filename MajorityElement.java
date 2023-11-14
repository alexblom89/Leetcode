import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
 */

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map <Integer, Integer> map = new HashMap<>();
        for (int num : nums)
        {
            if (map.containsKey(num))
            {
                map.merge(num, 1, (k, v) -> k + v);
            }
            else
            {
                map.put(num, 1);
            }
        }
        
        Integer key = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        return Integer.valueOf(key);
    }
}
