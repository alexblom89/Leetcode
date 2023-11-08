import java.util.Arrays;

public class MergeSortedArray 
{
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //Iterate through nums2 and append each value to nums1 starting at index m.
        for (int j = 0, i = m; j < n; j++)
        {
            nums1[i] = nums2[j];
            i++;
        }

        Arrays.sort(nums1);
    }
}