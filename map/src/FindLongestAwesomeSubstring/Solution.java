package FindLongestAwesomeSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "940884";
        System.out.println(solution.longestAwesome(s));
    }

    public int longestAwesome(String s) {
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = 1 << i;
        }

        Map<Integer, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int prefix = 0;
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i] - '0';
            prefix ^= (1 << num);
            int oneCount = Integer.bitCount(prefix);
            if (oneCount == 0 || oneCount == 1) {
                res = i + 1;
            } else {
                for (int n: nums) {
                    int key = n ^ prefix;
                    if (map.containsKey(key)) {
                        res = Math.max(res, i - map.get(key));
                    }
                }
            }
            if (!map.containsKey(prefix)) {
                map.put(prefix, i);
            }
        }

        return res;
    }
}
