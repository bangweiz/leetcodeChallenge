package IntegerBreak;

import java.util.Arrays;

public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= n; i++) {
            int left = 1;
            int right = i - left;

            while (left <= right) {
                dp[i] = Math.max(dp[i], Math.max(dp[left], left) * Math.max(dp[right], right));
                left++;
                right--;
            }
        }

        return dp[n];
    }
}
