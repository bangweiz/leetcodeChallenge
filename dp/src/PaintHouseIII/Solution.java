package PaintHouseIII;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] houses = {1,0,2,0};
        int[][] cost = {{4,5,2,6},{1,2,3,4},{2,2,1,1},{4,3,2,1}};
        int target = 1;
        System.out.println(solution.minCost(houses, cost, houses.length, cost[0].length, target));
    }

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] memo = new int[m][n + 1][target + 1];
        for (int[][] vals: memo) {
            for (int[] val: vals) {
                Arrays.fill(val, -2);
            }
        }
        return helper(houses, cost, m, n, target, 0, 0, memo);
    }

    private int helper(int[] houses, int[][] cost, int m, int n, int target, int start, int color, int[][][] memo) {
        if (target > m - start) {
            return -1;
        }
        if (start >= m) {
            return 0;
        }
        if (memo[start][color][target] != -2) {
            return memo[start][color][target];
        }
        if (target == 0) {
            if (color == 0) {
                memo[start][color][target] = -1;
                return -1;
            } else {
                int res = 0;
                for (int i = start; i < m; i++) {
                    if (houses[i] == 0) {
                        res += cost[i][color - 1];
                    } else if (houses[i] != color) {
                        res = -1;
                        break;
                    }
                }
                memo[start][color][target] = res;
                return res;
            }
        }

        int min = Integer.MAX_VALUE;
        if (houses[start] != 0) {
            int newTarget = color == houses[start] ? target : target - 1;
            int rightCost = helper(houses, cost, m, n, newTarget, start + 1, houses[start], memo);
            if (rightCost != -1) {
                min = Math.min(min, rightCost);
            }
        } else {
            for (int newColor = 1; newColor <= n; newColor++) {
                int leftCost = cost[start][newColor - 1];
                int newTarget = color == newColor ? target : target - 1;
                int rightCost = helper(houses, cost, m, n, newTarget, start + 1, newColor, memo);
                if (rightCost != -1) {
                    min = Math.min(min, leftCost + rightCost);
                }
            }
        }
        min = min == Integer.MAX_VALUE ? -1 : min;
        memo[start][color][target] = min;
        return min;
    }
}
