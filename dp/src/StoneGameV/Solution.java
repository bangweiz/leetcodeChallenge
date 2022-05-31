package StoneGameV;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] values = {7,7,7,7,7,7,7};
        System.out.println(solution.stoneGameV(values));
    }

    public int stoneGameV(int[] stoneValue) {
        return bottomTop(stoneValue);
    }

    // Top Bottom DP
    private int topBottom(int[] stoneValue) {
        int n = stoneValue.length;
        int[] sum = new int[n];
        calSum(stoneValue, sum);
        int[][] dp = new int[n][n];
        return helper(0, n - 1, sum, dp);
    }

    private int helper(int start, int end, int[] sum, int[][] dp) {
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        if (start == end) {
            return 0;
        }
        for (int i = 0; i + start < end; i++) {
            int left = start == 0 ? sum[start + i] : sum[start + i] - sum[start - 1];
            int right = sum[end] - sum[start + i];
            if (left > right) {
                dp[start][end] = Math.max(dp[start][end], right + helper(start + i + 1, end, sum, dp));
            } else if (left < right) {
                dp[start][end] = Math.max(dp[start][end], left + helper(start, start + i, sum, dp));
            } else {
                dp[start][end] = Math.max(dp[start][end], Math.max(helper(start + i + 1, end, sum, dp), helper(start, start + i, sum, dp)) + left);
            }
        }
        return dp[start][end];
    }

    // Bottom Top DP
    private int bottomTop(int[] stoneValue) {
        int n = stoneValue.length;
        int[] sum = new int[n];
        calSum(stoneValue, sum);

        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 0;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j], calVal(stoneValue, i, j, sum, dp));
            }
        }

        return dp[0][n - 1];
    }

    private int calVal(int[] values, int start, int end, int[] sum, int[][]dp) {
        if (end - start == 1) {
            return Math.min(values[start], values[end]);
        }
        int max = 0;
        for (int i = start; i < end; i++) {
            int left = start == 0 ? sum[i] : sum[i] - sum[start - 1];
            int right = sum[end] - sum[i];
            if (left > right) {
                max = Math.max(max, right + dp[i + 1][end]);
            } else if (left < right) {
                max = Math.max(max, left + dp[start][i]);
            } else {
                int temp = Math.max(dp[start][i], dp[i + 1][end]);
                max = Math.max(temp + left, max);
            }
        }
        return max;
    }

    // Helper Function
    private void calSum(int[] values, int[] sum) {
        sum[0] = values[0];
        for (int i = 1; i < values.length; i++) {
            sum[i] = values[i] + sum[i - 1];
        }
    }
}
