import java.util.Arrays;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int k = (int)Arrays.stream(nums).distinct().count();

        //Last index.
        int swapIndex = nums.length - 1;
        int sortIndex;
        int temp;
        
        for (int i = 0; i < k; i++)
        {
            for (int j = i + 1; j < k; j++)
            {
                sortIndex = j;
                while (nums[i] == nums[j] && swapIndex >= k)
                {
                    temp = nums[j];
                    nums[j] = nums[swapIndex];
                    nums[swapIndex] = temp;
                    swapIndex--;
                    
                    while (nums[sortIndex] > nums[sortIndex + 1] && sortIndex + 1 < k)
                    {
                        temp = nums[sortIndex];
                        nums[sortIndex] = nums[sortIndex+1];
                        nums[sortIndex+1] = temp;
                        sortIndex++;
                    }
                } 
            }
        }
        //System.out.println(Integer.toString(k));
        return k;
    }
}

