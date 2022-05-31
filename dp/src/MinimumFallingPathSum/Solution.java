package MinimumFallingPathSum;

import java.util.Arrays;

public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix.length];
        dp[0] = Arrays.copyOf(matrix[0], matrix[0].length);

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == matrix[i].length - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i - 1][j + 1]);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.min(dp[dp.length - 1][i], res);
        }
        return res;
    }
}
