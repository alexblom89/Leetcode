package Hashmap;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;

        for (int num : nums)
        {
            set.add(num);
        }

        for (int i = 0; i < nums.length; i++)
        {
            int count = 1;
            int num = nums[i];

            //Decrement num to previous integer while checking if it is in set, if it is then increment count
            //and remove num. Next iteration will continue from the integer before that one if it exists,
            //counting from num as far "left" as possible.
            while (set.contains(--num))
            {
                count++;
                set.remove(num);
            }

            //Reset num.
            num = nums[i];

            //Same as before but increment instead to count consecutive integers to the "right".
            while(set.contains(++num))
            {
                count++;
                set.remove(num);
            }

            //Replace max if count is higher.
            max = Math.max(max, count);
        }
        return max;
    }
}
