import java.util.*;

public class CompareStrings {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if (A == null || A.length() < B.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < A.length(); i++) {
            if (map.containsKey(A.charAt(i))) {
                map.put(A.charAt(i), map.get(A.charAt(i)) + 1);
            } else {
                map.put(A.charAt(i), 1);
            }
        }
        for (int i = 0; i < B.length(); i++) {
            if (!map.containsKey(B.charAt(i))) {
                return false;
            } else {
                if (map.get(B.charAt(i)) == 0) {
                    return false;
                } else {
                    map.put(B.charAt(i), map.get(B.charAt(i)) - 1);
                }
            }
        }
        return true;
    }
}


