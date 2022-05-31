package CoinChange;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int remain = i - coins[j];
                if (remain == 0) {
                    dp[i] = 1;
                } else if (remain > 0){
                    if (dp[remain] != - 1) {
                        if (dp[i] == -1) {
                            dp[i] = 1 + dp[remain];
                        } else {
                            dp[i] = Math.min(1 + dp[remain], dp[i]);
                        }
                    }

                }
            }
        }

        for (int num: dp) {
            System.out.println(num);
        }

        return dp[amount];
    }
}
