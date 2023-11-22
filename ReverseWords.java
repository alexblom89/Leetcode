/**
 * https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=top-interview-150
 */
public class ReverseWords {
    public static String reverseWords(String s) {
        String[] strings = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--)
        {
            String string = strings[i].trim();
            
            if (!(string.isBlank()))
            {
                //System.out.println(string + "\n");    
               sb.append(string);
                if (i != 0)
                {
                    sb.append(" ");
                }
            }
 
        }
        return sb.toString();
    }
}
