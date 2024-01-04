package Array.String;
/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDupFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i-1])
                nums[i++] = n;
        return i;
    }

    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
     * Same as above but leave 2 of each char if more than 2 exist.
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        //define at most k times of duplicate numbers
        final int k = 2;

        //check if it is an empty array
        if(nums.length == 0) return 0;

        //start pointer of new array
        int m = 1;

        // count the time of duplicate numbers occurence
        int count = 1;

        for(int i = 1; i < nums.length; ++i) {
            if(nums[i] == nums[i - 1]) {
                if(count < k) {
                    nums[m++] = nums[i];
                }
                count++;
            } else {
                count = 1;
                nums[m++] = nums[i];
            }
        }
        return m;
    }
}
