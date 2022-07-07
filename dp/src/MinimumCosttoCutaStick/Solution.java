package MinimumCosttoCutaStick;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 9;
        int[] cuts = {5,6,1,4,2};
        System.out.println(solution.minCost(n, cuts));
    }

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[][] dp = new int[cuts.length][cuts.length];
        return helper(n, cuts, dp, 0, cuts.length - 1);
    }

    private int helper(int n, int[] cuts, int[][] dp, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        int left = start == 0 ? 0 : cuts[start - 1];
        int right = end == cuts.length - 1 ? n : cuts[end + 1];
        if (start == end) {
            dp[start][end] = right - left;
            return dp[start][end];
        }
        int res = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            res = Math.min(res, helper(n, cuts, dp, start, i - 1) + helper(n, cuts, dp, i + 1, end));
        }
        dp[start][end] = res - left + right;
        return dp[start][end];
    }
}
