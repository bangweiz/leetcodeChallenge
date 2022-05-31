package LongestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j == i - 1) {
                        dp[j][i] = true;
                        if (i - j > end - start) {
                            start = j;
                            end = i;
                        }
                    } else {
                        if (dp[j + 1][i - 1]) {
                            dp[j][i] = true;
                            if (i - j > end - start) {
                                start = j;
                                end = i;
                            }
                        } else {
                            dp[j][i] = false;
                        }
                    }
                } else {
                    dp[j][i] = false;
                }
            }
        }
        return s.substring(start, end + 1);
    }

}
