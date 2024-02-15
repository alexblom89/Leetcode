package TwoPointers;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumII {
    /**
     * This answer is provided by the user 'ciote' in the problem solutions. Because the 
     * input array is sorted, it follows that if the sum is less than the target, then the 
     * answer will be in the first half of the array, otherwise it is in the last half. 
     * If we place one pointer at the start and one at the end, either one can be moved toward the 
     * center depending on the sum. This eliminates having to repeatedly add sums together as in the brute force
     * method below.
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0; 
        int right = nums.length - 1;
        
        while (nums[left] + nums[right] != target) 
        {
            if (nums[left] + nums[right] < target) 
            {
                left++;
            }
            else 
            {
                right--; 
            }
        }
    
        return new int[] {left + 1, right + 1};
    }

    /**
     * Original solution using two pointers beginning at the start, runs in O(n^2) time.
     * @param numbers
     * @param target
     * @return
     */
    // public int[] twoSum(int[] numbers, int target) {
    //     int length = numbers.length;
    //     int[] result = new int[2];

    //     for (int i = 0; i < length; i++)
    //     {
    //         for (int j = i + 1; j < length; j++)
    //         {
    //             int sum = numbers[i] + numbers[j];

    //             if (sum == target)
    //             {
    //                 result[0] = i + 1;
    //                 result[1] = j + 1;
    //                 return result;
    //             }
    //         }
    //     }

    //     return result;
    // }
}
