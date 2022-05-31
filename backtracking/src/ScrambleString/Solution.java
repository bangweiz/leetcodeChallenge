package ScrambleString;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    private HashMap<String, Boolean> map = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        return helper(s1, s2);
    }

    private boolean helper(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        String key = s1 + s2;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int n = s1.length();
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        boolean equal = true;
        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i]) {
                equal = false;
                break;
            }
        }

        if (!equal) {
            map.put(key, false);
            return false;
        }

        for (int i = 1; i < n; i++) {
            String firstS1 = s1.substring(0, i);
            String lastS1 = s1.substring(i);

            boolean noSwap = helper(firstS1, s2.substring(0, i)) && helper(lastS1, s2.substring(i));
            boolean swap = helper(firstS1, s2.substring(n - i)) && helper(lastS1, s2.substring(0, n - i));

            if (noSwap || swap) {
                map.put(key, true);
                return true;
            }
        }

        map.put(key, false);
        return false;
    }
}
