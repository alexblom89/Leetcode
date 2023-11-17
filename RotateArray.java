/**
 * https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150
 */

public class RotateArray {
    /**
     * code taken from solutions.
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) 
    {
        //take k mod nums.length to find how many times array needs to actually rotate, 
        //since if k mod nums.length == 0 the array is back to original state.
        k = k % nums.length; 
        if(k < 0){ 
            k += nums.length;
        }
        //reverse elements before kth element.
        reverse(nums, 0, nums.length - k - 1);
        //reverse elements after kth element.
        reverse(nums, nums.length - k, nums.length - 1);
        //reverse new array to obtain answer.
        reverse(nums, 0, nums.length - 1);
    }
    public static void reverse(int nums[], int leftIndex, int rightIndex) 
    {     
        while(leftIndex < rightIndex){
            int temp = nums[leftIndex];
            nums[leftIndex] = nums[rightIndex];
            nums[rightIndex] = temp;
            
            leftIndex++;
            rightIndex--;
        }
    }
}
