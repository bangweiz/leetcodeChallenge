package MinimumNumberofDaystoEatNOranges;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDays(2000000000));
    }

    public int minDays(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        int temp = 1;
        int days = 1;
        while (true) {
            temp *= 2;
            if (temp > 1000000000) {
                break;
            }
            map.put(temp, ++days);
        }
        temp = 1;
        days = 1;
        while (true) {
            temp *= 3;
            if (temp > 1000000000) {
                break;
            }
            map.put(temp, ++days);
        }
        return helper(n, map);
    }

    public int helper(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int res = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            res = Math.min(helper(n / 2, memo) + 1, res);
        } else {
            res = Math.min(helper((n - 1) / 2, memo) + 2, res);
        }
        if (n % 3 == 0) {
            res = Math.min(helper(n / 3, memo) + 1, res);
        } else if (n % 3 == 1){
            res = Math.min(helper((n - 1) / 3, memo) + 2, res);
        } else {
            res = Math.min(helper((n - 2) / 3, memo) + 3, res);
        }
        memo.put(n, res);
        return res;
    }
}
