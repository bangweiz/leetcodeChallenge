package WildcardMatching;

public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i <= p.length(); i++) {
            for (int j = 0; j <= s.length(); j++) {
                char pChar  = p.charAt(i - 1);
                if (j == 0) {
                    if (pChar == '*') {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (pChar == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i - 1][j - 1];
                    } else if (pChar == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        if (pChar == s.charAt(j - 1)) {
                            dp[i][j] = dp[i - 1][j - 1];
                        } else {
                            dp[i][j] = false;
                        }
                    }
                }
            }
        }

        return dp[p.length()][s.length()];
    }
}
