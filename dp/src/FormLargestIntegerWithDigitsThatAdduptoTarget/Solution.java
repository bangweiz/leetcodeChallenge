package FormLargestIntegerWithDigitsThatAdduptoTarget;

import helper.Helper;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] cost = {210,77,91,105,3276,881,957,3317,1234};
        int target = 4034;
        System.out.println(solution.largestNumber(cost, target));
    }

    public String largestNumber(int[] cost, int target) {
        int[][] dp = new int[target + 1][2];
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < cost.length; j++) {
                if (cost[j] <= i && dp[i - cost[j]][1] + 1 >= dp[i][1] && (i - cost[j] == 0 || dp[i - cost[j]][1] != 0)) {
                    dp[i][0] = j + 1;
                    dp[i][1] = dp[i - cost[j]][1] + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (target > 0) {
            if (dp[target][1] != 0) {
                sb.append(dp[target][0]);
                target -= cost[dp[target][0] - 1];
            } else {
                return "0";
            }
        }

        return sb.toString();
    }
}
