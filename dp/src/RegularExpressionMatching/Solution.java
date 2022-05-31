package RegularExpressionMatching;

import java.util.Arrays;

public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        Arrays.fill(dp[0], false);
        dp[0][0] = true;

        for (int i = 1; i <= p.length(); i++) {
            for (int j = 0; j <= s.length(); j++) {
                char pattern = p.charAt(i - 1);
                if (j == 0) {
                    if (pattern == '*') {
                        dp[i][j] = dp[i - 2][j];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    char str = s.charAt(j - 1);
                    if (pattern == '*') {
                        char leadingPattern = p.charAt(i - 2);
                        if (leadingPattern == '.') {
                            dp[i][j] = dp[i - 2][j - 1] || dp[i][j - 1] || dp[i - 2][j];
                        } else if (leadingPattern == str) {
                            if (j > 1 && str == s.charAt(j - 2)) {
                                dp[i][j] = dp[i - 2][j - 1] || dp[i - 2][j] || dp[i][j - 1];
                            } else {
                                dp[i][j] = dp[i - 2][j - 1] || dp[i - 2][j];
                            }
                        } else {
                            dp[i][j] = dp[i - 2][j];
                        }
                    } else if (pattern == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        if (pattern != str) {
                            dp[i][j] = false;
                        } else {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }
                }
            }
        }

        return dp[p.length()][s.length()];
    }
}
