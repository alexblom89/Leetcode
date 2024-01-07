
import java.util.HashMap;
import java.util.Map;
/**
 * https://leetcode.com/problems/ransom-note/
 */
 class RansomNote {
    Map<Character, Integer> map = new HashMap<>();

    public boolean canConstruct(String ransomNote, String magazine) {
        for (char m : magazine.toCharArray())
        {
            map.merge(m, 1, Integer::sum);
        }

        for (char c : ransomNote.toCharArray())
        {
            if (!map.containsKey(c) || map.get(c) == 0)
            {
                return false;
            }
            else
            {
                Integer value = map.get(c);
                value--;
                map.put(c, value);
            }
        }

        return true;
    }
}