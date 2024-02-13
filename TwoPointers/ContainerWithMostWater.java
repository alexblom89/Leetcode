package TwoPointers;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * Set pointers to the beginning and end of the array, 
 * calculate area based on distance between indices and 
 * the smaller side of the container.
 * Return maxArea.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int length = height.length;
        int start = 0;
        int end = length - 1;
        int maxArea = 0;

        while (start < end)
        {
            int startH = height[start];
            int endH = height[end];
            int base = end - start;
            int minHeight = Math.min(startH, endH);

            //Calculate area.
            int area = base * minHeight;
            maxArea = Math.max(maxArea, area);

            if (startH <= endH)
            {
                start++;
            }
            else
            {
                end--;
            }


        }

        return maxArea;
    }
}
