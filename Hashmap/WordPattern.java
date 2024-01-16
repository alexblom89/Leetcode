package Hashmap;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/
 */
public class WordPattern {
    Map<Character, String> map = new HashMap<>();
    
    public boolean wordPattern(String pattern, String s) {
        char[] charArray = pattern.toCharArray();
        String[] valueArray = s.split(" ");
        if (charArray.length != valueArray.length)
        {
            return false;
        }

        for (int i = 0; i < charArray.length; i++)
        {
            char c = charArray[i];
            String v = valueArray[i];
            if (!map.containsKey(c))
            {
                if (map.containsValue(v))
                {
                    return false;
                }
                map.put(c, v);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : charArray)
        {
            sb.append(map.get(c) + " ");
        }

        return sb.toString().trim().equals(s);
    }
}
