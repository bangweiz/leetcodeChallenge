package AllocateMailboxes;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] houses = {8,14,20,23,4,25};
        int k = 3;
        System.out.println(solution.minDistance(houses, k));
    }

    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        int[][] memo = new int[houses.length][k + 1];
        for (int[] i: memo) {
            Arrays.fill(i, -1);
        }
        return helper(houses, 0, k, memo);
    }

    private int helper(int[] houses, int start, int k, int[][] memo) {
        if (memo[start][k] != -1) {
            return memo[start][k];
        }
        if (k == 1) {
            memo[start][k] = cal(houses, start, houses.length - 1);
            return memo[start][k];
        }
        if (k >= houses.length - start) {
            memo[start][k] = 0;
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = start; i < houses.length; i++) {
            int left = cal(houses, start, i);
            if (left < res) {
                int right = helper(houses,i + 1,k - 1, memo);
                res = Math.min(res, left + right);
            }
        }
        memo[start][k] = res;
        return res;
    }

    private int cal(int[] houses, int start, int end) {
        int res = 0;
        while (start < end) {
            res += houses[end] - houses[start];
            start++;
            end--;
        }
        return res;
    }
}
