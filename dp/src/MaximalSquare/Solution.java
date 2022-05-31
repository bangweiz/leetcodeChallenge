package MaximalSquare;

import java.util.Arrays;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] == '0' ? 0 : 1;
            max = Math.max(max, dp[0][i]);
        }
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
            max = Math.max(max, dp[i][0]);
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (dp[i - 1][j - 1] == 0 || dp[i][j - 1] == 0 || dp[i - 1][j] == 0) {
                        dp[i][j] = 1;
                    } else {
                        int temp = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                        int n = (int) Math.sqrt(temp);
                        dp[i][j] = (n + 1) * (n + 1);
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }
}
