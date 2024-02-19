package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> answer = new ArrayList<>();
        int j = 0;
        int k = 0;
        
        //Sort array.
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++)
        {
            j = i + 1;
            k = nums.length - 1;

            while (j < k)
            {
                int sum = nums[i] + nums[j] + nums[k];
                
                if (sum == 0)
                {
                    answer.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Skip duplicate elements for j
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    // Skip duplicate elements for k
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                }
                else if (sum < 0)
                {
                    j++;
                }
                else
                {
                    k--;
                }
            }
        }

        return answer;
    }
}
