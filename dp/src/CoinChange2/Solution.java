package CoinChange2;

import java.util.Arrays;

public class Solution {
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int remain = j - coins[i - 1];
                if (remain < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (remain > 0) {
                    dp[i][j] = dp[i][remain] + dp[i - 1][j];
                } else {
                    dp[i][j] = 1 + dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
