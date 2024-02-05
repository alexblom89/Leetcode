package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringNoDuplicates {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int maxSize = 0;
        Set<Character> set = new HashSet<>();

        if (s.isEmpty())
        {
            return 0;
        }

        j = 0;
        while (j < s.length())
        {
            Character c = Character.valueOf(s.charAt(j));

            while (set.contains(c))
            {
                set.remove(s.charAt(i));
                i++;
            }

            set.add(c);
            j++;
            maxSize = Math.max(maxSize, j - i);
        }
        
        return maxSize;
    }
}
