package Array.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/?envType=study-plan-v2&envId=top-interview-150
 * 
 * This question specifies that each operation take O(1) time. However, just using Set operations in 
 * getRandom() function is not O(1), thus a second solution uses HashMap and ArrayList, where the element's index 
 * is stored as the key to the HashMap, thus lowering the time to O(1) (presumeably at a cost of space complexity).
 */
// public class RandomizedSet {
//     private Set<Integer> set = new HashSet<>();

//     public RandomizedSet() {
        
//     }
    
//     public boolean insert(int val) {
//         if (set.contains(val))
//         {
//             return false;
//         }
//         else
//         {
//             set.add(val);
//             return true;
//         }
//     }
    
//     public boolean remove(int val) {
//         if (!set.contains(val))
//         {
//             return false;
//         }
//         else
//         {
//             set.remove(val);
//             return true;
//         }
//     }
    
//     /**
//      * Question required O(1) time for this method, 
//      * my (slow) attempt is top, O(1) time attempt is below.
//      * @return
//      */
//     public int getRandom() {
//         int size = set.size();
//         int item = new Random().nextInt(size);
//         int i = 0;
//         for (int num : set)
//         {
//             if (i == item)
//             {
//                 return num;
//             }

//             i++;
//         }
//         return 0;
//     }
// }

public class RandomizedSet {

    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random rnd = new Random();

    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        
        int idx = map.remove(val);
        int last = list.remove(list.size() - 1);
        if(val != last) {
            list.set(idx, last);
            map.put(last, idx);
        }
        return true;
    }
    
    public int getRandom() {
        return list.get(rnd.nextInt(list.size()));
    }
}
