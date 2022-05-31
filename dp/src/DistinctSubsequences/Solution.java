package DistinctSubsequences;

import java.util.Arrays;

public class Solution {
    public int numDistinct(String s, String t) {
        if (t.length() > s.length()) {
            return 0;
        }
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        Arrays.fill(dp[0], 0);
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
