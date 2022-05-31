package MinimumInsertionStepstoMakeaStringPalindrome;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leetcode";
        System.out.println(solution.minInsertions(s));
    }

    public int minInsertions(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] == arr[j]) {
                    dp[j][i] = dp[j + 1][i - 1];
                } else {
                    dp[j][i] = Math.min(dp[j + 1][i], dp[j][i - 1]) + 1;
                }
            }
        }

        return dp[0][n - 1];
    }

}
