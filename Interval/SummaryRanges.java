package Interval;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++)
        {
            int start = nums[i];

            //Iterate through array until the next element is not consecutive.
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1])
            {
                i++;
            }

            //If start is equal to nums[i], current is a sequence of 1 element;
            if (start != nums[i])
            {
                result.add("" + start + "->" + nums[i]);
            } 
            else 
            {
                result.add("" + start);
            }
        }

        return result;
    }
}
