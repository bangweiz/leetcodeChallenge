package StoneGameVIII;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] stones = {25,-35,-37,4,34,43,16,-33,0,-17,-31,-42,-42,38,12,-5,-43,-10,-37,12};
        System.out.println(solution.stoneGameVIII(stones));
    }

    public int stoneGameVIII(int[] stones) {
        return topBottom(stones);
    }

    // Top bottom Dp
    private int topBottom(int[] stones) {
        int n = stones.length;
        int[] sum = calSum(stones);
        int[] memo = new int[n];
        Arrays.fill(memo, Integer.MIN_VALUE);
        return helper(sum, 1, memo);
    }

    private int helper(int[] sum, int start, int[] memo) {
        if (start == sum.length - 1) {
            return sum[start];
        }
        if (memo[start] != Integer.MIN_VALUE) {
            return memo[start];
        }
        memo[start] = Math.max(sum[start] - helper(sum, start + 1, memo), helper(sum, start + 1, memo));
        return memo[start];
    }

    // Bottom Top Dp
    private int bottomTop(int[] stones) {
        int n = stones.length;
        int[] sum = calSum(stones);
        int[] dp = new int[n];
        dp[n - 1] = sum[n - 1];
        int max = dp[n - 1];
        for (int i = n - 2; i > 0; i--) {
            dp[i] = sum[i] - max;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private int[] calSum(int[] stones) {
        int[] sum = new int[stones.length];
        sum[0] = stones[0];
        for (int i = 1; i < stones.length; i++) {
            sum[i] = stones[i] + sum[i - 1];
        }
        return sum;
    }
}
