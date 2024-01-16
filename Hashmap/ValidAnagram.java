package Hashmap;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
        {
            return false;
        }

        Map<String, Integer> sMap = new HashMap<>();
        Map<String, Integer> tMap = new HashMap<>();
        sMap = countChars(s);
        tMap = countChars(t);

        return sMap.equals(tMap);
    }

    public Map<String, Integer> countChars(String string)
    {
        Map<String, Integer> map = new HashMap<>();
        for (char c : string.toCharArray())
        {
            map.merge(String.valueOf(c), 1, Integer::sum);
        }
        return map;  
    }

    /**
     * Faster solution, better space complexity (1 map instead of 3), adds letter from s and increments, 
     * decrements letters from t, if hash is empty it means that they are anagrams.
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        HashMap<Character,Integer> smap=new HashMap<>();
        int sl=s.length();
        int tl=t.length();
        if(sl!=tl){return false;}
        for(int i=0;i<sl;i++){
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
            smap.put(t.charAt(i),smap.getOrDefault(t.charAt(i),0)-1);
        }
        for(char c:smap.keySet()){
            if(smap.get(c)!=0){return false;}
        }
        
        return true;
    }
}

