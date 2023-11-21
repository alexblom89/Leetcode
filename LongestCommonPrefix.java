import java.util.*;

/**
 * With the string array sorted alphabetically, the first and last
 * elements are most dissimilar of all strings in the array, and thus only
 * those two need to be compared. The longest common substring must exist between
 * these two strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;
        while(c < first.length() && first.charAt(c) == last.charAt(c)) 
        {
            c++;
        }
        
        return c == 0 ? "" : first.substring(0, c);
    }
}
