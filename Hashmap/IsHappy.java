package Hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/
 */
public class IsHappy {
    /**
     * 
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        //Add n to set if not already.
        while (set.add(n))
        {
            int sum = 0;
            while (n > 0)
            {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            
            if (sum == 1)
            {
                return true;
            } else {
                n = sum;
            }
        }
        return false;
    }
}
