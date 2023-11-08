class RemoveElement {
    public int removeElement(int[] nums, int val) {

        int count = 0;
        for (int num : nums)
        {
            if (num == val)
            {
                count += 1;
            }
        }

        //iterate through k elements, swapping with the last element if it equals val.
        //move the reference to last element when swapped.
        int k = nums.length - count;
        int swapIndex = nums.length - 1;


        for (int i = 0; i < k; i++)
        {
            int indexElement = nums[i];
            int swapElement = nums[swapIndex];
            if (indexElement == val)
            {
                //Don't want to swap with val.
                while (swapElement == val)
                {
                    swapIndex--;
                    swapElement = nums[swapIndex];
                }

                nums[swapIndex] = indexElement;
                nums[i] = swapElement;
                swapIndex--;
            }
        }
        return k;
    }

    /**
     * More concise solution.
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        return i;
    }
}