package MinimumCosttoCutaStick;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 7;
        int[] cuts = {3, 1, 4, 5};
        System.out.println(solution.minCost(n, cuts));
    }
    public int minCost(int n, int[] cuts) {
        Map<Integer, Integer> dp = new HashMap<>();
        Arrays.sort(cuts);
        return helper(n, cuts.length - 1, cuts, dp);
    }

    private int helper(int n, int i, int[] cuts, Map<Integer, Integer> dp) {
        if (i == 0) {
            return n;
        }
        int key = i * 1000001 + n;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int res1 = helper(cuts[i], i - 1, cuts, dp) + n;
        int res2 = helper(n, i - 1, cuts, dp) + n - cuts[i - 1];
        if (i == 1 && n== 5) {
            System.out.println(res1);
            System.out.println(res2);
        }
        int res = Math.min(res1, res2);
        dp.put(key, res);
        return res;
    }
}
