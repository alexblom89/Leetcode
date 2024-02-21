package Interval;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
 */
public class MinimumArrows {
    public int findMinArrowShots(int[][] points) {

        //Sort arrays by first value.
        Arrays.sort(points, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        int end = points[0][1];
        int arrows = 1;

        for (int i = 0; i < points.length; i++)
        {
            if (points[i][0] > end)
            {
                //Not overlapping, shoot arrow and start new interval.
                arrows++;
                end = points[i][1];
            }
            else
            {
                //points[i][0] <= end, so it overlaps.
                //Need to extend the interval for subsequent overlapping balloons.
                end = Math.min(end, points[i][1]); 
            }
        }
        
        return arrows;
    }
}
