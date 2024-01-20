package Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/
 * 
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;

        //Add intervals to list until the newInterval start.
        while (i < intervals.length && intervals[i][1] < newInterval[0])
        {
            result.add(intervals[i]);
            i++;
        }

        //Move through intervals, updating start and end of newInterval.
        //End loop when next interval start is > newInterval end.
        while(i < intervals.length && intervals[i][0] <= newInterval[1])
        {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        result.add(newInterval);
        
        //Continue moving through intervals until end of interval array, adding them to list.
        while(i < intervals.length){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
