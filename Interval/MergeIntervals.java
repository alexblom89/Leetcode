package Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        //Sort intervals by starting value.
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();

        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals)
        {
            //Intervals overlap, move end if larger.
            if (interval[0] <= newInterval[1])
            {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
            //Intervals do not overlap, add new interval to the list.
            else
            {
                newInterval = interval;
                result.add(newInterval);
            }
        }

        int[][] answer = new int[result.size()][];
        return result.toArray(answer);
    } 
}
