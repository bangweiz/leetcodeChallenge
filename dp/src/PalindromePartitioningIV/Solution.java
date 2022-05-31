package PalindromePartitioningIV;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leetcodeleetcodeleetcode";
        System.out.println(solution.checkPartitioning(s));
    }

    public boolean checkPartitioning(String s) {
        char[] charArr = s.toCharArray();
        int n = charArr.length;
        int[][] dp = new int[n][n];
        return helper(charArr, 0, 3, dp);
    }

    private boolean helper(char[] s, int start, int k, int[][] dp) {
        int n = s.length;
        if (k == 1) {
            return isPal(s, start, n - 1, dp);
        }
        if (k == n - start) {
            return true;
        }

        for (int i = start; i < n && k <= n - i; i++) {
            if (!isPal(s, start, i, dp)) {
                continue;
            }
            if (helper(s, i + 1, k - 1, dp)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPal(char[] s, int start, int end, int[][] dp) {
        if (dp[start][end] != 0) {
            return dp[start][end] == 1;
        }
        if (start >= end) {
            dp[start][end] = 1;
            return true;
        }
        if (s[start] == s[end]) {
            boolean res = isPal(s, start + 1, end - 1, dp);
            dp[start][end] = res ? 1 : -1;
            return res;
        } else {
            dp[start][end] = -1;
            return false;
        }
    }
}
