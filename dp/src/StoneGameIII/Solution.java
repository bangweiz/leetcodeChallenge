package StoneGameIII;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] values = {1,2,3,6};
        System.out.println(solution.stoneGameIII(values));
    }

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] sum = new int[n];
        calSum(stoneValue, sum);
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 0; j < 3 && i + j < n; j++) {
                int left = i == 0 ? sum[i + j] : sum[i + j] - sum[i - 1];
                if (i + j == n - 1) {
                    if (left > dp[i]) {
                        dp[i] = left;
                    }
                } else {
                    int remain = dp[i + j + 1];
                    if (left - remain > dp[i]) {
                        dp[i] = left - remain;
                    }
                }
            }
        }
        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    private void calSum(int[] values, int[] sum) {
        sum[0] = values[0];
        for (int i = 1; i < values.length; i++) {
            sum[i] = values[i] + sum[i - 1];
        }
    }
}
