package PalindromicSubstrings;

public class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            res++;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j == 1) {
                        dp[j][i] = true;
                        res++;
                    } else {
                        if (dp[j + 1][i - 1]) {
                            dp[j][i] = true;
                            res++;
                        } else {
                            dp[j][i] = false;
                        }
                    }
                } else {
                    dp[j][i] = false;
                }
            }
        }

        return res;
    }
}
