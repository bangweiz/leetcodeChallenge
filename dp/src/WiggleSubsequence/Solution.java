package WiggleSubsequence;

import java.util.Arrays;

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[0] < nums[i]) {
                dp[i] = 2;
            } else if (nums[0] > nums[i]) {
                dp[i] = -2;
            }
            for (int j = 1; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] < 0) {
                        dp[i] = Math.abs(dp[j]) + 1;
                    } else {
                        dp[i] = Math.abs(dp[i]) > Math.abs(dp[j]) ? dp[i] : dp[j];
                    }
                } else if (nums[j] > nums[i]) {
                    if (dp[j] < 0) {
                        dp[i] = Math.abs(dp[i]) > Math.abs(dp[j]) ? dp[i] : dp[j];
                    } else {
                        dp[i] = -Math.abs(dp[j]) - 1;
                    }
                } else {
                    dp[i] = Math.abs(dp[i]) > Math.abs(dp[j]) ? dp[i] : dp[j];
                }
            }
        }

        return Math.abs(dp[dp.length - 1]);
    }
}
