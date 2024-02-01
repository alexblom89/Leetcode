import Hashmap.GroupAnagrams;
import Hashmap.IsomorphicStrings;
import LinkedList.LRUCache;

public class Main {
    public static void main(String[] args) {
        // int[] array = {0,0,1,1,1,2,2,3,3,4};
        // RemoveDuplicates.removeDuplicates(array);
        // ReverseWords.reverseWords("a good  example");
        // IsomorphicStrings.isIsomorphic("32767", "65535");
        LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        obj.get(1);
        obj.put(3, 3);
        obj.get(2);
        obj.put(4, 4);
        obj.get(1);
        obj.get(1);
        obj.get(3);
        obj.get(4);
    }
}
