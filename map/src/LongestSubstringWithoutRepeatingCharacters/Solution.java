package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "bbbbbb";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int res = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int index = map.get(arr[i]);
                if (i - index > count) {
                    count++;
                } else {
                    count = i - map.get(arr[i]);
                }
                map.replace(arr[i], i);
            } else {
                map.put(arr[i], i);
                count++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
