package CountDifferentPalindromicSubsequences;

public class Solution {
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        long mod = 1_000_000_007;
        long[][] dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                char charI = s.charAt(i);
                char charJ = s.charAt(j);
                if (charI != charJ) {
                    dp[j][i] = dp[j + 1][i] + dp[j][i - 1] - dp[j + 1][i - 1];
                } else {
                    dp[j][i] = dp[j + 1][i - 1] * 2;
                    int left = j + 1;
                    int right = i - 1;

                    while (left <= right && s.charAt(left) != charI) {
                        left++;
                    }

                    while (left <= right && s.charAt(right) != charI) {
                        right--;
                    }

                    if (left > right) {
                        dp[j][i] += 2;
                    } else if (left == right) {
                        dp[j][i] += 1;
                    } else {
                        dp[j][i] -= dp[left + 1][right - 1];
                    }
                }
                dp[j][i] = (dp[j][i] + mod) % mod;
            }
        }

        return (int) dp[0][n - 1];
    }
}
