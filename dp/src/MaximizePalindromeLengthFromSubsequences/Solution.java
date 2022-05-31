package MaximizePalindromeLengthFromSubsequences;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String word1 = "aa";
        String word2 = "bb";
        System.out.println(solution.longestPalindrome(word1, word2));
    }

    public int longestPalindrome(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + n2][n1 + n2];
        buildDP(word1 + word2, dp);

        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int pointer1 = 0;

        while (pointer1 < n1 && map.size() <= 26) {
            char char1 = word1.charAt(pointer1);
            if (map.containsKey(char1)) {
                pointer1++;
                continue;
            }
            int pointer2 = n2 - 1;
            while (pointer2 >= 0) {
                if (word2.charAt(pointer2) == char1) {
                    max = Math.max(max, 2 + dp[pointer1 + 1][n1 + pointer2 - 1]);
                    map.put(char1, max);
                    break;
                }
                pointer2--;
            }
            map.put(char1, 0);
        }

        return max;
    }

    private void buildDP(String s, int[][] dp) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = dp[j + 1][i - 1] + 2;
                } else {
                    dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
                }
            }
        }
    }
}
