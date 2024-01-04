package Array.String;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class HIndex
{
    public int hIndex(int[] citations)      
    {
        Arrays.sort(citations);
        int n = citations.length;

        for (int i = 0; i < n; i++)
        {
            int h = n - i;
            if (citations[i] >= h)
            {
                return h;
            }
        }
        return 0;
    }

    /**
     * Top solution using counting sort.
     */
    public int hIndex2(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int c : citations) {
            if(c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for(int i = n; i >= 0; i--) {
            count += buckets[i];
            if(count >= i) {
                return i;
            }
        }
        return 0;
    }
}
 