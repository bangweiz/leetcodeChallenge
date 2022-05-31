package SplitArrayLargestSum;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,4,4};
        int m = 3;
        System.out.println(solution.splitArray(nums, m));
    }

    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] sum = new int[n][n];
        calSum(nums, sum);
        int[][] memo = new int[n][m + 1];
        for (int[] temp: memo) {
            Arrays.fill(temp, -1);
        }
        return helper(nums, 0, m, sum, memo);
    }

    private int helper(int[] nums, int start, int k, int[][] sum, int[][] memo) {
        int n = nums.length;
        if (memo[start][k] != -1) {
            return memo[start][k];
        }
        if (k <= 1) {
            memo[start][k] = sum[start][n - 1];
            return memo[start][k];
        }

        int min = Integer.MAX_VALUE;
        for (int i = start; i < n && n - i >= k; i++) {
            int left = sum[start][i];
            if (left > min) {
                continue;
            }
            int right = helper(nums, i + 1, k - 1, sum, memo);
            int temp = Math.max(left, right);
            min = Math.min(min, temp);
            memo[start][k] = min;
        }

        return min;
    }

    private void calSum(int[] nums, int[][] sum) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum[i][i] = nums[i];
            for (int j = i + 1; j < n; j++) {
                sum[i][j] = nums[j] + sum[i][j - 1];
            }
        }
    }
}
