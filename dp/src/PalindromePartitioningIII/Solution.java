package PalindromePartitioningIII;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode";
        int k = 30;
        System.out.println(solution.palindromePartition(s, k));
    }

    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] d: dp) {
            Arrays.fill(d, -1);
        }

        int[][] memo = new int[n][k + 1];
        for (int[] d: memo) {
            Arrays.fill(d, -1);
        }

        return helper(s, k, 0, dp, memo);
    }

    private int helper(String s, int k, int start, int[][] dp, int[][] memo) {
        if (memo[start][k] != -1) {
            return memo[start][k];
        }

        int n = s.length();
        if (n - start <= k) {
            memo[start][k] = 0;
            return 0;
        }
        if (k == 1) {
            memo[start][k] = convertPal(s, start, n - 1, dp);
            return memo[start][k];
        }

        int min = n - start;
        for (int i = start; i < n && n - i >= k; i++) {
            int first = convertPal(s, start, i, dp);
            if (first > min) {
                break;
            }
            int second = helper(s, k - 1, i + 1, dp, memo);
            min = Math.min(min, first + second);
        }

        memo[start][k] = min;
        return min;
    }

    private int convertPal(String s, int start, int end, int[][] dp) {
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        if (start >= end) {
            dp[start][end] = 0;
            return 0;
        }
        if (s.charAt(start) == s.charAt(end)) {
            dp[start][end] = convertPal(s, start + 1, end - 1, dp);
            return dp[start][end];
        }
        dp[start][end] = convertPal(s, start + 1, end - 1, dp) + 1;
        return dp[start][end];
    }
}
