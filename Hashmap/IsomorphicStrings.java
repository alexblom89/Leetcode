package Hashmap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
/**
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, List<Integer>> sMap = new HashMap<Character, List<Integer>>();
        Map<Character, List<Integer>> tMap = new HashMap<Character, List<Integer>>();

        if (s.length() != t.length())
        {
            return false;
        }
            
        sMap = collectDuplicateCharIndexMap(s, sMap);
        tMap = collectDuplicateCharIndexMap(t, tMap);

        if (sMap.size() != tMap.size())
        {
            return false;
        }
        
        for (List<Integer> list : sMap.values())
        {
            if (!tMap.containsValue(list))
            {
                return false;
            }
        }
        
        return true;
    }

    /**
     * This function checks the string for duplicate characters, if a character is a duplicate then it
     * is added to a HashMap as the key, and its indices in the string are added to a list which is then 
     * added to the HashMap as the value.
     * @param s
     * @param map
     * @return 
     */
    public static Map<Character, List<Integer>> collectDuplicateCharIndexMap(String s, Map<Character, List<Integer>> map)
    {
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            List<Integer> indexList = new ArrayList<>();

            for (int j = 0; j < s.length(); j++)
            {
                char d = s.charAt(j);
                if (d == c)
                {
                    indexList.add(j);
                }
            }

            if (indexList.size() > 1)
            {
                map.put(c, indexList);
            }
        }

        return map;
    }

    /**
     * Solution used for answer, My answer above seemed to be working but it timed out on a very large test case.
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) 
        {
            return false;
        }
            
        Hashtable<Character , Character> hashtable = new Hashtable<>();
        for (int i = 0; i < s.length(); i++) 
        {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            if (hashtable.containsKey(c1))
            {
                if (hashtable.get(c1) != c2) return false;
            } 
            else 
            {
                if (hashtable.containsValue(c2)) 
                {
                    return false;
                }
                hashtable.put(c1 , c2);
            }
        }

        return true;
    }
}
