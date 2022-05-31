package PalindromePartitioningII;

public class Solution {
    public int minCut(String s) {
        return calculate(palCheck(s), s.length());
    }

    private boolean[][] palCheck(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j == 1) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }
            }
        }

        return dp;
    }

    private int calculate(boolean[][] isPal, int n) {
        int[] dp = new int[n + 1];
        dp[0] = -1;

        for (int i = 1; i <= n; i++) {
            dp[i] = 1 + dp[i - 1];
            for (int j = i - 1; j > 0; j--) {
                if (isPal[j - 1][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }

        return dp[n];
    }
}
